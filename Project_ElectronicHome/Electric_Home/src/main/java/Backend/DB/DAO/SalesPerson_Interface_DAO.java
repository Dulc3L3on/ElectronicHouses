/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Customer_DTO;
import Backend.DB.DTO.Sold_DTO;
import Backend.DB.DTO.Stock_DTO;
import Backend.DB.DTO.Transferred_DTO;
import Backend.DB.Tools.Transformer;
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
public class SalesPerson_Interface_DAO {
    private Connection connection = DBMS.initConnection();
    private Transformer transformer;
    private Transformer_SalesPersonSearching transformer_SPS;
    
    private Movements_UI_DAO movements_UI_DAO;           
    
    public SalesPerson_Interface_DAO(){
        this.movements_UI_DAO = new Movements_UI_DAO();
        
        this.transformer = new Transformer();
        this.transformer_SPS = new Transformer_SalesPersonSearching();
    }
    
    //----------Para sales tab e inventary tab (porque tienen los mismos campos a SELECT...
    
    private String getSimilarProductsSt(boolean office, String like){
        return "SELECT p.code, s.office, p.name, p.brand, s.ID, s.quantity"
             + " p.price FROM goodsControl.Product as p "
             + " INNER JOIN goodsControl.Stock as s ON p.code = s.product"
             + " "+ ((office)?"WHERE s.office = ? AND ": "") 
             + " p.code LIKE \'" + like + "%\'";//to find any code that starts with the given entrance
    }//cuando se use para SALE -> WHERE = true, caso contrario en inventary
        //aunque tb hubiera podido hacer que en el caso de inventary office = current()
    /**
     * It will search the list by 
     * the code that the salesperson
     * is entering. For sale and check
     * (sale and inventary tab).
     */
    public ArrayList<Stock_DTO> search_similarProducts(String office, String code){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSimilarProductsSt(
                        ((office==null)?false:true), code))){            
            if(office!=null){
                statement.setString(1, office);            
            }
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer_SPS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_SPS.getStocks(result);
            }else{
                return new ArrayList<>();
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the similar Stocks -> " +e.getMessage());
            return null;
        }
    }//Ready
    
    //-----------
    
    private String getSelectedStockSt(){
        return "SELECT SELECT p.code, s.office, p.name, p.brand, s.ID, s.quantity"
             + " p.price FROM goodsControl.Product as p "
             + " INNER JOIN goodsControl.Stock as s ON p.code = s.product "
             + " WHERE s.office = ? AND p.code = ?";
    }    
    
    /**
     * Search the product that was 
     * selected from the reference
     * table.
     */
    public Stock_DTO search_selectedStock(String office, long code){//tb pudo haber sido el s.ID, pero para hacerlo similar a lo de arriba, entonces... xD
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSelectedStockSt())){
            statement.setString(1, office);
            statement.setLong(2, code);
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformer_SPS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_SPS.getSelectedStock(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the selected Stock -> " +e.getMessage());            
        }
        return null;
    }///este no tiene revisasdo el transofmer (recvisa los TO DO...)
    
    private String getSoldProductSt(){
        return "SELECT v.code, p.code, p.name, p.brand, s.ID, p.price,"
             + " v.quantity, v.subtotal FROM transactionControl.Sold as v"
             + " INNER JOIN goodsControl.Product as p ON v.product = p.code"
             + " INNER JOIN goodsControl.Stock as s ON s.product = p.code"
             + " WHERE v.sale = ? ORDER BY v.code DESC LIMIT 1";
    }
    
    /**
     * Será exe justo después de hacer
     * una inserción, puesto que luego
     * de presionar (+) se add a la DB
     * entonces esto reflejará that was
     * done.
     * 
     */
    public Sold_DTO search_SoldProduct(String sale){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSoldProductSt())){
            ResultSet result = statement.executeQuery();
         
            statement.setString(1, sale);
            
            if(result != null && this.transformer_SPS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_SPS.getSoldProduct(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the selected Stock -> " +e.getMessage());            
        }
        return null;
    }
    
    //------------- To show the transferred product on the ALREADY table
    
    private String getTransferredProductSt(){
        return "SELECT t.code, p.code, p.name, p.brand, s.ID, p.price,"
             + " t.requested FROM transactionControl.Transferred as t"
             + " INNER JOIN goodsControl.Product as p ON t.product = p.code"
             + " INNER JOIN goodsControl.Stock as s ON s.product = p.code"
             + " WHERE t.transfer = ? ORDER BY t.code DESC LIMIT 1";//para agarrar c/v el más reciente.
    }
    
    /**
     * Será exe justo después de hacer
     * una inserción, puesto que luego
     * de presionar (+) se add a la DB
     * entonces esto reflejará that was
     * done.
     * 
     */
    public Transferred_DTO search_TransferredProduct(String transfer){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getTransferredProductSt())){
            ResultSet result = statement.executeQuery();
         
            statement.setString(1, transfer);
            
            if(result != null && this.transformer_SPS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_SPS.getTransferredProduct(result, transfer);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the selected Stock (TRANSFERRED) -> " +e.getMessage());            
        }
        return null;
    }
    
    //------to navigate on inventory

    /**
     * It is the method that gather
     * the 2 methdos that are going
     * to be used when a salesPerson
     * uses the inventary-tab.
     */
    
    public ArrayList<Stock_DTO> searchOnInventary(String code, String store, 
            String brand, String type, String[] line){       
        
        if(code != null && store.equals("all") && brand.equals("all")
                && type.equals("all") && line[0].equals("all")){
           return this.search_similarProducts(null, code);//puesto que este espacio se dedicó al hecho de que no se especificó la store...
        }else{//tb podría ser code == null y los demás == all... lo cual noe está mal...
            //si hay code, solo code + store tiene sentido... pero eso dependerá del user...
            this.searchProduct(code, store, brand, type, line);
        }        
        return new ArrayList<>();
    }
    
    private String getSearchProductSt(boolean code, boolean office, 
        boolean brand, boolean type, String[] line){//al menos uno debe estar seleccionado...
        boolean where = false;
        
        String search = "SELECT p.code, s.office, p.name, p.theBrand, s.ID,"
             + " s.quantity, p.price FROM goodsControl.Product as p "
             + " INNER JOIN goodsControl.Stock as s ON s.product = p.code"
             + " INNER JOIN goodsControl.Appliance as a ON a.name = p.name"
             + " INNER JOIN goodsControl.Clasification as c ON c.ID = a.clasification";             
        
        if(code){//cuando algo más a parte de code se escribe es cuando este aplica, porque si estuviera solo entonces se emplearía el método de getSimilar
            search += " WHERE p.code = ?";
            where = true;
        }if(office){
            search += ((!where)?" WHERE":" AND") + " s.office = ?";
            if(!where) where = true;
        }if(brand){
            search += ((!where)?" WHERE":" AND") + " p.theBrand = ?";
            if(!where) where = true;
        }if(type){
            search += ((!where)?" WHERE":" AND") + " c.type = ?";
            if(!where) where = true;
        }if(line != null && !line[0].equals("All")){
            for(int indice = 0; indice < line.length; indice++) {
                search += ((!where)?" WHERE":" AND") + " c.line = ?";
                if(!where) where = true;
            }
        }
        return search;     
    }
    
    /**
     * It will be used to search a
     * product when the filters were
     * used.
     */
    private ArrayList<Stock_DTO> searchProduct(String code, String office, String brand,
        String type, String[] line){
        
        int index = 1;
        
        try(PreparedStatement statement
                = connection.prepareStatement(
                  this.getSearchProductSt((code!=null),(!office.equals("all")),
                   (!brand.equals("all")), (!type.equals("all")), line))){
            if(code != null){
                statement.setString(index, code);
                index++;
            }        
            if(!office.equals("All")){
                statement.setString(index, office);
                index++;
            }if(!brand.equals("All")){
                statement.setString(index, brand);
                index++;
            }if(!type.equals("All")){
                statement.setString(index, type);
                index++;
            }if(line != null && !line[0].equals("All")){
                for(int indice = 0; indice < line.length; indice++) {
                    statement.setString(indice+index, line[indice]);
                }
            }
            
            ResultSet result = statement.executeQuery();
            
            if(result != null && this.transformer_SPS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_SPS.getStocks(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the selected Stock -> " +e.getMessage());            
        }
        return new ArrayList<>();    
    }/*este solo se encarga de enviar los campos según el string generado arribita xD*/
    
    //-------
    
}//READY

//Será reemplazada por Procut_DAO /mejro el de interfaz xd
    //peusto que esto se hace tb coninventario, y stowage...