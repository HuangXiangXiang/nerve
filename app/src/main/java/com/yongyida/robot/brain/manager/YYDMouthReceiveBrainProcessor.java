package com.yongyida.robot.brain.manager;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.mouth.MouthSendBrain;
import com.yongyida.robot.nerve.cell.mouth.brain.MouthSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 嘴巴
 */
public class YYDMouthReceiveBrainProcessor extends MouthSendBrainProcessor {

    public YYDMouthReceiveBrainProcessor(BrainService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“嘴巴”的信息
     * */
    @Override
    public void handleEvent(Container container, MouthSendBrain send) {

    }


}
