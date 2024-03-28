package exam_prep.zoo.core;

import java.util.ArrayList;
import java.util.Collection;

import exam_prep.zoo.entities.animals.Animal;
import exam_prep.zoo.entities.animals.AquaticAnimal;
import exam_prep.zoo.entities.animals.TerrestrialAnimal;
import exam_prep.zoo.entities.areas.Area;
import exam_prep.zoo.entities.areas.LandArea;
import exam_prep.zoo.entities.areas.WaterArea;
import exam_prep.zoo.entities.foods.Food;
import exam_prep.zoo.entities.foods.Meat;
import exam_prep.zoo.entities.foods.Vegetable;
import exam_prep.zoo.repositories.FoodRepository;
import exam_prep.zoo.repositories.FoodRepositoryImpl;

import static exam_prep.zoo.common.ConstantMessages.*;
import static exam_prep.zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {

        Area area;

        switch (areaType) {
            case "WaterArea":
                area = new WaterArea(areaName);
                break;
            case "LandArea":
                area = new LandArea(areaName);
                break;
            default:
                throw new NullPointerException(INVALID_AREA_TYPE);
        }

        this.areas.add(area);

        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {

        Food food;

        switch (foodType) {

            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }

        foodRepository.add(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {

        Area area = getAreaByName(areaName);

        Food food = foodRepository.findByType(foodType);

        if (null == food) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        area.addFood(food);
        foodRepository.remove(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName,
                            String animalType,
                            String animalName,
                            String kind,
                            double price) {

        Area area = getAreaByName(areaName);

        Animal animal;
        String result = String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);

        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);

                if (area.getClass().getSimpleName().equals("WaterArea")) {
                    area.addAnimal(animal);
                } else {
                    result = AREA_NOT_SUITABLE;
                }

                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);

                if (area.getClass().getSimpleName().equals("LandArea")) {
                    area.addAnimal(animal);
                } else {
                    result = AREA_NOT_SUITABLE;
                }

                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        return result;
    }

    @Override
    public String feedAnimal(String areaName) {

        Area area = getAreaByName(areaName);

        area.feed();

        return String.format(ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {

        Area area = getAreaByName(areaName);

        double sum = area.getAnimals()
                         .stream()
                         .mapToDouble(Animal::getKg)
                         .sum();

        return String.format(KILOGRAMS_AREA, areaName, sum);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        areas.forEach(area -> {
            sb.append(area.getInfo());
            sb.append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    private Area getAreaByName(String areaName) {
        return this.areas.stream()
                         .filter(a -> a.getName().equals(areaName))
                         .findFirst()
                         .orElse(null);
    }
}
