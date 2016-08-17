package mrigor87.votingsystem.service;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Игорь on 14.08.2016.
 */
public interface DishService {
    Dish save(Dish dish,int restaurantId);

    void delete(int id,int restaurantId) throws NotFoundException;

    Dish get(int id,int restaurantId) throws NotFoundException;

    Collection<Dish> getAll(int restaurantId);

    void update(Dish dish,int restaurantId);
}
