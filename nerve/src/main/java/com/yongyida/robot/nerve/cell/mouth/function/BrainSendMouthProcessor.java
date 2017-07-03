package com.yongyida.robot.nerve.cell.mouth.function;

import com.yongyida.robot.nerve.cell.BrainSendFunctionProcessor;
import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.mouth.BrainSendMouth;
import com.yongyida.robot.nerve.service.FunctionService;

/**
 * Created by Huangxiangxiang on 2017/7/1.
 */
public abstract class BrainSendMouthProcessor extends BrainSendFunctionProcessor {

    public BrainSendMouthProcessor(FunctionService functionService) {

        super(functionService);
    }

    @Override
    public final Class<BrainSendMouth> getSendClass() {

        return BrainSendMouth.class;
    }

    @Override
    public final void handleEvent(Container container) {

        BrainSendMouth send = container.getData(getSendClass());
        handleEvent(container, send);
    }

    public abstract void handleEvent(Container container, BrainSendMouth send) ;

}
