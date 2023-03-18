/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;

/**
 *
 * @author phily
 */
public class Movements_UI_DAO{
    private DBMS connection;    
    private Product_DAO product_DAO;
    private Stock_DAO stock_DAO;
    private Movement_DAO movement_DAO;
    
    public Movements_UI_DAO(){
        this.product_DAO = new Product_DAO();
        this.stock_DAO = new Stock_DAO();
        this.movement_DAO = new Movement_DAO();
    }
    
    /**
     * Searchs all the brands that
     * are manage by a specific
     * store.
     */
    public void search_Store_Brand(){
    
    }//By: inventory
    
    /**
     * List all the types that are
     * related with a list of brands.
     */
    public void list_Brands_Types(){
        
    }//By: inventory and Stowage   
    
    /**
     * List all the types that are
     * related with a specific brand.
     */
    public void list_Brand_Types(){
        
    }//By: inventory and stowage   
        
    /**
     * It search a list of products
     * by brand, and sometimes by
     * type &/|| type and line.
     */
    public void search_products(){
        this.product_DAO.search_Products();
        
        while(true){
            this.stock_DAO.search_Existence(0);
        }
    }//mira si lo harás así, o mejor un JOIN..
    
    /**
     * It will be use when a row
     * is selected.
     */
    public void search_product(long code, String branch, String type, String line){
        this.product_DAO.search_product(code, branch, type, line);
            this.stock_DAO.search_Existence(0);        
    }//mira si lo harás así, o mejor un JOIN..
    
    //métodos a emplear de product_DAO        
        //list_Brands
        //list_Types
        //update (si lo vas a hacer fácil xD)
    
    //methods that I going to use from Movement_DAO
        //search_movements            
        //serch_movement
            //because it has to send the result to MOV_UI        
   
    public Movement_DAO getMovement_DAO(){
        return this.movement_DAO;
    }
    
    public Product_DAO getProduct_DAO(){
        return this.product_DAO;
    }
    
}//NO más

    //el listado de las lineas no se va a 
    //obtener, porque se complicaría/alargaría
    //bastantiton el proceso    