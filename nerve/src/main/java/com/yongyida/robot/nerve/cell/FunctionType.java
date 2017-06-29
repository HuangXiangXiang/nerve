package com.yongyida.robot.nerve.cell;

import android.util.SparseArray;

/**
 * Created by Huangxiangxiang on 2017/6/23.
 * 功能类型的配置信息
 */
public class FunctionType {

    /**大脑*/
    public static final int TYPE_BRAIN                          = 0x01 ;
    /**嘴巴*/
    public static final int TYPE_MOUTH                          = 0x02 ;
    /**眼睛*/
    public static final int TYPE_EYE                            = 0x03 ;
    /**耳朵*/
    public static final int TYPE_EAR                            = 0x04 ;


    /**足*/
    public static final int TYPE_FOOT                           = 0x10 ;
    /**手*/
    public static final int TYPE_HAND                           = 0x11 ;


    /**表情*/
    public static final int TYPE_EXPRESSION                     = 0x20 ;


    /**智能家庭*/
    public static final int TYPE_SMART_HOME                     = 0x100 ;





    // 以下 用于 配置在Service的Action中
    /**大脑的Action*/
    public static final String ACTION_BRAIN                     = "com.yydrobot.brain" ;
    /**嘴巴的Action*/
    public static final String ACTION_MOUTH                     = "com.yydrobot.mouth" ;
    /**眼睛的Action*/
    public static final String ACTION_EYE                       = "com.yydrobot.eye" ;
    /**耳朵的Action*/
    public static final String ACTION_EAR                       = "com.yydrobot.ear" ;
    /**手的Action*/
    public static final String ACTION_HAND                      = "com.yydrobot.hand" ;
    /**足的Action*/
    public static final String ACTION_FOOT                      = "com.yydrobot.foot" ;
    /**表情的Action*/
    public static final String ACTION_EXPRESSION                = "com.yydrobot.expression" ;

    /**智能家庭*/
    public static final String ACTION_SMART_HOME                = "com.yydrobot.smart_home" ;





    private static final SparseArray<String > actions = new SparseArray<>() ;
    static {

        actions.put(TYPE_BRAIN ,        ACTION_BRAIN);
        actions.put(TYPE_MOUTH ,        ACTION_MOUTH);
        actions.put(TYPE_EYE ,          ACTION_EYE);
        actions.put(TYPE_EAR ,          ACTION_EAR);
        actions.put(TYPE_HAND ,         ACTION_HAND);
        actions.put(TYPE_FOOT ,         ACTION_FOOT);
        actions.put(TYPE_EXPRESSION ,   ACTION_EXPRESSION);
        actions.put(TYPE_SMART_HOME,    ACTION_SMART_HOME);
    }


    /**获取对应消息的Aciton*/
    public static String getAction(int type){

        return actions.get(type) ;
    }

}
