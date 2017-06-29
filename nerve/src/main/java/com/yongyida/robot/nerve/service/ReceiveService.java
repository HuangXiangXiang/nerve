package com.yongyida.robot.nerve.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.yongyida.robot.nerve.NerveSendManager;
import com.yongyida.robot.nerve.ResponseListener;
import com.yongyida.robot.nerve.cell.Container;

import java.util.HashMap;


/**
 * 主要是用于接受信息
 */
public abstract class ReceiveService extends Service {

    private final static String TAG = ReceiveService.class.getName() ;

    private HashMap<String,ResponseListener> responseListeners = new HashMap() ;

    private String packageName ;

    @Override
    public final IBinder onBind(Intent intent) {

        packageName = intent.getPackage() ;
        Log.i(TAG, "绑定包名：" + packageName) ;

        return mSmartHomeManager ;
    }



    @Override
    public boolean onUnbind(Intent intent) {

        packageName = intent.getPackage() ;
        Log.i(TAG, "解除绑定包名：" + packageName) ;

        return super.onUnbind(intent);
    }

     protected abstract void onReceive(Container container) ;

    /**
     * 响应客户端
     * @param send 需要响应的对象
     * @param response 响应的内容
     * */
    public void responseClient(Container send, Container response){

        if(send == null || response == null){

            return ;
        }

        ResponseListener responseListener = responseListeners.get(send.getPackageName()) ;
        if(responseListener != null){

            try {
                responseListener.response(response.toJson());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }


    private NerveSendManager.Stub mSmartHomeManager = new NerveSendManager.Stub(){

        @Override
        public String setResponseListener(String packageName, ResponseListener responseListener) throws RemoteException {

            responseListeners.put(packageName, responseListener) ;

            return null;
        }

        @Override
        public String send(String content) throws RemoteException {

//            Log.i(TAG , "send : " + responseListener ) ;

            onReceive(Container.fromJson(content)) ;

            return null;
        }

    };


}
