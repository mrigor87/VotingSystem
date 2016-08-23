package mrigor87.votingsystem.web.user;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.service.RestaurantService;
import mrigor87.votingsystem.web.AbstractRestaurantController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Igor on 22.08.2016.
 */
@RestController
@RequestMapping(RestaurantRestController.REST_URL)
public class RestaurantRestController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractRestaurantController.class);
    public static final String REST_URL = "/rest/profile/restaurant/";

    @Autowired
    RestaurantService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     public Collection<Restaurant> getAll(){
        Collection<Restaurant> res=service.getAll();
        System.out.println(res);
        return res;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant getRestaurant(@PathVariable("id") int id) {
        LOG.info("get restaurant {}",id);
        return service.get(id);
    }
    @RequestMapping(value = "/{id}/menu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Dish> getMenu(@PathVariable("id") int id){
        LOG.info("get menu of restaurant {}",id);
        return service.getMenu(id);
    }

}
