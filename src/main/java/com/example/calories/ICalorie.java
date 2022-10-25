package com.example.calories;

import java.util.Date;

public interface ICalorie {
    boolean existCalorie(String login, Date date);
    Integer findCalories (String login, Date date);
    boolean updateCalorie(Calorie calorie, Integer historyCalorie);
    boolean createCalorie(Calorie calorie);
    java.sql.Date toSqlDate(String strDate);
}
