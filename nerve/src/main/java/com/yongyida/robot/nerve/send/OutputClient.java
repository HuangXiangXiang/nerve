package com.yongyida.robot.nerve.send;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;

import com.yongyida.robot.nerve.NerveSendManager;
import com.yongyida.robot.nerve.ResponseListener;
import com.yongyida.robot.nerve.cell.Container;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/5/31.
 */

public class OutputClient {

    /**
     * 存活时间，发送任务结束后1分钟断开连接
     * */
    private final static long ALIVE_TIME = 60*1000; //


    private Context context ;
    private String packageName ;
    private String action ;


    private NerveSendManager mNerveSendManager ;

    private JudeResponseListener mJudeResponseListener ;
    private SendResponseListener mResponse ;

    public OutputClient(Context context, String packageName, String action){

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

    public void registerService(){

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

    public void unRegisterService(){

        if(mNerveSendManager != null){

            context.unbindService(conn);

            mNerveSendManager = null ;

            isRegistering = false ;
        }
    }



    private ResponseListener.Stub mResponseListener = new ResponseListener.Stub() {

        @Override
        public void response(String content) throws RemoteException {


            if(mResponse != null){

                mResponse.responseSend(OutputClient.this, Container.fromJson(content));
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

            send(mContent) ;
            mContent = null ;

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

    private String mContent ;

    public void send(String content){

//        Logger.json(data);

        if(TextUtils.isEmpty(content)){

            return ;
        }

        startTimer() ;

        if(mNerveSendManager == null) {

            mContent = content ;

            registerService() ;
            return ;
        }

        try {

            mNerveSendManager.send(content);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getPackageName() {

        return packageName;
    }
}
