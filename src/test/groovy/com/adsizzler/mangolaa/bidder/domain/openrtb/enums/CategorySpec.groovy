package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class CategorySpec extends BaseSpec{

    def "resolve string to Category repr"() {

        when :
            def result = Category.from(str)

        then :
            result == expectedResult

        where :
            str       || expectedResult
            "IAB11-2"   || Category.IAB11_2
            "iab1-1"         || Category.IAB1_1
    }

}
