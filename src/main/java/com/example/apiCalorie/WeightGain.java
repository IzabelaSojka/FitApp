package com.example.apiCalorie;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class WeightGain {

    @SerializedName("gain weight")
    @Expose
    private String gainWeight;
    @SerializedName("calory")
    @Expose
    private Double calory;

    public String getGainWeight() {
        return gainWeight;
    }

    public void setGainWeight(String gainWeight) {
        this.gainWeight = gainWeight;
    }

    public Double getCalory() {
        return calory;
    }

    public void setCalory(Double calory) {
        this.calory = calory;
    }

}