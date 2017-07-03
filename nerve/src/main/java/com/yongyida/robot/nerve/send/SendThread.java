package com.yongyida.robot.nerve.send;

import com.yongyida.robot.nerve.cell.Container;

/**
 * Created by Administrator on 2017/6/19.
 */

public class SendThread extends Thread {

    private Receiver receiver;
    private Container container ;

    public SendThread(Receiver receiver, Container container){

        this.receiver = receiver;
        this.container = container ;
    }

    @Override
    public void run() {

        receiver.send(container);
    }
}
