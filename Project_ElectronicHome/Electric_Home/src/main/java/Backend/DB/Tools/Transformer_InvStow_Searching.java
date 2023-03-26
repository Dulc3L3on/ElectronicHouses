/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.Tools;

import Backend.DB.DTO.Appliance_DTO;
import Backend.DB.DTO.Clasification_DTO;
import Backend.DB.DTO.Product_DTO;
import Backend.DB.DTO.Stock_DTO;
import Backend.DB.DTO.Transfer_DTO;
import Backend.DB.DTO.Transferred_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Transformer_InvStow_Searching {
    public boolean moveBegin(ResultSet resultado){
        try{
            return resultado.first();            
        }catch(SQLException e){
            System.out.println("Error: al colocarse al principio del resultado -> "
                    + e.getMessage());
        }
        return false;
    }//Ready
    
    public ArrayList<Transfer_DTO> getPendingTransfers(ResultSet result){
        ArrayList<Transfer_DTO> transferList = new ArrayList<>();
        
         try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                transferList.add(this.getPendingTransfer(result));
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: seting into TRANSFERs");
        }
        return transferList;
    }//Ready
    
    private Transfer_DTO getPendingTransfer(ResultSet result){
        try{
            return new Transfer_DTO(result.getString(1), "pending",
                    result.getString(2), "OID-12536480", result.getDate(3),
                    result.getDate(4), null, "");//Available data: ID, CUI, name, position, office, hired                              
        }catch (SQLException e) {
            System.out.println("Error: seting an EMPLOYEE");
        }
        
        return null;
    }//Ready
    
    public Transfer_DTO getDetailedTransfer(ResultSet result){
        try{
            return new Transfer_DTO(result.getString(1), result.getString(3),
                    result.getString(2), "OID-12536480", result.getDate(4),
                    result.getDate(5), null, result.getString(6));//Available data: ID, CUI, name, position, office, hired                              
        }catch (SQLException e) {
            System.out.println("Error: seting a TRANSFER");
        }
        
        return null;
    }
    
    //----------------------- It wil be used to show the LIST of items on MOV window
    
    public ArrayList<Transferred_DTO> getTransferreds(ResultSet result, String transfer){
        ArrayList<Transferred_DTO> transferredList = new ArrayList<>();
        
         try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                transferredList.add(this.getTransferredProduct(result, transfer));//puesto que en las lista no es nec, ser específico xD
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: setting PRODUCTs");
        }
        return transferredList;
    }
    
    private Transferred_DTO getTransferredProduct(ResultSet result, String transfer){
        try{
            return new Transferred_DTO(result.getLong(1), transfer,           
                new Stock_DTO(result.getString(5), 
                    new Product_DTO(result.getLong(2), 
                        new Appliance_DTO(result.getString(3), result.getString(4),
                            new Clasification_DTO(0, "", ""), ""),
                    result.getDouble(6)), -1, ""), result.getInt(7));
        }catch (SQLException e) {
            System.out.println("Error: setting a TRANSFERRED");
        }
        return null;
    }
}
