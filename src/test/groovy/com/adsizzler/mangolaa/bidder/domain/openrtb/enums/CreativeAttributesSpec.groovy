package com.adsizzler.mangolaa.commons.domain.openrtb.enums

import com.adsizzler.mangolaa.commons.BaseSpec

/**
 * Created by Ankush on 02/08/17.
 */
class CreativeAttributesSpec extends BaseSpec{


    def "resolve int to CreativeAttributes repr"() {

        when :
            def result = CreativeAttributes.from(code)

        then :
            result == expectedResult

        where :
            code || expectedResult
            1   || CreativeAttributes.AUDIO_AD_AUTO_PLAY
            2   || CreativeAttributes.AUDIO_AD_USER_INITIATED
            3   || CreativeAttributes.EXPANDABLE_AUTOMATIC
            4   || CreativeAttributes.EXPANDABLE_USER_INITIATED_CLICK
            5   || CreativeAttributes.EXPANDABLE_USER_INITIATED_ROLLOVER
            6   || CreativeAttributes.IN_BANNER_VIDEO_AD_AUTO_PLAY
            7   || CreativeAttributes.IN_BANNER_VIDEO_AD_USER_INITIATED
            8   || CreativeAttributes.POP
            9   || CreativeAttributes.PROVOCATIVE_OR_SUGGESTED_IMAGERY
            10  || CreativeAttributes.ANIMATION
            11  || CreativeAttributes.SURVEYS
            12  || CreativeAttributes.TEXT_ONLY
            13  || CreativeAttributes.USER_INTERACTIVE
            14  || CreativeAttributes.WINDOWS_DIALOG_OR_ALERT_STYLE
            15  || CreativeAttributes.HAS_AUDIO_ON_OR_OFF_BUTTON
            16  || CreativeAttributes.AD_PROVIDES_SKIP_BUTTON
            17  || CreativeAttributes.ADOBE_FLASH
             0  || CreativeAttributes.UNKNOWN
    }

}
