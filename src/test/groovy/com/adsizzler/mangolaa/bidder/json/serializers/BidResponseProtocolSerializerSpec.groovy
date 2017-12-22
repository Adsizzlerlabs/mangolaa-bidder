package com.adsizzler.mangolaa.commons.json.serializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.BidResponseProtocol
import com.adsizzler.mangolaa.commons.json.jackson.serializers.BidResponseProtocolSerializer
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Ankush on 08/08/17.
 */
public class BidResponseProtocolSerializerSpec extends BaseSpec {

    Writer writer
    def jsonGen
    def objMapper
    def serializerProvider

    def setup(){
        objMapper = new ObjectMapper()
        writer = new StringWriter()
        serializerProvider = objMapper.getSerializerProvider()
    }

    def "Test out various BidResponseProtocol values. BidResponseProtocolSerializer woould convert BidResponseProtocol values to their string repr "(){
        given :
            jsonGen = new JsonFactory().createGenerator(writer)
            def serializer = new BidResponseProtocolSerializer()

        when :
            serializer.serialize(BidResponseProtocol.DAST_1_0, jsonGen, serializerProvider)
            jsonGen.flush()

        then :
             writer.toString().replace('"','') as Integer == BidResponseProtocol.DAST_1_0.code

    }

}
