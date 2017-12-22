package com.adsizzler.mangolaa.commons.domain.openrtb.domain

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.request.Segment
import com.adsizzler.mangolaa.commons.json.Json

/**
 * Created by Ankush on 08/08/17.
 */
class SegmentSpec extends BaseSpec{


    String json
    def id,name,value,someOtherField
    def setup(){
        id = "Some id"
        name = "Some name"
        value = "Some value"
        someOtherField = "This field would be ignored"

        json =
                """
            {
            \t"id" : "$id",
            \t"name":"$name",
            \t"value":"$value",
            \t"SomeOtherField":"$someOtherField"
            }

                """
    }

    def "JSON string to Segment POJO"(){

        when :
            def result = Json.toObject(json,Segment)

        then :
            result.with {
                id == id
                name == name
                value == value
            }
    }
}
