package com.example.apiCalorie;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class WeightLoss {

    @SerializedName("loss weight")
    @Expose
    private String lossWeight;
    @SerializedName("calory")
    @Expose
    private Double calory;

    public String getLossWeight() {
        return lossWeight;
    }

    public void setLossWeight(String lossWeight) {
        this.lossWeight = lossWeight;
    }

    public Double getCalory() {
        return calory;
    }

    public void setCalory(Double calory) {
        this.calory = calory;
    }

}
