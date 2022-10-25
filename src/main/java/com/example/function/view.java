package com.example.function;

import com.example.appedp.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class view {

    @FXML
    public static void exit(){
        System.exit(0);
    }
    public static void viewStart(Button button) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 727, 525);
        Stage startStage = (Stage) button.getScene().getWindow();
        startStage.setTitle("Fit App!");
        startStage.setScene(scene);
        startStage.show();
    }
    public static void viewBMI(Button button) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("BMI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 727, 525);
        Stage startStage = (Stage) button.getScene().getWindow();
        startStage.setTitle("Fit App!");
        startStage.setScene(scene);
        startStage.show();
    }

    public static void viewBMILogged(Button button) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("bmiLogged.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 727, 525);
        Stage startStage = (Stage) button.getScene().getWindow();
        startStage.setTitle("Fit App!");
        startStage.setScene(scene);
        startStage.show();
    }

    public static void viewRegister(Button button) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 727, 525);
        Stage registerStage = (Stage) button.getScene().getWindow();
        registerStage.setTitle("Fit App!");
        registerStage.setScene(scene);
        registerStage.show();
    }

    public static void viewLogin(Button button) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 727, 525);
        Stage loginStage = (Stage) button.getScene().getWindow();
        loginStage.setTitle("Fit App!");
        loginStage.setScene(scene);
        loginStage.show();
    }

    public static void viewProfile(Button button) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("profile.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 727, 525);
        Stage profileStage = (Stage) button.getScene().getWindow();
        profileStage.setTitle("Fit App!");
        profileStage.setScene(scene);
        profileStage.show();
    }

    public static void viewReminderPassword() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("reminderPassword.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 491, 256);
        Stage profileStage = new Stage();
        profileStage.setTitle("Fit App!");
        profileStage.setScene(scene);
        profileStage.show();
    }

    public static void viewLoggedStart(Button button) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loggedStart.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 727, 525);
        Stage profileStage = (Stage) button.getScene().getWindow();
        profileStage.setTitle("Fit App!");
        profileStage.setScene(scene);
        profileStage.show();
    }

    public static void viewTimer() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("timer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 727, 525);
        Stage timerStage = new Stage();
        timerStage.setTitle("Fit App!");
        timerStage.setScene(scene);
        timerStage.show();
    }

    public static void viewCalories(Button button) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("caloriePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 727, 525);
        Stage profileStage = (Stage) button.getScene().getWindow();
        profileStage.setTitle("Fit App!");
        profileStage.setScene(scene);
        profileStage.show();
    }
}
