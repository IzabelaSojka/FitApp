package com.example.threads;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CountdownTime extends Thread{
    Integer minutes, seconds, minutesTmp, secondsTmp;
    Integer minutesRest, secondsRest, minutesRestTmp, secondsRestTmp;
    Integer intervals;
    Integer allTime, allTimeRest;
    @FXML
    Text countMinutes;
    @FXML
    Text countSeconds;
    @FXML
    Text info;

    public CountdownTime(Integer intervals,Integer minutes, Integer seconds, Text countMinutes, Text countSeconds, Text info, Integer minutesRest, Integer secondsRest){
        this.intervals=intervals;
        this.minutes=minutes;
        this.seconds=seconds;
        this.countMinutes=countMinutes;
        this.countSeconds=countSeconds;
        this.info=info;
        this.minutesRest=minutesRest;
        this.secondsRest=secondsRest;
    }

    public void run(){
        while(intervals>0){
            setValues();
            this.info.setText("ACTIVITY!");
            while(allTime>=0) {
                Platform.runLater(() -> {
                    this.countMinutes.setText(Integer.toString(minutesTmp));
                    this.countSeconds.setText(Integer.toString(secondsTmp));
                });
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                allTime--;
                if (secondsTmp > 0) {
                    secondsTmp--;
                } else {
                    secondsTmp = 59;
                    minutesTmp--;
                }
            }
            this.info.setText("BREAK!");
            while(allTimeRest>=0){
                Platform.runLater(()->{
                    this.countMinutes.setText(Integer.toString(minutesRestTmp));
                    this.countSeconds.setText(Integer.toString(secondsRestTmp));
                });
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}
                allTimeRest--;
                if(secondsRestTmp>0) {
                    secondsRestTmp--;
                }else{
                    secondsRestTmp=59;
                    minutesRestTmp--;
                }
            }
            intervals--;
        }
        this.info.setText("END OF TRANING!");
    }

    public void setValues(){
        minutesTmp=minutes;
        secondsTmp=seconds;
        minutesRestTmp=minutesRest;
        secondsRestTmp=secondsRest;
        allTime=minutes*60+seconds;
        allTimeRest=minutesRest*60+secondsRest;
    }
}
