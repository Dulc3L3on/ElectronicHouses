/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Sale_DTO {
    private String _code;
    private String _office;
    private String _tender;
    private Customer_DTO _customer;
    private java.util.Date _salesDate;
    private double _subtotal;
    private double _percentage;
    private double _disccount;
    private double _total;
    private double _pastTotal;//porque aquí se guardará la cdad antigua...
    
    public Sale_DTO(String code, Customer_DTO customer, java.sql.Date salesDate,
            double subtotal, double percentage, double disccount, double total){
        this._code = code;
        this._customer = customer;
        this._salesDate = new java.util.Date(salesDate.getTime());
        this._subtotal = subtotal;
        this._percentage = percentage;
        this._disccount = disccount;
        this._total = total;
    }
    
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

    public Customer_DTO getCustomer() {
        return _customer;
    }

    public void setCustomer(Customer_DTO _customer) {
        this._customer = _customer;
    }

    public java.util.Date getSalesDate() {
        return _salesDate;
    }

    public void setSalesDate(java.util.Date _salesDate) {
        this._salesDate = _salesDate;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }    
    
    public double getPercentage() {
        return _percentage;
    }

    public void setPercentage(double percentage) {
        this._percentage = percentage;
    }
    
    public double getDisccount() {
        return _disccount;
    }

    public void setDisccount(double _disccount) {
        this._disccount = _disccount;
    }

    public double getTotal() {
        return _total;
    }

    public void setTotal(double _total) {
        this._total = _total;
    }
    
    public double getPastTotal() {
        return _pastTotal;
    }

    public void setPastTotal(double pastTotal) {
        this._pastTotal = pastTotal;
    }
    
}
