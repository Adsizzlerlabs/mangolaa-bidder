package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class LocationTypeSpec extends BaseSpec{


    def "resolve int to LocationType repr"() {

        when :
            def result = LocationType.from(code)

        then :
            result == expectedResult

        where :
            code  || expectedResult
            1     || LocationType.GPS_LOCATION_SERVICES
            2     || LocationType.IP_ADDRESS
            3     || LocationType.USER_PROVIDED
            111   || LocationType.UNKNOWN

    }

}
