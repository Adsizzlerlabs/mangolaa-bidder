package com.adsizzler.mangolaa.commons

import com.adsizzler.mangolaa.bidder.domain.openrtb.request.Segment

/**
 * Created by Ankush on 08/08/17.
 */
class MangolaaObjects {

    static Segment initSegment(){
        Segment.builder()
                .id("SomeId")
                .value("SomeVal")
                .name("Some name")
                .build()
    }
}
