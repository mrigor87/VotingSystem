package mrigor87.votingsystem.repository.mock;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.repository.RestaurantRepository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Igor on 10.08.2016.
 */
public class RestaurantMockImpl implements RestaurantRepository {
    Map<Integer,Restaurant> repository =new ConcurrentHashMap<>();
    AtomicInteger counter=new AtomicInteger(0);
    @Override
    public Restaurant get(int id) {
        return repository.get(id);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(get(id))!=null;
    }


    @Override
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()){
           return repository.put(counter.incrementAndGet(),restaurant);
        }
        return repository.put(restaurant.getId(),restaurant);
    }

    @Override
    public Collection<Restaurant> getAll() {
        return null;
    }

    @Override
    public Collection<Dish> getMenu(int id) {
        return null;
    }

    @Override
    public boolean setMenu(int id, Collection<Dish> menu) {
        return false;
    }

    @Override
    public Restaurant getWithMenu(int id) {
        return null;
    }
}
