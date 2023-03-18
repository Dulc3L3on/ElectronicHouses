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
public class Product_DAO {//It doesn't locate the office
    private DBMS connection;
    
    /**
     * It will be used to know if a
     * product already exist in the
     * whole DB.     * 
     */
    public long search_existence(String name){
        
        return 0;        
    }//By Product_UI (porque si fue una transfer o envío, quiere decri que ya existía...)
        //en el caso real, solo podría ser app en Procudt_UI if stowage, pero vamos a
        //omitir eso y dejarlo en general, porque quizá los prod llegaron desde el proveedor
        //y no la stowage a pesar de ser neuvos...       
    
    /**
     * It searchs a product, by
     * the code and maybe by brand,
     * type and line that are no
     * mandatory when is already
     * existent (search).
     * 
     */
    public void search_product(long code, String brand, String type, String line){
    
    }//By: inventory AND store
    
    /**
     * WHen a product doesn't exist
     * in the whole DB
     */
    public void create_code(){
    
    }
    
    /**
     * It search a list of products
     * by brand, and sometimes by
     * type &/|| type and line.
     */
    public void search_Products(){
    
    }//By: inventory AND store
        
    /**
     * It searchs all the
     * brands that are in total.
     */
    public void list_Brands(){
    
    }
    
    /**
     * It searchs all the types
     * that are in total.
     */
    public void list_Types(){
    
    }//By: inventory AND store
    
        
    /**
     * It allows to create JUST new
     * ones doesn't matter the destiny
     * because it has to exist in the
     * global DB.
     */
    public void insert(){
    
    }//By: inventary and stowage managers
    
    /**
     * It will be useful when a code is
     * repeated/existent, 'cause it means
     * is requiared to update in the most
     * of the cases quantity, or names and
     * price and just these.
     */
    public void update(){
    
    }//by inventary and stowage
    
    /**
     * It will be use (MAYBE) when a 
     * product is no more longer in 
     * a office (store/stowage)
     */
    public void delete(){
    
    }//By: inventary and stowage
    //see note in Notes xD
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