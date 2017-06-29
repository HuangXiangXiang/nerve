package com.yongyida.robot.nerve.cell;

import com.yongyida.robot.nerve.service.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/29.
 */
public abstract class SendProcessor {

    protected ReceiveService mReceiveService ;

    public SendProcessor(ReceiveService receiveService){

        this.mReceiveService = receiveService ;
    }

    public abstract Class getSendClass ();

    public final String getSendType (){

        return getSendClass().getSimpleName() ;
    }

    public abstract void handleEvent(Container container) ;


    public void responseClient(Container container, Container response){

        mReceiveService.responseClient(container, response);
    }
}
