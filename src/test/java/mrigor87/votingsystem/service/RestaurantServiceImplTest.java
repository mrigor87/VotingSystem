package mrigor87.votingsystem.service;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.util.exception.NotFoundException;
import mrigor87.votingsystem.web.DishTestData;
import mrigor87.votingsystem.web.RestaurantTestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static mrigor87.votingsystem.web.RestaurantTestData.*;
import static org.junit.Assert.*;

/**
 * Created by Игорь on 11.08.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class RestaurantServiceImplTest {

    @Autowired
    RestaurantService service;

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before ********************");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After**********************");
    }

    @Test
    public void saveNew() throws Exception {
        service.save(NEW_RESTAURANT);
        MATCHER.assertCollectionEquals(service.getAll(),Arrays.asList(NEW_RESTAURANT,RESTAURANT1,RESTAURANT2, RESTAURANT3));

    }

    @Test
    public void delete() throws Exception {
        service.delete(RESTAURANT2.getId());
        Collection<Restaurant> restaurants = Arrays.asList(RESTAURANT1, RESTAURANT3);
        MATCHER.assertCollectionEquals(service.getAll(), restaurants);
    }

    @Test(expected = NotFoundException.class)
    public void deleteException() throws  Exception{
        service.delete(10);
    }
    @Test
    public void get() throws Exception {
        MATCHER.assertEquals(RESTAURANT2,service.get(RESTAURANT2.getId()));
    }

    @Test(expected = NotFoundException.class)
    public void getException() throws Exception {
        service.get(8);

    }
    @Test
    public void getWithMenu(){
        Restaurant restaurant=service.getWithMenu(100000);
        Collection<Dish>menu=restaurant.getMenu();
        DishTestData.MATCHER.assertCollectionEquals(menu,Arrays.asList(DishTestData.DISH1,DishTestData.DISH2,DishTestData.DISH3));

    }


    @Test
    public void update() throws Exception {
        Restaurant updateRestaurant=getUpdated();
        service.update(updateRestaurant);
        //updateRestaurant.setId(100011);
        MATCHER.assertCollectionEquals(service.getAll(),Arrays.asList(RESTAURANT1,RESTAURANT3,updateRestaurant));
    }

}