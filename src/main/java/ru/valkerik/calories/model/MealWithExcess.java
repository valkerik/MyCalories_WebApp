package ru.valkerik.calories.model;

import java.time.LocalDateTime;

public class MealWithExcess {
    private final LocalDateTime dateTime;
    private final String description;
    private final int calories;
    private boolean excess;
    private int id;


    public MealWithExcess(LocalDateTime dateTime, String description, int calories, boolean excess) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.excess = excess;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public String getDateTimeToString() {
        return dateTime.toString();
    }
    public String getDescription() {
        return description;
    }
    public int getCalories() {
        return calories;
    }
    public boolean isExcess() {
        return excess;
    }
    public void setExcess(boolean excess) {
        this.excess = excess;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", excess=" + excess +
                '}' + "\n";
    }
}
