package com.yongyida.robot.nerve.send;


import com.yongyida.robot.nerve.bean.Container;

/**
 * Created by Administrator on 2017/6/2.
 *
 *  响应的方法
 */
public interface SendResponseListener {

    void responseSend(OutputClient outputClient, Container container);
}
