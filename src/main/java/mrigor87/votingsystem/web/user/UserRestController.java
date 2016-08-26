package mrigor87.votingsystem.web.user;

import mrigor87.votingsystem.AuthorizedUser;
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
    private static final Logger LOG = LoggerFactory.getLogger(UserRestController.class);
    public static final String REST_URL = "/rest/profile/";

    @Autowired
    UserService service;



    @RequestMapping(value = "vote/{restaurantId}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public void vote(@PathVariable int restaurantId){
        int userId= AuthorizedUser.id();
        LOG.info("userId {} voting for {}restaurantId",userId,restaurantId);
        service.setVote(userId,restaurantId);
    }
    @RequestMapping(value = "vote/{restaurantId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public void vote0(@PathVariable int restaurantId){
        int userId= AuthorizedUser.id();
        LOG.info("userId {} voting for {}restaurantId",userId,restaurantId);
        service.setVote(userId,restaurantId);
    }


}
