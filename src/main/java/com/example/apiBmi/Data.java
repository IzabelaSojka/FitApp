package com.example.apiBmi;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("bmi")
    @Expose
    private Double bmi;
    @SerializedName("health")
    @Expose
    private String health;
    @SerializedName("healthy_bmi_range")
    @Expose
    private String healthyBmiRange;

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHealthyBmiRange() {
        return healthyBmiRange;
    }

    public void setHealthyBmiRange(String healthyBmiRange) {
        this.healthyBmiRange = healthyBmiRange;
    }
}
