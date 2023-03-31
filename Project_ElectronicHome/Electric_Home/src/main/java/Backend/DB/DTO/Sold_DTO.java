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
    private long _code;
    private String _sale;
    //esto no incluirá producto aquí fuera, porque Stock, le incluye...
    private Stock_DTO _stockDTO;
    private int _quantity;
    private double _subtotal;

    public Sold_DTO(long code, Stock_DTO stock,
            int _quantity, double _subtotal) {
        this._code = code;
        this._sale = "";        
        this._stockDTO = stock;
        this._quantity = _quantity;
        this._subtotal = _subtotal;
    }
    
    public long getCode() {
        return _code;
    }

    public void setCode(long code) {
        this._code = code;
    }

    public String getSale() {
        return _sale;
    }

    public void setSale(String sale) {
        this._sale = sale;
    }

    public Stock_DTO getStockDTO() {
        return _stockDTO;
    }

    public void setStockDTO(Stock_DTO _stockDTO) {
        this._stockDTO = _stockDTO;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setCuantity(int _quantity) {
        this._quantity = _quantity;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }
    
}
