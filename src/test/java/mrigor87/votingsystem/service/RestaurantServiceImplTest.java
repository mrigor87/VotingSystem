package mrigor87.votingsystem.service;

import mrigor87.votingsystem.repository.RestaurantRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    RestaurantRepository repository;

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

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }


    @Test
    public void update() throws Exception {

    }

}