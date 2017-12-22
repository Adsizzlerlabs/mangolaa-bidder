package com.adsizzler.mangolaa.commons.domain

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class StatusSpec extends BaseSpec {

    def "resolve int to Status repr"() {

        when :
            def result = Status.from(code)

        then :
            result == expectedResult

        where :
            code || expectedResult
            1   || Status.ACTIVE
            2   || Status.DEACTIVE
            0   || Status.UNKNOWN
    }

    def "resolve string to Status repr"() {

        when :
            def result = Status.from(string)

        then :
            result == expectedResult

        where :
            string            || expectedResult
            "deactive"        || Status.DEACTIVE
            "active"          || Status.ACTIVE
            "something else"  || Status.UNKNOWN
    }



}
