package com.yongyida.robot.nerve.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.yongyida.robot.nerve.send.OutputClient;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */

public class AppUtils {


    /**
     *
     * 通过Action 获取,service package
     * */
    public static HashSet<String> getPackageNameByServiceAction(Context context , String action){

        HashSet<String> packageNames = new HashSet<>() ;

        PackageManager pm = context.getPackageManager();
        Intent robotService = new Intent(action) ;
        List<ResolveInfo> ris =  pm.queryIntentServices(robotService, 0) ;
        final int size = ris.size() ;
        for (int i = 0 ; i < size ; i++){

            ResolveInfo ri = ris.get(i) ;
            packageNames.add(ri.serviceInfo.packageName) ;
        }
        return packageNames ;
    }

    /**
     *
     * 通过Action 获取,service package
     * */
    public static HashMap<String,OutputClient> getOutputClientByServiceAction(Context context , String action){

        HashMap<String,OutputClient> outputClients = new HashMap<>() ;

        PackageManager pm = context.getPackageManager();
        Intent robotService = new Intent(action) ;
        List<ResolveInfo> ris =  pm.queryIntentServices(robotService, 0) ;
        final int size = ris.size() ;
        for (int i = 0 ; i < size ; i++){

//            ResolveInfo ri = ris.get(i) ;
//            packageNames.add(ri.serviceInfo.packageName) ;


            String packageName = ris.get(i).serviceInfo.packageName ;
            OutputClient outputClient = new OutputClient(context, packageName, action) ;
            outputClients.put(packageName, outputClient) ;

        }
        return outputClients ;
    }


}
