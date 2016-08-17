package mrigor87.votingsystem.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by Igor on 08.08.2016.
 */
@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM    Restaurant r WHERE r.id=:id "),
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r ORDER BY r.name")})

@Entity
@Table(name = "restaurants")
//             restaurants
public class Restaurant extends NamedEntity {
    public static final String DELETE = "Restaurant.delete";
    public static final String GET_ALL = "Restaurant.all";

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
