package com.example.appedp;

import com.example.apiBmi.Data;
import com.example.function.GetBmi;
import com.example.function.view;
import com.example.threads.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BMI implements Initializable {
    @FXML
    private Button calculateButton;
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
    private TextField weightField;
    @FXML
    private TextField heightField;
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
    }

    public void calculateButtonOnAction(ActionEvent event) {
        Integer weight = Integer.parseInt(weightField.getText());
        Integer height = Integer.parseInt(heightField.getText());
        Data data = GetBmi.calculateBMI(weight, height);
        bmiLabel.setText("BMI: "+Double.toString(data.getBmi()));
        healthyLabel.setText("Healthy: "+data.getHealth());
        rangeLabel.setText("Healthy BMI Range: "+data.getHealthyBmiRange());
    }

    public void back(ActionEvent event) throws IOException {
        view.viewStart(backButton);
    }
}
