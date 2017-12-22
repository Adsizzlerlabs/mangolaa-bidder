package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class SourceRelationshipSpec extends BaseSpec {

    def "resolve int to SourceRelationship repr"() {

        when :
             def result = SourceRelationship.from(intValue)

        then :
             result == expectedResult

        where :
            intValue     || expectedResult
            1            || SourceRelationship.DIRECT
            2            || SourceRelationship.INDIRECT
            3            || SourceRelationship.UNKNOWN

    }
}
