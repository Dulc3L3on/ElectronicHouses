/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Product_DTO;
import Backend.DB.DTO.Stock_DTO;
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
public class Stock_DAO {
    private Connection connection = DBMS.initConnection();
    private Transformer transformer;
    
    private Product_DAO product_DAO;
    
    public Stock_DAO(){
        this.transformer = new Transformer();
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
            System.out.println("Error: FINDING the selected Stock -> " +e.getMessage());            
        }
        return null;
    }//BY: inventary, stowage [más que todo para ADD]
    
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
    public boolean update(boolean nested, String ID, int quantity){//puesto que no hay límite en la cdad que pueda almacenar 1 solo stock, entonces con que se sepa de qué tineda, se encuentra el stock deseado...        
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getUpdateSt())){                     
            statement.setInt(1, quantity);//serpa el nuevo total, no algo que se deba sumar...
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
    
}//READY
