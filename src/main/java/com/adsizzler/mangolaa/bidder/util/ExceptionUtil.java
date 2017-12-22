package com.adsizzler.mangolaa.bidder.util;

import java.util.Objects;

/**
 * Created by ankushsharma on 03/10/17.
 */
public class ExceptionUtil {

    public static String shortDescription(final Throwable th){
        String result;
        if(Objects.isNull(th)){
            result = "Unknown Exception";
        }
        else{
            result = th.getMessage();
        }
        return result;
    }
}
