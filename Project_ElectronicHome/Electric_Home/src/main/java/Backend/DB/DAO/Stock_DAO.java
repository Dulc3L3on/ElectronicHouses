/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Product_DTO;
import Backend.DB.DTO.Stock_DTO;
import Backend.DB.Tools.Transformer;
import Backend.DB.Tools.Transformer_SalesPersonSearching;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author phily
 */
public class Stock_DAO {
    private Connection connection = DBMS.initConnection();
    private Transformer transformer;
    private Transformer_SalesPersonSearching transformer_SPS;
    private Indexator_DAO indexator;
    
    private Product_DAO product_DAO;
    
    private boolean error = false;
    
    public Stock_DAO(){
        this.transformer = new Transformer();
        this.transformer_SPS = new Transformer_SalesPersonSearching();
        this.indexator = new Indexator_DAO();
        //this.product_DAO = new Product_DAO();//:v ?        
    } 
    
    private String getSearchExistenceSt(){
        return "SELECT ID, quantity FROM goodsControl.Stock"
             + " WHERE p.name = ? and s.office = ?";
    }//si existe entonces SI se nec la quantity- recuerda que en ese casosolo ppdrá add no colocar menos - tb aplicaa cuando no existe, pero en ese caso el número ini sería 0... imagino que se exe después de presionar ENTER en el nombre del prod, es decir después de buscar el prod...
    
    /**
     * It will be use, to search
     * if a stock exist on a office
     * to vaoid repetition (when is
     * going to be add or uodate a 
     * product. JUst to confirm xD)
     */
    public Stock_DTO search_Existence(String name, String office,
            Product_DTO product){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchExistenceSt())){
            statement.setString(1, name);
            statement.setString(2, office);   
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer.getStock(result, office, product);
            }
        }catch(SQLException e) {
            this.error = true;
            System.out.println("Error: FINDING the selected Stock -> " +e.getMessage());            
        }
        return null;
    }//BY: inventary, stowage [más que todo para ADD]
    
    public String searchActualID(String tableName){
        return ""+this.indexator
                .search((tableName.equals("OID-12536477")?"ABC"
                                          :(tableName.equals("OID-12536478")?"ABN"
                                           :(tableName.equals("OID-12536479")?"ABS"
                                            :"ABT"))));//y así con las 4 restantes
    }
    
    public void updateID(String office){
        this.indexator.update(((office.equals("OID-12536477")?"ABC"
                                   :(office.equals("OID-12536478")?"ABN"
                                     :(office.equals("OID-12536479")?"ABS"
                                        :"ABT")))));//y así con las 4 restantes
    }
    
    private String getQuantity(){
        return "SELECT quantity FROM goodsControl.Stock WHERE ID = ?";
    }
    
    public int searchQuantity(String ID){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getQuantity())){
            statement.setString(1, ID);            
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer.moveBegin(result)){//Revisa si así dice que está vacío...
                return result.getInt(1);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the actual QUANTITY -> " +e.getMessage());            
        }
        return -1;
    }
    
    private String getSearchSt(){
        return "SELECT p.code, s.ID, p.name p.theBrand, c.type, c.line,"
             + " p.price, s.quantity, a.details FROM goodsControl.Stock as s"
             + " INNER JOIN goodsControl.Product as p ON s.product = p.code"
             + " INNER JOIN goodsControl.Appliance as a ON a.name = p.name"
             + " goodsControl.Clasification as c ON c.ID = a.clasification"
             + " WHERE p.code = ? and s.office = ?";//estos dos para ser específico
    }
    
    /**
     * It will be used to find the
     * particular product that was
     * selected to see its details
     * on the specific window.
     */
    public Stock_DTO search(long code, String office){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchSt())){
            statement.setLong(1, code);
            statement.setString(2, office);
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer_SPS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_SPS.getDetailedStock(result, office);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the selected Stock -> " +e.getMessage());            
        }
        return null;
    }//by salesPerson(without edit), inventory and stowage (same permissions)
        //also you can apply it when they enter the code on the product window...
    
    private String getInsertSt(){
        return "INSERT INTO goodsControl.Stock VALUES (?,?,?,?)";
    }
    
    /**
     * It will be use, to ADD a product
     * on a store.
     */
    public boolean insert(String ID, long product, int quantity, String office){
        try(PreparedStatement statement = 
               connection.prepareStatement(this.getInsertSt())){
            statement.setString(1, ID);
            statement.setLong(2, product);//no importando si existe o no, esto se verá en la ventanita, por lo cual ya existirá xD          
            statement.setInt(3, quantity);
            statement.setString(4, office);
            
            statement.executeUpdate();            
            return true;
        }catch(SQLException e){        
            System.out.println("Error: creating an STOCK" + e.getMessage());
        }
        return false;
    }
    
    private String getUpdateSt(){
        return "UPDATE goodsControl.Stock SET quantity = ?"
             + " WHERE ID = ?";
    }
    
    /**
     * It will be use when a
     * product is already
     * existent and is nec
     * add or reduce the quantity.
     */
    public boolean update(boolean nested, String ID, boolean isAdd, int quantity){//puesto que no hay límite en la cdad que pueda almacenar 1 solo stock, entonces con que se sepa de qué tineda, se encuentra el stock deseado...        
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getUpdateSt())){                     
            statement.setInt(1, ((isAdd)
                                    ?this.searchQuantity(ID)+quantity
                                    :this.searchQuantity(ID)-quantity));//serpa el nuevo total, no algo que se deba sumar...
            statement.setString(2, ID);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            System.out.println("Error: impossible UPDATE an Employee");
        }        
        
        if(!nested){
                JOptionPane.showMessageDialog(null, "Error: UPDATing an QUANTITY of a stock"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
        }        
        return false;
    }
    //reduce WHEN a sale or a transfer is sended (processed)
    //addition WHEN a transfer is received (done)
        
    public boolean isTherAnError(){
        return this.error;
    }
    
    public void ressetError(){
        this.error = false;
    }
    
}//READY
