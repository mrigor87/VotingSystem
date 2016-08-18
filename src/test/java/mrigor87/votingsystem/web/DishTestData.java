package mrigor87.votingsystem.web;

import mrigor87.votingsystem.matcher.ModelMatcher;
import mrigor87.votingsystem.model.Dish;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static mrigor87.votingsystem.web.RestaurantTestData.RESTAURANT1;
import static mrigor87.votingsystem.web.RestaurantTestData.RESTAURANT2;
import static mrigor87.votingsystem.web.RestaurantTestData.RESTAURANT3;

/**
 * Created by Игорь on 14.08.2016.
 */

public class DishTestData {
    public static final ModelMatcher<Dish, String> MATCHER = new ModelMatcher<>(Dish::toString);

/*          ('dish1',10.2,100000), *//*100003*//*
            ('dish2',10.2,100000), *//*100004*//*
            ('dish3',10.2,100000), *//*100005*//*
            ('dish4',10.2,100001), *//*100006*//*
            ('dish5',10.2,100001), *//*100007*//*
            ('dish6',10.2,100002); *//*100008*/


    public static final Dish DISH1=new Dish(100003,"Dish1",10,RESTAURANT1);
    public static final Dish DISH2=new Dish(100004,"Dish2",10.1,RESTAURANT1);
    public static final Dish DISH3=new Dish(100005,"Dish3",10.2,RESTAURANT1);
    public static final Dish DISH4=new Dish(100006,"Dish4",10.3,RESTAURANT2);
    public static final Dish DISH5=new Dish(100007,"Dish5",10.4,RESTAURANT2);
    public static final Dish DISH6=new Dish(100008,"Dish6",10.5,RESTAURANT3);

    public static final List<Dish> DISHES= Arrays.asList(DISH1,DISH2,DISH3,DISH4,DISH5,DISH6);
    public static final Dish NEW_DISH=new Dish(null,"new Dish",90);
    public static Dish getUpdated() {
        return new Dish(DISH2.getId(),  "update блюдо",50.11);
    }
}
