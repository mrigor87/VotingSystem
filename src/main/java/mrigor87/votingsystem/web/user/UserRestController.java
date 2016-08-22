package mrigor87.votingsystem.web.user;

import mrigor87.votingsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Igor on 22.08.2016.
 */


@RestController
@RequestMapping(RestaurantRestController.REST_URL)
public class UserRestController {
    private static final Logger LOG = LoggerFactory.getLogger(RestaurantRestController.class);
    public static final String REST_URL = "/rest/profile/";

    @Autowired
    UserService service;


/*
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody UserMeal meal, @PathVariable("id") int id) {
        super.update(meal, id);
    }
*/
    @RequestMapping(value = "{id}/vote/{restaurantId}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void vote(int userId,int restaurantId){
        service.setVote(userId,restaurantId);
    }

}
