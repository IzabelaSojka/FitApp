package com.example.profile;


import com.example.database.PostgreSQL;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProfileHandler implements IProfile {
    private static ProfileHandler instance;
    Connection connect = PostgreSQL.getInstance().initializeDatabase();

    public static ProfileHandler getInstance(){
        if(instance == null) instance = new ProfileHandler();
        return instance;
    }

    @Override
    public boolean existProfile(String login){
        String verify = "SELECT count(1) FROM profile WHERE login= '"+login+"';";

        try{
            Statement statement = connect.createStatement();
            ResultSet query = statement.executeQuery(verify);
            while(query.next()){
                if(query.getInt(1)==1){
                    return true;
                }
            }
        }catch(SQLException throwable){
            throwable.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean createProfile(Profile profile){
        try{
            PreparedStatement insertStatement = connect.prepareStatement(
                    "INSERT INTO profile(age, weight, height, gender, login,activity) VALUES (?,?,?,?,?,?);"
            );
            insertStatement.setInt(1, profile.getAge() );
            insertStatement.setInt(2, profile.getWeight() );
            insertStatement.setInt(3, profile.getHeight());
            insertStatement.setString(4, profile.getGender());
            insertStatement.setString(5, profile.getLogin());
            insertStatement.setString(6, profile.getActivityLevel());
            insertStatement.execute();
        }catch(SQLException throwable){
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateProfile(Profile profile){
        try{
            PreparedStatement updateStatement = connect.prepareStatement(
                    "UPDATE profile SET age=?, weight=?, height=?, gender=?, activity=? WHERE login=? "
            );
            updateStatement.setInt(1, profile.getAge() );
            updateStatement.setInt(2, profile.getWeight() );
            updateStatement.setInt(3, profile.getHeight());
            updateStatement.setString(4, profile.getGender());
            updateStatement.setString(5, profile.getActivityLevel());
            updateStatement.setString(6, profile.getLogin());
            updateStatement.executeUpdate();
        }catch(SQLException throwable){
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Profile findProfile(String login){
        String verify = "SELECT * FROM profile WHERE login= '"+login+"';";
        Profile profile=null;
        try{
            Statement findStatement = connect.createStatement();
            ResultSet query = findStatement.executeQuery(verify);
            while(query.next()){
                profile= new Profile(query.getString(4), query.getInt(6), query.getInt(1), query.getInt(2), query.getString(3), query.getString(5));
            }
        }catch(SQLException throwable){
            throwable.printStackTrace();
            return profile;
        }
        return profile;
    }

    public String findActivityLevel (String description){
        String verify = "SELECT level FROM activity WHERE description= '"+description+"';";
        String level = "";
        try{
            Statement statement = connect.createStatement();
            ResultSet query = statement.executeQuery(verify);
            while(query.next()){
                return level=query.getString(1);
            }
        }catch(SQLException throwable){
            throwable.printStackTrace();
        }
        return level;
    }

    public String findActivity (String level){
        String verify = "SELECT description FROM activity WHERE level= '"+level+"';";
        String description = "";
        try{
            Statement statement = connect.createStatement();
            ResultSet query = statement.executeQuery(verify);
            while(query.next()){
                return description=query.getString(1);
            }
        }catch(SQLException throwable){
            throwable.printStackTrace();
        }
        return description;
    }
}
