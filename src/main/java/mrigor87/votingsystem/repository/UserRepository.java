package mrigor87.votingsystem.repository;

import mrigor87.votingsystem.model.User;

import java.util.Collection;

/**
 * Created by Igor on 08.08.2016.
 */
public interface UserRepository {
    public User get(Integer id);
    public  boolean delete(Integer id);
    public  User  save(User user);
    public Collection<User> getAll(User user);
}
