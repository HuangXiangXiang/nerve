package com.yongyida.robot.nerve.processor;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.response.HandResponse;
import com.yongyida.robot.nerve.bean.send.HandSend;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 手
 */
public abstract class HandProcessor extends BaseProcessor {


    public HandProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<HandResponse> getResponseClass() {

        return HandResponse.class;
    }

    @Override
    public final Class<HandSend> getSendClass() {

        return HandSend.class;
    }

    @Override
    public final void handleEvent(Container container) {

        HandSend send = container.getData(getSendClass());
        handleEvent(container, send);
    }

    public abstract void handleEvent(Container container, HandSend send) ;
}
