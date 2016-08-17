package mrigor87.votingsystem.repository.jpa;

import mrigor87.votingsystem.model.User;
import mrigor87.votingsystem.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by Igor on 11.08.2016.
 */
@Repository
public class JpaUserRepositoryImpl implements UserRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public User get(int id) {
        return em.find(User.class,id);
    }

    @Override
    public boolean delete(int id) {

        return em.createNamedQuery(User.DELETE).setParameter(1,id).executeUpdate()!=0;
    }

    @Override
    public User save(User user) {
        if (user.isNew()){
            em.persist(user);
            return user;
        }
        return em.merge(user);
    }

    @Override
    public Collection<User> getAll() {

        return em.createNamedQuery(User.ALL_SORTED,User.class).getResultList();
    }
}
