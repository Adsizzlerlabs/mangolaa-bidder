package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class DeviceTypeSpec extends BaseSpec{

    def "resolve int to DeviceType repr"() {

        when :
            def result = DeviceType.from(code)

        then :
            result == expectedResult

        where :
            code || expectedResult
            1   || DeviceType.MOBILE_TABLET
            2   || DeviceType.PERSONAL_COMPUTER
            3   || DeviceType.TV
            4   || DeviceType.PHONE
            5   || DeviceType.TABLET
            6   || DeviceType.CONNECTED_DEVICE
            7   || DeviceType.SET_TOP_BOX
            0   || DeviceType.UNKNOWN
    }
}
