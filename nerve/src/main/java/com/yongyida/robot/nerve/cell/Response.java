package com.yongyida.robot.nerve.cell;

import android.content.Context;

/**
 * Created by Huangxiangxiang on 2017/7/3.
 */
public class Response {

    public final static int RESULT_OK                   = 0x00 ;
    public final static int RESULT_Fail                 = 0x01 ;

    public String test;

    public int result = RESULT_OK ;

    /**任务ID*/
    private final String taskId ;

    public Response(Context context){

        this.taskId = context.getPackageName() + "_" +System.currentTimeMillis() ;
    }

}
