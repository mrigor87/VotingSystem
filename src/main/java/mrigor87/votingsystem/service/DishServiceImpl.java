package mrigor87.votingsystem.service;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.repository.DishRepository;
import mrigor87.votingsystem.util.exception.ExceptionUtil;
import mrigor87.votingsystem.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Игорь on 14.08.2016.
 */
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    DishRepository repository;
    @Override
    public Dish save(Dish dish, int restaurantId) {

        return repository.save(dish,restaurantId);
    }

    @Override
    public void delete(int id, int restaurantId) throws NotFoundException {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id,restaurantId),id);

    }

    @Override
    public Dish get(int id, int restaurantId) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id,restaurantId),id);
    }

    @Override
    public Collection<Dish> getAll(int restaurantId) {
        return repository.getAll(restaurantId);
    }

    @Override
    public void update(Dish dish, int restaurantId) {
        ExceptionUtil.checkNotFoundWithId(repository.save(dish,restaurantId),dish.getId());

    }
}
