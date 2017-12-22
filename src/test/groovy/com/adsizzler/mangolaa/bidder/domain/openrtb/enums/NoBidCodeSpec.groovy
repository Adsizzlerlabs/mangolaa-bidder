package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 08/08/17.
 */
class NoBidCodeSpec extends BaseSpec {


    def "resolve int to BidCode repr"() {

        when :
            def result = NoBidCode.from(intValue)

        then :
            result == expectedResult

        where :
             intValue     || expectedResult
                0         || NoBidCode.UNKNOWN_ERROR
                1         || NoBidCode.TECHNICAL_ERROR
                2         || NoBidCode.INVALID_REQUEST
                3         || NoBidCode.KNOWN_WEB_SPIDER
                4         || NoBidCode.SUSPECTED_NON_HUMAN_TRAFFIC
                5         || NoBidCode.CLOUD_DATA_CENTER_OR_PROXY_IP
                6         || NoBidCode.UNSUPPORTED_DEVICE
                7         || NoBidCode.BLOCKED_PUBLISHER_OR_SITE
                8         || NoBidCode.UNMATCHED_USER
                9         || NoBidCode.DAILY_READER_CAP_MET
                10        || NoBidCode.DAILY_DOMAIN_CAP_MET

    }
}
