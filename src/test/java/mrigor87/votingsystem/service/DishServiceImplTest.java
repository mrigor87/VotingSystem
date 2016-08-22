package mrigor87.votingsystem.service;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.web.DishTestData;
import mrigor87.votingsystem.web.RestaurantTestData;
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

import static mrigor87.votingsystem.web.DishTestData.*;
import static mrigor87.votingsystem.web.RestaurantTestData.RESTAURANT1;
import static mrigor87.votingsystem.web.RestaurantTestData.RESTAURANT2;
import static mrigor87.votingsystem.web.RestaurantTestData.RESTAURANT3;
import static org.junit.Assert.*;

/**
 * Created by Игорь on 14.08.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class DishServiceImplTest {
    @Autowired
    DishService service;

    @Test
    public void save() throws Exception {
        service.save(getUpdated());
        MATCHER.assertCollectionEquals(service.getAll(RESTAURANT1.getId()),
                Arrays.asList(DISH1,DISH3,getUpdated()));
    }

    @Test
    public void delete() throws Exception {
        service.delete(DISH1.getId());
        MATCHER.assertCollectionEquals(service.getAll(RESTAURANT1.getId()),
                Arrays.asList(DISH2,DISH3));
    }

    @Test
    public void get() throws Exception {
        MATCHER.assertEquals(service.get(100004,100000),DISH2);
    }

    @Test
    public void getAll() throws Exception {
        MATCHER.assertCollectionEquals(service.getAll(RESTAURANT3.getId()),
                Arrays.asList(DISH6));

    }

    @Test
    public void update() throws Exception {

    }

}