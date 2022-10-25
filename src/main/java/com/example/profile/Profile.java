package com.example.profile;

import java.sql.Date;

public class Profile {
    private String login;
    private Integer age;
    private Integer weight;
    private Integer height;
    private String gender;
    private String activityLevel;

    public Profile(String login, Integer age, Integer weight, Integer height, String gender, String activityLevel){
        this.login=login;
        this.age=age;
        this.weight=weight;
        this.height=height;
        this.gender=gender;
        this.activityLevel=activityLevel;
    }

    public String getLogin(){
        return login;
    }

    public Integer getAge(){
        return age;
    }

    public Integer getWeight(){
        return weight;
    }

    public Integer getHeight(){
        return height;
    }

    public String getGender(){
        return gender;
    }

    public String getActivityLevel(){
        return activityLevel;
    }
}
