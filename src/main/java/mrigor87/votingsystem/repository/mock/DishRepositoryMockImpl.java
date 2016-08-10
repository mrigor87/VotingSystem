package mrigor87.votingsystem.repository.mock;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.repository.DishRepository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Igor on 08.08.2016.
 */
public class DishRepositoryMockImpl implements DishRepository {
    Map<Integer,Map<Integer,Dish>>repository=new ConcurrentHashMap<>();
    @Override
    public Dish get(Integer id, Integer restaurantId) {
        Map<Integer,Dish> menu=repository.get(restaurantId);
        return menu==null?null:menu.get(id);
    }

    @Override
    public boolean delete(Integer id, Integer restaurantId) {
        Map<Integer,Dish> menu=repository.get(restaurantId);
        return  (menu!=null)&&(menu.remove(id)!=null);
    }

    @Override
    public Dish save(Dish dish, Integer restaurantId) {
        Integer dishid=dish.getId();
        if (dishid==null){

        }
        return null;
    }

    @Override
    public Collection<Dish> getAll(Integer restaurantId) {
        return null;
    }
}
