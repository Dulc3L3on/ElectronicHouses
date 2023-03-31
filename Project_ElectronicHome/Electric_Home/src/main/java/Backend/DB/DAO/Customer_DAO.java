/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Customer_DTO;
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
public class Customer_DAO {
    private Connection connection = DBMS.initConnection();   
    private Transformer transformer;
    
    public Customer_DAO(){
        this.transformer = new Transformer();
    }
        
    private String getSearchingSt(){
        return "SELECT CUI, name, address, since FROM customerControl.Customer"
             + "WHERE NIT = ?";
    }
    
    /**
     * It will be used when
     * a Sale is a point
     * of start.
     */
    public Customer_DTO search(String NIT){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchingSt())){
            statement.setString(1, NIT);
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer.getCustomer(NIT, result);
            }else{
                return new Customer_DTO();
            }
        }catch(SQLException e) {            
            System.out.println("Error: FINDING the Customer -> " +e.getMessage());
            return null;
        }
    }//BY: SalesPerson
        //ENDED
    
    private String getInsertionSt(){
        return "INSERT INTO customerControl.Customer (NIT, CUI, name, address)"
             + " VALUES (?,?,?,?)";
    }
    
    /**
     * It will be used to add a
     * new customer and with that
     * register a sale.
     */
    public void insert(String NIT, String CUI, String name, String address){
        try(PreparedStatement statement = 
                connection.prepareStatement(this.getInsertionSt())){
            statement.setString(1, NIT);
            statement.setString(2, CUI);
            statement.setString(3, name);
            statement.setString(4, address);
            
            statement.executeUpdate();
        }catch(SQLException e){            
            JOptionPane.showMessageDialog(null, "Impossible to CREATE the Customer."
                                        + "\n Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: creating a Customer" + e.getMessage());
        }
    }//BY: salesPerson
     //Ready
    
    private String getUpdateSt(boolean name, boolean address){
        return "UPDATE customerControl.Customer SET " + ((name)?"name = ?":"")
             + ((name && address)?", ":"") +((address)?"address = ?":"") 
             + " WHERE NIT = ?";
    }
    
    public boolean update(String NIT, String name, String address){//si no hubo cb serán NULL
         int index = 1;
        
        try(PreparedStatement statement = connection.prepareStatement
                (this.getUpdateSt((name!= null), (address != null)))){
            
            if(name != null){
                statement.setString(index, name);
                index++;
            }
            if(address != null){
                statement.setString(index, address);
                index++;
            }            
            statement.setString(index, NIT);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: UPDATing an Customer"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: impossible UPDATE an Customer");
        }        
        return false;
    
    }//By salesPerson. It will use the same process as Employee UPDATE!
     //Ready
    
}//ENDed

//DELETE
    //I don't think curstomers are deleted
    //from a DB od a store, even if they just
    //have been bought just for 1 time
        //In any case ALL the customers will
        //be deleted, but it will be 'cause
        //the WHOLE DB was replaced o redo.
