package com.adsizzler.mangolaa.commons.json.serializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.json.jackson.serializers.LocalDateTimeSerializer
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Created by Ankush on 28/07/17.
 */
class LocalDateTimeSerializerSpec extends BaseSpec{

    Writer writer
    def jsonGen
    def objMapper
    def serializerProvider

    def setup(){
        objMapper = new ObjectMapper()
        writer = new StringWriter()
        serializerProvider = objMapper.getSerializerProvider()
    }


    def "Test out various LocalDateTime values. JsonSerializer should convert LocalDateTime values to their string repr "(){
        given :
            jsonGen = new JsonFactory().createGenerator(writer)
            def serializer = new LocalDateTimeSerializer()
        when :
            serializer.serialize(LocalDateTime.of(LocalDate.of(2017,1,1),LocalTime.of(9,9,9)), jsonGen, serializerProvider)
            jsonGen.flush()

        then :
        writer.toString().replace('"','') == '2017-01-01 09:09:09'
    }

    def "For a null, the corresponding String representation is an empty string "(){
        given :
            jsonGen = new JsonFactory().createGenerator(writer)
            def serializer = new LocalDateTimeSerializer()

        when :
            serializer.serialize(null, jsonGen, serializerProvider)
            jsonGen.flush()

        then :
            writer.toString().replace('"','') == ''
    }

}
