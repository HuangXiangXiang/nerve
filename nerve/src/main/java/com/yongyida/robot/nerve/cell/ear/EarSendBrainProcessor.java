package com.yongyida.robot.nerve.cell.ear;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 * 耳朵发送给大脑的处理
 */
public abstract class EarSendBrainProcessor extends FunctionSendBrainProcessor {

    public EarSendBrainProcessor(BrainService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<EarSendBrain> getSendClass() {

        return EarSendBrain.class;
    }

    @Override
    public void handleEvent(Container container) {

        EarSendBrain send = container.getData(getSendClass());
        handleEvent(container,send);
    }


    protected abstract void handleEvent(Container container, EarSendBrain send) ;




}
