package com.example.function;

import com.example.profile.Profile;
import com.example.apiCalorie.Data;
import javafx.scene.control.Label;

public class CheckRequirements {
    public static void check(Profile profile, String choice, Label daily){
        Data data = GetCalories.calculateDailyCaloriesRequirements(profile);
         switch (choice){
            case "maintain weight":
                daily.setText(Double.toString(data.getGoals().getMaintainWeight()));
                break;
            case "mild weight loss":
                daily.setText(Double.toString(data.getGoals().getMildWeightLoss().getCalory()));
                break;
            case "weight loss":
                daily.setText(Double.toString(data.getGoals().getWeightLoss().getCalory()));
                break;
            case "extreme weight loss":
                daily.setText(Double.toString(data.getGoals().getExtremeWeightLoss().getCalory()));
                break;
            case "mild weight gain":
                daily.setText(Double.toString(data.getGoals().getMildWeightGain().getCalory()));
                break;
            case "weight gain":
                daily.setText(Double.toString(data.getGoals().getWeightGain().getCalory()));
                break;
            case "extreme weight gain":
                daily.setText(Double.toString(data.getGoals().getExtremeWeightGain().getCalory()));
                break;
        }
    }
}
