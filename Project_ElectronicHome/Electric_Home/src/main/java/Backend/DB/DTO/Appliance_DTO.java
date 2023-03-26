/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Appliance_DTO {
    private String _name;
    private String _brand;
    private Clasification_DTO _clasification;
    private String _detail;

    public Appliance_DTO(String _name, String _brand, 
            Clasification_DTO _clasification, String _detail) {
        this._name = _name;
        this._brand = _brand;
        this._clasification = _clasification;
        this._detail = _detail;
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

    public Clasification_DTO getClasification() {
        return _clasification;
    }

    public void setClasification(Clasification_DTO _clasification) {
        this._clasification = _clasification;
    }

    public String getDetail() {
        return _detail;
    }

    public void setDetail(String _detail) {
        this._detail = _detail;
    }
    
}
