package com.adsizzler.mangolaa.commons.json.serializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.ApiFrameworks
import com.adsizzler.mangolaa.commons.json.jackson.serializers.ApiFrameworksSerializer
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Ankush on 08/08/17.
 */
class ApiFrameworksSerializerSpec extends BaseSpec {

    Writer writer
    def jsonGen
    def objMapper
    def serializerProvider

    def setup(){
        objMapper = new ObjectMapper()
        writer = new StringWriter()
        serializerProvider = objMapper.getSerializerProvider()
    }

    def "Test out various ApiFrameworks values. ApiFrameworksSerializer would convert ApiFrameworks values to their int repr "(){
        given :
            jsonGen = new JsonFactory().createGenerator(writer)
            def serializer = new ApiFrameworksSerializer()

        when :
            serializer.serialize(ApiFrameworks.MRAID_1, jsonGen, serializerProvider)
            jsonGen.flush()

        then :
            writer.toString().replace('"','') as Integer == ApiFrameworks.MRAID_1.code

    }


}
