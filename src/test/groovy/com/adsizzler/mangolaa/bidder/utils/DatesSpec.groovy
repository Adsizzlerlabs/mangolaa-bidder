package com.adsizzler.mangolaa.commons.utils

import com.adsizzler.mangolaa.bidder.util.Dates
import com.adsizzler.mangolaa.commons.BaseSpec

import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Created by Ankush on 20/07/17.
 */
class DatesSpec extends BaseSpec {

    def "Throw IllegalArgumentException when passing a null to asIsoString method(LocalDateTime)"(){
        when :
            Dates.asIsoString(null as LocalDateTime)

        then :
            thrown(IllegalArgumentException)
    }

    def "Converting Java's LocalDateTime object to ISO String representation. The DateTime returned should have format yyyy-MM-dd HH:mm:ss"(){

        when :
            def result = Dates.asIsoString(dateTime)

        then :
            result == expectedResult

        where :
            dateTime                              | expectedResult
            LocalDateTime.of(2017,11,1,12,12,1) | "2017-11-01 12:12:01"
            LocalDateTime.of(2017,1,1,1,1,1) | "2017-01-01 01:01:01"

    }


    def "Converting Java's LocalDate object to ISO String representation. The date returned should have format yyyy-MM-dd "(){

        when :
            def result = Dates.asIsoString(dateTime)

        then :
            result == expectedResult

        where :
            dateTime                         | expectedResult
            LocalDate.of(2017,1,1)  | "2017-01-01"
            LocalDate.of(2017,11,11) | "2017-11-11"

    }

    def "Throw IllegalArgumentException when passing a null to asIsoString method(LocalDate)"(){
        when :
            Dates.asIsoString(null as LocalDate)

        then :
            thrown(IllegalArgumentException)
    }


}
