/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Employee_DTO;
import Backend.DB.Tools.Transformer;
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
public class Employee_DAO {
    private Connection connection = DBMS.initConnection();
    
    private Contract_DAO contract_DAO;
    private Transformer transformer;
    
    public Employee_DAO(){
        this.contract_DAO = new Contract_DAO();
        this.transformer = new Transformer();
    }    
    
    private String getEmployeesSt(String name, String office, String[] position,
                                    String orderBy){
        boolean where = false;        
        String search = "SELECT e.ID e.CUI, e.name, c.position, c.office e.hired"
                     + " FROM humanResourcesControl.Employee as e INNER JOIN"
                     + " humanResourcesControl.Contract as c ON e.ID = c.employee";
        
        if(name != null){
            search += " WHERE e.name = ?";
            where = true;
        }        
        if(!office.equals("All")){            
            search += ((!where)?" WHERE":" AND") + " c.office = ?";
            if(!where) where = true;
        }
        if(position != null && !position[0].equals("All")){
            for(int indice = 0; indice < position.length; indice++) {
                search += ((!where)?" WHERE":" AND") + " c.position = ?";
                if(!where) where = true;
            }
        }
        
        return (search += "ORDER BY e."+ orderBy +", e.hired");//puesto que es ordery by, colocaremos directamente la data
        //orderBy, includes, by what and the type of order.
    }//READY
    
    /**
     * It will be used when an ADMIN
     * wants to search a list of employees
     * because of the filters os simply
     * finds one but by name.
     * 
     */
    public ArrayList<Employee_DTO> search_employees(String name, String office,
                                                String[] position, String orderBy){
        int index = 1;
        
        try(PreparedStatement statement = 
            connection.prepareStatement(getEmployeesSt(name, office, position, orderBy))){
        
            if(name != null){
                statement.setString(index, name);
                index++;
            }        
            if(!office.equalsIgnoreCase("all")){
                statement.setString(index, office);
                index++;
            }
            if(position != null && !position[0].equalsIgnoreCase("all")){
                for(int indice = 0; indice < position.length; indice++) {
                    statement.setString(indice+index, position[indice]);
                }
            }
            
            ResultSet resultado = statement.executeQuery();
            
            if(transformer.moveBegin(resultado)){
                return transformer.getEmployees(resultado);
            }            
        }catch(SQLException e) {
            System.out.println("Error: impossible to find EMPLOYEEs");
        }
        
        return new ArrayList<>();
    }//READY
    
    private String getEmployeeSt(){
        return "SELECT e.ID e.CUI, e.name, c.position, c.office e.hired"
             + " FROM humanResourcesControl.Employee as e INNER JOIN"
             + " humanResourcesControl.Contract as c ON e.ID = c.employee"             
             + " WHERE e.ID = ?";
    }//READY
    
    /**
     * Yo entiendo que esto será empleado
     * cuando el admin decida buscar a un
     * empleado específico, por su ID...
     *
     */
    public Employee_DTO search_employee(String ID){
        try(PreparedStatement statement = 
            connection.prepareStatement(getEmployeeSt())){            
            
            statement.setString(1, ID);            
            
            ResultSet resultado = statement.executeQuery();
            
            if(transformer.moveBegin(resultado)){
                return transformer.getEmployee(resultado);
            }            
        }catch(SQLException e) {
            System.out.println("Error: impossible to find EMPLOYEE");
        }
        
        return null;
    }//READY
    
    private String getSelectedEmployeeSt(){
        return "SELECT e.CUI e.ID, e.name, c.office, e.password, e.since,"
             + " p.position, p.salary, c.ID, c.initialDate, c.dueDate"
             + " FROM humanResourcesControl.Employee as e"
             + " INNER JOIN humanResourcesControl.Contract as c ON e.ID = c.employee"
             + " INNER JOIN humanResourcesControl.Position as p c.position = p.position"
             + " WHERE e.ID = ?";
    }//READY
    
    /**
     * YO entiendo que fue hecho para mostrar
     * los datos del employee seleccionado, en
     * la ventana para mostrar con detalle esto.
     */
    public Employee_DTO search_selectedEmployee(String ID){
        try(PreparedStatement statement = 
            connection.prepareStatement(getSelectedEmployeeSt())){            
            
            statement.setString(1, ID);            
            
            ResultSet resultado = statement.executeQuery();
            
            if(transformer.moveBegin(resultado)){
                return transformer.getDetailedEmployee(resultado);
            }            
        }catch(SQLException e) {
            System.out.println("Error: impossible to find EMPLOYEES");
        }
        
        return null;
    }//READY
    
    private String getInsertionSt(){
        return "INSERT INTO humanResourcesControl.Employee (ID, CUI, name, password) "
             + "VALUES (?,?,?,?)";
    }
    
    /**
     * It will be used to add a new
     * Employee, doesn't matter the
     * position.
     * 
     */
    public void insert(String ID, String CUI, String name, String password,
            String office, String position, String dueDate){
        boolean correct = true;
        
         try(PreparedStatement statement = 
                connection.prepareStatement(this.getInsertionSt())){
            statement.setString(1, ID);
            statement.setString(2, CUI);
            statement.setString(3, name);
            statement.setString(4, password);
            
            statement.executeUpdate();
            
            correct = this.contract_DAO.insert(true, ID, office, position, dueDate);
        }catch(SQLException e){
            correct = false;
            System.out.println("Error: creating an EMPLOYEE" + e.getMessage());
        }
         
         if(!correct){
            JOptionPane.showMessageDialog(null, "Error trying to ADD an employee."
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
         }      
    }//Ready
    
    private String getUpdateSt(boolean name, boolean pwd){//at least one of them has to be true
       return "UPDATE humanResourcesControl.Employee SET "
               + ((name)?"name = ?":"")+ ((name && pwd)?", ":"") +((pwd)?"password = ?":"") 
               + " WHERE ID = ?";
    }
    
    public boolean update(String ID, String name, String pwd){//we are going to compare the last values with the values after press ADD to know if there was an update
        int index = 1;
        
        try(PreparedStatement statement = connection.prepareStatement
                (this.getUpdateSt((name!= null), (pwd != null)))){
            
            if(name != null){
                statement.setString(index, name);
                index++;
            }
            if(pwd != null){
                statement.setString(index, pwd);
                index++;
            }            
            statement.setString(index, ID);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: UPDATing an Customer"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: impossible UPDATE an Employee");
        }        
        return false;
    }
    
    public String getHiringSt(){
        return "UPDATE humanResourcesControl.Employee SET hired = ?"
             + " WHERE ID = ?";
    }
    
    public boolean update_Firing(String ID, boolean hired){
        try(PreparedStatement statement = 
            connection.prepareStatement(this.getHiringSt())){
            
            statement.setBoolean(1, hired);//puesto que se puede volver a contratar a alguien, entonces...
            statement.setString(2, ID);         //Dicha recontratación se hará en ADD puesto que 1ro se buscará
                                                //luego se creará el CONTRACT y el employee solo se UPDATE
            statement.executeUpdate();                  //los pasos serían los mismos que al RENEWED un contract
            return true;                                //solo que esta vez se add este UPDATE
        }catch(SQLException e) {
            System.out.println("Error: impossible to FIRE an Employee");
        }        
        return false;
    
    }/*NOT DELETE because a company always has records of every single employee,
       to know if they can hired again or not
            ALso I could add reason, but that means that I have to add another
            field on the same window or do another window y no quiero*/
    
}
