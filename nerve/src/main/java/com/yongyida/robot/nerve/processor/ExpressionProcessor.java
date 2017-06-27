package com.yongyida.robot.nerve.processor;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.response.ExpressionResponse;
import com.yongyida.robot.nerve.bean.send.ExpressionSend;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 表情
 */
public abstract class ExpressionProcessor extends BaseProcessor {

    public ExpressionProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<ExpressionResponse> getResponseClass() {

        return ExpressionResponse.class;
    }

    @Override
    public final Class<ExpressionSend> getSendClass() {

        return ExpressionSend.class;
    }

    @Override
    public final void handleEvent(Container container) {

        ExpressionSend send = container.getData(getSendClass());
        handleEvent(container,send);
    }


    public abstract  void handleEvent(Container container, ExpressionSend send) ;
}
