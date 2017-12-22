package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.ExpandableDirection
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.ExpandableDirectionDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 28/07/17.
 */
class ExpandableDirectionDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its ExpandableDirection enum repr "(){
        given :
            def json = new JsonBuilder([deviceType: intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ExpandableDirectionDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

            where:
            intValue     || expectedResult
            1            ||  ExpandableDirection.LEFT
            2            ||  ExpandableDirection.RIGHT
            3            ||  ExpandableDirection.UP
            4            ||  ExpandableDirection.DOWN
            5            ||  ExpandableDirection.FULL_SCREEN
            null         ||  ExpandableDirection.UNKNOWN
    }

}
