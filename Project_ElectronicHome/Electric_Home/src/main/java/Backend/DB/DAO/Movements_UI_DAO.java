/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
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
public class Movements_UI_DAO{
    private Connection connection = DBMS.initConnection();  
    private Transformer_SalesPersonSearching transformer_SPS;
    
    /*private Product_DAO product_DAO;
    private Stock_DAO stock_DAO;
    private Movement_DAO movement_DAO;*/
    
    public Movements_UI_DAO(){
     /*   this.product_DAO = new Product_DAO();
        this.stock_DAO = new Stock_DAO();
        this.movement_DAO = new Movement_DAO();*/
     
        this.transformer_SPS = new Transformer_SalesPersonSearching();
    }
    
    private String getStoresBrandSt(){
        return "SELECT p.theBrand"
            + " FROM goodsControl.Product as p"
            + " INNER JOIN goodsControl.Stock as s"
            + " ON p.code = s.product WHERE s.office = ?";
    }
    
    /**
     * Searchs all the brands that
     * are manage by a specific
     * store.
     */
    public ArrayList<String> search_StoresBrand(String office){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getStoresBrandSt())){
            statement.setString(1, office);
                
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer_SPS.moveBegin(result)){
                return this.transformer_SPS.getList(result);
            }
        }catch(SQLException e){            
            System.out.println("Error: Impossible FIND a StoresBrandList");
        }
        
        return new ArrayList<>();        
    }//By: inventory
    
    private String getBrandsTypes(){
        return "SELECT c.type FROM goodsControl.Clasification as c"
            + " INNER JOIN goodsControl.Appliance as a ON a.clasification = c.ID"
            + " INNER JOIN goodsControl.Product as p ON p.name = a.name"
            + " INNER JOIN goodsControl.Stock as s ON s.product = p.name"
            + " WHERE s.office = ? GROUP BY c.type";//creo que podría eli producto y quedarme con s, a, y c...
        
    }//un select anidado?? o un join?? pero se que se hace así y está fácil
     //si no das, entonces esrá a la arcaica...
    
    /**
     * List all the types that are
     * related with a list of brands.
     */
    public ArrayList<String> list_BrandsTypes(String office){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getBrandsTypes())){
            statement.setString(1, office);
                
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer_SPS.moveBegin(result)){
                return this.transformer_SPS.getList(result);
            }
        }catch(SQLException e){            
            System.out.println("Error: Impossible FIND the Types from a Brands list");
        }        
        return new ArrayList<>();        
    }//By: inventory and Stowage   
    
    private String getBrands_Types(){
        return "SELECT c.type FROM goodsControl.Clasification as c"
             + " INNER JOIN goodsControl.Appliance as a"
             + " ON a.clasification = c.ID WHERE a.theBrand = ?";
    }
    
    /**
     * List all the types that are
     * related with a specific brand.
     */
    public ArrayList<String> list_Brands_Types(String brand){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getBrands_Types())){
            statement.setString(1, brand);
                
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer_SPS.moveBegin(result)){
                return this.transformer_SPS.getList(result);
            }
        }catch(SQLException e){            
            System.out.println("Error: Impossible FIND a StoresBrandList");
        }
        
        return new ArrayList<>();
    }//By: inventory and stowage           
}//Ready
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * It search a list of products
     * by brand, and sometimes by
     * type &/|| type and line.
     */
  /*  public void search_products(){
        this.product_DAO.search_Products();
        
        while(true){
            this.stock_DAO.search_Existence(0);
        }
    }//mira si lo harás así, o mejor un JOIN..
    
    /**
     * It will be use when a row
     * is selected.
     */
/*    public void search_product(long code, String branch, String type, String line){
        this.product_DAO.search_product(code, branch, type, line);
            this.stock_DAO.search_Existence(0);        
    }*///mira si lo harás así, o mejor un JOIN..
    
    //métodos a emplear de product_DAO        
        //list_Brands
        //list_Types
        //update (si lo vas a hacer fácil xD)
    
    //methods that I going to use from Movement_DAO
        //search_movements            
        //serch_movement
            //because it has to send the result to MOV_UI        
   
  /*  public Movement_DAO getMovement_DAO(){
        return this.movement_DAO;
    }
    
    public Product_DAO getProduct_DAO(){
        return this.product_DAO;
    }
    
}*///NO más

    //el listado de las lineas no se va a 
    //obtener, porque se complicaría/alargaría
    //bastantiton el proceso    