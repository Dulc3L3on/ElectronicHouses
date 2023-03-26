/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Stock_DTO;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class SalesPerson_DAO {
    private DBMS connection;    
    
    private SalesPerson_Interface_DAO salesPerson_Interface_DAO;
    private Movements_UI_DAO movementsUI_DAO;
    private Customer_DAO customer_DAO;
    private Sale_DAO sale_DAO;
    private Sold_DAO sold_DAO;
    private Transfer_DAO transfer_DAO;
    private Transferred_DAO transferred_DAO;
    private Product_DAO product_DAO;//Este contiene el método para buscar el proucto a detallar, get BrandsSt, getTypes y solo xD
    
    public SalesPerson_DAO(){
        this.salesPerson_Interface_DAO = new SalesPerson_Interface_DAO();
        this.movementsUI_DAO = new Movements_UI_DAO();
        this.customer_DAO = new Customer_DAO();
        this.sale_DAO = new Sale_DAO();
        this.sold_DAO = new Sold_DAO();
        this.transfer_DAO = new Transfer_DAO();
        this.transferred_DAO = new Transferred_DAO();
        this.product_DAO = new Product_DAO();
    }
    
    public Customer_DAO get_Customer_DAO(){
        return this.customer_DAO;
    }//Ready
    
    public SalesPerson_Interface_DAO getSalesPerson_IntDAO(){
        return this.salesPerson_Interface_DAO;
    }
    
    public Sale_DAO get_Sale_DAO(){
        return this.sale_DAO;
    }
    
    public Sold_DAO get_Sold_DAO(){
        return this.sold_DAO;
    }
    
    public Transfer_DAO getTransfer_DAO(){
        return this.transfer_DAO;
    }//BY: inventary
    
    public Transferred_DAO getTransferred_DAO(){
        return this.transferred_DAO;
    }
    
    public Stock_DTO searchDetailedProd(long code, String office){
        return this.product_DAO.searchProduct(code, office);
    }
    
    public ArrayList<String> getBrands(){
        return this.product_DAO.list_Brands();
    }
    
    public ArrayList<String> getTypes(){
        return this.product_DAO.list_Types();
    }
    
    //About salesPerson_Interface
        //All that is not specified that is restricted...
    //About sales, sold and customer
        //Everything!
  
}
