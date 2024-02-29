package inheritance.restaurant.beverages.hot_beverage;

import java.math.BigDecimal;

import inheritance.restaurant.beverages.Beverage;

public class HotBeverage extends Beverage {

    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
