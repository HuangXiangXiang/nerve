package com.yongyida.robot.nerve.cell;

import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 * 《大脑》 接收 《设备》信息
 */
public abstract class FunctionSendBrainProcessor extends ReceiveProcessor {

    public FunctionSendBrainProcessor(BrainService brainService){

        super(brainService) ;
    }

}
