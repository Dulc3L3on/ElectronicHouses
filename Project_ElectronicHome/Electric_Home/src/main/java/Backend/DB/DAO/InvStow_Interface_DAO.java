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
        if(states != null && !states[0].equals("All")){
           for(int index = 0; index < states.length; index++){
                search += ((!where)?" WHERE ":" AND ")+"transferState = ?";
                    if(!where) where = true;                
            }
        }
        
        if(dateType != null && date != null){
            if(dateType.length == 1){
                if((date.length == 1)){
                    search += ((!where)?" WHERE ":" AND ")+dateType[0]+" = "+date[0];
                    if(!where) where = true;
                }else{//igual a 2
                    search += ((!where)?" WHERE ":" AND ")+dateType[0]+" BETWEEN "+date[0]+ " AND "+date[1];
                    if(!where) where = true;
                }
            }else{//Es decir 2, porque 0 no hay xD (Bueno 0 es null entonces... xD
                if(date.length == 1){
                    search += ((!where)?" WHERE ":" AND ")+dateType[0]+" = "+date[0]
                            + " AND "+dateType[1] + " = "+date[0];
                }else{
                    search += ((!where)?" WHERE ":" AND ")+dateType[0]+" = "+date[0]
                            + " AND "+dateType[1] + " = "+date[1];
                }
            }
        }
        return (search += "ORDER BY since DESC");
    }//Ready
    
    /**
     * It will be used to search
     * a list of transfers when
     * filters allow this.
     */
    public ArrayList<Transfer_DTO> searchTransfers(String from, String to,
            String states[], String dateType[], String date[]){
        
        int index = 1;
        
        try(PreparedStatement statement = 
            connection.prepareStatement(getSearchTransfersSt((from!=null),
                    (to!=null), states, dateType, date))){
        
            if(from!=null){
                statement.setString(index, from);
                index++;
            }        
            if(to!=null){
                statement.setString(index, to);
                index++;
            }
            if(states != null && !states[0].equals("All")){
                for(int actual = 0; actual < states.length; actual++) {                        
                    statement.setString(index, states[actual]);
                    index++;
                }                    
            }
            //por dateType y date ya no te tienes que preocupar puesto que los seteaste allá arribita xD 
            
            ResultSet result = statement.executeQuery();
            
            if(result != null && transformer.moveBegin(result)){
                return transformer.getTransfers(result);
            }            
        }catch(SQLException e) {
            System.out.println("Error: impossible to find EMPLOYEEs");
        }
        
        return new ArrayList<>();        
    }//BY: inventary, stowage
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
