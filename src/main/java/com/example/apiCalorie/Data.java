package com.example.apiCalorie;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("BMR")
    @Expose
    private Double bmr;
    @SerializedName("goals")
    @Expose
    private Goals goals;

    public Double getBmr() {
        return bmr;
    }

    public void setBmr(Double bmr) {
        this.bmr = bmr;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

}
