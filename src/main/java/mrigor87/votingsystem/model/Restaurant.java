package mrigor87.votingsystem.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Igor on 08.08.2016.
 */
@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM    Restaurant r WHERE r.id=:id "),
      //  @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r ORDER BY r.name"),
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.menu ORDER BY r.name"),
        @NamedQuery(name = Restaurant.GET_WITH_MENU, query = "SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.menu WHERE r.id=?1 ORDER BY r.name")
})

@Entity
@Table(name = "restaurants")

public class Restaurant extends NamedEntity {
    public static final String DELETE = "Restaurant.delete";
    public static final String GET_ALL = "Restaurant.all";
    public static final String GET_WITH_MENU ="Restaurant.withMenu";

    @OneToMany(mappedBy="restaurant",fetch=FetchType.LAZY,targetEntity = Dish.class)
    private Collection<Dish> menu;

    public Collection<Dish> getMenu() {
        return menu;
    }

    public void setMenu(Collection<Dish> menu) {
        this.menu = menu;
    }

    public Restaurant() {
    }
    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
