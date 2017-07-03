package com.yongyida.robot.nerve.cell;

import com.yongyida.robot.nerve.cell.ear.BrainSendEar;
import com.yongyida.robot.nerve.cell.expression.BrainSendExpression;
import com.yongyida.robot.nerve.cell.eye.BrainSendEye;
import com.yongyida.robot.nerve.cell.foot.BrainSendFoot;
import com.yongyida.robot.nerve.cell.hand.BrainSendHand;
import com.yongyida.robot.nerve.cell.mouth.BrainSendMouth;
import com.yongyida.robot.nerve.cell.smarthome.BrainSendSmartHome;

import java.util.HashMap;

/**
 * Created by Huangxiangxiang on 2017/6/23.
 * 功能类型的配置信息
 */
public class FunctionType {


    // 以下 用于 配置在Service的Action中
    /**大脑的Action*/
    public static final String ACTION_BRAIN                     = "com.yydrobot.brain" ;

    public static final String PACKAGE_BRAIN                    = "" ;

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


    private static final HashMap<Class<? extends BrainSendFunction>, String> actions = new HashMap<>() ;
    static {

        actions.put(BrainSendMouth.class,           ACTION_MOUTH);
        actions.put(BrainSendEye.class,             ACTION_EYE);
        actions.put(BrainSendEar.class,             ACTION_EAR);
        actions.put(BrainSendHand.class,            ACTION_HAND);
        actions.put(BrainSendFoot.class,            ACTION_FOOT);
        actions.put(BrainSendExpression.class,      ACTION_EXPRESSION);
        actions.put(BrainSendSmartHome.class,       ACTION_SMART_HOME);
    }


    /**获取对应消息的Aciton*/
    public static String getAction(Class<? extends BrainSendFunction> clazz){

        return actions.get(clazz) ;
    }

}
