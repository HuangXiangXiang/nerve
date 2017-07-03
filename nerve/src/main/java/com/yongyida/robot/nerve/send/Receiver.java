package com.yongyida.robot.nerve.send;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.yongyida.robot.nerve.NerveSendManager;
import com.yongyida.robot.nerve.ResponseListener;
import com.yongyida.robot.nerve.cell.Container;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/5/31.
 * 发送的对象(即 接收者)
 */
public class Receiver {

    /**
     * 存活时间，发送任务结束后断开连接的时间，在这段时间内发送不需要连接
     * 并且每次发送重新刷新这个这个时间
     * */
    private final static long ALIVE_TIME = 60*1000; //


    private Context context ;
    private String packageName ;
    private String action ;


    private NerveSendManager mNerveSendManager ;

    private JudeResponseListener mJudeResponseListener ;
    private SendResponseListener mResponse ;

    // 未绑定，绑定中，绑定成功，
    // 发送指令 ，响应失败/响应成功。
    private int statue ;
    //任务编号
    private String taskId ;

    public Receiver(Context context, String packageName, String action){

        this.context = context ;
        this.packageName = packageName ;
        this.action = action ;

    }

    public void setResponse(SendResponseListener response) {

        this.mResponse = response;
    }

    public void setJudeResponseListener(JudeResponseListener judeResponseListener) {

        this.mJudeResponseListener = judeResponseListener;
    }

    private boolean isRegistering = false; // 是否注册中

    private void registerService(){

        if(isRegistering){

            return ;
        }
        isRegistering = true ;

        if(mNerveSendManager == null){

            Intent intent = new Intent() ;

            intent.setPackage(packageName) ;
            intent.setAction(action) ;

            context.bindService(intent, conn, Context.BIND_AUTO_CREATE) ;
        }
    }

    private void unRegisterService(){

        if(mNerveSendManager != null){

            context.unbindService(conn);

            mNerveSendManager = null ;

            isRegistering = false ;
        }
    }


    /**外部关闭*/
    public void close(){

        stopTimer();

        unRegisterService() ;
    }


    /**回调*/
    private ResponseListener.Stub mResponseListener = new ResponseListener.Stub() {

        @Override
        public void response(String content) throws RemoteException {

            //发送结果的回调

            if(mResponse != null){

                mResponse.responseSend(Receiver.this, Container.fromJson(content));
            }

        }
    };


    private ServiceConnection conn  = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            isRegistering = false ;

            mNerveSendManager = NerveSendManager.Stub.asInterface(service) ;

            try {
                mNerveSendManager.setResponseListener(context.getPackageName(), mResponseListener) ;
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            send(mContainer) ;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            mNerveSendManager = null ;
        }
    };

    private Timer mTimer ;
    private TimerTask mTask ;


    private void startTimer(){

        stopTimer() ;

        mTimer = new Timer() ;
        mTask = new TimerTask(){
            @Override
            public void run() {

                unRegisterService();
            }
        } ;

        mTimer.schedule(mTask , ALIVE_TIME);

    }

    private void stopTimer(){


        if(mTimer != null){

            mTimer.cancel();
            mTimer = null ;
        }

        if(mTask != null){

            mTask.cancel() ;
            mTask = null ;
        }
    }


    public Container getContainer() {

        return mContainer;
    }

    // 发送的内容
    private Container mContainer ;

    public void send(Container container){

        startTimer() ;

        if(mNerveSendManager == null) {

            mContainer = container ;

            registerService() ;
            return ;
        }

        try {

            mNerveSendManager.send(container.toJson());

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getPackageName() {

        return packageName;
    }
}
