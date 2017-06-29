package com.yongyida.robot.nerve.cell.expression;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 */
public abstract class ExpressionSendBrainProcessor extends FunctionSendBrainProcessor {

    public ExpressionSendBrainProcessor(BrainService receiveService) {
        super(receiveService);
    }

    @Override
    public final Class<ExpressionSendBrain> getSendClass() {

        return ExpressionSendBrain.class;
    }

    @Override
    public void handleEvent(Container container) {

        ExpressionSendBrain send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, ExpressionSendBrain send) ;
}
