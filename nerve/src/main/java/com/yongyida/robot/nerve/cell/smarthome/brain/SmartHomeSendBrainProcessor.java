package com.yongyida.robot.nerve.cell.smarthome.brain;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.cell.smarthome.BrainSendSmartHome;
import com.yongyida.robot.nerve.cell.smarthome.SmartHomeSendBrain;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/7/1.
 */
public abstract class SmartHomeSendBrainProcessor extends FunctionSendBrainProcessor {

    public SmartHomeSendBrainProcessor(BrainService brainService) {
        super(brainService);
    }

    @Override
    public final Class<SmartHomeSendBrain> getSendClass() {
        return SmartHomeSendBrain.class;
    }

    @Override
    public void handleEvent(Container container) {

        SmartHomeSendBrain send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, SmartHomeSendBrain send) ;
}
