package mrigor87.votingsystem.service;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Igor on 11.08.2016.
 */
public interface RestaurantService {

    Restaurant save(Restaurant user);

    void delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    Collection<Restaurant> getAll();
    Collection<Dish> getMenu(int id)  throws NotFoundException;
    void setMenu(int id, Collection<Dish>menu);

    void update(Restaurant user,int id);

    Restaurant getWithMenu(int id);


}
