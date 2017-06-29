package com.yongyida.robot.nerve.cell.hand;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 */
public abstract class HandSendBrainProcessor extends FunctionSendBrainProcessor {

    public HandSendBrainProcessor(BrainService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<HandSendBrain> getSendClass() {
        return HandSendBrain.class;
    }

    @Override
    public void handleEvent(Container container) {

        HandSendBrain send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, HandSendBrain send) ;

}
