/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

/**
 *
 * @author phily
 */
public class Admin_DAO {
    private Employee_DAO employee_DAO;
    private Report_DAO report_DAO;
    
    public Admin_DAO(){
        this.employee_DAO = new Employee_DAO();        
        this.report_DAO = new Report_DAO();        
    }
    
    public Employee_DAO getEmployee_DAO(){
        return this.employee_DAO;
    }
    
    public Report_DAO getReport_DAO(){
        return this.report_DAO;
    }//pending
}
