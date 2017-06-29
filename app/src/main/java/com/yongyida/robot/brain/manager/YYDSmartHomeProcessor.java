package com.yongyida.robot.brain.manager;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.smarthome.SmartHomeSendBrain;
import com.yongyida.robot.nerve.cell.smarthome.SmartHomeSendBrainProcessor;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 智能家居
 */
public class YYDSmartHomeProcessor extends SmartHomeSendBrainProcessor{

    public YYDSmartHomeProcessor(BrainService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“智能家居”的信息
     * */
    @Override
    public void handleEvent(Container container, SmartHomeSendBrain send) {

    }

}
