package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class ModeSpec extends BaseSpec{

    def "resolve int to Mode repr"() {

        when :
            def result = Mode.from(intValue)

        then :
            result == expectedResult

        where :
             intValue   || expectedResult
                0       || Mode.LIVE
                1       || Mode.TEST
                0       || Mode.LIVE

    }
}
