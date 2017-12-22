package com.adsizzler.mangolaa.bidder.util;

import lombok.val;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by Ankush on 17/07/17.
 */
public class Dates {

    private Dates(){}

    //Current Date and Time as per UTC timezone
    public static LocalDateTime utcNow(){
        return LocalDateTime.now(ZoneId.of("UTC"));
    }

    //Current Date and Time as per UTC timezone
    public static LocalDateTime istNow(){
        return LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
    }

    //Current Date and Time as per UTC timezone
    public static Long utcNowAsMs(){
        return LocalDateTime.now(ZoneId.of("UTC"))
                .atZone(ZoneId.of("UTC"))
                .toInstant()
                .toEpochMilli();
    }


    // as yyyy-MM-dd HH:mm:ss. For example, 1st August 2017 12:33 AM  becomes 2017-08-01 12:33:00
    //If any value is less than 9, simply append a '0' to it
    public static String asIsoString(final LocalDateTime dateTime){
        PreConditions.notNull(dateTime,"dateTime cannot be null");

        val month = dateTime.getMonthValue();
        val day = dateTime.getDayOfMonth();
        val hour = dateTime.getHour();
        val minute = dateTime.getMinute();
        val second = dateTime.getSecond();

        return Strings.build(
                dateTime.getYear(), "-",
                  month <= 9  ?  "0" + month  : month, "-",
                  day <= 9 ? "0" + day : day , " ",
                  hour <= 9 ? "0" + hour : hour , ":",
                  minute <= 9 ? "0" + minute : minute , ":",
                  second <= 9 ? "0" + second : second
        );

    }

    // A date in yyyy-MM-dd format
    public static String asIsoString(final LocalDate date){
        PreConditions.notNull(date,"date cannot be null");

        val month = date.getMonthValue();
        val day = date.getDayOfMonth();

        return Strings.build(
                date.getYear(), "-",
                month <=9 ? "0" + month : month , "-",
                day <= 9 ? "0" + day : day
        );

    }

}
