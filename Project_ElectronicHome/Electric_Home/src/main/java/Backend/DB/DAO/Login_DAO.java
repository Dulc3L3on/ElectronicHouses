/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Employee_DTO;
import Backend.DB.Tools.Transformer;
import Backend.Entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author phily
 */
public class Login_DAO {
    private Connection connection = DBMS.initConnection();
    private Transformer transformer;    
    
    public Login_DAO(){
        this.transformer = new Transformer();
    }
    
    private String getSearchSt(){
        return "SELECT e.ID e.CUI, e.name, c.position, c.office e.hired"
             + " FROM humanResourcesControl.Employee as e INNER JOIN"
             + " humanResourcesControl.Contract as c ON e.ID = c.employee"             
             + " WHERE name = ? AND password = ? and c.office = ?";
    } 
    
    
    public Employee_DTO search_User(String name, String pwd, String office){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getSearchSt())){//si falla, ya sabes que add xd
            
            statement.setString(1, name);
            statement.setString(2, pwd);
            statement.setString(2, office);
            
            ResultSet result = statement.executeQuery();
            
            if(result!=null && this.transformer.moveBegin(result)){
                if(result.getBoolean(6)){
                    return this.transformer.getEmployee(result);
                }
            }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "username or password failed",
                    "Authentication Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: al buscar an EMPLOYEE -> " +e.getMessage());
        }        
        JOptionPane.showMessageDialog(null, "You must be hired to sign in.",
                    "Unallowed entrance", JOptionPane.ERROR_MESSAGE);
        return null;
    }    
}
