package mrigor87.votingsystem.web.admin;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Igor on 26.08.2016.
 */
@RestController
@RequestMapping(RestaurantAdminRestController.REST_URL)
public class RestaurantAdminRestController {
    @Autowired
    RestaurantService service;

    private static final Logger LOG = LoggerFactory.getLogger(RestaurantAdminRestController.class);
    public static final String REST_URL = "/rest/admin/restaurant/";

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Restaurant> getAll() {
        Collection<Restaurant> res = service.getAll();
        LOG.info("get all restaurant");
        return res;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant getRestaurant(@PathVariable("id") int id) {
        LOG.info("get restaurant {}", id);
        return service.getWithMenu(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {

        service.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Restaurant restaurant, @PathVariable("id") int id) {
        service.update(restaurant, id);
    }

    @RequestMapping(value = "/{id}/menu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Dish> getMenu(@PathVariable("id") int id) {
        LOG.info("get menu for {} restaurantId", id);
        return service.getMenu(id);
    }

    @RequestMapping(value = "/{id}/menu", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setMenu(@PathVariable("id") int id, @RequestBody Collection<Dish> menu) {
        LOG.info("set menu {} for {} restaurantId", menu,id);
        service.setMenu(id,menu);
    }

}
