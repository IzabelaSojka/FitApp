package com.example.database;

import config.Props;
import java.sql.*;

public class PostgreSQL{
    private static PostgreSQL instance;
    public static Connection connect;
    public static String url = Props.getInstance().getProperty("url");
    public static String username = Props.getInstance().getProperty("username");
    public static String password = Props.getInstance().getProperty("password");
    public PostgreSQL(){initializeDatabase();}
    public static PostgreSQL getInstance(){
        if(instance == null) instance = new PostgreSQL();
        return instance;
    }

    public Connection initializeDatabase(){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            connect = DriverManager.getConnection(url,username,password);
        }
        catch(SQLException | IllegalArgumentException ex){
            ex.printStackTrace(System.err);
        }finally{
            if(connect == null) System.exit(-1);
        }
        return connect;
    }
}
