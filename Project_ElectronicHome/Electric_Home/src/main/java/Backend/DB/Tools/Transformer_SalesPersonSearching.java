/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.Tools;

import Backend.DB.DTO.Appliance_DTO;
import Backend.DB.DTO.Clasification_DTO;
import Backend.DB.DTO.Product_DTO;
import Backend.DB.DTO.Sold_DTO;
import Backend.DB.DTO.Stock_DTO;
import Backend.DB.DTO.Transferred_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Transformer_SalesPersonSearching {
    
    public boolean moveBegin(ResultSet resultado){
        try{
            return resultado.first();            
        }catch(SQLException e){
            System.out.println("Error: al colocarse al principio del resultado -> "
                    + e.getMessage());
        }
        return false;
    }//Ready
    
    //------------------------------------
    public ArrayList<Stock_DTO> getStocks(ResultSet result){
        ArrayList<Product_DTO> products = this.getProducts(result);
        ArrayList<Stock_DTO> stocksList = new ArrayList<>();
        
         try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                stocksList.add(
                    this.getStock(result, products.get(indice)));
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: setting PRODUCTs");
        }
        return stocksList;
        
    }//BY salesPerson (Debido a la búsqueda de coincidencias...)
    
    public Stock_DTO getSelectedStock(ResultSet result){
        return this.getStock(result, this.getProduct(result));
    }//By salesPerson (When a product of the sugerences is selected
        
    private Stock_DTO getStock(ResultSet result, Product_DTO product){//solo un producto, porque la cantidad está almacenada en el stock...
        try{
            return new Stock_DTO(result.getString(5), product,
                    result.getInt(6), result.getString(2));
        }catch (SQLException e) {
            System.out.println("Error: setting a STOCK");
        }
        return null;
    }//BY salesPerson (Debido a la búsqueda de coincidencias...)
    
    private ArrayList<Product_DTO> getProducts(ResultSet result){
      ArrayList<Product_DTO> productsList = new ArrayList<>();
        
         try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                productsList.add(this.getProduct(result));//puesto que en las lista no es nec, ser específico xD
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: setting PRODUCTs");
        }
        return productsList;
    }//By salesPerson    
    
    private Product_DTO getProduct(ResultSet result){
        try{
            return new Product_DTO(result.getLong(1),
                new Appliance_DTO(result.getString(3), result.getString(4),
                    new Clasification_DTO(0, "", ""), ""),
                result.getDouble(7));
        }catch (SQLException e) {
            System.out.println("Error: setting a PRODUCT");
        }
        return null;       
    }//By salesPerson
    
    //--------------------------All of them are used for the customer searching process         

    /**
     * Va a ser utilizado para obtener
     * el SOLD que recientemente fue
     * add a la DB, para así mostrarlo.
     */
    
    public Sold_DTO getSoldProduct(ResultSet result){//office es no nec, porque con el code de la SOLD basta...
        try{
            return new Sold_DTO(result.getLong(1),                
                new Stock_DTO(result.getString(5),
                    new Product_DTO(result.getLong(2), 
                        new Appliance_DTO(result.getString(3), result.getString(4), 
                            new Clasification_DTO(0, "", ""), ""),
                        result.getDouble(6)), -1, ""), result.getInt(7), result.getDouble(8));
        }catch (SQLException e) {
            System.out.println("Error: setting a PRODUCT");
        }
        return null;
    }//Ready

    //-----------------Also for searching process but it will be show on the table: already SOLD/transferred
    
    public Transferred_DTO getTransferredProduct(ResultSet result, String transfer){
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
    
    //----------------It will be used to show the transferred products on the the table: already sold/transferred
    
    public ArrayList<String> getList(ResultSet result){
        ArrayList<String> list = new ArrayList<>();
        
        try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                list.add(result.getString(indice+1));
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: setting a list for UI" + e.getMessage());
        }
        return list;
    }//empleado por los 3 métodos para los cbBox
    
    //----------------They will be used to show the detailed product on the dedicated window
    
    public Stock_DTO getDetailedStock(ResultSet result, String office){
        return this.getTheStock(result, this.getDetailedProduct(result), office);
    }//By salesPerson (When a product is selected to see it detailed
    
    private Stock_DTO getTheStock(ResultSet result, Product_DTO product, String office){//solo un producto, porque la cantidad está almacenada en el stock...
        try{
            return new Stock_DTO(result.getString(2), product,
                    result.getInt(8), office);
        }catch (SQLException e) {
            System.out.println("Error: setting a STOCK");
        }
        return null;
    }//BY salesPerson (Debido a la búsqueda de coincidencias...)
    
    private Product_DTO getDetailedProduct(ResultSet result){
        try{
            return new Product_DTO(result.getLong(1),
                new Appliance_DTO(result.getString(3), result.getString(4),
                    new Clasification_DTO(0, result.getString(5), result.getString(6)),
                        result.getString(9)), result.getDouble(7));
        }catch (SQLException e) {
            System.out.println("Error: setting a PRODUCT");
        }
        return null;       
    }//By salesPerson
        
    //------------------ Por el momento solo esta axn ¿ (la que se encarga de mostrar los 
    //------------------ datos en la window para mostrar los detalles; es la que requiere de la existencia del 95% de los elemenetos...
    
}//READY
