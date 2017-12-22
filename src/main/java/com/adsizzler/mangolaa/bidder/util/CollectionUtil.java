package com.adsizzler.mangolaa.bidder.util;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by ankushsharma on 06/10/17.
 */
public class CollectionUtil {

    public static <T>  boolean isNullOrEmpty(final Collection<T> list){
        boolean result = false;
        if (Objects.isNull(list) || list.isEmpty()) {
            result = true;
        }
        return result;
    }
}
