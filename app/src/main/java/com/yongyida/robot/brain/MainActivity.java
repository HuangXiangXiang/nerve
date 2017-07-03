package com.yongyida.robot.brain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.yongyida.robot.nerve.cell.Container;
import com.yongyida.robot.nerve.cell.ear.BrainSendEar;
import com.yongyida.robot.nerve.cell.ear.EarResponseBrain;
import com.yongyida.robot.nerve.send.Receiver;
import com.yongyida.robot.nerve.send.SendManager;
import com.yongyida.robot.nerve.send.SendResponseListener;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void send(View view){

        BrainSendEar brainSendEar = new BrainSendEar(this) ;

        SendResponseListener sendResponseListener = new SendResponseListener() {
            @Override
            public void responseSend(Receiver outputClient, Container container) {

                EarResponseBrain earResponseBrain = container.getData(EarResponseBrain.class) ;

                Log.i(TAG, "responseSend " + container) ;
            }
        };

        SendManager.getInstance(this).brainSendFunction(brainSendEar, sendResponseListener);

    }

}
