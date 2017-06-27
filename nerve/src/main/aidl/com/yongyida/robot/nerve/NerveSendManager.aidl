package com.yongyida.robot.nerve ;

import com.yongyida.robot.nerve.ResponseListener ;

interface NerveSendManager {

    String setResponseListener(String content, ResponseListener responseListener) ;

    String send(String content) ;

}
