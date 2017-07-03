package com.yongyida.robot.nerve.cell.eye.brain;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.cell.eye.EyeSendBrain;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/7/1.
 */
public abstract class EyeSendBrainProcessor extends FunctionSendBrainProcessor {

    public EyeSendBrainProcessor(BrainService receiveService) {

        super(receiveService);
    }

    @Override
    public final Class<EyeSendBrain> getSendClass() {
        return EyeSendBrain.class;
    }

    @Override
    public void handleEvent(Container container) {

        EyeSendBrain send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, EyeSendBrain send) ;
}
