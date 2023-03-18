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
public class Movement_DAO {
    private DBMS connection;
    
    /**
     * It will be used to find
     * transfers/shipments, because
     * they are the same in DB, but
     * not at all in both interfaces
     * (inventory, stowage)
     */
    public void search_movements(){
        
    }//By: Inventory, Stowage
    
    /**
     * It will be used by a tab
     * whether it's to ask from
     * another store(transfer)
     * or from stowage(shipment)
     * from the main interface
     * or tranfer/shipment window
     */
    public void search_movement(String type){
        //if one, so receptment else
        //from (because receip is stowage)
    
    }//By: inventory, stowage
    
    /**
     * It will be used by Movement
     * window and after this we have
     * to set the state as processed
     * it means that is a **REMOVE** 
     * of product
     */
    public void do_movement(String type){
    
    }//BY: inventary and stowage
    
}
