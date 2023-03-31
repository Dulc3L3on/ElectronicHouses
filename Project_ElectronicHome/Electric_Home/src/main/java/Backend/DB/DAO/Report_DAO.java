/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.Tools.Transformer_Reports;
import Backend.Entity.Reports.Report_3F;
import Backend.Entity.Reports.Report_4F;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Report_DAO {
    private Connection connection = DBMS.initConnection();
    private Transformer_Reports transformerReports;
    private Office_DAO officeDAO;
    
    public Report_DAO(){
        this.transformerReports = new Transformer_Reports();
        this.officeDAO = new Office_DAO();
    }    
    
    /**
     * Top 10: productos 
     * más vendidos.
     */
    private String getSearchReport1(){
        return "SELECT v.product, p.name, s.office, COUNT(p.name) as c"
             + " FROM transactionControl.Sold as v"
             + " INNER JOIN transactionControl.Sale as s ON s.ID = v.sale"
             + " INNER JOIN goodsControl.Product as p ON v.product = p.code"
             + " GROUP BY p.name"
             + " ORDER BY c DESC LIMIT 10";
    }//4F
    //bien podría poner o.name... en lugar del codigo...
    
    /**
     * Top 10: clientes que
     * generan más ganancias.
     */
    private String getSearchReport2(){
        return "SELECT s.customer, c.name, SUM(s.total) as sum"
             + " FROM transactionControl.Sale as s"
             + " INNER JOIN customerControl.Customer as c ON s.customer = c.NIT"
             + " GROUP BY s.customer"
             + " ORDER BY sum DESC LIMIT 10";
    }//3F
     //quienes compran más xD
    
    /**
     * Top 3: sucursales con
     * más ventas.
     */
    private String getSearchReport3(){
        return "SELECT s.office, o.name, COUNT(s.office) as c"
             + " FROM transactionControl.Sale as s"
             + " INNER JOIN officeControl.Office as o ON s.office = o.ID"
             + " GROUP BY s.office"
             + " ORDER BY c DESC LIMIT 3";
    }//3F
    
    /**
     * Top 3: sucursales con más
     * ingresos.
     */
    private String getSearchReport4(){
        return "SELECT s.office, o.name, SUM(s.total) as sum"
             + " FROM transactionControl.Sale as s"
             + " INNER JOIN officeControl.Office as o ON s.office = o.ID"
             + " GROUP BY s.office"
             + " ORDER BY sum DESC LIMIT 3";
    }//3F
    
    /**
     * Top 3: empleados con maś
     * ventas.
     */
    private String getSearchReport5(){
        return "SELECT s.tender, e.name, COUNT(s.tender) as c"
             + " FROM transactionControl.Sale as s"
             + " INNER JOIN humanResourcesControl.Employee as e ON s.tender = e.ID"
             + " GROUP BY s.tender"
             + " ORDER BY c DESC LIMIT 3";
    }//3F
    
    /**
     * Top 3: empleados con más
     * ingresos.
     */
    private String getSearchReport6(){
        return "SELECT s.tender, e.name, SUM(s.total) as sum"
             + " FROM transactionControl.Sale as s"
             + " INNER JOIN humanResourcesControl.Employee as e ON s.tender = e.ID"
             + " GROUP BY s.tender"
             + " ORDER BY sum DESC LIMIT 3";
    }//3F
    
    /**
     * Top 10: productos con más
     * ingresos.
     */
    private String getSearchReport7(){
        return "SELECT v.product, p.name, SUM(v.subtotal) as sum"
             + " FROM transactionControl.Sold as v"
             + " INNER JOIN goodsControl.Product as p ON v.product = p.code"
             + " GROUP BY v.product"
             + " ORDER BY sum DESC LIMIT 10";
    }//3F
    
    /**
     * Top 5: productos más
     * vendidos por sucursal.
     */
    private String getSearchReport8(){
        return "SELECT o.name, v.product, p.name, COUNT(v.product) as c"
             + " FROM transactionControl.Sold as v"
             + " INNER JOIN transactionControl.Sale as s ON v.sale = s.ID"
             + " INNER JOIN officeControl.Office as o ON o.ID = s.office"
             + " INNER JOIN goodsControl.Product as o ON p.code = v.product"
             + " WHERE s.office = ?"
             + " GROUP BY v.product"
             + " ORDER BY c DESC LIMIT 5";
    }//assembled [4]
    //it will be executed by each of the sucursales
    
    /**
     * Top 5: productos con más
     * ingresos por sucursal.
     */
    private String getSearchReport9(){
        return "SELECT o.name, v.product, p.name, SUM(v.subtotal) as sum"
             + " FROM transactionControl.Sold as v"
             + " INNER JOIN transactionControl.Sale as s ON v.sale = s.ID"
             + " INNER JOIN officeControl.Office as o ON o.ID = s.office"
             + " INNER JOIN goodsControl.Product as o ON p.code = v.product"
             + " WHERE s.office = ?"
             + " GROUP BY v.product"
             + " ORDER BY sum DESC LIMIT 5";
    }//assembled  [4]
    
    //el 6 es un reporte repetido    

    /**
     * To send report 1.     
     */
    public ArrayList<Report_4F> searchReport_4F(){
         try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchReport1(), ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){            
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformerReports.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformerReports.getReports_4F(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the REPORT1(3F) -> " +e.getMessage());            
        }
        return null;
    }//aplica a 1
    
    /**
     * To send reports 2-7     
     */    
    public ArrayList<Report_3F> chooseReport(int report){
        return this.searchReport_3F(((report == 2)?this.getSearchReport2()
                                     :((report == 3)?this.getSearchReport3()
                                       :((report == 4)?this.getSearchReport4()
                                         :((report == 5)?this.getSearchReport5()
                                           :((report == 6)?this.getSearchReport6()
                                             :this.getSearchReport7()))))));
    }
    
    private ArrayList<Report_3F> searchReport_3F(String query){
        try(PreparedStatement statement
                = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)){            
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformerReports.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformerReports.getReports_3F(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the REPORT2(2F) -> " +e.getMessage());            
        }
        return null;
    }//aplica a reportes: 2-7
    
    /**
     * To send reports 8-9.     
     */
    public ArrayList<Report_4F> chooseReportAssembled(int report){
        return this.searchAssembledReport(((report == 8)?this.getSearchReport8()
                                            :this.getSearchReport9()));
    }
    
    private ArrayList<Report_4F> searchAssembledReport(String query){
        ArrayList<String> offices = this.officeDAO.searchAll();
        ArrayList<Report_4F> items = new ArrayList<>();
        
        for (int index = 0; index < offices.size(); index++) {
            this.getReport_4F(items, query, offices.get(index));
        }
        
        return items;
    }//aplica a reportes:8 y 9
    
    private void getReport_4F(ArrayList<Report_4F> list, String query, String office){
        try(PreparedStatement statement
                = connection.prepareStatement(query,
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){            
            statement.setString(1, office);
            
            ResultSet result = statement.executeQuery();
         
            if(result != null && this.transformerReports.moveBegin(result)){//Revisa si así dice que está vacío...
                this.transformerReports.setReport_4F(list, result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING the REPORT2(2F) -> " +e.getMessage());            
        }
    }   
    
}
