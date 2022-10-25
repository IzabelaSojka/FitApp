package com.example.appedp;

import com.example.apiBmi.Data;
import com.example.function.GetBmi;
import com.example.function.SendingData;
import com.example.function.view;
import com.example.profile.IProfile;
import com.example.profile.Profile;
import com.example.profile.ProfileHandler;
import com.example.threads.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BmiLogged implements Initializable {
    @FXML
    private Button backButton;
    @FXML
    private ImageView icon, clock;
    @FXML
    private Label bmiLabel;
    @FXML
    private Label healthyLabel;
    @FXML
    private Label rangeLabel;
    @FXML
    private Label time;
    @FXML
    private Label login;
    Time times;
    SendingData sendLogin = SendingData.getInstance();
    IProfile profileHandler = ProfileHandler.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File iconFile = new File("picture/fit.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        icon.setImage(iconImage);

        iconFile = new File("picture/clock.png");
        iconImage = new Image(iconFile.toURI().toString());
        clock.setImage(iconImage);

        times = new Time(time);
        times.start();

        login.setText(sendLogin.getLogin());
        Profile profile = profileHandler.findProfile(sendLogin.getLogin());

        Integer weight = profile.getWeight();
        Integer height = profile.getHeight();
        Data data = GetBmi.calculateBMI(weight, height);
        bmiLabel.setText("BMI: "+Double.toString(data.getBmi()));
        healthyLabel.setText("Healthy: "+data.getHealth());
        rangeLabel.setText("Healthy BMI Range: "+data.getHealthyBmiRange());
    }
    public void back(ActionEvent event) throws IOException {
        view.viewLoggedStart(backButton);
    }
}
