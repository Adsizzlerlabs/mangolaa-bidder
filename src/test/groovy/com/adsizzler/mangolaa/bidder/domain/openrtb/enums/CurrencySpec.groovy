package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class CurrencySpec extends BaseSpec{

    def "resolve int to Currency repr"() {

        when :
            def result = Currency.from(str)

        then :
            result == expectedResult

        where : "only lower case or all upper case will work"
            str     || expectedResult
            "usd"   || Currency.USD
            "INR"   || Currency.INR
    }

}
