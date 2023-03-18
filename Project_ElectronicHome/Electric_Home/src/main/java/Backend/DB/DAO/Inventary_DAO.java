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
public class Inventary_DAO {//CRUD about the person who is in charge
    private DBMS connection;
    
    private Movements_UI_DAO movement_UI_DAO;//product_DAO included        
    private Stock_DAO stock_DAO;
    
    public Inventary_DAO(){
        this.movement_UI_DAO = new Movements_UI_DAO();     
        this.stock_DAO = new Stock_DAO();
    }
    
     /**
     * TO add a real new one
     * or a new product at the
     * store
     */
    public void add_NewOne(String type){
        
        this.stock_DAO.add_NewOne(type);               
    
    }//by: inventary   
    
    public void add_More(){
        
        this.stock_DAO.add_More();
    }
    
    public void request_shipment(){
        //Se tiene que obtener el los datos de c/prod a 
        //pedir, según la tienda escogida
    }//BY: inventary
    
    
    //methods that I will use from Mov_interface
        //ALL
    
}
