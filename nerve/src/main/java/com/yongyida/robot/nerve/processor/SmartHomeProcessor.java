package com.yongyida.robot.nerve.processor;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.response.SmartHomeResponse;
import com.yongyida.robot.nerve.bean.send.SmartHomeSend;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 智能家居
 */
public abstract class SmartHomeProcessor extends BaseProcessor {

    public SmartHomeProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<SmartHomeSend> getSendClass() {

        return SmartHomeSend.class;
    }

    @Override
    public final Class<SmartHomeResponse> getResponseClass() {

        return SmartHomeResponse.class;
    }

    @Override
    public final void handleEvent(Container container) {

        SmartHomeSend send = container.getData(getSendClass());
        handleEvent(container, send);
    }

    public abstract void handleEvent(Container container, SmartHomeSend send) ;
}
