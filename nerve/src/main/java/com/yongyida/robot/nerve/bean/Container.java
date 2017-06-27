package com.yongyida.robot.nerve.bean;

import android.content.Context;

import com.google.gson.Gson;
import com.yongyida.robot.nerve.bean.response.BaseResponse;
import com.yongyida.robot.nerve.bean.send.BaseSend;

/**
 * Created by Huangxiangxiang on 2017/6/26.
 * 传输数据的容器，
 * 将对象转换成JSON字符串使用
 */
public class Container {

    // 数据来源
    private String packageName ;

    private String className ;
    private String data ;

    public static Container fromJson(String json){

        return new Gson().fromJson(json, Container.class) ;
    }

    public static Container getSendContainer(Context context, BaseSend baseSend){

        return new Container(context, baseSend) ;
    }

    public static Container getResponseContainer(Context context, BaseResponse baseResponse){

        return new Container(context, baseResponse) ;
    }

    private Container(Context context, Object object){

        this.packageName = context.getPackageName() ;

        this.className = object.getClass().getSimpleName() ;
        this.data = toJson(object) ;
    }

    public String getClassName() {

        return className;
    }

    public String getPackageName() {
        return packageName;
    }

    public <T>T getData(Class<T> classOfT){

        return fromJson(data, classOfT) ;
    }

    public String toJson() {

        return new Gson().toJson(this);
    }

    private static String toJson(Object object) {

        return new Gson().toJson(object);
    }

    private static <T>T fromJson(String json ,Class<T> classOfT){

        return new Gson().fromJson(json, classOfT) ;
    }
}
