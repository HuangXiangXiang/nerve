package com.yongyida.robot.nerve.cell.mouth;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 */
public abstract class BrainSendMouthProcessor extends BrainSendFunctionProcessor {

    public BrainSendMouthProcessor(FunctionService functionService) {
        super(functionService);
    }

    @Override
    public final Class<BrainSendMouth> getSendClass() {
        return BrainSendMouth.class;
    }

    @Override
    public void handleEvent(Container container) {

        BrainSendMouth send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, BrainSendMouth send) ;
}
