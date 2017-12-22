package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.LocalDateDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

import java.time.LocalDate

/**
 * As best as one can test this out
 * Created by Ankush on 07/05/17.
 */
class LocalDateDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "Test out various date values. JsonDeserializer should convert string values to their LocalDate representation "(){

        given :
            def json = new JsonBuilder([dateTime: dateStr ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new LocalDateDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            dateStr | expectedResult
            '2017-04-04' |  LocalDate.of(2017,4,4)
            ''           | null
    }
}
