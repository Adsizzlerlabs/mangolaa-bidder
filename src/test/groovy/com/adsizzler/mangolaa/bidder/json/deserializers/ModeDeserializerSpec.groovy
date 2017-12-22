package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.Mode
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.ModeDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 28/07/17.
 */
class ModeDeserializerSpec extends BaseSpec{

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup() {
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its Mode enum repr "() {

        given:
            def json = new JsonBuilder([mode: intValue]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when:
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ModeDeserializer().deserialize(jsonParser, deserializationCtx)


        then:
            result == expectedResult

            where:
            intValue || expectedResult
                0    || Mode.LIVE
                1    || Mode.TEST
            null     || Mode.LIVE

    }

}
