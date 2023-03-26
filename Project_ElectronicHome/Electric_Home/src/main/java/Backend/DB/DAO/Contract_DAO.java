/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.Tools.Tool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author phily
 */
public class Contract_DAO {
    private Connection connection = DBMS.initConnection();
    private Tool tool = new Tool();
    
    
    //SEARCH is not necessary porque use JOIN

    /**
     * It will be used to do an
     * INSERTION because of a new
     * employee or a RENEWAL, that
     * means new Contract.
     * 
     */
    
    public boolean insert(boolean nested, String employee, String office, 
            String position, String dueDate){
    
        if(!this.insert(employee, office, dueDate, position)){
            if(!nested){
                JOptionPane.showMessageDialog(null, "Error trying to add a new CONTRACT"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        return true;
    }
    
    private String getInsertionSt(){
        return "INSERT INTO humanResourcesControl.Contract (employee, office, "
             + "position, dueDate) VALUES (?,?,?,?)";
    }
    
    /**
     * It will be used when
     * an EMPLOYEE is just 
     * ADDED and also when 
     * they do a RENEWAL.
     */
    private boolean insert(String employee, String office, String position, String dueDate){
        try(PreparedStatement statement = 
                connection.prepareStatement(this.getInsertionSt())){
            statement.setString(1, employee);
            statement.setString(2, office);
            statement.setString(3, position);
            statement.setDate(4, this.tool.toSQLDate(dueDate));
            
            statement.executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.out.println("Error: creating a CONTRACT" + e.getMessage());
        }
        return false;
    }//BY: Admin [insert new EMployee; UPDATE contract of a employee, that really is a CREATION]
        
    /**
     * It will be used when
     * an EMPLOYEE was fired.
     */
    public void delete(){
        
    }//BY: Admin
    
    
    /*este irá de la mano con employee es decir
      que si se hace un INSERT, a este tb se le
      hará exe esa axn, y así con lo demás xD*/
    
    /*An UPDATE is not needed because if a customer
      is UPDATED it doesn't affect the contract...
      in fact, they have to CREATE a new contract
      because NEVER EVER a contract can be updated*/
    
    /*An about DELETE, I am not sure if that is also
      applicable...*/
}
