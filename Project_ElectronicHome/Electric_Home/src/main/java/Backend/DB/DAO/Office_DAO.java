/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.Tools.Transformer;
import Backend.DB.Tools.Transformer_SalesPersonSearching;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Office_DAO {
    private Connection connection = DBMS.initConnection();
    private Transformer transformer;
    private Transformer_SalesPersonSearching transformer_SPS;
    
     public Office_DAO(){
        this.transformer = new Transformer();
        this.transformer_SPS = new Transformer_SalesPersonSearching();
    }
    
    private String getSearchAllSt(){
        return "SELECT name FROM officeControl.Office";
    } 
     
    public ArrayList<String> searchAll(){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchAllSt(), ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE)){
            ResultSet result = statement.executeQuery();
            
            if(result != null && this.transformer_SPS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_SPS.getList(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING all the Offices" +e.getMessage());            
        }
        return null;
    }
    
    private String getSearchOtherSt(){
        return "SELECT name FROM officeControl.Office WHERE name != ?";
    }
    
    /**
     * It will be used to find 
     * other offices that are not
     * the recieved office (current).
     */
    public ArrayList<String> searchOther(String current){
        try(PreparedStatement statement
                = connection.prepareStatement(this.getSearchOtherSt())){
            ResultSet result = statement.executeQuery();
            
            if(result != null && this.transformer_SPS.moveBegin(result)){//Revisa si así dice que está vacío...
                return this.transformer_SPS.getList(result);
            }
        }catch(SQLException e) {
            System.out.println("Error: FINDING other Offices" +e.getMessage());            
        }
        return null;
    }
}
