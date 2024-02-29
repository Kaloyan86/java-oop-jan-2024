package inheritance.restaurant.food.dessert;

import java.math.BigDecimal;

import inheritance.restaurant.food.Food;

public class Dessert extends Food {

    private double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
