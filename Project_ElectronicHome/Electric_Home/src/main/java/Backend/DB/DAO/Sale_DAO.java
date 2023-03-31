/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;
import Backend.DB.DTO.Sale_DTO;
import Backend.DB.Tools.Transformer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author phily
 */
public class Sale_DAO {
    private Connection connection = DBMS.initConnection();
    private Transformer transformer;
    private Indexator_DAO indexator;
    
    public Sale_DAO(){
        this.transformer = new Transformer();
        this.indexator = new Indexator_DAO();
    }
    
    private String getWasEditSt(){
        return "SELECT total, pastTotal FROM transactionControl.Sale WHERE ID = ?";
    }
    
    /**
     * It will be used to check if
     * a sale was already CHANGEd     
     */
    public int wasEdit(String sale){
        try(PreparedStatement statement = connection.prepareStatement(this.getWasEditSt())){//si falla, ya sabes que add xd            
            statement.setString(1, sale);
            
            ResultSet result = statement.executeQuery();
            
            if(result!=null && transformer.moveBegin(result)){                
                if(result.getDouble(2) == 0){
                    return 1;
                }else{
                    JOptionPane.showConfirmDialog(null, "This sale was already CHANGED.\n"
                        + "The last amount "+ result.getDouble(1)+"was changed by"
                        + result.getDouble(2) + ".\nImpossible to proceed", "Already did",
                        JOptionPane.DEFAULT_OPTION);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect ID, check it"
                        + "\n and try again.", "Invalid SALE-ID", JOptionPane.ERROR_MESSAGE);
                return 3;
            }       
        }catch(SQLException e) {
            System.out.println("Error: al buscar an EMPLOYEE -> " +e.getMessage());
        }        
        return 2;
    }//1 = C, 2 = Error, 3 = NExiste
    
    private String getPreviousAmountSt(){
        return "SELECT total FROM transactionControl.Sale WHERE ID = ?";
    }
    
    /**
     * It will be used to obtain
     * the prevoius amount (total
     * prev a update) that is going
     * to be turn onto pastTotal.
     */
    public double searchPreviousAmount(String ID){
        try(PreparedStatement statement = connection.prepareStatement(this.getPreviousAmountSt())){
            statement.setString(1, ID);
                
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer.moveBegin(result)){
                return result.getDouble(1);
            }
        }catch(SQLException e){            
            System.out.println("Error: Impossible FIND a PAST_TOTAL");
        }        
        return 0;
    }
    
    public String searchActualID(){
        return ""+this.indexator.search("SID");//y así con las 4 restantes
    }
    
    public void updateID(){
        this.indexator.update("SID");//y así con las 4 restantes
    }
    
    private String getSearchingSt(){
        return "SELECT s.ID, c.NIT, c.name, c.CUI, c.address, c.since, s.salesDate"
             + " SUM(v.subtotal), (SUM(v.subtotal)*s.disccount), s.disccount, s.total"
             + " FROM transactionControl.Sale as s"
             + " INNER JOIN customerControl.Customer as c ON c.NIT = s.customer"
             + " INNER JOIN transactionControl.Sold as v ON v.sale = s.ID"
             + " WHERE s.ID = ?";
    }//AL final no usé el JOIN, porque si colocaba lo de las SOLD no sé como se 
    //hubiera guardado la data de SALE, ya que es UNA sola fila. Imagino que se
    //Repetiría esa misma data en cada una de las lineas generadas debido a SOLD...
    
    /**
     * It will be useful to
     * set the Sale header 
     * when there is requested
     * a CHANGE of this.
     */
    public Sale_DTO search(String ID){
        try(PreparedStatement statement = connection.prepareStatement(this.getSearchingSt())){
            statement.setString(1, ID);
                
            ResultSet result = statement.executeQuery();
            
            if(result!= null && this.transformer.moveBegin(result)){
                return this.transformer.getSale(result);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Impossible find the Sale.\n"
                   + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: Impossible FIND a Sale");
        }
        
        return null;
    }//By: salesPerson
    
    private String getDisccountSt(){
        return "SELECT total FROM transactionControl.Sale WHERE customer = ?"
             + "ORDER BY salesDate DESC LIMIT 1";//yo diría que DESC es del más antiguo al más reciente...
    }
    
    /**
     * It will be used to SALEs,
     * specifically after enter
     * or have the customer, 'cause
     * with this we will be able to
     * find the last SALE.
     * 
     */
    public double searchDisccount(String NIT){
        try(PreparedStatement statement = 
                connection.prepareStatement(this.getDisccountSt())){
            
            double amount = statement.executeQuery().getDouble(1);
            
            if(amount >= 1000 && amount < 5000){
                return 0.02;
            }else if(amount >= 5000 && amount < 10000){
                return 0.05;
            }else if(amount >= 10000){
                return 0.1;
            }
            
        }catch(SQLException e){            
            JOptionPane.showMessageDialog(null, "Impossible to CREATE the Customer."
                                        + "\n Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: creating a Customer" + e.getMessage());
        }        
        return 0;//ya sea porque hubo error, o porque no tenía xD para no provocar problemas (bine podría enviar 0 cuando es < a 1000, y -1 cuando hay error, pero que se quede así general, con esa excusa xD
    }//se usará antes de INSERT
       
    private String getInsertionSt(){
        return "INSERT INTO transactionControl.Sale (ID, office, tender, "
                + "customer, disccount) VALUES (?,?,?,?,?)";
    }
    
    /**
     * To insert/create the whole
     * sale that a customer did.
     */
    public void insert(String ID, String office, String tender,
            String customer, Double disccount){
        
        try(PreparedStatement statement = 
                connection.prepareStatement(this.getInsertionSt())){
            statement.setString(1, ID);
            statement.setString(2, office);
            statement.setString(3, tender);
            statement.setString(4, customer);
            statement.setDouble(4, disccount);
            
            statement.executeUpdate();
        }catch(SQLException e){            
            JOptionPane.showMessageDialog(null, "Impossible to create the Customer."
                                        + "\n Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: creating a Customer" + e.getMessage());
        }       
    }//By: salesPerson
     //Ready
    
    private String getCompleteInsertionSt(){
        return "UPDATE transactionControl.Sale subtotal = ?, total = ?"
             + " WHERE ID = ? ";
    }//Ready
    
    /**
     * It will be used when a sale
     * is already ended.
     */
    public boolean completeInsert(String ID, double subtotal, double total){//el subtotal se sacará con la función SUM(table.column)
        
        try(PreparedStatement statement = connection.prepareStatement
                (this.getCompleteInsertionSt())){            
            
            statement.setDouble(1, subtotal);
            statement.setDouble(2, total);
            statement.setString(3, ID);
                
            statement.executeUpdate();
            return true;
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: ENDING the sale"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: impossible to COMPLETE the sale");
        }        
        return false;
    }//Ready
    
    private String getUpdateSt(){
        return "UPDATE transactionControl.Sale SET subtotal = ?, pastTotal = ?,"
             + " total =  ? WHERE ID = ?";
    }
    
    /**
     * To do a CHANGE because there
     * was an issue with the original
     * product.
     */
    public boolean update(String ID, double subtotal, double pastTotal,
            double total){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getUpdateSt())){
            
            statement.setDouble(1, subtotal);
            statement.setDouble(1, pastTotal);
            statement.setDouble(2, total);
            statement.setString(3, ID);
            
            statement.executeUpdate();
            return true;            
        }catch(SQLException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Impossible update the sale.\n"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al UPDATE the Sale -> "+ e.getMessage());
        }
        return false;        
    }//BY and allow: inventory
    
    private String getDeleteSt(){
        return "DELETE FROM transactionControl.Sale WHERE ID = ?";
    }
    
    /**
     * It could be done JUST if
     * it will be applied to a 
     * SALE and not a CHANGE (I
     * mean before the factura
     * and no to return. And when
     * after delete a SOLD there
     * is no more solds there.
     */
    public boolean delete(String ID){
        try(PreparedStatement statement 
                = connection.prepareStatement(this.getDeleteSt())){
            
            statement.setString(1,ID);
            
            statement.executeUpdate();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Impossible DELETE the Sale.\n"
                    + "Try one more time.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al deshacer la TRANSACCION: "+ e.getMessage());
        }
        
        return false;   
    }//BY: sales person, (allowed) inventary
        //Se exe, cuando ya no quede ninguna SOLDs
        
    
    //CHANGE de articulos (porque no hay devolución de dinero)
        //1. crear el UPDATE, porque poisblemente el amount se modif
            //1.2. esto se hará en apoyo del delete, posiblemente
                //esto si en caso no hay otro producto igual
                //pero eso quiere decir que debo add un campo CHANGE
                //a SALE para que se deje constancia
        //2. hacer un método en JAVA que
            //2.1 se encargue de revisar que el tiempo no sea mayor a
                //6 meses... pero depano que se hará con los meses porque
                //así exacto no se como hacerlo
            //2.2 cobre el restante si es que add más
                //no habrá devolución de dinero si lo que escoge vale menos...
            
    //UPDATE: aunque por la defi del proyecto, creo que esta axn no está
            //obligada que sea ejecutada por el de inventario, pero como
            //para que no sea hecha así nada más, está bine
            
            //entonces el código solo se usará para eso y no para registrar
            //la modificaión, porque al final de cuentas es una venta y eso
            //lo hace el salesPerson.
    
    //con respecto al método, tb tendrá que revisar que el campo de EDIT, sea
    //falso, para proceder. Sé que se va a marcar con un sello, pero así sería
    //más seguro.
    
    //recuerda, que lo neuvo, se add después de lo que ya está
        //solo que creo que no se podría modif la PK, entonces todo
        //tendrá que ser en base a lo que se insertó de último, aunque
        //no haya correlación
            //A menos que se borre el único elemento
            //De todos modos no habrá problema porque para hallar el ID
            //Se hará con una query...
}
