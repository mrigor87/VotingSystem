package mrigor87.votingsystem.repository;

import mrigor87.votingsystem.model.Dish;

import java.util.Collection;

/**
 * Created by Igor on 08.08.2016.
 */
public interface DishRepository {
    Dish get (Integer id, Integer restaurantId);
    boolean delete (Integer id, Integer restaurantId);
    Dish save (Dish dish, Integer restaurantId);
    Collection<Dish>getAll(Integer restaurantId);

}
