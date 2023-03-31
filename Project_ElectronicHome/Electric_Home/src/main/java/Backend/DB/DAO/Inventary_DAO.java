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
public class Inventary_DAO {//CRUD about the person who is in charge
    private Movements_UI_DAO movement_UI_DAO;//all? I think xD
    private Employees_Interface_DAO e_interfacce_DAO;//ALL    
    private InvStow_Interface_DAO insvStowDAO;
    private Office_DAO officeDAO;
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
        this.transferDAO = new Transfer_DAO();
        this.transferredDAO = new Transferred_DAO();
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
        return this.officeDAO;
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
    
    public ArrayList<String> getBrands(){
        return this.product_DAO.list_Brands();
    }
    
    public ArrayList<String> getTypes(){
        return this.product_DAO.list_Types();
    }
    
    public Transfer_DAO getTransferDAO(){
        return this.transferDAO;
    }//BY: inventary
    
    public Transferred_DAO getTransferred_DAO(){
        return this.transferredDAO;
    }
    
    //methods that I will use from Mov_interface
        //ALL    
}
//CANDIDATA para ser elimnada