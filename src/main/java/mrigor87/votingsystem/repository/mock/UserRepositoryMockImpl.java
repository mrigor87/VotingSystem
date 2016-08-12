package mrigor87.votingsystem.repository.mock;

import mrigor87.votingsystem.model.User;
import mrigor87.votingsystem.repository.UserRepository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Igor on 08.08.2016.
 */
public class UserRepositoryMockImpl implements UserRepository {
    Map<Integer,User> repository =new ConcurrentHashMap<>();
    AtomicInteger counter=new AtomicInteger(0);
    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id)!=null;
    }

    @Override
    public User save(User user) {
        if (user.isNew()){
            user.setId(counter.incrementAndGet());
        }
        return repository.put(user.getId(),user);
    }

    @Override
    public Collection<User> getAll() {
        return repository.values();
    }
}
