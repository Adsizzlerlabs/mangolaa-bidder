package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.ImpressionEntity
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.ImpressionEntityDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 01/08/17.
 */
class ImpressionEntityDeserializerSpec extends BaseSpec {


    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup() {
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its ImpressionEntity enum repr "() {
        given:
            def json = new JsonBuilder([fd: intValue]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when:
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ImpressionEntityDeserializer().deserialize(jsonParser, deserializationCtx)


        then:
            result == expectedResult

        where:
            intValue || expectedResult
            0        || ImpressionEntity.EXCHANGE
            1        || ImpressionEntity.UPSTREAM
            null     || ImpressionEntity.EXCHANGE

    }

}
