package com.yongyida.robot.brain.manager;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.send.MouthSend;
import com.yongyida.robot.nerve.processor.MouthProcessor;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/24.
 * 嘴巴
 */
public class YYDMouthProcessor extends MouthProcessor {

    public YYDMouthProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“嘴巴”的信息
     * */
    @Override
    public void handleEvent(Container container, MouthSend send) {

    }


}
