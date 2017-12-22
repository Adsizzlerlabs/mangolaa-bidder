package com.adsizzler.mangolaa.commons.utils

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 20/07/17.
 */
class EnumsSpec extends BaseSpec {

    private enum Gender{
        MALE,
        FEMALE
    }

    def "Get Enum from String representation, ignoring case of the string"(){

        when :
            def result = Enums.getEnumFromString(Gender,string)

        then :
            result == expectedResult

        where :
            string | expectedResult
            "male" | Gender.MALE
            "maLe" | Gender.MALE
            "FEMALE" | Gender.FEMALE

    }

    def "Throw IllegalArgumentException if a string yields no Enum representation or when null is passed "(){

        when :
            Enums.getEnumFromString(Gender,null)

        then :
            thrown(IllegalArgumentException)

        when :
            Enums.getEnumFromString(Gender, "Some other thing")

        then :
            thrown(IllegalArgumentException)

    }

    def "Throw IllegalArgumentException is no class is passed to method"(){

        when :
            Enums.getEnumFromString(null,"Some string")

        then :
            thrown(IllegalArgumentException)

    }
}
