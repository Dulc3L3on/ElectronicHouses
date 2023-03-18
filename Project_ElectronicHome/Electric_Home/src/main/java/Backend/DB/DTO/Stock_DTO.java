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
    private int _cuantity;
    private String _office;

    public String getID() {
        return _ID;
    }

    public void setID(String _ID) {
        this._ID = _ID;
    }

    public int getCuantity() {
        return _cuantity;
    }

    public void setCuantity(int _cuantity) {
        this._cuantity = _cuantity;
    }

    public String getOffice() {
        return _office;
    }

    public void setOffice(String _office) {
        this._office = _office;
    }
    
}
