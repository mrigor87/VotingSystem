package mrigor87.votingsystem.web.user;

import mrigor87.votingsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Igor on 22.08.2016.
 */


@RestController
@RequestMapping(UserRestController.REST_URL)
public class UserRestController {
    private static final Logger LOG = LoggerFactory.getLogger(RestaurantRestController.class);
    public static final String REST_URL = "/rest/profile/";

    @Autowired
    UserService service;

    //http://localhost:8080/votingsystem/rest/profile/100010/vote/100000
/*
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody UserMeal meal, @PathVariable("id") int id) {
        super.update(meal, id);
    }
*/
/*    @RequestMapping( method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public void vote3(){
        LOG.info("userId {} voting for {}restaurantId");
    }*/

    @RequestMapping(value = "{userId}/vote/{restaurantId}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public void vote(@PathVariable  int userId,@PathVariable int restaurantId){
        LOG.info("userId {} voting for {}restaurantId",userId,restaurantId);
        service.setVote(userId,restaurantId);
    }
    @RequestMapping(value = "{userId}/vote/{restaurantId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public void vote0(@PathVariable  int userId,@PathVariable int restaurantId){
        LOG.info("userId {} voting for {}restaurantId",userId,restaurantId);
        service.setVote(userId,restaurantId);
    }
   //                        100010/vote/100000
/*    @RequestMapping(value = "100010/vote/100000", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public void vote1(){
        LOG.info("userId {} voting for {}restaurantId");
    }*/
/*    @RequestMapping(value = "100010/vote/100000", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public void vote2(){
        LOG.info("userId {} voting for {}restaurantId");
    }*/
    //public void update(@RequestBody User user) {super.update(user, AuthorizedUser.id());}

}
