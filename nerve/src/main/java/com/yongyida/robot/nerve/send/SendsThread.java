package com.yongyida.robot.nerve.send;

import com.yongyida.robot.nerve.cell.Container;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/19.
 * 直接发送数据
 */
public class SendsThread extends Thread {

    private ArrayList<Receiver> receivers;
    private Container container ;               // 发送的数据
    private SendResponseListener responseListener ;

    public SendsThread(ArrayList<Receiver> receivers, Container container,
                       SendResponseListener responseListener ){

        this.receivers = receivers;
        this.container = container ;
        this.responseListener = responseListener ;
    }

    @Override
    public void run() {

        for (Receiver receiver : receivers){

            receiver.setResponse(responseListener);
            new SendThread(receiver, container).start();
        }
    }
}
