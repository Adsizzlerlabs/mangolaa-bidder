package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.AdPosition
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.AdPositionDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 01/08/17.
 */
class AdPositionDeserializerSpec extends BaseSpec {
    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its AdPosition enum repr "(){
        given :
            def json = new JsonBuilder([adPost: intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new AdPositionDeserializer().deserialize(jsonParser,deserializationCtx)

        then :
            result  == expectedResult

        where:
            intValue || expectedResult
            1        || AdPosition.ABOVE_THE_FOLD
            2        || AdPosition.DEPRECATED
            3        || AdPosition.BELOW_THE_FOLD
            4        || AdPosition.HEADER
            5        || AdPosition.FOOTER
            6        || AdPosition.SIDEBAR
            7        || AdPosition.FULL_SCREEN
            null     || AdPosition.UNKNOWN
    }


//    UNKNOWN(0),
//    ABOVE_THE_FOLD(1),
//    DEPRECATED(2),
//    BELOW_THE_FOLD(3),
//    HEADER(4),
//    FOOTER(5),
//    SIDEBAR(6),
//    FULL_SCREEN(7);


}
