package com.yongyida.robot.nerve.cell.eye;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 */
public abstract class BrainSendEyeProcessor extends BrainSendFunctionProcessor {

    public BrainSendEyeProcessor(FunctionService functionService) {
        super(functionService);
    }

    @Override
    public final Class<BrainSendEye> getSendClass() {
        return BrainSendEye.class;
    }

    @Override
    public void handleEvent(Container container) {

        BrainSendEye send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, BrainSendEye send) ;

}
