package com.example.apiCalorie;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Goals {

    @SerializedName("maintain weight")
    @Expose
    private Double maintainWeight;
    @SerializedName("Mild weight loss")
    @Expose
    private MildWeightLoss mildWeightLoss;
    @SerializedName("Weight loss")
    @Expose
    private WeightLoss weightLoss;
    @SerializedName("Extreme weight loss")
    @Expose
    private ExtremeWeightLoss extremeWeightLoss;
    @SerializedName("Mild weight gain")
    @Expose
    private MildWeightGain mildWeightGain;
    @SerializedName("Weight gain")
    @Expose
    private WeightGain weightGain;
    @SerializedName("Extreme weight gain")
    @Expose
    private ExtremeWeightGain extremeWeightGain;

    public Double getMaintainWeight() {
        return maintainWeight;
    }

    public void setMaintainWeight(Double maintainWeight) {
        this.maintainWeight = maintainWeight;
    }

    public MildWeightLoss getMildWeightLoss() {
        return mildWeightLoss;
    }

    public void setMildWeightLoss(MildWeightLoss mildWeightLoss) {
        this.mildWeightLoss = mildWeightLoss;
    }

    public WeightLoss getWeightLoss() {
        return weightLoss;
    }

    public void setWeightLoss(WeightLoss weightLoss) {
        this.weightLoss = weightLoss;
    }

    public ExtremeWeightLoss getExtremeWeightLoss() {
        return extremeWeightLoss;
    }

    public void setExtremeWeightLoss(ExtremeWeightLoss extremeWeightLoss) {
        this.extremeWeightLoss = extremeWeightLoss;
    }

    public MildWeightGain getMildWeightGain() {
        return mildWeightGain;
    }

    public void setMildWeightGain(MildWeightGain mildWeightGain) {
        this.mildWeightGain = mildWeightGain;
    }

    public WeightGain getWeightGain() {
        return weightGain;
    }

    public void setWeightGain(WeightGain weightGain) {
        this.weightGain = weightGain;
    }

    public ExtremeWeightGain getExtremeWeightGain() {
        return extremeWeightGain;
    }

    public void setExtremeWeightGain(ExtremeWeightGain extremeWeightGain) {
        this.extremeWeightGain = extremeWeightGain;
    }

}
