package com.yongyida.robot.brain.manager;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.foot.FootSendBrain;
import com.yongyida.robot.nerve.cell.foot.brain.FootSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 足
 */
public class YYDFootProcessor extends FootSendBrainProcessor {

    public YYDFootProcessor(BrainService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“足”的信息
     * */
    @Override
    public void handleEvent(Container container, FootSendBrain send) {

    }

}
