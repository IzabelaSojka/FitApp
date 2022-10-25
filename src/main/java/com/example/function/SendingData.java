package com.example.function;

public class SendingData {
    private String login;
    private static SendingData instance;
    public static SendingData getInstance(){
        if(instance == null) instance = new SendingData();
        return instance;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login=login;
    }

}
