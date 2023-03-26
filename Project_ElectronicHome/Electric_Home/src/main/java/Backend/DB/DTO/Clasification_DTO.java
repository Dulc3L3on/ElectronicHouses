/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Clasification_DTO {
    private int _ID;
    private String _type;
    private String _line;

    public Clasification_DTO(int _ID, String _type, String _line) {
        this._ID = _ID;
        this._type = _type;
        this._line = _line;
    }

    public int getID() {
        return _ID;
    }

    public void setID(int _ID) {
        this._ID = _ID;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getLine() {
        return _line;
    }

    public void setLine(String _line) {
        this._line = _line;
    }    
    
}
