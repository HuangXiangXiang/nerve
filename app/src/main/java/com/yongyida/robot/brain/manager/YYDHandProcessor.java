package com.yongyida.robot.brain.manager;

import android.content.Context;

import com.yongyida.robot.brain.service.BrainService;
import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.send.HandSend;
import com.yongyida.robot.nerve.processor.HandProcessor;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 手
 */
public class YYDHandProcessor extends HandProcessor{

    public YYDHandProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“手”的信息
     * */
    @Override
    public void handleEvent(Container container, HandSend send) {

    }


}
