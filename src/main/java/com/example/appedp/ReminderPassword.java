package com.example.appedp;

import com.example.mail.EmailJava;
import com.example.member.IMember;
import com.example.member.Member;
import com.example.member.MemberHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReminderPassword extends AnchorPane implements Initializable {
    IMember memberHandler = MemberHandler.getInstance();
    @FXML
    private ImageView icon;
    @FXML
    private TextField loginTextField;
    @FXML
    private Button sendButton;
    @FXML
    private Label info;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File iconFile = new File("picture/fit.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        icon.setImage(iconImage);
    }

    public void sendMail(ActionEvent event) throws IOException{
        if(memberHandler.existMember(loginTextField.getText())==false){
            info.setText("The user with this login does not exist!");
        }else if(loginTextField.getText().isBlank() == true){
            info.setText("Enter login!");
        }
        else{
            EmailJava emailJava = new EmailJava();
            emailJava.sendEmail(memberHandler.findPassword(loginTextField.getText()), memberHandler.findEmail(loginTextField.getText()));
            sendButton.setText("Email sent");
            info.setText("");
        }
    }


}
