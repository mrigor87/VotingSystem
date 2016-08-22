package mrigor87.votingsystem.repository.jpa;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.model.User;
import mrigor87.votingsystem.repository.RestaurantRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

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

        return em.createNamedQuery(Restaurant.DELETE).setParameter("id", id).executeUpdate() != 0;
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

    @Override
    public Collection<Restaurant> getAll() {
        return em.createNamedQuery(Restaurant.GET_ALL, Restaurant.class).getResultList();
    }

    @Override
    public Collection<Dish> getMenu(int id) {
        Restaurant restaurant = get(id);
        return restaurant.getMenu();
    }

    @Override
    public boolean setMenu(int id, Collection<Dish> menu) {
        Restaurant restaurant = get(id);
        if (restaurant != null) {
            restaurant.setMenu(menu);
            return true;
        }
        return false;
    }

    @Override
    public Restaurant getWithMenu(int id) {
        return em.createNamedQuery(Restaurant.GET_WITH_MENU, Restaurant.class).setParameter(1,id) .getSingleResult();
    }
}
