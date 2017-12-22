package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class ContextSpec extends BaseSpec {

    def "resolve int to Context repr"() {

        when :
            def result = Context.from(code)

        then :
            result == expectedResult

        where :
            code || expectedResult
            1   || Context.VIDEO
            2   || Context.GAME
            3   || Context.MUSIC
            4   || Context.APPLICATION
            5   || Context.TEXT
            6   || Context.OTHER
            0   || Context.UNKNOWN
    }
}
