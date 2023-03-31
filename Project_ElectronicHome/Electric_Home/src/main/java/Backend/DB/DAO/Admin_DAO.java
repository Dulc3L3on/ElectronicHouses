/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.FrontendAuxiliar.ReportAuxiliar;
import Backend.Tools.Tool;
import javax.swing.JEditorPane;

/**
 *
 * @author phily
 */
public class Admin_DAO {
    private Employee_DAO employee_DAO;    
    private Office_DAO officeDAO;
    private Position_DAO positionDAO;
    private Report_DAO report_DAO;
    private ReportAuxiliar reportAuxiliar;
    private Tool tool = new Tool();
    
    public Admin_DAO(JEditorPane editor){
        this.employee_DAO = new Employee_DAO();        
        this.officeDAO = new Office_DAO();
        this.report_DAO = new Report_DAO();     
        this.reportAuxiliar = new ReportAuxiliar(editor);
    }
    
    public Employee_DAO getEmployee_DAO(){
        return this.employee_DAO;
    }
    
    public Office_DAO getOfficeDAO(){
        return this.officeDAO;
    }
    
    public Position_DAO getPositionDAO(){
        return this.positionDAO;
    }
    
    public void getReport1(){
        this.reportAuxiliar
            .getReport1(this.report_DAO
                    .searchReport_4F());
    }
    
    public void getReport2(){
       this.reportAuxiliar
            .getReport2(this.report_DAO
                    .chooseReport(2));
    }
    
    public void getReport3(){
       this.reportAuxiliar
            .getReport3(this.report_DAO
                    .chooseReport(3));
    }
    
    public void getReport4(){
       this.reportAuxiliar
            .getReport4(this.report_DAO
                    .chooseReport(4));
    }
    
    public void getReport5(){
        this.reportAuxiliar
            .getReport5(this.report_DAO
                    .chooseReport(5));       
    }
    
    public void getReport6(){
       this.reportAuxiliar
            .getReport6(this.report_DAO
                    .chooseReport(6));
    }
    
    public void getReport7(){
       this.reportAuxiliar
            .getReport7(this.report_DAO
                    .chooseReport(7));
    }
    
    public void getReport8(){
       this.reportAuxiliar
            .getReport8(this.report_DAO
                    .chooseReportAssembled(8));
    }
    
    public void getReport9(){
       this.reportAuxiliar
            .getReport8(this.report_DAO
                    .chooseReportAssembled(9));
    }
    
    public Tool getTool(){
       return this.tool;
    }
}
