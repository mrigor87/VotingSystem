package mrigor87.votingsystem.servive;

import mrigor87.votingsystem.model.User;
import mrigor87.votingsystem.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Igor on 08.08.2016.
 */
public interface UserService {
    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);

}
