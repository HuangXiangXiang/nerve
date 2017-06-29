package com.yongyida.robot.brain.manager;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.ear.EarSendBrain;
import com.yongyida.robot.nerve.cell.ear.EarSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/23.
 * 耳朵
 */
public class YYDEarProcessor extends EarSendBrainProcessor {


    public YYDEarProcessor(BrainService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“耳朵”的信息
     * */
    @Override
    public void handleEvent(Container container, EarSendBrain earSendBrain) {

    }
}
