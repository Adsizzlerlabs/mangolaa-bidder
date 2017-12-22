package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.ProductionQuality
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.ProductionQualityDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 28/07/17.
 */
class ProductionQualityDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup() {
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its ProductionQuality enum repr"() {

        given:
            def json = new JsonBuilder([mode: intValue]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when:
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ProductionQualityDeserializer().deserialize(jsonParser, deserializationCtx)


        then:
            result == expectedResult

        where:
            intValue || expectedResult
            1        || ProductionQuality.PROFESSIONALLY_PRODUCED
            2        || ProductionQuality.PROSUMER
            3        || ProductionQuality.USER_GENERATED_UGC
            null     || ProductionQuality.UNKNOWN

    }
}
