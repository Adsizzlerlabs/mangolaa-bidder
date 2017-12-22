package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.ConnectionType
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.ConnectionTypeDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 27/07/17.
 */
class ConnectionTypeDeserializerSpec extends BaseSpec {
    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its ConnectionType enum repr "(){
        given :
            def json = new JsonBuilder([connectiontype: intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ConnectionTypeDeserializer().deserialize(jsonParser,deserializationCtx)

        then :
            result  == expectedResult

        where:
            intValue  || expectedResult
                1     || ConnectionType.ETHERNET
                2     || ConnectionType.WIFI
                3     || ConnectionType.CELLULAR_NETWORK_UNKNOWN_GENERATION
                4     || ConnectionType.CELLULAR_NETWORK_2G
                5     || ConnectionType.CELLULAR_NETWORK_3G
                6     || ConnectionType.CELLULAR_NETWORK_4G
                null  || ConnectionType.UNKNOWN
    }
}
