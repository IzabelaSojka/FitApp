package com.example.threads;

import com.example.profile.Profile;
import com.example.profile.ProfileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;

public class SetProfileValue extends Thread{
    @FXML
    private TextField birthdayTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private ChoiceBox<String> genderChoice;
    @FXML
    private ChoiceBox<String> activityChoice;
    Profile profile;

    public SetProfileValue(Profile profile, TextField birthdayTextField, TextField weightTextField, TextField heightTextField, ChoiceBox<String> genderChoice, ChoiceBox<String> activityChoice){
        this.profile=profile;
        this.birthdayTextField=birthdayTextField;
        this.weightTextField=weightTextField;
        this.heightTextField=heightTextField;
        this.genderChoice=genderChoice;
        this.activityChoice=activityChoice;
    }

    public void run(){
        weightTextField.setText(Integer.toString(profile.getWeight()));
        heightTextField.setText(Integer.toString(profile.getHeight()));
        genderChoice.setValue(profile.getGender());
        birthdayTextField.setText(Integer.toString(profile.getAge()));

        String activity = ProfileHandler.getInstance().findActivity(profile.getActivityLevel());
        activityChoice.setValue(activity);
    }
}
