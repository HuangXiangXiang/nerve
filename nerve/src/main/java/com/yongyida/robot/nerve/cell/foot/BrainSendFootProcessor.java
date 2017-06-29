package com.yongyida.robot.nerve.cell.foot;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 */
public abstract class BrainSendFootProcessor extends BrainSendFunctionProcessor {


    public BrainSendFootProcessor(FunctionService functionService) {
        super(functionService);
    }

    @Override
    public final Class<BrainSendFoot> getSendClass() {
        return BrainSendFoot.class;
    }

    @Override
    public void handleEvent(Container container) {

        BrainSendFoot send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, BrainSendFoot send) ;
}
