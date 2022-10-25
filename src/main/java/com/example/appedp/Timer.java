package com.example.appedp;

import com.example.function.view;
import com.example.threads.CountdownTime;
import com.example.threads.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Timer implements Initializable {
    @FXML
    private ImageView icon, start, clock;
    @FXML
    private Label time;
    @FXML
    private Button backButton;
    @FXML
    private Text info;
    @FXML
    private Text countMinutes;
    @FXML
    private TextField intervalsTextField;
    @FXML
    private Text countsSeconds;
    Time times;
    @FXML
    private ChoiceBox<Integer> activityMinutes;
    @FXML
    private ChoiceBox<Integer> activitySeconds;
    @FXML
    private ChoiceBox<Integer> restMinutes;
    @FXML
    private ChoiceBox<Integer> restSeconds;

    CountdownTime countdownTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File iconFile = new File("picture/fit.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        icon.setImage(iconImage);

        iconFile = new File("picture/start.png");
        iconImage = new Image(iconFile.toURI().toString());
        start.setImage(iconImage);

        iconFile = new File("picture/clock.png");
        iconImage = new Image(iconFile.toURI().toString());
        clock.setImage(iconImage);

        times = new Time(time);
        times.start();

        ObservableList<Integer> minutesSecondsList = FXCollections.observableArrayList();
        for(int i=0;i<=60;i++){
            minutesSecondsList.add(new Integer(i));
        }
        activityMinutes.setItems(minutesSecondsList);
        activityMinutes.setValue(0);

        restMinutes.setItems(minutesSecondsList);
        restMinutes.setValue(0);

        activitySeconds.setItems(minutesSecondsList);
        activitySeconds.setValue(0);

        restSeconds.setItems(minutesSecondsList);
        restSeconds.setValue(0);
    }
    public void start(){
        countdownTime = new CountdownTime(Integer.parseInt(intervalsTextField.getText()),activityMinutes.getValue(),activitySeconds.getValue(),countMinutes,countsSeconds,info,restMinutes.getValue(),restSeconds.getValue());
        countdownTime.start();
    }

    public void back()throws IOException {
        view.viewStart(backButton);
    }
}
