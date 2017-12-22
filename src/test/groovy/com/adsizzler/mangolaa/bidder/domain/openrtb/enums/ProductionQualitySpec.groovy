package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class ProductionQualitySpec extends BaseSpec {

    def "resolve int to ProductionQuality repr"() {

        when :
            def result = ProductionQuality.from(intValue)

        then :
            result == expectedResult

        where :
            intValue     || expectedResult
            1            || ProductionQuality.PROFESSIONALLY_PRODUCED
            2            || ProductionQuality.PROSUMER
            3            || ProductionQuality.USER_GENERATED_UGC
            111          || ProductionQuality.UNKNOWN

    }
}
