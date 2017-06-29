package com.yongyida.robot.nerve.cell.smarthome;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 智能家居
 */
public abstract class SmartHomeSendBrainProcessor extends FunctionSendBrainProcessor {

    public SmartHomeSendBrainProcessor(BrainService receiveService) {

        super(receiveService);
    }

    @Override
    public final Class<SmartHomeSendBrain> getSendClass() {

        return SmartHomeSendBrain.class;
    }


    @Override
    public final void handleEvent(Container container) {

        SmartHomeSendBrain send = container.getData(getSendClass());
        handleEvent(container, send);
    }

    public abstract void handleEvent(Container container, SmartHomeSendBrain send) ;
}
