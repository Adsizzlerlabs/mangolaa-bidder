package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class GenderSpec extends BaseSpec{

    def "resolve string to Gender repr"() {

        when :
            def result = Gender.from(str)

        then :
            result == expectedResult

        where :
             str || expectedResult
            "m"    || Gender.MALE
            "M"    || Gender.MALE
            "f"    || Gender.FEMALE
            "F"    || Gender.FEMALE
            "Other" || Gender.UNKNOWN
    }

}
