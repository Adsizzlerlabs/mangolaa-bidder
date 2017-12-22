package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class MediaRatingSpec extends BaseSpec{

    def "resolve int to MediaRating repr"() {

        when :
            def result = MediaRating.from(code)

        then :
            result == expectedResult

        where :
            code  || expectedResult
            1     || MediaRating.ALL_AUDIENCES
            2     || MediaRating.EVERYONE_OVER_12
            3     || MediaRating.MATURE_AUDIENCES
            111   || MediaRating.UNKNOWN

    }
}
