package com.yongyida.robot.nerve.cell.hand.function;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.hand.BrainSendHand;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/7/1.
 */
public abstract class BrainSendHandProcessor extends BrainSendFunctionProcessor {

    public BrainSendHandProcessor(FunctionService functionService) {
        super(functionService);
    }

    @Override
    public final Class<BrainSendHand> getSendClass() {
        return BrainSendHand.class;
    }

    @Override
    public void handleEvent(Container container) {

        BrainSendHand send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, BrainSendHand send) ;
}
