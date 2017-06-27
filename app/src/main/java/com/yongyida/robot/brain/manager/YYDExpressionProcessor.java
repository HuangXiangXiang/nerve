package com.yongyida.robot.brain.manager;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.send.ExpressionSend;
import com.yongyida.robot.nerve.processor.ExpressionProcessor;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 表情
 */
public class YYDExpressionProcessor extends ExpressionProcessor {


    public YYDExpressionProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“表情”的信息
     * */
    @Override
    public void handleEvent(Container container, ExpressionSend send) {

    }
}
