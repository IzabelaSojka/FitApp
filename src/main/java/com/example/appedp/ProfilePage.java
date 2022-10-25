package com.example.appedp;

import com.example.function.SendingData;
import com.example.function.view;
import com.example.profile.IProfile;
import com.example.profile.Profile;
import com.example.profile.ProfileHandler;
import com.example.threads.Time;
import com.example.threads.SetProfileValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ProfilePage implements Initializable {
    IProfile profileHandler = ProfileHandler.getInstance();
    SendingData sendLogin = SendingData.getInstance();
    @FXML
    private ImageView icon, clock;
    @FXML
    private TextField birthdayTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private Button backButton;
    @FXML
    private Label infoChanges;
    @FXML
    private Label time;
    @FXML
    private Label login;

    Time times;
    SetProfileValue setProfileValue;
    @FXML
    private ChoiceBox<String> genderChoice;

    private String[] gender = {"male","female"};

    @FXML
    private ChoiceBox<String> activityChoice;

    private String[] activity ={"Sedentary: little or no exercise","Exercise 1-3 times/week","Exercise 4-5 times/week","Daily exercise or intense exercise 3-4 times/week","Intense exercise 6-7 times/week","Very intense exercise daily, or physical job"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File iconFile = new File("picture/fit.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        icon.setImage(iconImage);

        iconFile = new File("picture/clock.png");
        iconImage = new Image(iconFile.toURI().toString());
        clock.setImage(iconImage);

        genderChoice.getItems().addAll(gender);
        activityChoice.getItems().addAll(activity);

        times = new Time(time);
        times.start();

        login.setText(sendLogin.getLogin());
        Profile profile = profileHandler.findProfile(sendLogin.getLogin());

        setProfileValue = new SetProfileValue(profile, birthdayTextField, weightTextField, heightTextField, genderChoice, activityChoice);
        setProfileValue.start();
    }

    public void saveChanges(ActionEvent event) {
        String level = profileHandler.findActivityLevel(activityChoice.getValue());
        Profile profile = new Profile(sendLogin.getLogin(), Integer.parseInt(birthdayTextField.getText()), Integer.parseInt(weightTextField.getText()), Integer.parseInt(heightTextField.getText()), genderChoice.getValue(), level);
        if(profileHandler.existProfile(sendLogin.getLogin())==false){
            profileHandler.createProfile(profile);
        }
        else{
            profileHandler.updateProfile(profile);
        }
        infoChanges.setText("Save changes!");
    }

    public void back()throws IOException {
        view.viewLoggedStart(backButton);
    }

}
