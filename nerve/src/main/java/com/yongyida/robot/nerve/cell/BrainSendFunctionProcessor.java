package com.yongyida.robot.nerve.cell;

import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 * 大脑发送给功能的基类
 */
public abstract class BrainSendFunctionProcessor extends SendProcessor {

    public BrainSendFunctionProcessor(FunctionService functionService){

        super(functionService) ;
    }

}
