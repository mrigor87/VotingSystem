package mrigor87.votingsystem.repository;

import mrigor87.votingsystem.model.Dish;

import java.util.Collection;

/**
 * Created by Igor on 08.08.2016.
 */
public interface DishRepository {
    Dish get (int id, int restaurantId);
    boolean delete (int id, int restaurantId);
    Dish save (Dish dish, int restaurantId);
    Collection<Dish>getAll(int restaurantId);

}
