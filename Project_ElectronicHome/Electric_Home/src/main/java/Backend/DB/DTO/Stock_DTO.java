/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Stock_DTO {
    private String _ID;
    private Product_DTO _product;
    private int _quantity;
    private String _office;

    public Stock_DTO(String ID){
        this._ID = ID;
    }
    
    public Stock_DTO(String ID, Product_DTO product, int quantity, String office){
        this._ID = ID;
        this._quantity = quantity;
        this._office = office;
        this._product = product;
    }
    
    public String getID() {
        return _ID;
    }

    public void setID(String _ID) {
        this._ID = _ID;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int _cuantity) {
        this._quantity = _cuantity;
    }

    public String getOffice() {
        return _office;
    }

    public void setOffice(String _office) {
        this._office = _office;
    }

    public Product_DTO getProduct() {
        return _product;
    }

    public void setProduct(Product_DTO _product) {
        this._product = _product;
    }
    
}
