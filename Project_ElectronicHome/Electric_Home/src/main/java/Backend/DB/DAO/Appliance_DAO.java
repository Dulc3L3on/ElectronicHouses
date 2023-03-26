/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Appliance_DTO;
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
public class Appliance_DAO {
    private Connection connection = DBMS.initConnection();
    private Clasification_DAO clasification_DAO;
    private Transformer transformer;    
    
    public Appliance_DAO(){
        clasification_DAO = new Clasification_DAO();
        this.transformer = new Transformer();        
    }
    
    private String getSearchExistence(){
         return "SELECT a.name, a.brand, c.type, c.line, a.detail"
              + " FROM goodsControl.Appliance WHERE name = ?";
    }//va ir unido con Clasification, pues tiene más sentido de esta manera, que buscándolo por serparado xD
    
    /**
     * It will be used, to check if
     * an applaince already exists, 
     * if yes - so it info will show
     * on PRODUCT window. Office it is
     * not nec because it is a GLOBAL
     * existence.
     */
    public Appliance_DTO search_Existence(String name){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchExistence())){
            statement.setString(1, name);            
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer.getAppliance(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING if an APPLIANCE exist -> " +e.getMessage());            
        }
        return null;   
    }//By: inventary, stowage...
    //Global existence, so OFFICE it is NOT nec.
    
    private String getInsertSt(){
        return "INSERT INTO goodsControl.Appliance VALUES (?,?,?,?)";
    }
    
    /**
     * When a new appliance arrives
     * toward the store. It will be
     * record by STOWAGE!. It is GLOBAL
     */
    public boolean insert(String name, String brand, String detail, String type){//just by type, because a type just have a LINE it means there are no combinations on clasification table xD
        try(PreparedStatement statement = 
               connection.prepareStatement(this.getInsertSt())){
            statement.setString(1, name);
            statement.setString(2, brand);
            statement.setLong(2, this.clasification_DAO.search(type));
            statement.setString(3, detail);
            
            statement.executeUpdate();            
            return true;
        }catch(SQLException e){        
            System.out.println("Error: creating an APPLIANCE" + e.getMessage());
        }
        return false;
    }//BY: stowage
    //about the clasifID, it will be find by a subSELECT or by a method on clasif IF it is so much difficult... OR if it is better for you xD because TIME!!! XD
    
    private String getUpdateSt(){
        return "UPDATE goodsControl.Appliance SET name = ? WHERE name = ?";
    }
    
    /**
     * Por si acaso se confunden con el
     * nomreb y quizá tb el detail por
     * si tienen que modificarlo.     
     */
    public boolean update(String oldName, String newName){
     try(PreparedStatement statement 
                = connection.prepareStatement(this.getUpdateSt())){                     
            statement.setString(1, newName);//serpa el nuevo total, no algo que se deba sumar...
            statement.setString(2, oldName);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: UPDATing a NAME of a appliance"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: impossible UPDATE an Employee");
        }                
        return false;
    }//mira si le vas a add la uodate de DETAUL is no mandatory pero si queires...
}
