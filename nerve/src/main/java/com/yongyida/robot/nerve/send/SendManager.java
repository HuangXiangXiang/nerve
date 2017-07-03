package com.yongyida.robot.nerve.send;

import android.content.Context;

import com.yongyida.robot.nerve.cell.FunctionSendBrain;
import com.yongyida.robot.nerve.cell.BrainSendFunction;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionType;
import com.yongyida.robot.nerve.utils.AppUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/5/27.
 * 发送命令中心
 */
public class SendManager {

    private HashMap<String,ArrayList<Receiver>> mOutputClientMap = new HashMap<>() ;

    private Context mContext ;


    private static SendManager mRobotControlCenter;
    private SendManager(Context context){

        this.mContext = context.getApplicationContext() ;

    }

    public static SendManager getInstance(Context context){

        if(mRobotControlCenter == null){

            mRobotControlCenter = new SendManager(context) ;
        }

        return mRobotControlCenter ;
    }


    /**
     *  @param action service 监听的action
     *
     * */
    private ArrayList<Receiver> initServiceAction(String action) {

        HashSet<String> packageNames = AppUtils.getPackageNameByServiceAction(mContext,action) ;

        ArrayList<Receiver> receiverList = mOutputClientMap.get(action) ;
        if(receiverList == null){

            receiverList = new ArrayList<>() ;
            mOutputClientMap.put(action, receiverList) ;

        }else{

            Iterator<Receiver> iterator = receiverList.iterator() ;
            while (iterator.hasNext()){

                Receiver receiver = iterator.next();
                String packageName = receiver.getPackageName();

                if(!packageNames.remove(packageName)){

                    iterator.remove();
                }
            }
        }

        for (String packageName : packageNames) {

            Receiver receiver = new Receiver(mContext, packageName,action) ;
            receiverList.add(receiver) ;
        }

        return receiverList;
    }




    /**
     * 功能端发送给大脑
     * @param functionSendBrain 需要更大脑的内容
     * */
    public void functionSendBrain(FunctionSendBrain functionSendBrain, SendResponseListener response ){

        String action = FunctionType.ACTION_BRAIN ;
        ArrayList<Receiver> receiverList = initServiceAction(action) ;

        Container container = Container.getFunctionSendBrainContainer(mContext, functionSendBrain) ;

        new SendsThread(receiverList,container ,response).start();
    }

    /**
     *
     * 大脑发送给功能段
     * */
    public void brainSendFunction(BrainSendFunction brainSendFunction, SendResponseListener response ){

        String action = FunctionType.getAction(brainSendFunction.getClass()) ;
        ArrayList<Receiver> receiverList = initServiceAction(action) ;

        Container container = Container.getBrainSendFunctionContainer(mContext, brainSendFunction) ;

        new SendsThread(receiverList,container ,response).start();
    }
}
