package inheritance.restaurant.food.starter;

import java.math.BigDecimal;

import inheritance.restaurant.food.Food;

public class Starter extends Food {

    public Starter(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
