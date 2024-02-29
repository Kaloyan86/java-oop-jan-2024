package inheritance.restaurant.food.main_dish;

import java.math.BigDecimal;

import inheritance.restaurant.food.Food;

public class MainDish extends Food {

    public MainDish(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
