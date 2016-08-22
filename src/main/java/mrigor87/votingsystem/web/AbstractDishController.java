package mrigor87.votingsystem.web;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by Igor on 22.08.2016.
 */
public abstract class AbstractDishController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDishController.class);
    @Autowired
    DishService service;

    public Collection<Dish> getAll(int restaurantId){
        LOG.info("get all dishes for restaurant",restaurantId);
        return service.getAll(restaurantId);

    }
    public Dish get(int id, int restaurantId){
        LOG.info("get dish id {}", id,restaurantId);
        return service.get(id,restaurantId);
    }
    public void delete (int id){
        LOG.info("delete dish id {}", id);
        service.delete(id);
    }
    public void update(Dish dish) {
        LOG.info("update Dish {}", dish);
        service.update(dish);
    }

    public Dish create(Dish dish) {
        LOG.info("create Dish {}", dish);
        return service.save(dish);
    }

}
