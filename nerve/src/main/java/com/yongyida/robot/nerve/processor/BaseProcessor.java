package com.yongyida.robot.nerve.processor;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.receive.ReceiveService;

/**
 * Created by Huangxiangxiang on 2017/6/26.
 */
public abstract class BaseProcessor {

    protected ReceiveService mReceiveService ;

    public BaseProcessor(ReceiveService receiveService){

        this.mReceiveService = receiveService ;
    }


    public abstract <T>Class<? super T> getResponseClass();

    public abstract<T> Class<? super T> getSendClass ();

    public final String getResponseType(){

        return getResponseClass().getSimpleName() ;
    }

    public final String getSendType (){

       return getSendClass().getSimpleName() ;
    }

    public abstract void handleEvent(Container container) ;


    public void responseClient(Container container, Container response){

        mReceiveService.responseClient(container, response);
    }


}
