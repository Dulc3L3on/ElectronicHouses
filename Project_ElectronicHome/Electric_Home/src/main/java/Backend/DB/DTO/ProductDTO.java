/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phily
 */
public class ProductDTO {
   private long _code;
   private String _name;
   private String _brand;//Recuerda que en el caso del jasper, os nombres de los atrib del repo son los que deben corresponder a estos...
   private String _stock;
   private double _price;

    public long getID() {
        return _code;
    }

    public void setID(long _code) {
        this._code = _code;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getBrand() {
        return _brand;
    }

    public void setBrand(String _brand) {
        this._brand = _brand;
    }

    public String getStock() {
        return _stock;
    }

    public void setStock(String _stockID) {
        this._stock = _stockID;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double _price) {
        this._price = _price;
    }
  
}
