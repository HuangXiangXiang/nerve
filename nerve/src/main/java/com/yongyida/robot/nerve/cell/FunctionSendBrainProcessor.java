package com.yongyida.robot.nerve.cell;

import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/26.
 * 功能发送给大脑的处理基类
 */
public abstract class FunctionSendBrainProcessor extends SendProcessor {

    public FunctionSendBrainProcessor(BrainService receiveService){

        super(receiveService);
    }
}
