/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.Entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class Login_DAO {
    private Connection connection = DBMS.initConnection();
    private static Employee user;
    
    private String getSearchSt(){
        return "SELECT * FROM humanResourcesControl.Employee"
             + " WHERE name = ? and password = ?";
    } 
    
    
    public void search_Username(String name, String pwd){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getSearchSt())){//si falla, ya sabes que add xd
            
            statement.setString(1, name);
            statement.setString(2, pwd);
            
            ResultSet result = statement.executeQuery();
            
            user = new Employee(result.getString(0), result.getString(1), 
                                    result.getString(2), result.getString(3),
                                    result.getString(4));            
        }catch(SQLException e) {
            System.out.println("Error: al buscar an EMPLOYEE -> " +e.getMessage());
        }
    }    
}
