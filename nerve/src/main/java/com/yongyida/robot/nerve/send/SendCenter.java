package com.yongyida.robot.nerve.send;

import android.content.Context;
import android.os.Bundle;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.DataType;
import com.yongyida.robot.nerve.utils.AppUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/5/27.
 * 发送命令中心
 */
public class SendCenter {


    private HashMap<String,ArrayList<OutputClient>> mOutputClientMap = new HashMap<>() ;

    private Context mContext ;


    private static SendCenter mRobotControlCenter;
    private SendCenter(Context context){

        this.mContext = context.getApplicationContext() ;

    }
    public static SendCenter getInstance(Context context){

        if(mRobotControlCenter == null){

            mRobotControlCenter = new SendCenter(context) ;
        }

        return mRobotControlCenter ;
    }



    /**
     *  @param action service 监听的action
     *
     * */
    private ArrayList<OutputClient> initServiceAction(String action) {

        HashSet<String> packageNames = AppUtils.getPackageNameByServiceAction(mContext,action) ;

        ArrayList<OutputClient> outputClientList = mOutputClientMap.get(action) ;
        if(outputClientList == null){

            outputClientList = new ArrayList<>() ;
            mOutputClientMap.put(action, outputClientList) ;

        }else{

            Iterator<OutputClient> iterator = outputClientList.iterator() ;
            while (iterator.hasNext()){

                OutputClient outputClient = iterator.next();
                String packageName = outputClient.getPackageName();

                if(!packageNames.remove(packageName)){

                    iterator.remove();
                }
            }
        }

        for (String packageName : packageNames) {

            OutputClient outputClient  = new OutputClient(mContext, packageName,action) ;
            outputClientList.add(outputClient) ;
        }

        return outputClientList ;
    }


    /**
     * 发送给脑
     * */
    public void sendToBrain(Container container, SendResponseListener response ) {

        send(DataType.TYPE_BRAIN ,container, response) ;
    }



    /**
     * 发送控制数据（直接发送数据）
     * */
    public void send(int to,Container container, SendResponseListener response ){

        String action = DataType.getAction(to) ;
        ArrayList<OutputClient> outputClientList = initServiceAction(action) ;

        new SendClientsThread(outputClientList,container ,response).start();
    }


//    public void sendNeedJude(Bundle bundle, SendResponseListener response ) {
//
//        String type = bundle.getString("TYPE") ;
//
//        ArrayList<OutputClient> outputClientList = initServiceAction(type) ;
//
//        new SendClientsNeedJudeThread(outputClientList, bundle, response).start();
//    }




}
