package mrigor87.votingsystem.repository.jpa;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.model.Restaurant;
import mrigor87.votingsystem.model.User;
import mrigor87.votingsystem.repository.DishRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * Created by Igor on 11.08.2016.
 */
@Repository
public class JpaDishRepositoryImpl implements DishRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public Dish get(int id, int restaurantId) {

        List<Dish> menu = em.createNamedQuery(Dish.GET, Dish.class)
                .setParameter("id", id)
                .setParameter("restaurantId", restaurantId)
                .getResultList();
        return DataAccessUtils.singleResult(menu);
    }

    @Transactional
    @Override
    public boolean delete(int id, int restaurantId) {
        return
                em.createNamedQuery(Dish.DELETE)
                        .setParameter(1, id)
                        .setParameter(2, restaurantId)
                        .executeUpdate() != 0;
    }

    @Transactional
    @Override
    public Dish save(Dish dish, int restaurantId) {
        if (!dish.isNew() && get(dish.getId(), restaurantId) == null) {
            return null;
        }
        Restaurant restaurant = em.getReference(Restaurant.class, restaurantId);
        dish.setRestaurant(restaurant);
        if (dish.isNew()) {
            em.persist(dish);
            return dish;
        }
        return em.merge(dish);
    }

    @Override
    public Collection<Dish> getAll(int restaurantId) {
        return em.createNamedQuery(Dish.ALL, Dish.class).setParameter(1, restaurantId).getResultList();
    }
}
