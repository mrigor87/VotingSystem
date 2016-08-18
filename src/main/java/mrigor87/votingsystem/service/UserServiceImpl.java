package mrigor87.votingsystem.service;

import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.model.User;
import mrigor87.votingsystem.repository.UserRepository;
import mrigor87.votingsystem.util.exception.ExceptionUtil;
import mrigor87.votingsystem.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Igor on 11.08.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Transactional
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id),id);
    }

    @Override
    public User get(int id) throws NotFoundException {
       return ExceptionUtil.checkNotFoundWithId(repository.get(id),id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {

        return null;//ExceptionUtil.checkNotFound(repository. getByEmail(email),email);
    }

    @Override
    public Collection<User> getAll() {
        return repository.getAll();
    }

    @Transactional
    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public boolean setVote(int id,Restaurant restaurant) {
        User user=get(id);
        user.setRestaurant(restaurant);
        update(user);
        return true;
    }
}
