package com.yongyida.robot.nerve.processor;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.response.FootResponse;
import com.yongyida.robot.nerve.bean.send.FootSend;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 足
 */
public abstract class FootProcessor extends BaseProcessor {

    public FootProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<FootResponse> getResponseClass() {

        return FootResponse.class;
    }

    @Override
    public final Class<FootSend> getSendClass() {

        return FootSend.class;
    }

    @Override
    public final void handleEvent(Container container) {

        FootSend send = container.getData(getSendClass());
        handleEvent(container, send);
    }

    public abstract void handleEvent(Container container, FootSend send) ;

}
