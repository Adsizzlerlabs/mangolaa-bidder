package com.adsizzler.mangolaa.commons.json.serializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.NoBidCode
import com.adsizzler.mangolaa.commons.json.jackson.serializers.NoBidCodeSerializer
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Ankush on 08/08/17.
 */
class NoBidCodeSerializerSpec extends BaseSpec{

    Writer writer
    def jsonGen
    def objMapper
    def serializerProvider

    def setup(){
        objMapper = new ObjectMapper()
        writer = new StringWriter()
        serializerProvider = objMapper.getSerializerProvider()
    }

    def "Test out various NoBidCode values. NoBidCodeSerializer would convert NoBidCode values to their int repr "(){
        given :
            jsonGen = new JsonFactory().createGenerator(writer)
            def serializer = new NoBidCodeSerializer()

        when :
            serializer.serialize(NoBidCode.BLOCKED_PUBLISHER_OR_SITE, jsonGen, serializerProvider)
            jsonGen.flush()

        then :
            writer.toString().replace('"','') as Integer == NoBidCode.BLOCKED_PUBLISHER_OR_SITE.code

    }
}
