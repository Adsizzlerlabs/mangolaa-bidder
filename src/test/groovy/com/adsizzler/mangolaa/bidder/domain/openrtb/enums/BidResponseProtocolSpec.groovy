package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 04/08/17.
 */
class BidResponseProtocolSpec extends BaseSpec{


    def "resolve int to BidResponseProtocol repr"() {

        when :
        def result = BidResponseProtocol.from(intValue)

        then :
        result == expectedResult

        where :
                intValue  || expectedResult
                1         || BidResponseProtocol.VAST_1_0
                2         || BidResponseProtocol.VAST_2_0
                3         || BidResponseProtocol.VAST_3_0
                4         || BidResponseProtocol.VAST_1_0_WRAPPER
                5         || BidResponseProtocol.VAST_2_0_WRAPPER
                6         || BidResponseProtocol.VAST_3_0_WRAPPER
                7         || BidResponseProtocol.VAST_4_0
                8         || BidResponseProtocol.VAST_4_0_WRAPPER
                9         || BidResponseProtocol.DAST_1_0
                10        || BidResponseProtocol.DAST_1_0_WRAPPER
                0         || BidResponseProtocol.UNKNOWN
    }

}
