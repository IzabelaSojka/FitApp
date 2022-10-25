package com.example.calories;

import com.example.database.PostgreSQL;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalorieHandler implements ICalorie {
    private static CalorieHandler instance;
    Connection connect = PostgreSQL.getInstance().initializeDatabase();

    public static CalorieHandler getInstance(){
        if(instance == null) instance = new CalorieHandler();
        return instance;
    }

    @Override
    public boolean existCalorie(String login, Date date){
        String verify = "SELECT count(1) FROM calorie WHERE login= '"+login+"' AND caloriesday= '"+date+"';";
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
    public boolean createCalorie(Calorie calories){
        try{
            PreparedStatement insertStatement = connect.prepareStatement(
                    "INSERT INTO calorie(login, calories, caloriesday) VALUES (?,?,?);"
            );
            insertStatement.setString(1, calories.getLogin());
            insertStatement.setInt(2, calories.getCalories());
            insertStatement.setDate(3, calories.getCaloriesday());
            insertStatement.execute();
        }catch(SQLException throwable){
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCalorie(Calorie calories, Integer historyCalorie){
        try{
            PreparedStatement updateStatement = connect.prepareStatement(
                    "UPDATE calorie SET calories=? WHERE login=? "
            );
            updateStatement.setInt(1, historyCalorie+calories.getCalories() );
            updateStatement.setString(2, calories.getLogin());
            updateStatement.executeUpdate();
        }catch(SQLException throwable){
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Integer findCalories (String login, Date date){
        String verify = "SELECT calories FROM calorie WHERE login= '"+login+"' AND caloriesday= '"+date+"';";

        try{
            Statement statement = connect.createStatement();
            ResultSet query = statement.executeQuery(verify);
            while(query.next()){
                return query.getInt(1);
            }
        }catch(SQLException throwable){
            throwable.printStackTrace();
        }
        return 0;
    }

    public java.sql.Date toSqlDate(String strDate) {
        DateFormat dateFrm = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date myDate = new java.util.Date();
        java.sql.Date sqlDate;

        try
        {
            myDate = dateFrm.parse(strDate);
            sqlDate = new java.sql.Date(myDate.getTime());
        }
        catch (Exception e)
        {
            sqlDate = null;
        }
        return (sqlDate);
    }
}
