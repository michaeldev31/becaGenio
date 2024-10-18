package com.mycompany.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    public static Connection sqlConexion; 
    //Singleton
    public static Connection getConnection(){
      try{
          if(sqlConexion==null || sqlConexion.isClosed()){              
            Runtime.getRuntime().addShutdownHook(new getClose());            
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/becagenio","root","Reques123@");
            System.out.println("se conecto a la base de datos");
          }
          return sqlConexion;
        }catch(Exception ex){
            throw new RuntimeException("Error",ex);
        }      
    }
    static class getClose extends Thread{
        @Override
        public void run(){
            try{
                Connection conn = getConnection();
                conn.close();
            }catch(SQLException ex){
                throw new RuntimeException(ex);               
            }
        }          
    }  
}

