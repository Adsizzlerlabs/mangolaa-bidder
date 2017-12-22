package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class ApiFrameworksSpec extends BaseSpec {


    def "resolve int to ApiFrameworks repr"() {

        when :
            def result = ApiFrameworks.from(code)

        then :
            result == expectedResult

        where :
            code || expectedResult
            1   || ApiFrameworks.VPAID_1_0
            2   || ApiFrameworks.VPAID_2_0
            3   || ApiFrameworks.MRAID_1
            4   || ApiFrameworks.ORMMA
            5   || ApiFrameworks.MRAID_2
            6   || ApiFrameworks.MRAID_3
            0   || ApiFrameworks.UNKNOWN
    }
}
