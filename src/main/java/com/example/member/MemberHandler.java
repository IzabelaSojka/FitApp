package com.example.member;

import com.example.database.PostgreSQL;

import java.sql.*;

public class MemberHandler implements IMember{
    private static MemberHandler instance;
    Connection connect = PostgreSQL.getInstance().initializeDatabase();

    public static MemberHandler getInstance(){
        if(instance == null) instance = new MemberHandler();
        return instance;
    }
    @Override
    public boolean existMember(String login){
        String verify = "SELECT count(1) FROM member WHERE login= '"+login+"';";

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
    public boolean createMember(Member member){
        try{
            PreparedStatement insertStatement = connect.prepareStatement(
                    "INSERT INTO member(login, password, email) VALUES (?,?,?);"
            );
            insertStatement.setString(1, member.getLogin());
            insertStatement.setString(2, member.getPassword());
            insertStatement.setString(3, member.getEmail());
            insertStatement.execute();
        }catch(SQLException throwable){
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean validationLogin(Member member){
        String verify = "SELECT count(1) FROM member WHERE login= '"+member.getLogin()+"'AND password= '"+member.getPassword()+"';";

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

    public String findPassword (String login){
        String verify = "SELECT password FROM member WHERE login= '"+login+"';";
        String password = "";
        try{
            Statement statement = connect.createStatement();
            ResultSet query = statement.executeQuery(verify);
            while(query.next()){
                password=query.getString(1);
            }
        }catch(SQLException throwable){
            throwable.printStackTrace();
        }
        return password;
    }

    public String findEmail (String login){
        String verify = "SELECT email FROM member WHERE login= '"+login+"';";
        String email = "";
        try{
            Statement statement = connect.createStatement();
            ResultSet query = statement.executeQuery(verify);
            while(query.next()){
                email=query.getString(1);
            }
        }catch(SQLException throwable){
            throwable.printStackTrace();
        }
        return email;
    }

}
