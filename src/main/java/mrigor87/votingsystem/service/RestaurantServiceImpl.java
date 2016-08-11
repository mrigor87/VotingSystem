package mrigor87.votingsystem.service;

import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.repository.RestaurantRepository;
import mrigor87.votingsystem.util.exception.ExceptionUtil;
import mrigor87.votingsystem.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Igor on 11.08.2016.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository repository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id),id);
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id),id);
    }

    @Override
    public void update(Restaurant restaurant) {
        repository.save(restaurant);
    }
}
