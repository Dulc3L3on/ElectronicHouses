/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class DBMS {
    public static Connection connection;
    String url = "";
    String user = "";
    String password = "";
    
    public boolean initConnection(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            return true;
        }catch(SQLException e){
            System.err.println("Error al conectar con la DB " + e.getMessage());
            return false;
        }                
    }    
}
