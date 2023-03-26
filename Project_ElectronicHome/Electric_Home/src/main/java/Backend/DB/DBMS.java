/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author phily
 */
public class DBMS {
    private static Connection connection = null;
    private static DBMS dbms;
    
    private DBMS(){
        String url = "jdbc:postgresql://localhost:5432/electronichome";//recuerda que postgre guarda todo en minúsculas...
        String user = "postgresql";
        String password = "PO5T3greZZ";//podría usar un sha xdxd
        
        try{
            connection = DriverManager.getConnection(url, user, password);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la DB " 
                    + e.getMessage(), "Conexion Error", JOptionPane.ERROR_MESSAGE);
        }/*catch(ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
           JOptionPane.showMessageDialog(null, "Error: " 
                    + ex.getMessage(), "Conexion Error", JOptionPane.ERROR_MESSAGE);
           System.out.println();       
        }*/            
    
    }
    
    public static Connection initConnection(){
        if (dbms == null) {
            dbms = new DBMS();
        }
        return connection;
    }    
}
