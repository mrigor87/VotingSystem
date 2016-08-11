package mrigor87.votingsystem.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by Igor on 08.08.2016.
 */
@NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant u WHERE u.id=:id")

@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {
    public static final String DELETE = "Restaurant.delete";

    public Restaurant() {
    }
    public Restaurant(Integer id, String name) {
        super(id, name);
    }
}
