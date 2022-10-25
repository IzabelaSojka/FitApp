package com.example.appedp;

import com.example.function.view;
import com.example.member.IMember;
import com.example.member.Member;
import com.example.member.MemberHandler;
import com.example.threads.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Register implements Initializable {
    IMember memberHandler = MemberHandler.getInstance();
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private ImageView icon, clock;
    @FXML
    private Label info;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField enterRepeatPasswordField;
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
    public void loginButtonOnAction(ActionEvent event) throws IOException {
        view.viewLogin(loginButton);
    }


    public void registerButtonOnAction(ActionEvent event) throws IOException {
        Member member = new Member(loginTextField.getText(), enterPasswordField.getText(), emailTextField.getText());
        if(memberHandler.existMember(member.getLogin())==true){
            info.setText("User with this login already exist");
        }
//        else if(enterPasswordField.getText() == enterRepeatPasswordField.getText()){
//            info.setText("Password and repeat password must be the same!");
//        }
        else{
            memberHandler.createMember(member);
            view.viewLogin(loginButton);
        }
    }
}
