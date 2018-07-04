package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;
import java.util.Map;

public interface MealDao {
    List<Meal> getAll();
    Meal getById(int id);
    void deleteById(int id);
    void put(Meal meal);
    Meal update(int id, Meal updated);

}
