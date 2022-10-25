package com.example.appedp;

import com.example.function.SendingData;
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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    IMember memberHandler = MemberHandler.getInstance();
    @FXML
    private Button registerButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button startButton;
    @FXML
    private ImageView icon;
    @FXML
    private ImageView clock;
    @FXML
    private Label info;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private Hyperlink forgotPassword;
    @FXML
    private Label time;
    Time times;
    SendingData sendLogin = SendingData.getInstance();

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

    public void loginButtonOnAction(ActionEvent event)throws IOException{
        Member member = new Member(loginTextField.getText(), enterPasswordField.getText()," ");
        if(member.getLogin().isBlank() == false && member.getPassword().isBlank()==false){

            if(memberHandler.validationLogin(member)==true){
                sendLogin.setLogin(member.getLogin());
                view.viewLoggedStart(loginButton);
            }
            else{
                info.setText("Invalid log!");
            }
        }
        else{
            info.setText("Enter login and password!");
        }
    }

    public void registerButtonOnAction(ActionEvent event) throws IOException {
        view.viewRegister(registerButton);
    }

    public void reminderPassword(ActionEvent event)throws IOException{
        view.viewReminderPassword();
    }

    public void startButtonOnAction(ActionEvent event) throws IOException{
        view.viewStart(startButton);
    }
}
