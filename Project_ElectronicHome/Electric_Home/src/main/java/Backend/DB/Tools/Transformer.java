/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.Tools;

import Backend.DB.DTO.Appliance_DTO;
import Backend.DB.DTO.Clasification_DTO;
import Backend.DB.DTO.Contract_DTO;
import Backend.DB.DTO.Customer_DTO;
import Backend.DB.DTO.Employee_DTO;
import Backend.DB.DTO.Product_DTO;
import Backend.DB.DTO.Sale_DTO;
import Backend.DB.DTO.Sold_DTO;
import Backend.DB.DTO.Stock_DTO;
import Backend.DB.DTO.Transfer_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Transformer {
    
    public boolean moveBegin(ResultSet resultado){
        try{
            return resultado.first();            
        }catch(SQLException e){
            System.out.println("Error: al colocarse al principio del resultado -> "
                    + e.getMessage());
        }
        return false;
    }//Ready
    
    public ArrayList<Employee_DTO> getEmployees(ResultSet result){
        ArrayList<Employee_DTO> employeeList = new ArrayList<>();
        
         try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                employeeList.add(this.getEmployee(result));
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: seting into EMPLOYEEs");
        }
        return employeeList;
    }//Ready
        
    public Employee_DTO getEmployee(ResultSet result){
        try{
            Employee_DTO employeeDTO = new Employee_DTO(result.getString(1), result.getString(2),
                    result.getString(3), "", null, 
                        new Contract_DTO(result.getLong(1), result.getString(5),
                                result.getString(4), 0, null, null));//Available data: ID, CUI, name, position, office, hired
                              
            employeeDTO.setHired(result.getBoolean(6));
            return employeeDTO;
        }catch (SQLException e) {
            System.out.println("Error: seting an EMPLOYEE");
        }
        
        return null;
    }//Ready
    
    private Contract_DTO createContract(ResultSet result){   
        try{
            return new Contract_DTO(result.getLong(9), result.getString(4), 
            result.getString(7), result.getDouble(8), result.getDate(9),
            result.getDate(10));
        }catch (SQLException e) {
            System.out.println("Error: setting a CONTRACT");
        }
        return null;
    }//Ready
    
    public Employee_DTO getDetailedEmployee(ResultSet result){
        try{
            return new Employee_DTO(result.getString(2), result.getString(1),
                                result.getString(3), result.getString(5),
                                result.getDate(6), this.createContract(result));
        }catch (SQLException e) {
            System.out.println("Error: seting a detailed EMPLOYEE");
        }
        return null;
    }//Ready
    
    public Customer_DTO getCustomer(String NIT, ResultSet result){
        try{
            return new Customer_DTO(NIT, result.getString(1),
                    result.getString(2), result.getString(3),
                    result.getDate(4));
        }catch (SQLException e) {
            System.out.println("Error: seting a detailed EMPLOYEE");
        }
        return null;        
    }    
    
    public Sale_DTO getSale(ResultSet result){
        try{
            return new Sale_DTO(result.getString(1), result.getDouble(4),
                    result.getDouble(5));
        }catch (SQLException e) {
            System.out.println("Error: setting a SALE");
        }
        return null;
    }    
    
    public ArrayList<Sold_DTO> getSolds(ResultSet result){
        ArrayList<Sold_DTO> soldList = new ArrayList<>();
        
         try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                soldList.add(this.getSold(result));
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: setting into SOLDs");
        }
        return soldList;
    }
    
    public Sold_DTO getSold(ResultSet result){
        try{
            return new Sold_DTO(result.getString(1),                
                new Stock_DTO(result.getString(5), new Product_DTO(result.getLong(2), 
                        new Appliance_DTO(result.getString(3), result.getString(4),
                            new Clasification_DTO(0, "", ""), ""),
                        result.getDouble(6)), -1, ""), result.getInt(7),//puesto que es sold, no importa la avaiability y office...
                result.getDouble(8));
        }catch (SQLException e) {
            System.out.println("Error: setting a Sold");
        }
        return null;
    }
    
    public ArrayList<Transfer_DTO> getTransfers(ResultSet result){
        ArrayList<Transfer_DTO> transferList = new ArrayList<>();
        
         try {
            result.last();
            int size = result.getRow();
            result.first();
        
            for (int indice = 0; indice < size; indice++) {                
                transferList.add(this.getTransfer(result));
                result.next();
            }
         } catch (SQLException e) {
            System.out.println("Error: seting into TRANSFERs");
        }
        return transferList;
    }//Ready
        
    public Transfer_DTO getTransfer(ResultSet result){
        try{
            return new Transfer_DTO(result.getString(1), result.getString(6),
                    result.getString(2), result.getString(3), result.getDate(4),
                    result.getDate(5), null, "");//Available data: ID, CUI, name, position, office, hired                              
        }catch (SQLException e) {
            System.out.println("Error: seting an EMPLOYEE");
        }
        
        return null;
    }//Ready
    
    //si vas a querere un STOCK completo, en el orden de product window, usa el getDeailedStock kfrom T_SPS
    
    public Appliance_DTO getAppliance(ResultSet result){
        try{
           return new Appliance_DTO(result.getString(1), result.getString(2),
                       new Clasification_DTO(-1, result.getString(3), result.getString(4)),
                   result.getString(5));
        }catch (SQLException e) {
            System.out.println("Error: seting an APPLIANCE");
        }
        return null;
    }
    
    public Product_DTO getProduct(ResultSet result, Appliance_DTO appliance){
        try{
           return new Product_DTO(result.getLong(1), appliance, result.getDouble(2));
        }catch (SQLException e) {
            System.out.println("Error: seting an PRODUCT");
        }
        return null;
    }
    
    public Stock_DTO getStock(ResultSet result, String office, Product_DTO product){
        try{
           return new Stock_DTO(result.getString(1), product, result.getInt(2) , office);
        }catch (SQLException e) {
            System.out.println("Error: seting an PRODUCT");
        }
        return null;
    }
    
    
}//ENDED
//es que cosas más específicas son las que se mandan a la clase transfoemr específica
//pero las generalaes (que invlucren Entitys without extras entonces xD)
