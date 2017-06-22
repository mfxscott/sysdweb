package com.scott.net.datadb;

import org.apache.commons.logging.Log;

/**
 * Created by mfx-t224 on 2017/6/22.
 */
public class LogUtil {
    public  static boolean isDebug = true;
    public static void LogDebug(String str){
        if(isDebug)
            System.out.println("LogInfo===="+str);
    }
}
