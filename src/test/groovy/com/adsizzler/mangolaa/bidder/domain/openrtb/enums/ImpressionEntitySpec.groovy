package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class ImpressionEntitySpec extends BaseSpec {

    def "resolve int to ImpressionEntity repr"() {

        when :
            def result = ImpressionEntity.from(code)

        then :
            result == expectedResult

        where :
            code || expectedResult
            0    || ImpressionEntity.EXCHANGE
            1    || ImpressionEntity.UPSTREAM
            111   || ImpressionEntity.EXCHANGE  //DEFAULT VALUE, SOME OTHER RANDOM INT. This wouldn't happen in real world scenario
    }
}
