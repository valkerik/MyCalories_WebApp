package ru.valkerik.calories.dao;

import ru.valkerik.calories.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MealDAO {
    private static final List<Meal> mealList;

    static {
        mealList = new ArrayList<>();
        mealList.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        mealList.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        mealList.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        mealList.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        mealList.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        mealList.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        mealList.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
    }


    public static List<Meal> getAllMeals() {

        return mealList;
    }

    public Meal getMealById(int id) {
        return mealList.stream().filter(m -> m.getId() == id).findAny().orElse(null);
    }

    public void addMeal(Meal meal) {
        mealList.add(meal);
    }

    public void updateMeal(int id, Meal updatedMeal) {
        Meal meal = getMealById(id);

        meal.setDateTime(updatedMeal.getDateTime());
        meal.setDescription(updatedMeal.getDescription());
        meal.setCalories(updatedMeal.getCalories());
    }

    public void deleteMeal(int id) {
        mealList.removeIf(p -> p.getId() == id);
    }

}
