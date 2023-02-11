package ru.valkerik.calories.repository;

import ru.valkerik.calories.model.Meal;

import java.util.Collection;

public interface MealRepository {
    Meal save(Meal meal);
    void delete(int id);
    Meal getById(int id);
    Collection<Meal> getAll();
}
