package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class ConnectionTypeSpec extends BaseSpec {

    def "resolve string to ConnectionType repr"() {

        when :
            def result = ConnectionType.from(code)

        then :
            result == expectedResult

        where :
             code        || expectedResult
                 1       || ConnectionType.ETHERNET
                 2       || ConnectionType.WIFI
                 3       || ConnectionType.CELLULAR_NETWORK_UNKNOWN_GENERATION
                 4       || ConnectionType.CELLULAR_NETWORK_2G
                 5       || ConnectionType.CELLULAR_NETWORK_3G
                 6       || ConnectionType.CELLULAR_NETWORK_4G

    }
}
