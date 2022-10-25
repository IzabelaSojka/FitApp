package com.example.appedp;

import com.example.calories.Calorie;
import com.example.calories.CalorieHandler;
import com.example.calories.ICalorie;
import com.example.function.CheckRequirements;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class CaloriePage implements Initializable {

    IProfile profileHandler = ProfileHandler.getInstance();
    @FXML
    private Button addCalories;
    @FXML
    private Button backButton;
    @FXML
    private ImageView clock;
    @FXML
    private Label history;
    @FXML
    private ImageView icon;
    @FXML
    private Label time;
    @FXML
    private Label daily;
    @FXML
    private Label today;
    @FXML
    private Label login;
    @FXML
    private TextField calorieTextField;
    @FXML
    private TextField historyTextField;
    @FXML
    private ChoiceBox<String> weightChoice;
    private String[] choice ={"maintain weight", "mild weight loss", "weight loss", "extreme weight loss", "mild weight gain", "weight gain","extreme weight gain"};
    Time times;
    SendingData sendLogin = SendingData.getInstance();
    ICalorie calorieHandler = CalorieHandler.getInstance();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String datenow = sdf.format(new Date());
    java.sql.Date dateTmp = calorieHandler.toSqlDate(datenow);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File iconFile = new File("picture/fit.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        icon.setImage(iconImage);

        iconFile = new File("picture/clock.png");
        iconImage = new Image(iconFile.toURI().toString());
        clock.setImage(iconImage);

        weightChoice.getItems().addAll(choice);
        weightChoice.setValue(choice[0]);

        times = new Time(time);
        times.start();

        login.setText(sendLogin.getLogin());

        setCalorie();
    }

    public void saveCalories(ActionEvent event) throws IOException{
        Calorie calorie = new Calorie(sendLogin.getLogin(),Integer.parseInt(calorieTextField.getText()), dateTmp);
        if(calorieHandler.existCalorie(sendLogin.getLogin(),dateTmp)==false){
            calorieHandler.createCalorie(calorie);
            setCalorie();
        }
        else{
            Integer historyCalorie = calorieHandler.findCalories(sendLogin.getLogin(),dateTmp);
            calorieHandler.updateCalorie(calorie, historyCalorie);
            setCalorie();
        }
    }

    public void back(ActionEvent event) throws IOException {
        view.viewLoggedStart(backButton);
    }

    private void setCalorie(){
        String calories=Integer.toString(calorieHandler.findCalories(sendLogin.getLogin(),dateTmp));
        today.setText(calories);
    }

    public void findCaloriesInDay(ActionEvent event){
        java.sql.Date historyDate = calorieHandler.toSqlDate(historyTextField.getText());
        history.setText(Integer.toString(calorieHandler.findCalories(sendLogin.getLogin(),historyDate)));
    }
    public void checkDailyRequirements(ActionEvent event){
        Profile profile = profileHandler.findProfile(sendLogin.getLogin());
        CheckRequirements.check(profile,weightChoice.getValue(),daily);
    }
}
