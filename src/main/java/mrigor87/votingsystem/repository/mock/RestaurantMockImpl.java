package mrigor87.votingsystem.repository.mock;

import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.repository.RestaurantRepository;

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
    public Restaurant get(Integer id) {
        return repository.get(id);
    }

    @Override
    public boolean delete(Integer id) {
        return repository.remove(get(id))!=null;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()){
           return repository.put(counter.incrementAndGet(),restaurant);
        }
        return repository.put(restaurant.getId(),restaurant);
    }
}
