/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Sold_DTO;
import Backend.DB.Tools.Transformer;
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
public class Sold_DAO {
    private Connection connection = DBMS.initConnection();
    private Stock_DAO stockDAO;
    private Transformer transformer;
    
    public Sold_DAO(){
        this.stockDAO = new Stock_DAO();
        this.transformer = new Transformer();
    }
    
    private String getSearchingSoldsSt(){
        return "SELECT v.code, p.code, p.name, p.brand, s.ID, p.price v.quantity,"
             + " v.subtotal FROM transactionControl.Sold as v INNER JOIN"
             + " goodsControl.Product as p ON v.product = p.code INNER JOIN"
             + " goodsControl.Stock as s ON s.product = p.code"
             + " WHERE v.sale =  ?";
    }
    
    /**
     * It will be used when a SALE
     * is searched because of a
     * CHANGE (devolución).
     */
    public ArrayList<Sold_DTO> searchSolds(String sale){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchingSoldsSt())){
            statement.setString(1, sale);
                
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer.moveBegin(result)){
                return this.transformer.getSolds(result);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Impossible find the Sold list\n"
                   + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: Impossible FIND the Sold list");
        }
        
        return new ArrayList<>();
    }//Ready
    
    private String getInsertionSt(){
        return "INSERT INTO transactionControl.Sold "
             + "(sale, product, quantity, subtotal)"
             + " VALUES (?,?,?,?)";
    }
    
    /**
     * It will be used to add
     * the individual sales
     * to a whole sale.
     */
    public void insert(String sale, long productCode, int quantity, double subtotal){
         try(PreparedStatement statement = 
                connection.prepareStatement(this.getInsertionSt())){            
            statement.setString(2, sale);
            statement.setLong(3, productCode);
            statement.setInt(4, quantity);
            statement.setDouble(5, subtotal);
            
            statement.executeUpdate();
        }catch(SQLException e){            
            JOptionPane.showMessageDialog(null, "Impossible to CREATE the Sold"
                 + "\n Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: creating a Sold" + e.getMessage());
        }        
    }//By: salesPerson (será exe c/v que se presiona el botón ADD)
    
    private String getUpdationSt(){
        return "UPDATE transactionControl.Sold SET quantity  = ?, subtotal = ?"
             + "WHERE product = ?";
    }
    
    /**
     * It will be used when a
     * appliance is registered
     * or urchased and actually
     * there was an appliance
     * of the same type before.
     */
    public boolean update(int quantity, double amount){
       try(PreparedStatement statement 
               = connection.prepareStatement(this.getUpdationSt())){
           
            statement.setInt(1, quantity);
            statement.setDouble(2, amount);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: UPDATing an Sold"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: impossible UPDATE an Sold");
        }        
        return false;
    }//By:SalesPerson; Ready
  
    ///////////////////////////////////////////////////////////////---INVENTARY
    
    private String getDeletionSt(){
        return "DELETE FROM transactionControl.Sold WHERE code = ?";
    }
    
    /**
     * It will be used to delete
     * an individual sold, before
     * the sale was do or already
     * did because of a CAHNGE.
     */
    public boolean delete(long code){//qunatity no porque si no tendría que hacer que la tabla permitirera esa edición y no queiro pober maś!
        boolean correct = true;
        
        try(PreparedStatement statement = 
                connection.prepareStatement(this.getDeletionSt())){
            statement.setLong(1, code);
            
            statement.executeUpdate();                                    
            
        }catch(SQLException e){            
            System.out.println("Error: Impossible to DELETE the Sold: "+ e.getMessage());
            correct = false;
        }
        
        if(!correct){
            JOptionPane.showMessageDialog(null, "Impossible to DELETE the Sold.\n"
                    + "Try one more time", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }//By: Inventary (por medio de SalesPerson)!!!
        //Empleado antes de generar factura, o tiempo después de haber hecho la venta...
    

    //DELETE: Por cada eliminación será necesario que se solicite el code
         //del de inventario, no importando si se app a una UPDATE o no
            //Y puesto que el code se obtendrá al pedirlo, entonces justo
            //después de eso se SEARCH el de inventario corresp y con ese
            //usario (si lo creara [pero en este caso solo se quedará en la
            //búsqueda]) se haría el acceso a la DB y se exe la axn
    
        //AL hacer un DELETE, se hará un INSERT con la axn del DAO inventary    
}//ENDED