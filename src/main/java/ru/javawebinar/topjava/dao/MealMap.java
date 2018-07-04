package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class MealMap implements MealDao {
    private static Map<Integer, Meal> mealsMap;
    private static AtomicInteger counter = new AtomicInteger(0);
    {
        mealsMap = new ConcurrentHashMap<>();
        List<Meal> meals = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        for (Meal meal : meals) {
            int id = counter.incrementAndGet();
            meal.setId(id);
            mealsMap.put(id, meal);
        }
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(mealsMap.values());
    }

    @Override
    public Meal getById(int id) {
        return mealsMap.get(id);
    }

    @Override
    public void deleteById(int id) {
        mealsMap.remove(id);
 }

    @Override
    public void put(Meal meal) {
        int id = counter.incrementAndGet();
        meal.setId(id);
        mealsMap.put(id, meal);
    }

    @Override
    public Meal update(int id, Meal updated) {
        return mealsMap.put(id, updated);
    }
}
