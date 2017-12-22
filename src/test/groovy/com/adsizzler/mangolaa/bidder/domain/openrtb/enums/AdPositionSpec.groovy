package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class AdPositionSpec extends BaseSpec {

    def "resolve int to AdPosition repr"() {

        when :
            def result = AdPosition.from(code)

        then :
            result == expectedResult

        where :
            code || expectedResult
            1 || AdPosition.ABOVE_THE_FOLD
            2 || AdPosition.DEPRECATED
            3 || AdPosition.BELOW_THE_FOLD
            4 || AdPosition.HEADER
            5 || AdPosition.FOOTER
            6 || AdPosition.SIDEBAR
            0 || AdPosition.UNKNOWN
    }

}
