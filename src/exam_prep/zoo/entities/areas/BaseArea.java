package exam_prep.zoo.entities.areas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import exam_prep.zoo.entities.animals.Animal;
import exam_prep.zoo.entities.foods.Food;

import static exam_prep.zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static exam_prep.zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    private void setName(String name) {

        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {

        if (animals.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {

        StringBuilder info = new StringBuilder();
        info.append(String.format("%s (%s):",
                                  this.name,
                                  this.getClass().getSimpleName()))
            .append(System.lineSeparator());
        info.append("Animals: ");

        String animals = this.animals.isEmpty() ? " none" :
                         this.animals.stream()
                                     .map(Animal::getName)
                                     .collect(Collectors.joining(" "));

        info.append(animals);

        info.append(System.lineSeparator());
        info.append(String.format("Foods: %d", this.foods.size())).append(System.lineSeparator());
        info.append(String.format("Calories: %d", sumCalories()));
        return info.toString().trim();
    }
}
