package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.BidResponseProtocol
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.BidResponseProtocolDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 04/08/17.
 */
class BidResponseProtocolDeserializerSpec extends BaseSpec{


    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its BidResponseProtocol enum repr  "(){
        given :
            def json = new JsonBuilder([protocol: intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new BidResponseProtocolDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            intValue  || expectedResult
            1         || BidResponseProtocol.VAST_1_0
            2         || BidResponseProtocol.VAST_2_0
            3         || BidResponseProtocol.VAST_3_0
            4         || BidResponseProtocol.VAST_1_0_WRAPPER
            5         || BidResponseProtocol.VAST_2_0_WRAPPER
            6         || BidResponseProtocol.VAST_3_0_WRAPPER
            7         || BidResponseProtocol.VAST_4_0
            8         || BidResponseProtocol.VAST_4_0_WRAPPER
            9         || BidResponseProtocol.DAST_1_0
            10        || BidResponseProtocol.DAST_1_0_WRAPPER
            null        || BidResponseProtocol.UNKNOWN
    }


}
