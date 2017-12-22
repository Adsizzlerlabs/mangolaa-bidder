package com.adsizzler.mangolaa.bidder.util;

import lombok.experimental.var;
import lombok.val;

/**
 * Created by Ankush on 17/07/17.
 */
public class Enums {

    private Enums(){}

    @SuppressWarnings({"unchecked"})
    public static <T extends Enum<T>> T getEnumFromString(
            final Class<T> enumClass,
            final String value
        )
    {
        PreConditions.notNull(enumClass, "EnumClass value can't be null");
        PreConditions.notEmptyString(value,"string value cannot be null or empty");

        for (val enumValue : enumClass.getEnumConstants()) {
            if (enumValue.toString().equalsIgnoreCase(value)) {
                return enumValue;
            }
        }
        //Construct an error message that indicates all possible values for the enum.
        val errorMessage = new StringBuilder();
        var bFirstTime = true;
        for (val enumValue : enumClass.getEnumConstants()) {
            errorMessage.append(bFirstTime ? "" : ", ").append(enumValue);
            bFirstTime = false;
        }
        throw new IllegalArgumentException(value + " is invalid value. Supported values are " + errorMessage);
    }

}
