package com.adsizzler.mangolaa.bidder.domain;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ankushsharma on 13/09/17.
 */
@Data
@Builder
public class Advertiser {

    public static final Attribute<Advertiser,String> DOMAIN = new SimpleAttribute<Advertiser,String>() {
        @Override
        public String getValue(final Advertiser adv,final QueryOptions queryOptions) {
            return adv.getDomain();
        }
    };

    private final Integer id;
    private final String domain;
    private final String name;


}
