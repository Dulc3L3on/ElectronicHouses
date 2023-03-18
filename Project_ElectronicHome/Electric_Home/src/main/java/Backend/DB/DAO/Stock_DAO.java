/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Stock_DAO {
    private DBMS connection;
    
    private Product_DAO product_DAO;
    
    public Stock_DAO(){
        this.product_DAO = new Product_DAO();
    }
    
    /**
     * It will search if a product exists
     * in a specific office (on product_UI)
     * because UPDATE and movement
     * (just use this) because of the context
     * the product already exists on the DB
     * @return
     */
    public ArrayList<String> search_Existence(long code){
        return null;
    }
    
    /**
     * WHen the product appears
     * into the DB but it doesn't
     * exist in the specific store.
     */
    public String create_IDStock(){
        return "";
    }
    
    /**
     * It will be use, when a product
     * is
     *  - not existent
     *  - or already existent but doesn't
     *    be on the specific store
     */
    public void add_NewOne(String type){
        if(type.equals("realNew")){
            this.product_DAO.insert();
        }else{
        
        }
    }
    
    /**
     * It will be use when a
     * product is already
     * existent and is nec
     * add more on quantity.
     */
    public void add_More(){
        this.product_DAO.update();
    }
    
    /**
     * It will be used to modify
     * the quantity
     */
    public void update(){
    
    }//ahora que lo pienso
        //si la cdad llega a 0, no es nec que
        //el stock sea eliminado...
            //entonces dejalo ahí xD
                //así tb no andas creando c/v +...
    
}//READY
