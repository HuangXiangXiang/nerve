package com.yongyida.robot.brain.manager;

import android.util.Log;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.FunctionType;
import com.yongyida.robot.nerve.cell.ear.BrainSendEar;
import com.yongyida.robot.nerve.cell.eye.EyeSendBrain;
import com.yongyida.robot.nerve.cell.eye.EyeSendBrainProcessor;
import com.yongyida.robot.nerve.cell.mouth.BrainSendMouth;
import com.yongyida.robot.nerve.send.OutputClient;
import com.yongyida.robot.nerve.send.SendCenter;
import com.yongyida.robot.nerve.send.SendResponseListener;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/23.
 * 眼睛
 */
public class YYDEyeProcessor extends EyeSendBrainProcessor{

    public static final String TAG = YYDEyeProcessor.class.getName();

    public YYDEyeProcessor(BrainService receiveService) {
        super(receiveService);
    }


    /**
     * 处理来自“眼睛”的信息
     * */
    @Override
    public void handleEvent(final Container send, EyeSendBrain eyeSendBrain) {

        // 接收眼睛信息
        Log.i("hxx", mReceiveService.getPackageName() + eyeSendBrain.test) ;

        //大脑发送信息给嘴巴
        BrainSendMouth brainSendMouth = new BrainSendMouth() ;
        brainSendMouth.test = " brain send mouth " ;
        final Container brainContainer = Container.getBrainSendFunctionContainer(mReceiveService, brainSendMouth) ;

        SendResponseListener sendResponseListener = new SendResponseListener() {

            @Override
            public void responseSend(OutputClient outputClient, Container response) {

                Log.i("hxx", mReceiveService.getPackageName() + " brain response ") ;
                mReceiveService.responseClient(send, response);
            }
        };

        Log.i("hxx", mReceiveService.getPackageName() + brainSendMouth.test) ;
        SendCenter.getInstance(mReceiveService).send(FunctionType.TYPE_MOUTH ,brainContainer, sendResponseListener );

    }


}
