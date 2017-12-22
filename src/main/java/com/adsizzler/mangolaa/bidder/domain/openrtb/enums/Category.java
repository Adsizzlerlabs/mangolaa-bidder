package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.CategoryDeserializer;
import com.adsizzler.mangolaa.bidder.json.jackson.serializers.CategorySerializer;
import com.adsizzler.mangolaa.bidder.util.Strings;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.val;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ankush on 19/07/17.
 */
@Getter
@JsonDeserialize(using = CategoryDeserializer.class)
@JsonSerialize(using = CategorySerializer.class)
public enum Category {

    //IAB1 : Arts & Entertainment
    IAB1_1("IAB1-1","Books & Literature"),
    IAB1_2("IAB1-2","Celebrity Fan/Gossip"),
    IAB1_3("IAB1-3","Fine Art"),
    IAB1_4("IAB1-4","Humour"),
    IAB1_5("IAB1-5","Movies"),
    IAB1_6("IAB1-6","Music"),
    IAB1_7("IAB1-7","Television"),

    //IAB12: Automotive
    IAB2_1("IAB2-1","Auto Parts"),
    IAB2_2("IAB2-2","Auto Repairs"),
    IAB2_3("IAB2-3","Buying/Selling Cars"),
    IAB2_4("IAB2-4","Car Culture"),
    IAB2_5("IAB2-5","Certified Pre-Owned"),
    IAB2_6("IAB2-6","Convertible"),
    IAB2_7("IAB2-7","Coupe"),
    IAB2_8("IAB2-8","Crossover"),
    IAB2_9("IAB2-9","Diesel"),
    IAB2_10("IAB2-10","Electric Vehicle"),
    IAB2_11("IAB2-11","Hatchback"),
    IAB2_12("IAB2-12","Hybrid"),
    IAB2_13("IAB2-13","Luxury"),
    IAB2_14("IAB2-14","Minivan"),
    IAB2_15("IAB2-15","Motorcycles"),
    IAB2_16("IAB2-16","Off-Road Vehicles"),
    IAB2_17("IAB2-17","Performance Vehicles"),
    IAB2_18("IAB2-18","Pickup"),
    IAB2_19("IAB2-19","Road-Side Assistance"),
    IAB2_20("IAB2-20","Sedan"),
    IAB2_21("IAB2-21","Trucks & Accessories"),
    IAB2_22("IAB2-22","Vintage Cars"),
    IAB2_23("IAB2-23","Wagon"),

    //IAB3 : Business
    IAB3_1("IAB3-1","Advertising"),
    IAB3_2("IAB3-2","Agriculture"),
    IAB3_3("IAB3-3","Biotech/Biomedical"),
    IAB3_4("IAB3-4","Business Software"),
    IAB3_5("IAB3-5","Construction"),
    IAB3_6("IAB3-6","Forestry"),
    IAB3_7("IAB3-7","Government"),
    IAB3_8("IAB3-8","Green Solutions"),
    IAB3_9("IAB3-9","Human Resources"),
    IAB3_10("IAB3-10","Logistics"),
    IAB3_11("IAB3-11","Marketing"),
    IAB3_12("IAB3-12","Metals"),

    //IAB4: Careers
    IAB4_1("IAB4-1","Career Planning"),
    IAB4_2("IAB4-2","College"),
    IAB4_3("IAB4-3","Financial Aid"),
    IAB4_4("IAB4-4","Job Fairs"),
    IAB4_5("IAB4-5","Job Search"),
    IAB4_6("IAB4-6","Resume Writing/Advice"),
    IAB4_7("IAB4-7","Nursing"),
    IAB4_8("IAB4-8","Scholarships"),
    IAB4_9("IAB4-9","Telecommuting"),
    IAB4_10("IAB4-10","U.S. Military"),
    IAB4_11("IAB4-11","Career Advice"),

    //IAB5 : Education
    IAB5_1("IAB5-1","7-12 Education"),
    IAB5_2("IAB5-2","Adult Education"),
    IAB5_3("IAB5-3","Art History"),
    IAB5_4("IAB5-4","College Administration"),
    IAB5_5("IAB5-5","College Life"),
    IAB5_6("IAB5-6","Distance Learning"),
    IAB5_7("IAB5-7","English as a 2nd Language"),
    IAB5_8("IAB5-8","Language Learning"),
    IAB5_9("IAB5-9","Graduate School"),
    IAB5_10("IAB5-10","Homeschooling"),
    IAB5_11("IAB5-11","Homework/Study Tips"),
    IAB5_12("IAB5-12","K-6 Educators"),
    IAB5_13("IAB5-13","Private School"),
    IAB5_14("IAB5-14","Special Education"),
    IAB5_15("IAB5-15","Studying Business"),

    //IAB6 : Family & Parenting
    IAB6_1("IAB6-1","Adoption"),
    IAB6_2("IAB6-2","Babies & Toddlers"),
    IAB6_3("IAB6-3","Daycare/Pre School"),
    IAB6_4("IAB6-4","Family Internet"),
    IAB6_5("IAB6-5","Parenting - K-6 Kids"),
    IAB6_6("IAB6-6","Parenting teens"),
    IAB6_7("IAB6-7","Pregnancy"),
    IAB6_8("IAB6-8","Special Needs kids"),
    IAB6_9("IAB6-9","Eldercare"),

    //IAB7 : Health & Fitness
    IAB7_1("IAB7-1","Exercise"),
    IAB7_2("IAB7-2","ADD"),
    IAB7_3("IAB7-3","AIDS/HIV"),
    IAB7_4("IAB7-4","Allergies"),
    IAB7_5("IAB7-5","Alternative Medicine"),
    IAB7_6("IAB7-6","Arthritis"),
    IAB7_7("IAB7-7","Asthma"),
    IAB7_8("IAB7-8","Autism/PDD"),
    IAB7_9("IAB7-9","Bipolar Disorder"),
    IAB7_10("IAB7-10","Brain Tumour"),
    IAB7_11("IAB7-11","Cancer"),
    IAB7_12("IAB7-12","Cholesterol"),
    IAB7_13("IAB7-13","Chronic Fatigue Syndrome"),
    IAB7_14("IAB7-14","Chronic Pain"),
    IAB7_15("IAB7-15","Cold & Flu"),
    IAB7_16("IAB7-16","Deafness"),
    IAB7_17("IAB7-17","Dental Care"),
    IAB7_18("IAB7-18","Depression"),
    IAB7_19("IAB7-19","Dermatology"),
    IAB7_20("IAB7-20","Diabetes"),
    IAB7_21("IAB7-21","Epilepsy"),
    IAB7_22("IAB7-22","GERD/Acid Reflux"),
    IAB7_23("IAB7-23","Headaches/Migraines"),
    IAB7_24("IAB7-24","Heart Disease"),
    IAB7_25("IAB7-25","Herbs for Health"),
    IAB7_26("IAB7-26","Holistic Healing"),
    IAB7_27("IAB7-27","IBS/Crohn's Disease"),
    IAB7_28("IAB7-28","Incest/Abuse Support"),
    IAB7_29("IAB7-29","Incontinence"),
    IAB7_30("IAB7-30","Infertility"),
    IAB7_31("IAB7-31","Men's Health"),
    IAB7_32("IAB7-32","Nutrition"),
    IAB7_33("IAB7-33","Orthopedics"),
    IAB7_34("IAB7-34","Panic/Anxiety Disorders"),
    IAB7_35("IAB7-35","Pediatrics"),
    IAB7_36("IAB7-36","Physical Therapy"),
    IAB7_37("IAB7-37","Psychology/Psychitary"),
    IAB7_38("IAB7-38","Senior Health"),
    IAB7_39("IAB7-39","Sexuality"),
    IAB7_40("IAB7-40","Sleep Disorders"),
    IAB7_41("IAB7-41","Smoking Cessation"),
    IAB7_42("IAB7-42","Substance Abuse"),
    IAB7_43("IAB7-43","Thyroid Disease"),
    IAB7_44("IAB7-44","Weight loss"),
    IAB7_45("IAB7-45","Women's Health"),

    //IAB8 : Food & Drink
    IAB8_1("IAB8-1","American Cuisine"),
    IAB8_2("IAB8-2","Barbecues & Grilling"),
    IAB8_3("IAB8-3","Cajun/Creole"),
    IAB8_4("IAB8-4","Chinise Cuisine"),
    IAB8_5("IAB8-5","Cocktails/Beer"),
    IAB8_6("IAB8-6","Coffee/Tea"),
    IAB8_7("IAB8-7","Cuisine-Specific"),
    IAB8_8("IAB8-8","Desert & Baking"),
    IAB8_9("IAB8-9","Dining Out"),
    IAB8_10("IAB8-10","Food Allergies"),
    IAB8_11("IAB8-11","French Cuisine"),
    IAB8_12("IAB8-12","Health/Low-Fat Cooking"),
    IAB8_13("IAB8-13","Italian Cuisine"),
    IAB8_14("IAB8-14","Japanese Cuisine"),
    IAB8_15("IAB8-15","Mexican Cuisine"),
    IAB8_16("IAB8-16","Vegan"),
    IAB8_17("IAB8-17","Vegetarian"),
    IAB8_18("IAB8-18","Wine"),

    //IAB9 : Hobbies & Interests
    IAB9_1("IAB9-1","Art/Technology"),
    IAB9_2("IAB9-2","Arts & Crafts"),
    IAB9_3("IAB9-3","Beadwork"),
    IAB9_4("IAB9-4","Bird-Watching"),
    IAB9_5("IAB9-5","Board Games/Puzzles"),
    IAB9_6("IAB9-6","Candle & Soap Making"),
    IAB9_7("IAB9-7","Card Games"),
    IAB9_8("IAB9-8","Chess"),
    IAB9_9("IAB9-9","Cigars"),
    IAB9_10("IAB9-10","Collecting"),
    IAB9_11("IAB9-11","Comic Books"),
    IAB9_12("IAB9-12","Drawing/Sketching"),
    IAB9_13("IAB9-13","Freelance Writing"),
    IAB9_14("IAB9-14","Genealogy"),
    IAB9_15("IAB9-15","Getting Published"),
    IAB9_16("IAB9-16","Guitar"),
    IAB9_17("IAB9-17","Home Recording"),
    IAB9_18("IAB9-18","Investors & Parents"),
    IAB9_19("IAB9-19","Jewelry Makng"),
    IAB9_20("IAB9-20","Magic & Illusion"),
    IAB9_21("IAB9-21","Needlework"),
    IAB9_22("IAB9-22","Painting"),
    IAB9_23("IAB9-23","Photography"),
    IAB9_24("IAB9-24","Radio"),
    IAB9_25("IAB9-25","Roleplaying Games"),
    IAB9_26("IAB9-26","Sci-Fi & Fantasy"),
    IAB9_27("IAB9-27","Scrapbooking"),
    IAB9_28("IAB9-28","Screenwriting"),
    IAB9_29("IAB9-29","Stamps & Coins"),
    IAB9_30("IAB9-30","Video & Computer Games"),
    IAB9_31("IAB9-31","Woodworking"),

    //IAB10 : Home & Garden
    IAB10_1("IAB10-1","Appliances"),
    IAB10_2("IAB10-2","Entertaining"),
    IAB10_3("IAB10-3","Environmental Safety"),
    IAB10_4("IAB10-4","Gardening"),
    IAB10_5("IAB10-5","Home Repair"),
    IAB10_6("IAB10-6","Home Theater"),
    IAB10_7("IAB10-7","Interior Decorating"),
    IAB10_8("IAB10-8","Landscaping"),
    IAB10_9("IAB10-9","Remodeling & Construction"),

    //IAB10 : Law, Government & Politics
    IAB11_1("IAB11-1","Immigration"),
    IAB11_2("IAB11-2","Legal Issues"),
    IAB11_3("IAB11-3","U.S. Government Resources"),
    IAB11_4("IAB11-4","Politics"),
    IAB11_5("IAB11-5","Commentary"),

    //IAB11 : News
    IAB12_1("IAB12-1","International News"),
    IAB12_2("IAB12-2","National News"),
    IAB12_3("IAB12-3","Local News"),

    //IAB12: Personal Finance
    IAB13_1("IAB13-1","Beginning Investing"),
    IAB13_2("IAB13-2","Credit/Debt & Loans"),
    IAB13_3("IAB13-3","Financial News"),
    IAB13_4("IAB13-4","Financial Planning"),
    IAB13_5("IAB13-5","Hedge Fund"),
    IAB13_6("IAB13-6","Insurance"),
    IAB13_7("IAB13-7","Investing"),
    IAB13_8("IAB13-8","Mutual Funds"),
    IAB13_9("IAB13-9","Options"),
    IAB13_10("IAB13-10","Retirement Planning"),
    IAB13_11("IAB13-11","Stocks"),
    IAB13_12("IAB13-12","Tax Planning"),

    //IAB14 : Society
    IAB14_1("IAB14-1","Dating"),
    IAB14_2("IAB14-2","Divorce Support"),
    IAB14_3("IAB14-3","Gay Life"),
    IAB14_4("IAB14-4","Marriage"),
    IAB14_5("IAB14-5","Senior Living"),
    IAB14_6("IAB14-6","Teens"),
    IAB14_7("IAB14-7","Weddings"),
    IAB14_8("IAB14-8","Ethnic Specific"),

    //IAB15: Science
    IAB15_1("IAB15-1","Astrology"),
    IAB15_2("IAB15-2","Biology"),
    IAB15_3("IAB15-3","Chemistry"),
    IAB15_4("IAB15-4","Geology"),
    IAB15_5("IAB15-5","Paranormal Phenomena"),
    IAB15_6("IAB15-6","Physics"),
    IAB15_7("IAB15-7","Space/Astronomy"),
    IAB15_8("IAB15-8","Geography"),
    IAB15_9("IAB15-9","Botany"),
    IAB15_10("IAB15-10","Weather"),

    //IAB16 : Pets
    IAB16_1("IAB16-1","Aquariums"),
    IAB16_2("IAB16-2","Birds"),
    IAB16_3("IAB16-3","Cats"),
    IAB16_4("IAB16-4","Dogs"),
    IAB16_5("IAB16-5","Large Animals"),
    IAB16_6("IAB16-6","Reptiles"),
    IAB16_7("IAB16-7","Veterinary Medicine"),

    //IAB17: Sports
    IAB17_1("IAB17-1","Auto Racing"),
    IAB17_2("IAB17-2","Baseball"),
    IAB17_3("IAB17-3","Bicycling"),
    IAB17_4("IAB17-4","Bodybuilding"),
    IAB17_5("IAB17-5","Boxing"),
    IAB17_6("IAB17-6","Canoeing/Kayaking"),
    IAB17_7("IAB17-7","Cheerleading"),
    IAB17_8("IAB17-8","Climbing"),
    IAB17_9("IAB17-9","Cricket"),
    IAB17_10("IAB17-10","Figure Skating"),
    IAB17_11("IAB17-11","Fly Fishing"),
    IAB17_12("IAB17-12","Football"),
    IAB17_13("IAB17-13","Freshwater Fishing"),
    IAB17_14("IAB17-14","Game & Fish"),
    IAB17_15("IAB17-15","Golf"),
    IAB17_16("IAB17-16","Horse Racing"),
    IAB17_17("IAB17-17","Horses"),
    IAB17_18("IAB17-18","Hunting/Shooting"),
    IAB17_19("IAB17-19","Inline Skating"),
    IAB17_20("IAB17-20","Martial Arts"),
    IAB17_21("IAB17-21","Mountain Biking"),
    IAB17_22("IAB17-22","NASCAR Racing"),
    IAB17_23("IAB17-23","Olympics"),
    IAB17_24("IAB17-24","Paintball"),
    IAB17_25("IAB17-25","Power & Motorcycles"),
    IAB17_26("IAB17-26","Pro Basketball"),
    IAB17_27("IAB17-27","Pro Ice Hockey"),
    IAB17_28("IAB17-28","Rodeo"),
    IAB17_29("IAB17-29","Rugby"),
    IAB17_30("IAB17-30","Running/Jogging"),
    IAB17_31("IAB17-31","Sailing"),
    IAB17_32("IAB17-32","Saltwater Fishing"),
    IAB17_33("IAB17-33","Scuba Diving"),
    IAB17_34("IAB17-34","Skateboarding"),
    IAB17_35("IAB17-35","Skiing"),
    IAB17_36("IAB17-36","Snowboarding"),
    IAB17_37("IAB17-37","Surfing/Body-Boarding"),
    IAB17_38("IAB17-38","Swimming"),
    IAB17_39("IAB17-39","Table Tennis/Ping-Pong"),
    IAB17_40("IAB17-40","Tennis"),
    IAB17_41("IAB17-41","Volleyball"),
    IAB17_42("IAB17-42","Walking"),
    IAB17_43("IAB17-43","Waterski/Wakeboard"),
    IAB17_44("IAB17-44","World Soccer"),

    //IAB18 : Style & Fashion
    IAB18_1("IAB18-1","Beauty"),
    IAB18_2("IAB18-2","Body Art"),
    IAB18_3("IAB18-3","Fashion"),
    IAB18_4("IAB18-4","Jewelry"),
    IAB18_5("IAB18-5","Clothing"),
    IAB18_6("IAB18-6","Accessories"),

    //IAB19 : Technology & Computing
    IAB19_1("IAB19-1","3-D Graphics"),
    IAB19_2("IAB19-2","Animation"),
    IAB19_3("IAB19-3","Antivirus Software"),
    IAB19_4("IAB19-4","C/C++"),
    IAB19_5("IAB19-5","Cameras & Camcorders"),
    IAB19_6("IAB19-6","Cell Phones"),
    IAB19_7("IAB19-7","Computer Certification"),
    IAB19_8("IAB19-8","Computer Networking"),
    IAB19_9("IAB19-9","Computer Peripherals"),
    IAB19_10("IAB19-10","Computer Reviews"),
    IAB19_11("IAB19-11","Data Centers"),
    IAB19_12("IAB19-12","Databases"),
    IAB19_13("IAB19-13","Desktop Publishing"),
    IAB19_14("IAB19-14","Desktop Video"),
    IAB19_15("IAB19-15","Email"),
    IAB19_16("IAB19-16","Graphics Software"),
    IAB19_17("IAB19-17","Home Video/DVD"),
    IAB19_18("IAB19-18","Internet Technology"),
    IAB19_19("IAB19-19","Java"),
    IAB19_20("IAB19-20","Javascript"),
    IAB19_21("IAB19-21","Mac Support"),
    IAB19_22("IAB19-22","MP3/MIDI"),
    IAB19_23("IAB19-23","Net Conferencing"),
    IAB19_24("IAB19-24","Net for Begineers"),
    IAB19_25("IAB19-25","Network Security"),
    IAB19_26("IAB19-26","Palmtops/PDAs"),
    IAB19_27("IAB19-27","PC Support"),
    IAB19_28("IAB19-28","Portable"),
    IAB19_29("IAB19-29","Entertainment"),
    IAB19_30("IAB19-30","Shareware/Freeware"),
    IAB19_31("IAB19-31","Unix"),
    IAB19_32("IAB19-32","Visual Basic"),
    IAB19_33("IAB19-33","Web Clip Art"),
    IAB19_34("IAB19-34","Web Design/HTML"),
    IAB19_35("IAB19-35","Web Search"),
    IAB19_36("IAB19-36","Windows"),

    //IAB20 : Travel
    IAB20_1("IAB20-1","Adventure Travel"),
    IAB20_2("IAB20-2","Africa"),
    IAB20_3("IAB20-3","Air Travel"),
    IAB20_4("IAB20-4","Australia & New Zealand"),
    IAB20_5("IAB20-5","Bed & Breakfasts"),
    IAB20_6("IAB20-6","Budget Travel"),
    IAB20_7("IAB20-7","Business Travel"),
    IAB20_8("IAB20-8","By US Locale"),
    IAB20_9("IAB20-9","Camping"),
    IAB20_10("IAB20-10","Canada"),
    IAB20_11("IAB20-11","Caribbean"),
    IAB20_12("IAB20-12","Cruises"),
    IAB20_13("IAB20-13","Eastern Europe"),
    IAB20_14("IAB20-14","Europe"),
    IAB20_15("IAB20-15","France"),
    IAB20_16("IAB20-16","Greece"),
    IAB20_17("IAB20-17","Honeymoons/Getaways"),
    IAB20_18("IAB20-18","Hotels"),
    IAB20_19("IAB20-19","Italy"),
    IAB20_20("IAB20-20","Japan"),
    IAB20_21("IAB20-21","Mexico & Central America"),
    IAB20_22("IAB20-22","National Parks"),
    IAB20_23("IAB20-23","South America"),
    IAB20_24("IAB20-24","Spas"),
    IAB20_25("IAB20-25","Theme Parks"),
    IAB20_26("IAB20-26","Traveling with Kids"),
    IAB20_27("IAB20-27","United Kingdom"),

    //IAB21 : Real Estate
    IAB21_1("IAB21-1","Apartments"),
    IAB21_2("IAB21-2","Architects"),
    IAB21_3("IAB21-3","Buying/Selling Homes"),

    //IAB22 : Shopping
    IAB22_1("IAB22-1","Contests & Freebies"),
    IAB22_2("IAB22-2","Couponing"),
    IAB22_3("IAB22-3","Comparison"),
    IAB22_4("IAB22-4","Engines"),

    //IAB23 : Relegion & Spirituality
    IAB23_1("IAB23-1","Alternative Relegions"),
    IAB23_2("IAB23-2","Atheism/Agnosticism"),
    IAB23_3("IAB23-3","Buddhism"),
    IAB23_4("IAB23-4","Catholicism"),
    IAB23_5("IAB23-5","Christianity"),
    IAB23_6("IAB23-6","Hinduism"),
    IAB23_7("IAB23-7","Islam"),
    IAB23_8("IAB23-8","Judaism"),
    IAB23_9("IAB23-9","Latter-Day Saints"),
    IAB23_10("IAB23-10","Pagan/Wiccan"),

    //IAB24 : Uncategorized

    //IAB25 : Non-Standard Content
    IAB25_1("IAB25-1","Unmoderated UGC"),
    IAB25_2("IAB25-2","Extreme Graphic/Explicit Violence"),
    IAB25_3("IAB25-3","Pornography"),
    IAB25_4("IAB25-4","Profane Content"),
    IAB25_5("IAB25-5","Hate Content"),
    IAB25_6("IAB25-6","Under Construction"),
    IAB25_7("IAB25-7","Incentivized"),

    //IAB26 : Illegal Content
    IAB26_1("IAB26-1","Illegal Content"),
    IAB26_2("IAB26-2","Warez"),
    IAB26_3("IAB26-3","Spyware/Malware"),
    IAB26_4("IAB26-4","Copyright Infringement");

    private final String code;
    private final String description;

    Category(final String code,final String description){
        this.code = code;
        this.description = description;
    }

    private static final Map<String,Category> CACHE ;

    //Populate on Startup. Put all lower and upper cases as key
    static{
        val tempMap = new HashMap<String,Category>();
        for(val category : Category.values()){
            tempMap.put(category.getCode(), category);
            tempMap.put(category.getCode().toLowerCase(), category);
        }
        CACHE = ImmutableMap.copyOf(tempMap);
    }

    public static Category from(final String code){
        //can you think of something better here apart from null?
        Category result = null;
        if(Strings.hasText(code)){
            result =  CACHE.get(code);
        }
        return result;
    }

}
