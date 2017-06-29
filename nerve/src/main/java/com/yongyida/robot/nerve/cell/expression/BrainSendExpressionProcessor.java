package com.yongyida.robot.nerve.cell.expression;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 */
public abstract class BrainSendExpressionProcessor extends BrainSendFunctionProcessor {

    public BrainSendExpressionProcessor(FunctionService functionService) {
        super(functionService);
    }

    @Override
    public final Class<BrainSendExpression> getSendClass() {

        return BrainSendExpression.class;
    }

    @Override
    public void handleEvent(Container container) {

        BrainSendExpression send = container.getData(getSendClass());
        handleEvent(container,send);
    }

    protected abstract void handleEvent(Container container, BrainSendExpression send) ;
}
