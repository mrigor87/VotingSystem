package mrigor87.votingsystem.model;

/**
 * Created by Igor on 08.08.2016.
 */
public class Dish extends NamedEntity {
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

