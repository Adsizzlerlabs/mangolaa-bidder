package com.adsizzler.mangolaa.commons.utils

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.Status

/**
 * Created by Ankush on 20/07/17.
 */
class StringsSpec extends BaseSpec{

    def "Does String have text?"(){

        when:
            def result = Strings.hasText(str)

        then:
            result == expectedResult

        where:
            str |  expectedResult
            "A" | true
            null | false
            " "  | false
            ""  | false
            " trim " | true
    }

    def "Build String from a collection of Strings" (){

        when:
            def result = Strings.build(array)

        then:
            result == expectedResult

        where:
            array                                           | expectedResult
            ["a"," " ,"b"].toArray()                        | "a b"
            [Status.ACTIVE, ' ', Status.DEACTIVE].toArray() | 'ACTIVE DEACTIVE'
    }


}
