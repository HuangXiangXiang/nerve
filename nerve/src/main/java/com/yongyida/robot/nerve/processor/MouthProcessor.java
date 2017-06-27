package com.yongyida.robot.nerve.processor;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.response.MouthResponse;
import com.yongyida.robot.nerve.bean.send.MouthSend;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 嘴巴
 */
public abstract class MouthProcessor extends BaseProcessor {


    public MouthProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<MouthResponse> getResponseClass() {

        return MouthResponse.class;
    }

    @Override
    public final Class<MouthSend> getSendClass() {

        return MouthSend.class;
    }

    @Override
    public final void handleEvent(Container container) {

        MouthSend send = container.getData(getSendClass());
        handleEvent(container, send);
    }

    public abstract void handleEvent(Container container, MouthSend send) ;
}
