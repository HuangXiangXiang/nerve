package com.yongyida.robot.nerve.processor;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.send.BaseSend;
import com.yongyida.robot.nerve.bean.send.BrainSend;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/26.
 */
public abstract class BrainProcessor extends BaseProcessor {


    public BrainProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<BaseSend> getResponseClass() {

        return BaseSend.class;
    }

    @Override
    public final Class<BrainSend> getSendClass() {

        return BrainSend.class;
    }


    @Override
    public final void handleEvent(Container container) {

        BrainSend brainSend = container.getData(getSendClass());
        handleEvent(container, brainSend);
    }

    public abstract void handleEvent(Container container, BrainSend brainSend);

}
