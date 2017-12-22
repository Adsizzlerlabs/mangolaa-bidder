package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.Gender
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.GenderDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 28/07/17.
 */
class GenderDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve string value to its Gender enum repr "(){
        given :
            def json = new JsonBuilder([gender: strValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new GenderDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

            where:
            strValue       || expectedResult
            "M"            ||  Gender.MALE
            "m"            ||  Gender.MALE
            "F"            ||  Gender.FEMALE
            "f"            ||  Gender.FEMALE
            null           ||  Gender.UNKNOWN
    }

}
