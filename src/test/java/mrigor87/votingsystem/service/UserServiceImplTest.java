package mrigor87.votingsystem.service;

import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.model.User;
import mrigor87.votingsystem.web.RestaurantTestData;
import mrigor87.votingsystem.web.UserTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static mrigor87.votingsystem.web.UserTestData.*;
import static org.junit.Assert.*;

/**
 * Created by Igor on 18.08.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceImplTest {
    @Autowired
    UserService service;

    @Test
    public void save() throws Exception {
        service.update(getUpdated());
        MATCHER.assertCollectionEquals (service.getAll(),Arrays.asList(ADMIN,getUpdated()));
    }

    @Test
    public void delete() throws Exception {
        service.delete(USER.getId());
        MATCHER.assertCollectionEquals(service.getAll(),Arrays.asList(ADMIN));
    }

    @Test
    public void get() throws Exception {
        User user = service.get(ADMIN.getId());
        MATCHER.assertEquals(service.get(100010),ADMIN);
    }



    @Test
    public void getAll() throws Exception {
        service.getAll();
        MATCHER.assertCollectionEquals(service.getAll(), Arrays.asList(ADMIN,USER));
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void setVote() throws Exception {
        User user=UserTestData.USER;
        Restaurant restaurant= RestaurantTestData.RESTAURANT1;
        user.setRestaurant(restaurant);
        service.setVote(user.getId(),restaurant.getId());
       RestaurantTestData. MATCHER.assertEquals(user.getRestaurant(),restaurant);
    }

}