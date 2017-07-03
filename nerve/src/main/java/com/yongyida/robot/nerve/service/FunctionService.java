package com.yongyida.robot.nerve.service;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.cell.Container;

import java.util.HashMap;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 * 大脑 处理来自各个器官的信息
 */
public abstract class FunctionService extends ReceiveService {

    private HashMap<String, BrainSendFunctionProcessor> mBrainSendFunctionProcessors = new HashMap<>() ;


    @Override
    public void onCreate() {
        super.onCreate();

        setBrainSendFunctionProcessors() ;
    }


    protected abstract void setBrainSendFunctionProcessors();

    /**设置处理各个功能发来的信息*/
    public void setBrainSendFunctionProcessor(BrainSendFunctionProcessor brainSendFunctionProcessor){

        if(brainSendFunctionProcessor != null){

            mBrainSendFunctionProcessors.put(brainSendFunctionProcessor.getSendType(), brainSendFunctionProcessor) ;
        }
    }



    @Override
    protected final void onReceive(Container container) {

        String className = container.getClassName() ;

        BrainSendFunctionProcessor brainSendFunctionProcessor = mBrainSendFunctionProcessors.get(className) ;

        if(brainSendFunctionProcessor != null){

            brainSendFunctionProcessor.handleEvent(container);
        }
    }
}
