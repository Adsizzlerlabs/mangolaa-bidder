package com.adsizzler.mangolaa.commons.json.serializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.CreativeAttributes
import com.adsizzler.mangolaa.commons.json.jackson.serializers.CreativeAttributesSerializer
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Ankush on 08/08/17.
 */
class CreativeAttributesSerializerSpec extends BaseSpec{

    Writer writer
    def jsonGen
    def objMapper
    def serializerProvider

    def setup(){
        objMapper = new ObjectMapper()
        writer = new StringWriter()
        serializerProvider = objMapper.getSerializerProvider()
    }

    def "Test out various CreativeAttributes values. CreativeAttributesSerializer woould convert CreativeAttributes values to their int repr "(){
        given :
            jsonGen = new JsonFactory().createGenerator(writer)
            def serializer = new CreativeAttributesSerializer()

        when :
            serializer.serialize(CreativeAttributes.AD_PROVIDES_SKIP_BUTTON, jsonGen, serializerProvider)
            jsonGen.flush()

        then :
            writer.toString().replace('"','') as Integer == CreativeAttributes.AD_PROVIDES_SKIP_BUTTON.code

    }
}
