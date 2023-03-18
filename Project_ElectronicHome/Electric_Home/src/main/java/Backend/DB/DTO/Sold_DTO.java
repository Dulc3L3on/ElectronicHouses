/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Sold_DTO {
    private int code;
    private String sale;
    private long _product;
    private int _cuantity;
    private double _subtotal;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public long getProduct() {
        return _product;
    }

    public void setProduct(long _product) {
        this._product = _product;
    }

    public int getCuantity() {
        return _cuantity;
    }

    public void setCuantity(int _cuantity) {
        this._cuantity = _cuantity;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }
    
}
