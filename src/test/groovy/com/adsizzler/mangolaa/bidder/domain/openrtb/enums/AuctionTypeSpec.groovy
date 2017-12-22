package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class AuctionTypeSpec extends BaseSpec{

    def "resolve int to AuctionType repr"() {

        when :
            def result = AuctionType.from(code)

        then :
            result == expectedResult

        where :
            code || expectedResult
            1   || AuctionType.FIRST_PRICE
            2   || AuctionType.SECOND_PRICE
    }


}
