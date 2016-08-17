package mrigor87.votingsystem.web;

import mrigor87.votingsystem.matcher.ModelMatcher;
import mrigor87.votingsystem.model.Restaurant;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Игорь on 14.08.2016.
 */
public class RestaurantTestData {
    public static final ModelMatcher<Restaurant, String> MATCHER = new ModelMatcher<>(Restaurant::toString);
/*    ('Restaurant1'), *//*100000*//*
            ('Restaurant2'), *//*100001*//*
            ('Restaurant3'); *//*100002*/
    public static final Restaurant RESTAURANT1=new Restaurant(100000,"Restaurant1");
    public static final Restaurant RESTAURANT2=new Restaurant(100001,"Restaurant2");
    public static final Restaurant RESTAURANT3=new Restaurant(100002,"Restaurant3");
    public static final Collection<Restaurant> RESTAURANTS= Arrays.asList(RESTAURANT1,RESTAURANT2,RESTAURANT3);
    public static final Restaurant NEW_RESTAURANT=new Restaurant(null,"new Restaurant");
    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT2.getId(),  "update ресторан");
    }
}
