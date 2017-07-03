package com.yongyida.robot.nerve.cell;

import android.content.Context;

/**
 * Created by Huangxiangxiang on 2017/7/3.
 */
public class Send {

    public static final int TYPE_COVER              = 0x00 ;    // 覆盖任务
    public static final int TYPE_APPEND             = 0x01 ;    // 添加任务

    public String test;

    /**任务ID*/
    private final String taskId ;

    /**
     * 是否属于追加任务</br>
     * true 表示追加任务
     * false 表示覆盖任务
     * */
    private int taskType = TYPE_COVER ;

    public Send(Context context){

        this.taskId = context.getPackageName() + "_" +System.currentTimeMillis() ;
    }

}
