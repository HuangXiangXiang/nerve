package com.yongyida.robot.nerve.cell.expression.function;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.expression.ExpressionSendBrain;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/7/1.
 */
public abstract class BrainSendExpressionProcessor extends BrainSendFunctionProcessor {

    public BrainSendExpressionProcessor(FunctionService functionService) {
        super(functionService);
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
