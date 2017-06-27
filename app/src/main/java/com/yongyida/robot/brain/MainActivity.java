package com.yongyida.robot.brain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.yongyida.robot.nerve.bean.send.BrainSend;
import com.yongyida.robot.nerve.bean.Container;
import com.yongyida.robot.nerve.send.OutputClient;
import com.yongyida.robot.nerve.send.SendCenter;
import com.yongyida.robot.nerve.send.SendResponseListener;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void send(View view){

        BrainSend brainSend = new BrainSend() ;
        Container container = Container.getSendContainer(this, brainSend) ;

        SendResponseListener sendResponseListener = new SendResponseListener() {
            @Override
            public void responseSend(OutputClient outputClient, Container container) {

                Log.i(TAG, "responseSend " + container) ;
            }
        };

        SendCenter.getInstance(this).sendToBrain(container, sendResponseListener);

    }

}
