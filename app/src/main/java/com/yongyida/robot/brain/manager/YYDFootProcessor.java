package com.yongyida.robot.brain.manager;

import android.content.Context;

import com.yongyida.robot.brain.service.BrainService;
import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.send.FootSend;
import com.yongyida.robot.nerve.processor.FootProcessor;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 足
 */
public class YYDFootProcessor extends FootProcessor {

    public YYDFootProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“足”的信息
     * */
    @Override
    public void handleEvent(Container container, FootSend send) {

    }

}
