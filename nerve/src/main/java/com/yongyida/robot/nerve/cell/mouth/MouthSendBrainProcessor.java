package com.yongyida.robot.nerve.cell.mouth;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 嘴巴
 */
public abstract class MouthSendBrainProcessor extends FunctionSendBrainProcessor {

    public MouthSendBrainProcessor(BrainService receiveService) {

        super(receiveService);
    }

    @Override
    public final Class<MouthSendBrain> getSendClass() {

        return MouthSendBrain.class;
    }

    @Override
    public final void handleEvent(Container container) {

        MouthSendBrain send = container.getData(getSendClass());
        handleEvent(container, send);
    }

    public abstract void handleEvent(Container container, MouthSendBrain send) ;
}
