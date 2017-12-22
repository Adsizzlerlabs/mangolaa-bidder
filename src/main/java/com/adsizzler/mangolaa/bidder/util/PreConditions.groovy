package com.adsizzler.mangolaa.bidder.util
/**
 * Created by Ankush on 17/07/17.
 */
class PreConditions {

    static <T> void notNull(T t, String errorMsg){
        if(Objects.isNull(t)){
            throw new IllegalArgumentException(errorMsg);
        }
    }

    static void notEmptyString(String string, String errorMsg){
        if(!Strings.hasText(string)){
            throw new IllegalArgumentException(errorMsg);
        }
    }

}
