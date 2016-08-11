package mrigor87.votingsystem.repository.jpa;

import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.model.User;
import mrigor87.votingsystem.repository.RestaurantRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Igor on 11.08.2016.
 */
@Repository
public class JpaRestaurantRepositoryImpl implements RestaurantRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public Restaurant get(int id) {
        return em.find(Restaurant.class, id);
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(User.DELETE, Restaurant.class).setParameter("id", id).executeUpdate() != 0;
        //return em.re;
    }

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant) {
        Integer id = restaurant.getId();
        if (restaurant.isNew()) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }
}
