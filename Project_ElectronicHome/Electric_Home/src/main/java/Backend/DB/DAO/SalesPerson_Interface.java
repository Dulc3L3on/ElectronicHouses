/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

/**
 *
 * @author phily
 */
public class SalesPerson_Interface {
    private Movements_UI_DAO movements_UI_DAO;    
    
    public SalesPerson_Interface(){
        this.movements_UI_DAO = new Movements_UI_DAO();          
    }
    
    /**
     * It will search the list by 
     * the code that the salesperson
     * is entering.
     * 
     * @param code
     */
    public void search_products(long code){
        //se hará un JOIN para buscar todos los prod
        //que sean de la tienda y empiecen con el código
        //a partir de LIKE %%
    }
    
    /**
     * Search the product that was 
     * selected from the reference
     * table.
     */
    public void search_product(long code, String brand, String type, String line){       
        this.movements_UI_DAO.search_product(code, brand, type, line);
        
        /*this.product_DAO.search_product(code, brand, type, line);
            this.stock_DAO.search_Existence(code);*/
    }
    
    //methos of Movements_UI_DAO
        //All except for the movements [until > search_Product()]
            //because they just can request a tranfer
            //not see all of them
}
