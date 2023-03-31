/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.FrontendAuxiliar;

import Backend.DB.DAO.Report_DAO;
import Backend.Entity.Reports.Report_3F;
import Backend.Entity.Reports.Report_4F;
import java.util.ArrayList;
import javax.swing.JEditorPane;

/**
 *
 * @author phily
 */
public class ReportAuxiliar {
    private Report_DAO reportDAO;
    private JEditorPane editor;
    
    
    public ReportAuxiliar(JEditorPane editor){
        this.reportDAO = new Report_DAO();
        this.editor = editor;
        editor.setContentType("text/html");
    }
    
    public void getReport1(ArrayList<Report_4F> list){
        String text = "<h2><b><font face='arial'>10 best selling products</font></b></h2><br>" 
                    +"<table>"
                    + "<tr>"
                        + "<td><font color='blue'>No.</font></td>"
                        + "<td><font color='blue'>Code</font></td>"
                        + "<td><font color='blue'>Name</font></td>"
                        + "<td><font color='blue'>Office</font></td>"
                        + "<td><font color='blue'>Number</font></td>"                        
                    + "</tr>";       
        
        text += this.setRows_4F(list);       
        editor.setText(text+"</table>");
    }
    
    public void getReport2(ArrayList<Report_3F> list){
        String text = "<h2><b><font face='arial'>10 generators with most profits</font></b></h2><br>" 
                    +"<table>"
                    + "<tr>"
                        + "<td><font color='blue'>No.</font></td>"
                        + "<td><font color='blue'>NIT</font></td>"
                        + "<td><font color='blue'>Name</font></td>"
                        + "<td><font color='blue'>Total</font></td>"                        
                    + "</tr>";       
        
        text += this.setRows_3F(list);
        editor.setText(text+"</table>");
    }
    
    public void getReport3(ArrayList<Report_3F> list){
        String text = "<h2><b><font face='arial'>3 stores with more sales</font></b></h2><br>" 
                    +"<table>"
                    + "<tr>"
                        + "<td><font color='blue'>No.</font></td>"
                        + "<td><font color='blue'>Office</font></td>"
                        + "<td><font color='blue'>Name</font></td>"
                        + "<td><font color='blue'>Number</font></td>"                        
                    + "</tr>";       
        
        text += this.setRows_3F(list);
        editor.setText(text+"</table>");
    }
    
    public void getReport4(ArrayList<Report_3F> list){
        String text = "<h2><b><font face='arial'>3 stores with more incomes</font></b></h2><br>" 
                    +"<table>"
                    + "<tr>"
                        + "<td><font color='blue'>No</font></td>"
                        + "<td><font color='blue'>Office</font></td>"
                        + "<td><font color='blue'>Name</font></td>"
                        + "<td><font color='blue'>Total</font></td>"                        
                    + "</tr>";       
        
        text += this.setRows_3F(list);
        editor.setText(text+"</table>");
    }
    
    public void getReport5(ArrayList<Report_3F> list){
        String text = "<h2><b><font face='arial'>3 employees with more sales</font></b></h2><br>" 
                    +"<table>"
                    + "<tr>"
                        + "<td><font color='blue'>No.</font></td>"
                        + "<td><font color='blue'>Tender</font></td>"
                        + "<td><font color='blue'>Name</font></td>"
                        + "<td><font color='blue'>Number</font></td>"                        
                    + "</tr>";       
        
        text += this.setRows_3F(list);
        editor.setText(text+"</table>");
    }
    
    public void getReport6(ArrayList<Report_3F> list){
        String text = "<h2><b><font face='arial'>3 employees with more incomes</font></b></h2><br>" 
                    +"<table>"
                    + "<tr>"
                        + "<td><font color='blue'>No.</font></td>"
                        + "<td><font color='blue'>Tender</font></td>"
                        + "<td><font color='blue'>Name</font></td>"
                        + "<td><font color='blue'>Total</font></td>"                        
                    + "</tr>";       
        
        text += this.setRows_3F(list);
        editor.setText(text+"</table>");
    }
    
    public void getReport7(ArrayList<Report_3F> list){
        String text = "<h2><b><font face='arial'>10 products with more incomes</font></b></h2><br>" 
                    +"<table>"
                    + "<tr>"
                        + "<td><font color='blue'>No.</font></td>"
                        + "<td><font color='blue'>Product</font></td>"
                        + "<td><font color='blue'>Name</font></td>"
                        + "<td><font color='blue'>Total</font></td>"                        
                    + "</tr>";       
        
        text += this.setRows_3F(list);
        editor.setText(text+"</table>");
    }
    
    public void getReport8(ArrayList<Report_4F> list){
        String text = "<h2><b><font face='arial'>5 best-selling products by store</font></b></h2><br>" 
                    +"<table>"
                    + "<tr>"
                        + "<td><font color='blue'>No.</font></td>"
                        + "<td><font color='blue'>Office</font></td>"
                        + "<td><font color='blue'>Product</font></td>"
                        + "<td><font color='blue'>Name</font></td>"
                        + "<td><font color='blue'>Number</font></td>"                        
                    + "</tr>";       
        
        text += this.setRows_4F(list);       
        editor.setText(text+"</table>");
    }
    
    public void getReport9(ArrayList<Report_4F> list){
        String text = "<h2><b><font face='arial'>5 products with more profits</font></b></h2><br>" 
                    +"<table>"
                    + "<tr>"
                        + "<td><font color='blue'>No.</font></td>"
                        + "<td><font color='blue'>Office</font></td>"
                        + "<td><font color='blue'>Product</font></td>"
                        + "<td><font color='blue'>Name</font></td>"
                        + "<td><font color='blue'>Total</font></td>"                        
                    + "</tr>";       
        
        text += this.setRows_4F(list);       
        editor.setText(text+"</table>");
    }
    
    private String setRows_4F(ArrayList<Report_4F> list){
        String text = "";
        
        for (int row = 0; row < list.size(); row++) {
            text+= "<tr>"
                        + "<td>"+(row+1)+"</td>"
                        + "<td>"+list.get(row).getField1()+"</td>"
                        + "<td>"+list.get(row).getField2()+"</td>"
                        + "<td>"+list.get(row).getField3()+"</td>"
                        + "<td>"+list.get(row).getField4()+"</td>"                        
                  + "</tr>";
        }        
        return text;
    }
    
    private String setRows_3F(ArrayList<Report_3F> list){
        String text = "";
        
        for (int row = 0; row < list.size(); row++) {
            text+= "<tr>"
                        + "<td>"+(row+1)+"</td>"
                        + "<td>"+list.get(row).getField1()+"</td>"
                        + "<td>"+list.get(row).getField2()+"</td>"
                        + "<td>"+list.get(row).getField3()+"</td>"                                              
                  + "</tr>";
        }        
        return text;
    }
    
    
}
