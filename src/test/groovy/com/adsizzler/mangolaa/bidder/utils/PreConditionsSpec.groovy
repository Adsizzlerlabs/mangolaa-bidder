package com.adsizzler.mangolaa.commons.utils

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 20/07/17.
 */
class PreConditionsSpec extends BaseSpec {

    def "Testing PreConditions. If condition is violated, IllegalArgumentException is thrown, otherwise all ok"(){

        when:
             PreConditions.notNull("aaaaaa","Some error msg")

        then:
             notThrown(Exception)

    }

    def "Pass null obj. IllegalArgumentException would be thrown"(){

        when:
            PreConditions.notNull(null,"Some error msg")

        then:
            thrown(IllegalArgumentException)
    }


    def "Pass in an empty string. IllegalArgumentException will be thrown"(){

        when:
            PreConditions.notEmptyString(' ','Some msg')

        then:
            thrown(IllegalArgumentException)

    }

    def "Pass in null. IllegalArgumentException will be thrown"(){

        when:
            PreConditions.notEmptyString(null,'Some msg')

        then:
            thrown(IllegalArgumentException)

    }



}
