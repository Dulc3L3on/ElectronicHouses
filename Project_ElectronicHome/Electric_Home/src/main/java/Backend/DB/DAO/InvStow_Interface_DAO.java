/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Stock_DTO;
import Backend.DB.DTO.Transfer_DTO;
import Backend.DB.DTO.Transferred_DTO;
import Backend.DB.Tools.Transformer;
import Backend.DB.Tools.Transformer_InvStow_Searching;
import Backend.DB.Tools.Transformer_SalesPersonSearching;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class InvStow_Interface_DAO {
    private Connection connection = DBMS.initConnection();
    private Transformer transformer;
    private Transformer_InvStow_Searching transformer_ISS;
    
    public InvStow_Interface_DAO(){
        this.transformer = new Transformer();
        this.transformer_ISS = new Transformer_InvStow_Searching();
    }
    
    private String getSearchTransfersSt(boolean from, boolean to, String[] states,
                                        String dateType[], String date[]){
        boolean where = false;        
        String search = "SELECT ID, origin, destiny, since, until, transferState"
                      + " FROM transactionControl.Transfer";
        
        if(from){
            search += " WHERE from = ?";
            where = true;
        }        
        if(to){            
            search += ((!where)?" WHERE":" AND") + " to = ?";
            if(!where) where = true;
        }

        for (int array = 0; array < 3; array++) {//puesto que hay 2 arreglos :p xD
            String[] reference = ((array == 0)?states:((array == 1)?dateType:date));
            
            if(reference != null && !reference[0].equals("All")){
                for(int index = 0; index < reference.length; index++) {
                    search += ((!where)?" WHERE":" AND") 
                       + " "+ ((array == 0)?"transferState"
                                           :((array == 1)?dateType
                                                         :date)) +" = ?";
                    if(!where) where = true;
                }
            }
        }
        return (search += "ORDER BY since DESC");
    }
    
    /**
     * It will be used to search
     * a list of transfers when
     * filters allow this.
     */
    public ArrayList<Transfer_DTO> searchTransfers(String from, String to,
            String states[], String dateType[], String date[]){
        
        int index = 1;
        
        try(PreparedStatement statement = 
            connection.prepareStatement(getSearchTransfersSt((!from.equals("All")),
                    (!to.equals("All")), states, dateType, date))){
        
            if(!from.equals("All")){
                statement.setString(index, from);
                index++;
            }        
            if(!to.equals("All")){
                statement.setString(index, to);
                index++;
            }
            for (int array = 0; array < 3; array++) {//puesto que hay 2 arreglos :p xD
                String[] reference = ((array == 0)?states:((array == 1)?dateType:date));
            
                if(reference != null && !reference[0].equals("All")){
                    for(int actual = 0; actual < reference.length; actual++) {                        
                        statement.setString(index, reference[actual]);
                        index++;
                    }                    
                }
            }           
            
            ResultSet result = statement.executeQuery();
            
            if(result != null && transformer.moveBegin(result)){
                return transformer.getTransfers(result);
            }            
        }catch(SQLException e) {
            System.out.println("Error: impossible to find EMPLOYEEs");
        }
        
        return new ArrayList<>();
        
    }
    //como no sé cuantos transfer puede abarcar una búsqueda
    //con los filters aplicados, entonces siempre devolveré
    //una lista, no importando que al final tenga solo 1
    
    private String getPendingTransfers(){
        return "SELECT ID, from, since, until FROM"
             + " transactionControl.Transfer"
             + " WHERE transferState = pending ";
    }
    
    public ArrayList<Transfer_DTO> searchPendingTransfers(){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getPendingTransfers())){
            ResultSet result = statement.executeQuery();
            
            if(result != null && this.transformer_ISS.moveBegin(result)){//Revisa si así dice que está vacío...
                return transformer_ISS.getPendingTransfers(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING all the Offices" +e.getMessage());            
        }
        return null;
    }
    
}
