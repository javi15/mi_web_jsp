/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Coneccion.model;
import java.sql.*;

/**
 *
 * @author javier
 */
public class DbConnection {
    
    static String db = "sistemadb";
    static String login = "javier";
    static String password = "javier";
    static String url = "jdbc:mysql://localhost/" + db;
    
    //Esta variable guarda la coneccion
    Connection conn = null;

    public DbConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            if(conn != null){
                System.out.println("Coneccion establecida ["+ conn + "] OK CON EL DRIVER");
            }
        }
        catch(SQLException e){
        System.out.println("Error en la conexion " + e.getMessage());        
        }
        catch(ClassNotFoundException e){
        System.out.println("Clase no fue encontrada: " + e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void desconnet(){
        System.out.println("Desconectando OK");
        if(conn != null){
            try{
                conn.close();
            }
            catch(SQLException e){
                System.out.println("Error " + e.getMessage());
            }
        }
    }
    
    
    
}
