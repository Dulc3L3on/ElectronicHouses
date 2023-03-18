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
public class Sale_DTO {
    private String _code;
    private String _office;
    private String _tender;
    private String _customer;
    private Date _salesDate;
    private double _total;

    public String getCode() {
        return _code;
    }

    public void setCode(String _code) {
        this._code = _code;
    }

    public String getOffice() {
        return _office;
    }

    public void setOffice(String _office) {
        this._office = _office;
    }

    public String getTender() {
        return _tender;
    }

    public void setTender(String _tender) {
        this._tender = _tender;
    }

    public String getCustomer() {
        return _customer;
    }

    public void setCustomer(String _customer) {
        this._customer = _customer;
    }

    public Date getSalesDate() {
        return _salesDate;
    }

    public void setSalesDate(Date _salesDate) {
        this._salesDate = _salesDate;
    }

    public double getTotal() {
        return _total;
    }

    public void setTotal(double _total) {
        this._total = _total;
    }
    
}
