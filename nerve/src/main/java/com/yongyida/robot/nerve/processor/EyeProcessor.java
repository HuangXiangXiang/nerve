package com.yongyida.robot.nerve.processor;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.response.EyeResponse;
import com.yongyida.robot.nerve.bean.send.EyeSend;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/23.
 * 眼睛
 */
public abstract class EyeProcessor extends BaseProcessor {


    public EyeProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<EyeResponse> getResponseClass() {

        return EyeResponse.class;
    }

    @Override
    public final Class<EyeSend> getSendClass() {

        return EyeSend.class;
    }

    @Override
    public final void handleEvent(Container container) {

        EyeSend send = container.getData(getSendClass());
        handleEvent(container, send);
    }

    public abstract void handleEvent(Container container, EyeSend send) ;

}
