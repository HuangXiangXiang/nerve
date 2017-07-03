package com.yongyida.robot.nerve.cell.ear.function;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.ear.BrainSendEar;
import com.yongyida.robot.nerve.cell.ear.EarSendBrain;
import com.yongyida.robot.nerve.service.BrainService;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 * 耳朵处理来自大脑的信息
 */
public abstract class BrainSendEarProcessor extends BrainSendFunctionProcessor {

    public BrainSendEarProcessor(FunctionService functionService) {
        super(functionService);
    }

    @Override
    public final Class<BrainSendEar> getSendClass() {

        return BrainSendEar.class;
    }

    @Override
    public void handleEvent(Container container) {

        BrainSendEar send = container.getData(getSendClass());
        handleEvent(container,send);
    }


    protected abstract void handleEvent(Container container, BrainSendEar send) ;


}
