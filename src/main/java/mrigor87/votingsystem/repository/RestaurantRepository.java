package mrigor87.votingsystem.repository;

import mrigor87.votingsystem.model.Restaurant;

/**
 * Created by Igor on 08.08.2016.
 */
public interface RestaurantRepository {
    Restaurant get(Integer id);
    boolean delete(Integer id);
    Restaurant save(Integer id);
}
