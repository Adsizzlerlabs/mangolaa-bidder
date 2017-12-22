package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.CurrencyDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 27/07/17.
 */
class CurrencyDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve string value to its Currency enum repr "(){
        given :
            def json = new JsonBuilder([cur: strValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new CurrencyDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            strValue  || expectedResult
                "USD"     ||  Currency.USD
                "inr"     ||  Currency.INR
                null      ||  Currency.USD
    }

}
