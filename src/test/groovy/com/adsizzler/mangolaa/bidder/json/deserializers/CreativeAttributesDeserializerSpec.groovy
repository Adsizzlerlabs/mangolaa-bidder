package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.CreativeAttributes
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.CreativeAttributesDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 27/07/17.
 */
class CreativeAttributesDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup() {
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its CreativeAttributes enum repr "() {
        given:
            def json = new JsonBuilder([api: intValue]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when:
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new CreativeAttributesDeserializer().deserialize(jsonParser, deserializationCtx)

        then:
            result == expectedResult

        where:
            intValue || expectedResult
            1        || CreativeAttributes.AUDIO_AD_AUTO_PLAY
            2        || CreativeAttributes.AUDIO_AD_USER_INITIATED
            3        || CreativeAttributes.EXPANDABLE_AUTOMATIC
            4        || CreativeAttributes.EXPANDABLE_USER_INITIATED_CLICK
            5        || CreativeAttributes.EXPANDABLE_USER_INITIATED_ROLLOVER
            6        || CreativeAttributes.IN_BANNER_VIDEO_AD_AUTO_PLAY
            7        || CreativeAttributes.IN_BANNER_VIDEO_AD_USER_INITIATED
            8        || CreativeAttributes.POP
            9        || CreativeAttributes.PROVOCATIVE_OR_SUGGESTED_IMAGERY
            10       || CreativeAttributes.ANIMATION
            11       || CreativeAttributes.SURVEYS
            12       || CreativeAttributes.TEXT_ONLY
            13       || CreativeAttributes.USER_INTERACTIVE
            14       || CreativeAttributes.WINDOWS_DIALOG_OR_ALERT_STYLE
            15       || CreativeAttributes.HAS_AUDIO_ON_OR_OFF_BUTTON
            16       || CreativeAttributes.AD_PROVIDES_SKIP_BUTTON
            17       || CreativeAttributes.ADOBE_FLASH
           null      || CreativeAttributes.UNKNOWN
    }


}