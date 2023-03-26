/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Product_DTO {
   private long _code;
   private Appliance_DTO _appliance;
   private double _price;//Recuerda que en el caso del jasper, os nombres de los atrib del repo son los que deben corresponder a estos...   

    public Product_DTO(long _code, Appliance_DTO appliance, double _price){
        this._code = _code;
        this._appliance = appliance;
        this._price = _price;
    }
   
    public long getID() {
        return _code;
    }

    public void setID(long _code) {
        this._code = _code;
    }

    public Appliance_DTO getAppliance(){
        return this._appliance;
    }
    
    public void setAppliance_DTO(Appliance_DTO appliance){
        this._appliance = appliance;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double _price) {
        this._price = _price;
    }
  
}
