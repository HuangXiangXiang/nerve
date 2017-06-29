package com.yongyida.robot.nerve.cell.smarthome;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 */
public abstract class BrainSendSmartHomeProcessor extends BrainSendFunctionProcessor {

    public BrainSendSmartHomeProcessor(FunctionService functionService) {
        super(functionService);
    }

    @Override
    public final Class<BrainSendSmartHome> getSendClass() {
        return BrainSendSmartHome.class;
    }

    @Override
    public void handleEvent(Container container) {

        BrainSendSmartHome send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, BrainSendSmartHome send) ;
}
