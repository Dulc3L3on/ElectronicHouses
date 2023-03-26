/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Transfer_DTO;
import Backend.DB.DTO.Transferred_DTO;
import Backend.DB.Tools.Transformer;
import Backend.DB.Tools.Transformer_InvStow_Searching;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author phily
 */
public class Transferred_DAO {
    private Connection connection = DBMS.initConnection();
    
    private Transformer transformer = new Transformer();
    private Transformer_InvStow_Searching transformer_ISS;
    
    public Transferred_DAO(){
        this.transformer = new Transformer();
        this.transformer_ISS = new Transformer_InvStow_Searching();
    }
    
    //-------------To show on Movement window
    
    private String getTransferredItemsSt(){
        return "SELECT i.code, p.name, p.brand, s.stockID, p.price,"
             + " s.quantity, i.requested FROM transactionControl.Transferred as i"
             + " INNER JOIN goodsControl.Product as p ON i.product = p.code"
             + " INNER JOIN goodsControl.Stock as s s.product = p.code"
             + " WHERE i.transfer = ?";
    }
    
    /**
     * It will be used when a specific
     * transfer is requeted to see it
     * detailed on the MOVE window.
     */
    public ArrayList<Transferred_DTO> searchTransferredItems(String ID){
          try(PreparedStatement statement
                = connection.prepareStatement(this.getTransferredItemsSt())){
            statement.setString(1, ID);            
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer_ISS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_ISS.getTransferreds(result, ID);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the selected Stock -> " +e.getMessage());            
        }
        return null;
    }
    
    //----------
    
    private String getInsertionSt(){
        return "INSERT INTO transactionControl.Transferred (transfer,"
             + " product, requested) VALUES(?,?,?)";
    }
    
    /**
     * It is used when a 
     * TRANSFER is CREATED.
     */
    public boolean insert(String transfer, long product, int requested){
        try(PreparedStatement statement = 
                connection.prepareStatement(this.getInsertionSt())){
            statement.setString(1, transfer);
            statement.setLong(2, product);
            statement.setInt(3, requested);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e){            
            JOptionPane.showMessageDialog(null,
                 "Impossible to CREATE the list of Transferences."
                 + "\n Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: creating the list of Transferences" 
                    + e.getMessage());
        }
        return false;        
    }//By: SalesPerson, Inventary and Stowage
        //Igual que en SOLD, se irá exe este método
            //Cada vez que presione (+)
                //esto se escogerá a partir de la pestaña de axn selected...
    
    private String getUpdateSt(){
        return "UPDATE transactionControl.Transferred SET sended = ?"
             + " WHERE code = ?";
    }//esto se irá exe uno por uni
    
    /**
     * It will be used just when 
     * someone authorized send
     * the requested items. It will
     * be executed for each transferred.
     */
    public boolean update(long code, int sended){
      try(PreparedStatement statement 
              = connection.prepareStatement(this.getUpdateSt())){
                        
            statement.setInt(1, sended);            
            statement.setLong(2, code);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: UPDATing an transferED item"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: impossible UPDATE an TRANSFERRED");
        }        
        return false;
    }//By: Inventary/Stowage
        //app a SENDED
            //Cuando ahcen la TRANSFER
    
    private String getDeleteSt(){
        return "DELETE FROM transactionControl.Transferred WHERE transfer = ?";
    }
    
    /**
     * When a transfer is deleted
     * Just remember It will
     * be executed for each transferred.
     * 
     */
    public boolean delete(String transfer){
        try(PreparedStatement instrucciones 
                = connection.prepareStatement(this.getDeleteSt())){
            instrucciones.setString(1, transfer);
            
            instrucciones.executeUpdate();
            
        }catch(SQLException sqlE){
            System.out.println("Error: DELETing the transferREDs: "+ sqlE.getMessage());
        }
        return false;       
    }
}
