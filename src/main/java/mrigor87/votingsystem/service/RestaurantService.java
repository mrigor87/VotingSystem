package mrigor87.votingsystem.service;

import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.util.exception.NotFoundException;

/**
 * Created by Igor on 11.08.2016.
 */
public interface RestaurantService {

    Restaurant save(Restaurant user);

    void delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

   // Collection<Restaurant> getAll();

    void update(Restaurant user);
}