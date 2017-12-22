package com.adsizzler.mangolaa.commons.json.serializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.json.jackson.serializers.LocalDateSerializer
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper

import java.time.LocalDate

/**
 * Created by Ankush on 28/07/17.
 */
class LocalDateSerializerSpec extends BaseSpec{

    Writer writer
    def jsonGen
    def objMapper
    def serializerProvider

    def setup(){
        objMapper = new ObjectMapper()
        writer = new StringWriter()
        serializerProvider = objMapper.getSerializerProvider()
    }

    def "Test out various LocalDate values. JsonSerializer should convert LocalDate values to their string repr "(){
        given :
            jsonGen = new JsonFactory().createGenerator(writer)
            def serializer = new LocalDateSerializer()

        when :
            serializer.serialize(LocalDate.of(2017,5,7), jsonGen, serializerProvider)
            jsonGen.flush()

        then :  'the format should be yyyy-MM-dd'
          writer.toString().replace('"','') == '2017-05-07'
    }

    def "For a null, the corresponding String representation is an empty string "(){
        given :
            jsonGen = new JsonFactory().createGenerator(writer)
            def serializer = new LocalDateSerializer()

        when :
            serializer.serialize(null, jsonGen, serializerProvider)
            jsonGen.flush()

        then :
            writer.toString().replace('"','') == ''
    }

}
