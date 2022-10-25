package com.example.threads;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time extends Thread{
    @FXML
    Label time;

    public Time(Label time){
        this.time=time;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

    public void run(){
        while(true){
        try{
            Thread.sleep(1000);
        }catch(Exception e){}
        final String timenow = sdf.format(new Date());
        Platform.runLater(()->{
            this.time.setText(timenow);
        });
    }
    }
}
