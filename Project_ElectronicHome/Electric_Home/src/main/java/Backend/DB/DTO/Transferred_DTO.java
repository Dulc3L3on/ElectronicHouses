/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Transferred_DTO {
    private long _transfer;
    private long _product;
    private int _quantity;

    public long getTransfer() {
        return _transfer;
    }

    public void setTransfer(long _transfer) {
        this._transfer = _transfer;
    }

    public long getProduct() {
        return _product;
    }

    public void setProduct(long _product) {
        this._product = _product;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int _quantity) {
        this._quantity = _quantity;
    }    
    
}
