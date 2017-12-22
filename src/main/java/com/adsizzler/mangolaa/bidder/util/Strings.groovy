package com.adsizzler.mangolaa.bidder.util
/**
 * Created by Ankush on 17/07/17.
 */
class Strings {

     static final String EMPTY = "";

    /*
    * Returns false if the String does not have text after trimming
    * */
     static boolean hasText(String text){
        if(!text){
            return false
        }
        for(char ch in text.toCharArray()){
            if(!Character.isWhitespace(ch)){
                return true
            }
        }
        return false
    }

    /*
    * Uses a StringBuilder to build an array of objects. The value returned in the Object's toString method is considered
    * If a null is passed in the array, it is simply ignored
    * */
    static <T> String build(final T... array){
        PreConditions.notNull(array, "array cannot be null");
        def sb = new StringBuilder()
        for(T object in array){
            if(Objects.nonNull(object)){
                sb.append(object.toString())
            }
        }
        return sb.toString()
    }

}
