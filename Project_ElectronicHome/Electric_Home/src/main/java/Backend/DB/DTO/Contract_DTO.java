/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Contract_DTO {
    private long _ID;    
    private String _office;//debería ser un onbjeto... 
    private String _position;
    private double _salary;
    private java.util.Date _initialDate;
    private java.util.Date _dueDate;

    public Contract_DTO(long ID, String office, String position, double salary, 
            java.sql.Date initialDate, java.sql.Date dueDate){
        this._ID = ID;
        this._office = office;
        this._position = position;
        this._salary = salary;
        this._initialDate = new java.util.Date(initialDate.getTime());
        this._dueDate = new java.util.Date(dueDate.getTime());
    }
    
    public long getID() {
        return _ID;
    }

    public void setID(long _ID) {
        this._ID = _ID;
    }

    public String getOffice() {
        return _office;
    }

    public void setOffice(String _office) {
        this._office = _office;
    }

    public String getPosition() {
        return this._position;
    }

    public void setPosition(String position) {
        this._position = position;
    }

    public double getSalary() {
        return this._salary;
    }

    public void setSalary(double salary) {
        this._salary = salary;
    }
    
    public java.util.Date getInitialDate() {
        return _initialDate;
    }

    public void setInitialDate(java.util.Date _initialDate) {
        this._initialDate = _initialDate;
    }

    public java.util.Date getDueDate() {
        return _dueDate;
    }

    public void setDueDate(java.util.Date _dueDate) {
        this._dueDate = _dueDate;
    }    
}
