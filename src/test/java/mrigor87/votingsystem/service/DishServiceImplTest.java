package mrigor87.votingsystem.service;

import mrigor87.votingsystem.web.DishTestData;
import mrigor87.votingsystem.web.RestaurantTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    }

    @Test
    public void delete() throws Exception {
        service.delete(DishTestData.DISH1.getId(), RestaurantTestData.RESTAURANT1.getId());
        DishTestData.MATCHER.assertCollectionEquals(service.getAll(RestaurantTestData.RESTAURANT1.getId()));
    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}