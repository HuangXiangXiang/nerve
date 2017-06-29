package com.yongyida.robot.nerve.service;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;

import java.util.HashMap;

/**
 * Created by Huangxiangxiang on 2017/6/28.
 * 某个器官 处理来自大脑的信息
 */
public abstract class BrainService extends ReceiveService {

    private HashMap<String, FunctionSendBrainProcessor> mFunctionSendBrainProcessors = new HashMap<>() ;

    @Override
    public void onCreate() {
        super.onCreate();
        setFunctionSendBrainProcessors() ;
    }

    /**用于设置处理类*/
    protected abstract void setFunctionSendBrainProcessors() ;


    /**设置处理各个功能发来的信息*/
    public void setFunctionSendBrainProcessor(FunctionSendBrainProcessor functionSendBrainProcessor){

        if(functionSendBrainProcessor != null){

            mFunctionSendBrainProcessors.put(functionSendBrainProcessor.getSendType(), functionSendBrainProcessor) ;
        }
    }



    protected final void onReceive(Container container) {

        String className = container.getClassName() ;

        FunctionSendBrainProcessor functionSendBrainProcessor = mFunctionSendBrainProcessors.get(className) ;

        if(functionSendBrainProcessor != null){

            functionSendBrainProcessor.handleEvent(container);
        }
    }
}
