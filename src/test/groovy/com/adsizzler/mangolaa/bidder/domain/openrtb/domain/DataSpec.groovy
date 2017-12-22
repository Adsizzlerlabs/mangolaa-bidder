package com.adsizzler.mangolaa.commons.domain.openrtb.domain

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.MangolaaObjects
import com.adsizzler.mangolaa.commons.domain.openrtb.request.Data
import com.adsizzler.mangolaa.commons.json.Json

/**
 * Created by Ankush on 08/08/17.
 */
class DataSpec extends BaseSpec{

    String json
    def id,name,segment,someOtherField

    def setup(){
        id = "Some id"
        name = "Some name"
        segment  = MangolaaObjects.initSegment()

        someOtherField = "This field would be ignored"

        def segmentJson =
                """

                """
        json  =
                """
            {
            \t"id" : "$id",
            \t"name":"$name",
            \t"segment":[
            \t\t{
            \t\t\t"id" : "ID1",
            \t\t\t"name":" name1",
            \t\t\t"value" :"value1"
            \t\t},
            \t\t{
            \t\t\t"id" : "ID2",
            \t\t\t"name":" name2",
            \t\t\t"value" :"value2"
            \t\t}\t
            \t],
            \t"SomeOtherField":"this one would be ignored"
            }
                """
    }

    def "JSON string to Segment POJO"(){

        when :
            def result = Json.toObject(json, Data)

        then :
            result.with {
                id == id
                name == name
                segment == segment
            }
    }

}
