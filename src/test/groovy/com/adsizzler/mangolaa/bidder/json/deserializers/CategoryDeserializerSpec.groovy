package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.CategoryDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 27/07/17.
 */
class CategoryDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve string value to its Category enum repr "(){
        given :
            def json = new JsonBuilder([cat: strValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new CategoryDeserializer().deserialize(jsonParser,deserializationCtx)

        then :
            result  == expectedResult

        where:
            strValue  || expectedResult
            "IAB1-1"  || Category.IAB1_1
            "IAB11-2" || Category.IAB11_2
            null      || null
    }
}
