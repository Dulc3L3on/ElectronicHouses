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
public class Contract_DTO {
    private long _ID;
    private String _employee;
    private String _office;
    private Date _initialDate;
    private Date _dueDate;

    public long getID() {
        return _ID;
    }

    public void setID(long _ID) {
        this._ID = _ID;
    }

    public String getEmployee() {
        return _employee;
    }

    public void setEmployee(String _employee) {
        this._employee = _employee;
    }

    public String getOffice() {
        return _office;
    }

    public void setOffice(String _office) {
        this._office = _office;
    }

    public Date getInitialDate() {
        return _initialDate;
    }

    public void setInitialDate(Date _initialDate) {
        this._initialDate = _initialDate;
    }

    public Date getDueDate() {
        return _dueDate;
    }

    public void setDueDate(Date _dueDate) {
        this._dueDate = _dueDate;
    }
    
}
