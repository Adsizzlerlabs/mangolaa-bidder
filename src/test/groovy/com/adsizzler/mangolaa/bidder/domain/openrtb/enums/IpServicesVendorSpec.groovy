package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class IpServicesVendorSpec extends BaseSpec {

    def "resolve int to IpServicesVendor repr"() {

        when :
            def result = IpServicesVendor.from(code)

        then :
            result == expectedResult

        where :
            code  || expectedResult
            1     || IpServicesVendor.QUOVA
            2     || IpServicesVendor.MAXMIND
            3     || IpServicesVendor.DIGITAL_ELEMENT
            111   || IpServicesVendor.UNKNOWN

    }

}
