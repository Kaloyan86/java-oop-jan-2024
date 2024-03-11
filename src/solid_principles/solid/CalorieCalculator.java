package solid_principles.solid;

import java.util.List;

public class CalorieCalculator implements Calculator{

    @Override
    public double sum(List<Food> products) {
        return products.stream().mapToDouble(Product::amountOfCalories).sum();
    }

    @Override
    public double average(List<Food> products) {
        return sum(products) / products.size();
    }
}








