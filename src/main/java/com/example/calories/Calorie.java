package com.example.calories;

import java.sql.Date;

public class Calorie {
    private String login;
    private Integer calories;
    private Date caloriesday;

    public Calorie(String login, Integer calories, Date caloriesday){
        this.login=login;
        this.calories=calories;
        this.caloriesday=caloriesday;
    }

    public String getLogin(){
        return login;
    }

    public Integer getCalories() {
        return calories;
    }

    public Date getCaloriesday() {
        return caloriesday;
    }
}
