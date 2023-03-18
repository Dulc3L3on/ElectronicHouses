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
public class SalesPerson_DAO {
    private DBMS connection;    

    //private Contract_DAO contract_DAO;        
    
    private SalesPerson_Interface salesPerson_Interface;
    private Customer_DAO customer_DAO;
    private Sale_DAO sale_DAO;
    private Sold_DAO sold_DAO;
    
    public SalesPerson_DAO(){
        this.salesPerson_Interface = new SalesPerson_Interface();
        this.customer_DAO = new Customer_DAO();
        this.sale_DAO = new Sale_DAO();
        this.sold_DAO = new Sold_DAO();
    }
    
    public void request_transfer(){
        //Se tiene que obtener el los datos de c/prod a 
        //pedir, según la tienda escogida
            //será como una venta, pero en lugar de
            //obtener el dato del prod y stock para
            //vender, será para pedir.
            
            
    }//BY: inventary
    
    public Customer_DAO get_CUstomer_DAO(){
        return this.customer_DAO;
    }
    
    public Sale_DAO get_Sale_DAO(){
        return this.sale_DAO;
    }
    
    public Sold_DAO get_Sold_DAO(){
        return this.sold_DAO;
    }
    
    //About salesPerson_Interface
        //All that is not specified that is restricted...
    //About sales, sold and customer
        //Everything!
  
}
