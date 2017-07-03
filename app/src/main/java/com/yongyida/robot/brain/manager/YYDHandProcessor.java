package com.yongyida.robot.brain.manager;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.hand.HandSendBrain;
import com.yongyida.robot.nerve.cell.hand.brain.HandSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 手
 */
public class YYDHandProcessor extends HandSendBrainProcessor {

    public YYDHandProcessor(BrainService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“手”的信息
     * */
    @Override
    public void handleEvent(Container container, HandSendBrain send) {

    }


}
