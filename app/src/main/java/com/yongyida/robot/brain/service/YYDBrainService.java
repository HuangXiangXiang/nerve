package com.yongyida.robot.brain.service;

import com.yongyida.robot.brain.manager.YYDEarProcessor;
import com.yongyida.robot.brain.manager.YYDExpressionProcessor;
import com.yongyida.robot.brain.manager.YYDEyeProcessor;
import com.yongyida.robot.brain.manager.YYDFootProcessor;
import com.yongyida.robot.brain.manager.YYDHandProcessor;
import com.yongyida.robot.brain.manager.YYDMouthReceiveBrainProcessor;
import com.yongyida.robot.brain.manager.YYDSmartHomeProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/19.
 *
 * 相当于大脑，处理来自各个方向的信息
 * 正常情况下，不会主动
 */
public class YYDBrainService extends BrainService {

    private final static String TAG = YYDBrainService.class.getName() ;


    @Override
    protected void setFunctionSendBrainProcessors() {


        setFunctionSendBrainProcessor(new YYDEarProcessor(this));
        setFunctionSendBrainProcessor(new YYDExpressionProcessor(this));
        setFunctionSendBrainProcessor(new YYDEyeProcessor(this));
        setFunctionSendBrainProcessor(new YYDFootProcessor(this));
        setFunctionSendBrainProcessor(new YYDHandProcessor(this));
        setFunctionSendBrainProcessor(new YYDMouthReceiveBrainProcessor(this));
        setFunctionSendBrainProcessor(new YYDSmartHomeProcessor(this));

    }


}
