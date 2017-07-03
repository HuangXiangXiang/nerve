package com.yongyida.robot.brain.manager;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.expression.ExpressionSendBrain;
import com.yongyida.robot.nerve.cell.expression.brain.ExpressionSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 表情
 */
public class YYDExpressionProcessor extends ExpressionSendBrainProcessor {


    public YYDExpressionProcessor(BrainService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“表情”的信息
     * */
    @Override
    public void handleEvent(Container container, ExpressionSendBrain send) {

    }
}
