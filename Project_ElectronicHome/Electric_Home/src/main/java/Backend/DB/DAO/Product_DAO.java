/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Appliance_DTO;
import Backend.DB.DTO.Product_DTO;
import Backend.DB.DTO.Stock_DTO;
import Backend.DB.Tools.Transformer;
import Backend.DB.Tools.Transformer_InvStow_Searching;
import Backend.DB.Tools.Transformer_SalesPersonSearching;
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
public class Product_DAO {//It doesn't locate the office
    private Connection connection = DBMS.initConnection();
    private Transformer transformer;
    private Transformer_SalesPersonSearching transformer_SPS;
    private Transformer_InvStow_Searching transformer_ISS;
    private Indexator_DAO indexator;
    
    private String errorMessage = null;
    
    public Product_DAO(){
        this.transformer = new Transformer();
        this.transformer_SPS = new Transformer_SalesPersonSearching();
        this.transformer_ISS = new Transformer_InvStow_Searching();
        this.indexator = new Indexator_DAO();
    }
    
    private String getSearchExistenceSt(){
        return "SELECT code, price FROM goodsControl.Product"
            + " WHERE name =  ?";//solo esto puse, porque es para ver existencia y de los dmeás se encargó appliance...
    }
    
    /**
     * It will be used to know if a
     * product already exist in the
     * whole DB.(Creation of them is
     * responsabiity JUST of STOWAGE).
     */
    public Product_DTO search_existence(String name, Appliance_DTO appliance){//este appliance, no es nec, pero para no estar poniendo null en product, pues si lo tenemos, y para ir ensamblando todo, entonces xD
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchExistenceSt())){
            statement.setString(1, name);            
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer.getProduct(result, appliance);
            }
        }catch(SQLException e) {
            this.errorMessage = "Impossiible to find the Product\n";
            System.out.println("Error: FINDING the PRODUCT (Ne) -> " +e.getMessage());            
        }
        return null;   
    }//By Product_UI (inventary;stowage)
        //Será útil cuando sea el caso en el que se confundan de ventanita. Además no cae mal una 2da capa de seguridad xD               
            
    private String getBrandsSt(){
        return "SELECT theBrand FROM goodsControl.Appliance";
    }
    
    /**
     * It searchs all the
     * brands that are in total.
     */
    public ArrayList<String> list_Brands(){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getBrandsSt())){
            
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer_SPS.moveBegin(result)){
                return this.transformer_SPS.getList(result);
            }
              
        }catch(SQLException e) {
            System.out.println("Error: finding all the BRANDS -> " +e.getMessage());
        }
        return new ArrayList<>();      
    }//Ready
    
    private String getTypesSt(){
        return "SELECT type FROM goodsControl.Clasification";
    }
    
    /**
     * It searchs all the types
     * that are in total.
     */
    public ArrayList<String> list_Types(){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getTypesSt())){
            
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer_SPS.moveBegin(result)){
                return this.transformer_SPS.getList(result);
            }
              
        }catch(SQLException e) {
            System.out.println("Error: finding all the BRANDS -> " +e.getMessage());
        }
        return new ArrayList<>();    
    }//By: inventory AND store
    //Ready
    
    private String getSearchCode(String name, String brand){
        return "SELECT code FROM goodsControl.Product"
             + " WHERE name = ? AND brand = ?";
    }
    
    public long searchCode(String name, String brand){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getSearchCode(name, brand))){
            
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer_SPS.moveBegin(result)){
                return result.getLong(1);
            }
              
        }catch(SQLException e) {
            System.out.println("Error: finding all the BRANDS -> " +e.getMessage());
        }
        return 0;    
    }
    
    private String getInsertSt(){
        return "INSERT INTO goodsControl.Product (name, theBrand, price)"
             + " VALUES (?,?,?,?)";
    }    
    
    /**
     * It allows to create JUST new
     * ones doesn't matter the destiny
     * because it has to exist in the
     * global DB.
     */
    public boolean insert(String name, String brand, double price){
        try(PreparedStatement statement = 
               connection.prepareStatement(this.getInsertSt())){
            //el code es serial
            statement.setString(2, name);
            statement.setString(3, brand);            
            statement.setDouble(4, price);
            
            statement.executeUpdate();            
            return true;
        }catch(SQLException e){        
            System.out.println("Error: creating a PRODUCT" + e.getMessage());
        }
        return false;
    }//By: stowage managers - because they are the only responsables [see notes]
    
    private String getUpdateSt(boolean price){//pero al menos uno de los dos sino ni se mandará a exe...
        return "UPDATE goodsControl.Product "
             + " SET price = ? WHERE code = ?";
    }
    
    /**
     * It will be use to update
     * quantity (more when is
     * directly or there is a transfer
     * DONE or less on sales.
     */
    public boolean update(long code, double price){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getUpdateSt((price!=0)))){                                
            
            statement.setDouble(1, price);//serpa el nuevo total, no algo que se deba sumar...                        
            statement.setLong(2, code);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: UPDATing an PRICE of a product"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: impossible UPDATE an Employee");
        }                
        return false;
    }//by inventary and stowage
    
    public String getMessageError(){
        return this.errorMessage;
    }
    
    public boolean isTherAnError(){
        return (this.errorMessage != null);
    }
    
    public void ressetErrorMessage(){
        this.errorMessage = null;
    }
    
    //about delete, see in notes [recent and prev of this]
}

//el de inventario, no tiene la potestad
//de modif los prod, solo el de STORE, la 
//tiene,
    //cuando se elimina de una SALE
        //cuenta como INSERT to Inventary xD

//there will be axns to INVENTARY and STORE
//and I think that we will have to include 
//stock in a similar relation as contract::employee

//DELETE
    //Yo permití eseto en la DB, pero no en la interfaz
    //Debido a las instrucciones del proyecto