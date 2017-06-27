package com.yongyida.robot.nerve.send;

/**
 * Created by Administrator on 2017/6/19.
 */

public class SendClientThread extends Thread {

    private OutputClient outputClient ;
    private String content ;

    public SendClientThread(OutputClient outputClient, String content){

        this.outputClient = outputClient ;
        this.content = content ;
    }

    @Override
    public void run() {

        outputClient.send(content);
    }
}
