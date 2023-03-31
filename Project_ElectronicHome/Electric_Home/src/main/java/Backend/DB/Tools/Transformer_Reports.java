/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.Tools;

import Backend.Entity.Reports.Report_3F;
import Backend.Entity.Reports.Report_4F;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Transformer_Reports {
    
    public boolean moveBegin(ResultSet resultado){
        try{
            return resultado.first();            
        }catch(SQLException e){
            System.out.println("Error: al colocarse al principio del resultado -> "
                    + e.getMessage());
        }
        return false;
    }//Ready
    
    public ArrayList<Report_3F> getReports_3F(ResultSet result){
        ArrayList<Report_3F> report3FtList = new ArrayList<>();
        
         try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                report3FtList.add(this.getReport_3F(result));
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: seting into EMPLOYEEs");
        }
        return report3FtList;       
    }
    
    private Report_3F getReport_3F(ResultSet result){
        try{
            return new Report_3F(result.getString(1), result.getString(2),
                result.getString(3));//solo que al pedir para result, debes fijarte que estén en el orden en el cual quieres mostrarlo, porque de lo contrario no se mostrará lo que es xD
        }catch (SQLException e) {
            System.out.println("Error: seting a REPORT_2F");
        }        
        return null;
    }
    
    public ArrayList<Report_4F> getReports_4F(ResultSet result){
        ArrayList<Report_4F> repor4FtList = new ArrayList<>();
        
         try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                repor4FtList.add(this.getReport_4F(result));
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: seting into EMPLOYEEs");
        }
        return repor4FtList;
    }
    
    private Report_4F getReport_4F(ResultSet result){
        try{
            return new Report_4F(result.getString(1), result.getString(2), 
                    result.getString(3), result.getString(4));//solo que al pedir para result, debes fijarte que estén en el orden en el cual quieres mostrarlo, porque de lo contrario no se mostrará lo que es xD
        }catch (SQLException e) {
            System.out.println("Error: seting a REPORT_3F");
        }        
        return null;
    }
    
    public void setReport_4F(ArrayList<Report_4F> list,
            ResultSet result){        
        try{
            list.add(new Report_4F(result.getString(1), result.getString(2), 
                    result.getString(3), result.getString(4)));//solo que al pedir para result, debes fijarte que estén en el orden en el cual quieres mostrarlo, porque de lo contrario no se mostrará lo que es xD
        }catch (SQLException e) {
            System.out.println("Error: seting a REPORT_3F");
        }
    }
}
