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
public class Product_Interface_DAO {
    private DBMS connection;
    
    private Product_DAO product_DAO;
    private Stock_DAO stock_DAO;
    
    public Product_Interface_DAO(){
        this.product_DAO = new Product_DAO();
        this.stock_DAO = new Stock_DAO();
    }    
    
    public void list_brands_type(){
    
    }
    
    //methods that are going to be used
    //from PRODUCT_dAO
        //search_existence
        //search_product
        //create_code        
        //list brands        
            //Creo que voy a tener que 
            //add estos métodos de list
            //a product, porque lo está
            //nec más de 1...
    
    //methods to use from STOCK_DAO
        //search_existence()
        //create_stockID()
        //add_NewOne()
        //add_More()
    
    //Cab resaltar, que si se tiene el código
    //Que se insertó, entonces
        //IF NO haces no edit los field, show
           //an error the console
        //ELSE you DO it no edit, it won't be
             //something to be worried
    
    
    //NOTA: aquí si obligtoriamente todos los
          //campos deberán ser llenados...
    
}
//Candidata a ser eliminada