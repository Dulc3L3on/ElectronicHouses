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
    private Movements_UI_DAO movement_UI_DAO;//all? I think xD
    private Employees_Interface_DAO e_interfacce_DAO;//ALL    
    private Stock_DAO stock_DAO;//existencia, add y update
    private Product_DAO product_DAO;//existencia y update
    private Appliance_DAO appliance_DAO;//existencia
    private Transfer_DAO transferDAO;//
    private Transferred_DAO transferredDAO;//
    
    public Inventary_DAO(){
        this.movement_UI_DAO = new Movements_UI_DAO();     
        this.e_interfacce_DAO = new Employees_Interface_DAO();
        this.stock_DAO = new Stock_DAO();
        this.product_DAO = new Product_DAO();
        this.appliance_DAO = new Appliance_DAO();
    }
    
    public Movements_UI_DAO getMovements_UI_DAO(){
        return this.movement_UI_DAO;
    }
    
    public Employees_Interface_DAO getE_interfacce_DAO(){
        return this.e_interfacce_DAO;
    }
    
    public Stock_DAO getStock_DAO(){
        return this.stock_DAO;
    }
    
    public Product_DAO getProduct_DAO(){
        return product_DAO;
    }
    
    public Appliance_DAO getAppliance_DAO(){
        return appliance_DAO;
    }
    
    //methods that I will use from Mov_interface
        //ALL    
}
//CANDIDATA para ser elimnada