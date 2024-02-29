package inheritance.restaurant.beverages.cold_beverage;

import java.math.BigDecimal;

import inheritance.restaurant.beverages.Beverage;

public class ColdBeverage extends Beverage {

    public ColdBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
