package com.example.appedp;

import com.example.function.SendingData;
import com.example.function.view;
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

public class LoggedStart implements Initializable {
    SendingData sendLogin = SendingData.getInstance();
    @FXML
    private ImageView icon, clock;
    @FXML
    private Button logoutButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button BMIButton;
    @FXML
    private Button caloriesButton;
    @FXML
    private Label logged;
    @FXML
    private Label time;
    Time times;

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

        logged.setText("Hello, "+sendLogin.getLogin());
    }

    public void profileButtonOnAction(ActionEvent event) throws IOException {
        view.viewProfile(profileButton);
    }
    public void bmiButtonOnAction(ActionEvent event) throws IOException {
        view.viewBMILogged(BMIButton);
    }
    public void timerOnAction(ActionEvent event) throws IOException {
        view.viewTimer();
    }
    public void logoutButtonOnAction(ActionEvent event) throws IOException {
        view.viewLogin(logoutButton);
        sendLogin.setLogin("");
    }
    public void caloriesButtonOnAction(ActionEvent event) throws IOException {
        view.viewCalories(caloriesButton);
    }
}
