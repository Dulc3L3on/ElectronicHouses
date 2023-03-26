/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.Tools.Transformer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author phily
 */
public class Clasification_DAO {
    private Connection connection = DBMS.initConnection();
    private Transformer transformer;
    
    public Clasification_DAO(){
        this.transformer = new Transformer();        
    }
  
    private String getSearchSt(){
        return "SELECT ID FROM goodsControl.Clasification WHERE type = ?";
    }
    
    /**
     * It will be used to complete
     * the INSERTION of Appliance.
     * 
     */
    public long search(String type){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchSt())){
            statement.setString(1, type);            
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer.moveBegin(result)){//Revisa si así dice que está vacío...
                return result.getLong(1);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the CLASIF_ID -> " +e.getMessage());            
        }
        return -1;   
    }
    
    private String getInsertSt(){
        return "INSERT INTO goodsControl.Clasification (type, line) VALUES (?,?)";
    }
    
    public boolean insert(String type, String line){
        try(PreparedStatement statement = 
               connection.prepareStatement(this.getInsertSt())){
            statement.setString(1, type);
            statement.setString(2, line);            
            
            statement.executeUpdate();            
            return true;
        }catch(SQLException e){        
            System.out.println("Error: creating an EMPLOYEE" + e.getMessage());
        }
        return false;
    }//BY: sotwage, the only responsables [see notes]
    //con el aviso, si uno es false entocnes se mostrará "hubo error al intentar add el product" o sea se mostrará un msje general...
    
}
