package mrigor87.votingsystem.web;

import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by Igor on 22.08.2016.
 */
public abstract class AbstractRestaurantController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractRestaurantController.class);
    @Autowired
    RestaurantService service;

    public Collection<Restaurant> getAll(){
        LOG.info("get All restaurant");
        return service.getAll();

    }
    public Restaurant get(int id){
        LOG.info("get restaurant id {}", id);
        return service.get(id);
    }
    public Restaurant getWithMenu(int id){
        LOG.info("get restaurant id {}", id);
        return service.getWithMenu(id);
    }


    public void delete (int id){
        LOG.info("delete restaurant id {}", id);
        service.delete(id);
    }
    public void update(Restaurant restaurant) {
        LOG.info("update Restaurant {}", restaurant);
        service.update(restaurant);
    }

    public Restaurant create(Restaurant restaurant) {
        LOG.info("create Restaurant {}", restaurant);
        return service.save(restaurant);
    }


}
