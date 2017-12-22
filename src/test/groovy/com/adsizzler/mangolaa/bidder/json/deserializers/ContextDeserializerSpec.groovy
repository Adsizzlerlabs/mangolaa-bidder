package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.Context
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.ContextDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 01/08/17.
 */
class ContextDeserializerSpec extends BaseSpec {
    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its Context enum repr "(){
        given :
            def json = new JsonBuilder([context: intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ContextDeserializer().deserialize(jsonParser,deserializationCtx)

        then :
            result  == expectedResult

        where:
            intValue  || expectedResult
            1         || Context.VIDEO
            2         || Context.GAME
            3         || Context.MUSIC
            4         || Context.APPLICATION
            5         || Context.TEXT
            6         || Context.OTHER
            null      || Context.UNKNOWN
    }

}
