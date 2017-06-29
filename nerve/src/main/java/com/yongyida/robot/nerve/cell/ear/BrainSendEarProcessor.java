package com.yongyida.robot.nerve.cell.ear;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
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
