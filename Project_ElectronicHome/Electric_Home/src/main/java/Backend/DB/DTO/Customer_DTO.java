/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

import java.util.Date;

/**
 *
 * @author phily
 */
public class Customer_DTO {
   private String _NIT;
   private String _name;
   private String _CUI;
   private String _adress;
   private Date _since;

    public String getNIT() {
        return _NIT;
    }

    public void setNIT(String _NIT) {
        this._NIT = _NIT;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getCUI() {
        return _CUI;
    }

    public void setCUI(String _CUI) {
        this._CUI = _CUI;
    }

    public String getAdress() {
        return _adress;
    }

    public void setAdress(String _adress) {
        this._adress = _adress;
    }

    public Date getSince() {
        return _since;
    }

    public void setSince(Date _since) {
        this._since = _since;
    }
   
}
