package mrigor87.votingsystem.model;

import javax.persistence.*;

/**
 * Created by Igor on 08.08.2016.
 */
@NamedQueries({
          @NamedQuery(name = Dish.DELETE,     query = "DELETE FROM Dish d     WHERE d.id=?1"),
       // @NamedQuery(name = UserMeal.DELETE, query = "DELETE FROM UserMeal m WHERE m.id=:id AND m.user      .id=:userId"),

        @NamedQuery(name = Dish.GET, query = "SELECT d FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurantId"),
        @NamedQuery(name = Dish.ALL, query = "SELECT d FROM Dish d WHERE d.restaurant.id=?1 ORDER BY d.name")
})
@Entity
@Table(name = "dishes")
public class Dish extends NamedEntity {
    public static final String DELETE="Dish.delete";
    public static final String GET="Dish.get";
    public static final String ALL="Dish.all";

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurantId", nullable = false)
    private Restaurant restaurant;

public Dish(Dish dish){
    this.id=dish.id;
    this.name=dish.name;
    this.price=dish.price;
}

    public Dish() {
    }

    public Dish(Integer id, String name,double price) {
        super(id, name);
        this.price=price;
    }
    public Dish(Integer id, String name,double price, Restaurant restaurant) {
        super(id, name);
        this.price=price;
        this.restaurant=restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name=" + name +
                " price=" + price +
                '}';
    }
}

