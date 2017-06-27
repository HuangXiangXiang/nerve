package com.yongyida.robot.nerve.processor;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.response.EarResponse;
import com.yongyida.robot.nerve.bean.send.EarSend;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/23.
 * 耳朵
 */
public abstract class EarProcessor extends BaseProcessor {


    public EarProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<EarResponse> getResponseClass() {

        return EarResponse.class;
    }

    @Override
    public final Class<EarSend> getSendClass() {

        return EarSend.class;
    }

    @Override
    public final void handleEvent(Container container) {

        EarSend earSend = container.getData(getSendClass());
        handleEvent(container,earSend);
    }


    /**
     * 处理来自“耳朵”的信息
     * */
    public abstract void handleEvent(Container container, EarSend earSend);

}
