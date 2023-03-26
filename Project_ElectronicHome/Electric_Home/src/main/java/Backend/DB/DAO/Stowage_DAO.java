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
public class Stowage_DAO {
    private DBMS connection;
    
    private Movements_UI_DAO movement_interface_DAO;//product_DAO included        
    private Stock_DAO stock_DAO;
    
    
    public Stowage_DAO(){
        this.movement_interface_DAO = new Movements_UI_DAO();     
        this.stock_DAO = new Stock_DAO();
    }
     
    /**
     * TO add a real new one
     * or a new in the store
     */
    public void add_NewOne(String type){
        this.stock_DAO.add_NewOne(type);
    }
    
    public void add_More(){
        //no creo que aquí sea nested xd, pero para miesntras se comentará xD
        //this.stock_DAO.add_More();
    }
    
    //methods that will be used from MOV_Interface
        //All except for Store_Brands
            //because everything will be base on 
            //stowage
    
}
