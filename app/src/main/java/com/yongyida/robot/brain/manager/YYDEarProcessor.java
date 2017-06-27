package com.yongyida.robot.brain.manager;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.send.EarSend;
import com.yongyida.robot.nerve.processor.EarProcessor;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/23.
 * 耳朵
 */
public class YYDEarProcessor extends EarProcessor{


    public YYDEarProcessor(ReceiveService receiveService) {
        super(receiveService);
    }

    /**
     * 处理来自“耳朵”的信息
     * */
    @Override
    public void handleEvent(Container container, EarSend earSend) {

    }
}
