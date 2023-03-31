package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Transfer_DTO;
import Backend.DB.Tools.Transformer;
import Backend.DB.Tools.Transformer_InvStow_Searching;
import Backend.Tools.Tool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phily
 */
public class Transfer_DAO {
    private Connection connection = DBMS.initConnection();
    
    private Transformer transformer = new Transformer();
    private Transformer_InvStow_Searching transformer_ISS;
    private Indexator_DAO indexator;
    private Tool tool;
    
    public Transfer_DAO(){
        this.transformer = new Transformer();
        this.transformer_ISS = new Transformer_InvStow_Searching();
        this.indexator = new Indexator_DAO();
        this.tool = new Tool();
    }    
    
    /**
     * To obtain the correspondent ID     
     */
    public String searchActualID(){
        return "TID-"+this.indexator.search("TID");
    }//Est
    
    private String getSearchQuantityOfSt(boolean state){
        return "SELECT COUNT(transferState) FROM transactionControl.Transfer"
             + ((state)?" WHERE transferState = ?":"");
    }
    
    //----at gain FOCUS
    
    /**
     * It will be used to find
     * the number of transfers
     * with a determinated state.
     */
    public int searchQuantityOf(String state){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchQuantityOfSt(state!=null))){
            if(state!=null){
                statement.setString(1, state);
            }
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer_ISS.moveBegin(result)){//Revisa si así dice que está vacío...
                return result.getInt(1);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the total of transfers("+state+") -> "
                    +e.getMessage());            
        }
        return 0;
    }
    
    //-------------To show on Movement window
    
    private String getSelectedTransferSt(){
        return "SELECT ID, origin, trasnferState, since, until, reason"
             + " WHERE ID = ?";
    }    
    
    /**
     * It will be used when a specific
     * transfer is requeted to see it
     * detailed on the MOVE window.
     */
    public Transfer_DTO searchSelectedTransfer(String ID){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSelectedTransferSt())){
            statement.setString(1, ID);            
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer_ISS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_ISS.getDetailedTransfer(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the selected Stock -> " +e.getMessage());            
        }
        return null;
    }
    
    
    
    //----------
    
    private String getInsertionSt(){
        return "INSERT INTO transactionControl.Transfer (ID, origin, destiny,"
                + " until, reason) VALUES (?,?,?,?,?)";
    }
    
    /**
     * It is used when a 
     * TRANSFER is CREATED.
     */
    public boolean insert(String origin, String destiny,
                String until, String reason){
        String ID = this.indexator.update("TID");
        
        if(ID != null){//pues sin ID no se peude exe la insertion...
            try(PreparedStatement statement = 
                    connection.prepareStatement(this.getInsertionSt())){
                statement.setString(1, ID);
                statement.setString(2, origin);
                statement.setString(3, destiny);
                statement.setDate(4, this.tool.toSQLDate(until));
                statement.setString(5, reason);
            
                statement.executeUpdate();
                return true;
            }catch(SQLException e){                            
                    System.out.println("Error: creating the Transfer" + e.getMessage());
            }        
        }        
        JOptionPane.showMessageDialog(null, "Impossible to CREATE the Transfer."
           + "\n Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }//By: SalesPerson, Inventary and Stowage
        //al igual que Sale, se crerá previo a tener el listado add... xD
    
    private String getUpdateSt(boolean did){
        return "UPDATE transactionControl.Transfer SET transferState = ?"
             + ((did)?", did = ?":"") + " WHERE ID = ?";
    }
    
    /**
     * It will be used to update the whole
     * transfer, specifically: transferState,
     * and did when (processed) or just 
     * transferState like when it was already
     * DONE, read.
     */
    public boolean update(String ID, String date, String state){//puesto que puede ser utilizado para decir PROCESSED (with did), or solo DONE
        try(PreparedStatement statement = connection.prepareStatement
                (this.getUpdateSt((date!= null)))){
            int index = 2;            
            
            statement.setString(1, state);
            if(date!=null){
                statement.setDate(index, this.tool.toSQLDate(date));
                index++;
            }            
            statement.setString(index, ID);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: UPDATing an TRANSFER"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: impossible UPDATE an Employee");
        }        
        return false;
    }//By: Inventary/Stowage
        //caudno cb el stato
            //lo cual implica tb cuando TRANSFER sea exe
                //lo cual solo cb el estado
            //y la TRANSFER sea VERIFY
                //lo cual YA add productos a la store...
    
    private String getDelete(){
        return "DELETE FROM transactionControl.Transfer"
             + " WHERE ID = ?";
    }
    
    /**
     * When a total transfer is
     * cancelled
     */
    public boolean delete(String ID){
         try(PreparedStatement instrucciones 
                 = connection.prepareStatement(this.getDelete())){
            instrucciones.setString(1, ID);
            
            instrucciones.executeUpdate();
            
        }catch(SQLException sqlE){
            System.out.println("Error: at DELETE the TRANSFER "+ sqlE.getMessage());
        }
        return false;       
    }//by: Inventory, Stowage
    //va a buscar por ID y va a elimiar la TRANFER no transferred
        //a parte las trasnferred (esas se eli antes de este)
    
}
