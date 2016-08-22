package mrigor87.votingsystem.repository.jpa;

import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.model.User;
import mrigor87.votingsystem.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
    @Transactional
    @Override
    public User save(User user) {
        if (user.isNew()){
            em.persist(user);
            return user;
        }
        User user1= em.find(User.class,user.getId());
        return em.merge(user);
    }

    @Override
    public Collection<User> getAll() {

        return em.createNamedQuery(User.ALL_SORTED,User.class).getResultList();
    }

    @Override
    @Transactional
    public boolean setVote(int userId, int restaurantId) {

        User user=em.getReference(User.class,userId);
        Restaurant restaurant=em.getReference(Restaurant.class,restaurantId);
        user.setRestaurant(restaurant);

        em.merge(user);
        return true;
    }
}
