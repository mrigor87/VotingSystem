package mrigor87.votingsystem.repository;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;

import java.util.Collection;

/**
 * Created by Igor on 08.08.2016.
 */
public interface RestaurantRepository {
    Restaurant get(int id);
    boolean delete(int id);
    Restaurant save(Restaurant restaurant);
    public Collection<Restaurant> getAll();
    public Collection<Dish> getMenu(int id);
    public boolean setMenu(int id,Collection<Dish>menu);
    public Restaurant getWithMenu(int id);
}
