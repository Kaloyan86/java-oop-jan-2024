package exam_prep.zoo.repositories;

import java.util.ArrayList;
import java.util.Collection;

import exam_prep.zoo.entities.foods.Food;

public class FoodRepositoryImpl implements FoodRepository {

    private Collection<Food> foods;

    public FoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        return this.foods.remove(food);
    }

    @Override
    public Food findByType(String type) {
        return this.foods.stream()
                         .filter(food -> food.getClass().getSimpleName().equals(type))
                         .findFirst()
                         .orElse(null);
    }
}
