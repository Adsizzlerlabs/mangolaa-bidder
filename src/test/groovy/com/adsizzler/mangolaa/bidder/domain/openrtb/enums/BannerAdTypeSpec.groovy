package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class BannerAdTypeSpec extends BaseSpec{

    def "resolve int to BannerAdType repr"() {

        when :
            def result = BannerAdType.from(code)

        then :
            result == expectedResult

        where :
            code || expectedResult
            1   || BannerAdType.XHTML_TEXT
            2   || BannerAdType.XHTML_BANNER
            3   || BannerAdType.JAVASCRIPT
            4   || BannerAdType.IFRAME

    }
//    XHTML_TEXT(1),
//    XHTML_BANNER(2),
//    JAVASCRIPT(3),
//    IFRAME(4);


}
