/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Customer_DTO {
   private String _NIT;
   private String _CUI;
   private String _name;   
   private String _address;
   private java.util.Date _since;

   public Customer_DTO(){}
   
   public Customer_DTO(String NIT, String CUI, String name,
           String address, java.sql.Date since){
   
       this._NIT = NIT;
       this._CUI = CUI;
       this._name = name;
       this._address = address;
       this._since = new java.util.Date(since.getTime());
   }
   
    public String getNIT() {
        return _NIT;
    }

    public void setNIT(String _NIT) {
        this._NIT = _NIT;
    }

    public String getCUI() {
        return _CUI;
    }

    public void setCUI(String _CUI) {
        this._CUI = _CUI;
    }
    
    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _adress) {
        this._address = _adress;
    }

    public java.util.Date getSince() {
        return _since;
    }

    public void setSince(java.util.Date _since) {
        this._since = _since;
    }
   
}//Ready
