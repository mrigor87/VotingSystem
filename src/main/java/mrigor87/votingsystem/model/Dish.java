package mrigor87.votingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by Igor on 08.08.2016.
 */
@NamedQuery(name = Dish.DELETE, query = "DELETE FROM Dish u WHERE u.id=:id")

@Entity
@Table(name = "dishes")
public class Dish extends NamedEntity {
    public static final String DELETE="Dish.delete";

    @Column(name = "price", nullable = false)
    private double price;

    public Dish() {
    }

    public Dish(Integer id, String name,double price) {
        super(id, name);
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

