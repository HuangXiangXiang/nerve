package com.yongyida.robot.brain.manager;

import android.util.Log;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.eye.BrainResponseEye;
import com.yongyida.robot.nerve.cell.eye.EyeSendBrain;
import com.yongyida.robot.nerve.cell.eye.brain.EyeSendBrainProcessor;
import com.yongyida.robot.nerve.cell.mouth.BrainSendMouth;
import com.yongyida.robot.nerve.cell.mouth.MouthResponseBrain;
import com.yongyida.robot.nerve.send.Receiver;
import com.yongyida.robot.nerve.send.SendManager;
import com.yongyida.robot.nerve.send.SendResponseListener;
import com.yongyida.robot.nerve.service.BrainService;

/**
 * Created by Huangxiangxiang on 2017/6/23.
 * 眼睛
 */
public class YYDEyeProcessor extends EyeSendBrainProcessor {

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
        BrainSendMouth brainSendMouth = new BrainSendMouth(mReceiveService) ;
        brainSendMouth.test = " brain send mouth " ;

        SendResponseListener sendResponseListener = new SendResponseListener() {

            @Override
            public void responseSend(Receiver outputClient, Container response) {

                // 大脑发送信息给嘴巴的响应
                MouthResponseBrain mouthResponseBrain = response.getData(MouthResponseBrain.class) ;

                Log.i("hxx", mReceiveService.getPackageName() + mouthResponseBrain.test) ;



                // 响应 eye send brain
                BrainResponseEye brainResponseEye = new BrainResponseEye(mReceiveService) ;
                Container response1 = Container.getBrainResponseFunctionContainer(mReceiveService,brainResponseEye) ;


                mReceiveService.responseClient(send, response);
            }
        };

        Log.i("hxx", mReceiveService.getPackageName() + brainSendMouth.test) ;
        SendManager.getInstance(mReceiveService).brainSendFunction(brainSendMouth, sendResponseListener );

    }


}
