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
    private int _clasification;
    private String _detail;

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

    public int getClasification() {
        return _clasification;
    }

    public void setClasification(int _clasification) {
        this._clasification = _clasification;
    }

    public String getDetail() {
        return _detail;
    }

    public void setDetail(String _detail) {
        this._detail = _detail;
    }
    
}
