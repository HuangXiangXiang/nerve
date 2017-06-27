package com.yongyida.robot.brain.manager;

import android.util.Log;

import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.bean.DataType;
import com.yongyida.robot.nerve.bean.send.BrainSend;
import com.yongyida.robot.nerve.bean.send.EyeSend;
import com.yongyida.robot.nerve.processor.EyeProcessor;
import com.yongyida.robot.nerve.receive.ReceiveService;
import com.yongyida.robot.nerve.send.OutputClient;
import com.yongyida.robot.nerve.send.SendCenter;
import com.yongyida.robot.nerve.send.SendResponseListener;

/**
 * Created by Huangxiangxiang on 2017/6/23.
 * 眼睛
 */
public class YYDEyeProcessor extends EyeProcessor{

    public static final String TAG = YYDEyeProcessor.class.getName();

    public YYDEyeProcessor(ReceiveService receiveService) {
        super(receiveService);
    }


    /**
     * 处理来自“眼睛”的信息
     * */
    @Override
    public void handleEvent(final Container send, EyeSend eyeSend) {

        // 接收眼睛信息
        Log.i("hxx", mReceiveService.getPackageName() + eyeSend.test) ;

        //大脑发送信息给嘴巴
        BrainSend brainSend = new BrainSend() ;
        brainSend.test = " brain send mouth " ;
        final Container brainContainer = Container.getSendContainer(mReceiveService, brainSend) ;

        SendResponseListener sendResponseListener = new SendResponseListener() {

            @Override
            public void responseSend(OutputClient outputClient, Container response) {

                Log.i("hxx", mReceiveService.getPackageName() + " 大脑接收嘴巴的响应") ;
                mReceiveService.responseClient(send, response);
            }
        };

        Log.i("hxx", mReceiveService.getPackageName() + brainSend.test) ;
        SendCenter.getInstance(mReceiveService).send(DataType.TYPE_MOUTH ,brainContainer, sendResponseListener );

    }


}
