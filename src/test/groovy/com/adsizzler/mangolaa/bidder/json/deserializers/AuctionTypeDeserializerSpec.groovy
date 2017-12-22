package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.AuctionType
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.AuctionTypeDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 27/07/17.
 */
class AuctionTypeDeserializerSpec extends BaseSpec{

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its AuctionType enum repr. If int = 1, then AuctionType = FIRST PRICE, otherwise the default is always SECOND_PRICE  "(){
        given :
            def json = new JsonBuilder([at: intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new AuctionTypeDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            intValue  || expectedResult
                1     ||  AuctionType.FIRST_PRICE
                2     || AuctionType.SECOND_PRICE
                null  || AuctionType.SECOND_PRICE // default price
    }


}
