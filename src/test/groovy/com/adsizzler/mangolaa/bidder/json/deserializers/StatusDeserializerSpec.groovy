package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.Status
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.StatusDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 28/07/17.
 */
class StatusDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup() {
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its Status enum repr"() {

        given :
            def json = new JsonBuilder([status: intValue]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()
            def result = new StatusDeserializer().deserialize(jsonParser, deserializationCtx)

        then :
            result == expectedResult

        where :
            intValue   || expectedResult
            1          || Status.ACTIVE
            2          || Status.DEACTIVE
            null       || Status.UNKNOWN

    }

}
