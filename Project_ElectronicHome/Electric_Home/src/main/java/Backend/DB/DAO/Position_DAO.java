/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.Tools.Transformer;
import Backend.DB.Tools.Transformer_SalesPersonSearching;
import Backend.Tools.Tool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author phily
 */
public class Position_DAO {
    private Connection connection = DBMS.initConnection();
    
    private Transformer_SalesPersonSearching transformer;    
    
    public Position_DAO(){
       this.transformer = new Transformer_SalesPersonSearching();
    }
    
    
    private String getSearchPositionsSt(){
        return "SELECT position FROM humanResourcesControl.Position";                
    }
    
    public ArrayList<String> searchPositions(){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getSearchPositionsSt())){            
                
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer.moveBegin(result)){
                return this.transformer.getList(result);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Impossible find the positions",
                 "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: Impossible FIND positions");
        }        
        return new ArrayList<>();
    }
    
    private String searchSalary(){
        return "SELECT payment FROM humanResourcesControl.Position"
             + " WHERE position = ?";
    }
    
    public String searchSalary(String position){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.searchSalary())){            
                
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer.moveBegin(result)){
                return result.getString(1);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Impossible find the SALARY",
                 "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: Impossible FIND positions");
        }        
        return "0";
    }
    
}
