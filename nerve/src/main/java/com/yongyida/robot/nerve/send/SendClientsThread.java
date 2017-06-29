package com.yongyida.robot.nerve.send;

import com.yongyida.robot.nerve.cell.Container;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/19.
 * 直接发送数据
 */
public class SendClientsThread extends Thread {

    private ArrayList<OutputClient> outputClients ;
    private String content ;               // 发送的数据
    private SendResponseListener mResponseListener ;

    public SendClientsThread(ArrayList<OutputClient> outputClients,Container container,
                             SendResponseListener responseListener ){

        this.outputClients = outputClients ;
        this.content = container.toJson() ;
        this.mResponseListener = responseListener ;
    }

    @Override
    public void run() {

        for (OutputClient outputClient : outputClients){

            outputClient.setResponse(mResponseListener);
            new SendClientThread(outputClient, content).start();
        }
    }
}
