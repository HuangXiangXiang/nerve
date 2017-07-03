package com.yongyida.robot.nerve.cell.ear.brain;

import com.yongyida.robot.nerve.cell.FunctionSendBrainProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.ear.BrainSendEar;
import com.yongyida.robot.nerve.cell.ear.EarSendBrain;
import com.yongyida.robot.nerve.service.BrainService;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 * 《大脑》处理《耳朵》发来的信息
 */
public abstract class EarSendBrainProcessor extends FunctionSendBrainProcessor {

    public EarSendBrainProcessor(BrainService brainService) {

        super(brainService);
    }

    @Override
    public final Class<EarSendBrain> getSendClass() {

        return EarSendBrain.class;
    }

    @Override
    public void handleEvent(Container container) {

        EarSendBrain send = container.getData(getSendClass());

        handleEvent(container,send);
    }


    protected abstract void handleEvent(Container container, EarSendBrain send) ;




}
