/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Stowage_DAO{
    private Movements_UI_DAO movement_UI_DAO;//all? I think xD
    private Employees_Interface_DAO e_interfacce_DAO;//ALL
    private InvStow_Interface_DAO insvStowDAO;
    private Office_DAO office_DAO;//ambos (para hallar todas y todas EXCEPTO)
    private Transfer_DAO transfer_DAO;//update y....
    private Transferred_DAO transferred_DAO;
    private Stock_DAO stock_DAO;//ALL: existencia, add y update
    private Product_DAO product_DAO;//ALL: existencia, update e insert
    private Appliance_DAO appliance_DAO;//ALL: existencia, update e insert
    private Clasification_DAO clasification_DAO;//ALL: insert
    
    public Stowage_DAO(){
        this.movement_UI_DAO = new Movements_UI_DAO();     
        this.e_interfacce_DAO = new Employees_Interface_DAO();
        this.stock_DAO = new Stock_DAO();
        this.product_DAO = new Product_DAO();
        this.appliance_DAO = new Appliance_DAO();
        this.clasification_DAO = new Clasification_DAO();
    }
    
    public Movements_UI_DAO getMovUI_DAO(){
        return this.movement_UI_DAO;
    }
    
    public Employees_Interface_DAO getEmployee_IntDAO(){
        return this.e_interfacce_DAO;
    }
    
    public InvStow_Interface_DAO getInvStow_In_DAO(){
        return this.insvStowDAO;
    }//
    
    public Office_DAO getOfficeDAO(){
        return this.office_DAO;
    }
    
    public Transfer_DAO getTransferDAO(){
        return this.transfer_DAO;
    }
    
    public Transferred_DAO getTransferredDAO(){
        return this.transferred_DAO;
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
    
    //methods that will be used from MOV_Interface
        //All except for Store_Brands
            //because everything will be base on 
            //stowage
 
    public ArrayList<String> getBrands(){
        return this.product_DAO.list_Brands();
    }
    
    public ArrayList<String> getTypes(){
        return this.product_DAO.list_Types();
    }
    
}
