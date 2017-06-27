package com.yongyida.robot.brain.manager;

import android.content.Context;

import com.yongyida.robot.brain.service.BrainService;
import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.send.SmartHomeSend;
import com.yongyida.robot.nerve.processor.SmartHomeProcessor;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 智能家居
 */
public class YYDSmartHomeProcessor extends SmartHomeProcessor{

    public YYDSmartHomeProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“智能家居”的信息
     * */
    @Override
    public void handleEvent(Container container, SmartHomeSend send) {

    }

}
