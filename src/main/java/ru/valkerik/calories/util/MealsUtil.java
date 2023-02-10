package ru.valkerik.calories.util;

import ru.valkerik.calories.model.Meal;
import ru.valkerik.calories.model.MealWithExcess;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.valkerik.calories.util.TimeUtil.isBetweenHalfOpen;

public class MealsUtil {


    public static List<MealWithExcess> filteredByCycles(List<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        final Map<LocalDate, Integer> caloriesSumByDate = new HashMap<>();
        meals.forEach(meal -> caloriesSumByDate.merge(meal.getDate(), meal.getCalories(), Integer::sum));

        final List<MealWithExcess> mealsTo = new ArrayList<>();
        meals.forEach(meal -> {
            if (isBetweenHalfOpen(meal.getTime(), startTime, endTime)) {
                mealsTo.add(createTo(meal, caloriesSumByDate.get(meal.getDate()) > caloriesPerDay));
            }
        });
        return mealsTo;
    }

    private static MealWithExcess createTo(Meal meal, boolean excess) {
        MealWithExcess mealWithExcess = new MealWithExcess(meal.getDateTime(), meal.getDescription(), meal.getCalories(), excess);
        mealWithExcess.setId(meal.getId());
        return mealWithExcess;
    }
}
