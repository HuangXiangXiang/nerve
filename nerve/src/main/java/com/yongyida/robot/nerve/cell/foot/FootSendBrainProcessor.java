package com.yongyida.robot.nerve.cell.foot;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 */
public abstract class FootSendBrainProcessor extends FunctionSendBrainProcessor {

    public FootSendBrainProcessor(BrainService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<FootSendBrain> getSendClass() {
        return FootSendBrain.class;
    }

    @Override
    public void handleEvent(Container container) {

        FootSendBrain send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, FootSendBrain send) ;
}
