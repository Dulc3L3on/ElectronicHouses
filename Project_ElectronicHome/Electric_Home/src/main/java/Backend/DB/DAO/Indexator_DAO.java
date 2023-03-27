/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phily
 */
public class Indexator_DAO {
    private Connection connection = DBMS.initConnection();    
    
    private String getSerialSt(){
        return "SELECT indice FROM tool.indexator WHERE prefix = ?";//no coloco tableName, porquecon el prefix basta...
    }//Ready
    
    /**
     * Will be used to search the
     * last index that was added to
     * a specific table to show the
     * ID and with that be able to
     * update the value.     
     */
    public long search(String prefix){
        try(PreparedStatement statement = 
            connection.prepareStatement(this.getSerialSt())){            
            
            statement.setString(1, prefix);
            
            ResultSet resultado = statement.executeQuery();
            resultado.first();
            return Long.valueOf(resultado.getString(0)) +1;            
        }catch(SQLException e) {
            System.out.println("Error: impossible to FIND serial IDEXATOR");
        }        
        return -1;
    }//Ready
    
    private String getUpdateSt(){
        return "UPDATE tool.Indexator SET indice = ? WHERE prefix = ?";
    }//Ready
    
    /**
     * It will be used to UPDATE
     * with the value that was given
     * by the search method of
     * this class.
     */
    public boolean update(Long indice){
        try(PreparedStatement statement = 
            connection.prepareStatement(this.getUpdateSt())){
            
            statement.setString(1, indice.toString());
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            System.out.println("Error: impossible to UPDATE serial IDEXATOR");
        }        
        return false;
    }//Ready
    
}//END
