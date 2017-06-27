package com.yongyida.robot.brain.service;

import com.yongyida.robot.brain.manager.YYDEarProcessor;
import com.yongyida.robot.brain.manager.YYDExpressionProcessor;
import com.yongyida.robot.brain.manager.YYDEyeProcessor;
import com.yongyida.robot.brain.manager.YYDFootProcessor;
import com.yongyida.robot.brain.manager.YYDHandProcessor;
import com.yongyida.robot.brain.manager.YYDMouthProcessor;
import com.yongyida.robot.brain.manager.YYDSmartHomeProcessor;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/19.
 *
 * 相当于大脑，处理来自各个方向的信息
 * 正常情况下，不会主动
 */
public class BrainService extends ReceiveService {

    private final static String TAG = BrainService.class.getName() ;


    @Override
    public void onCreate() {
        super.onCreate();

        setProcessor(new YYDEarProcessor(this));
        setProcessor(new YYDExpressionProcessor(this));
        setProcessor(new YYDEyeProcessor(this));
        setProcessor(new YYDFootProcessor(this));
        setProcessor(new YYDHandProcessor(this));
        setProcessor(new YYDMouthProcessor(this));
        setProcessor(new YYDSmartHomeProcessor(this));

    }






}
