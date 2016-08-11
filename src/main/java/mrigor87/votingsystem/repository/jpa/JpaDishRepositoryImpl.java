package mrigor87.votingsystem.repository.jpa;

import mrigor87.votingsystem.model.Dish;
import mrigor87.votingsystem.repository.DishRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by Igor on 11.08.2016.
 */
@Repository
public class JpaDishRepositoryImpl implements DishRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public Dish get(Integer id, Integer userId) {
        return em.find(Dish.class,id);
    }

    @Override
    public boolean delete(Integer id, Integer userId) {
        return
                em.createNamedQuery(Dish.DELETE,Dish.class).setParameter(1,id).executeUpdate()!=0;
    }

    @Override
    @Transactional
    public Dish save(Dish dish, Integer userid) {
        return null;
    }

    @Override
    public Collection<Dish> getAll(Integer userid) {
        return null;
    }
}
