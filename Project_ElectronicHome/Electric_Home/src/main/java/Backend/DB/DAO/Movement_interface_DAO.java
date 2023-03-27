/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DAO;

import Backend.DB.DBMS;

/**
 *
 * @author phily
 */
public class Movement_interface_DAO {
    private DBMS connection;
    private Movement_DAO movement_DAO;
    
    public Movement_interface_DAO(){
        this.movement_DAO = new Movement_DAO();
    }
    
    /**
     * It will be useful to list
     * all the transfer or shipment
     * that a destinatary has to do
     * and are waitin.
     */
    public void search_pendings(){
    
    }//By: inventary and storage    
  
    public Movement_DAO getMovement_DAO(){
        return this.movement_DAO;
    }
    
    //Method that we will use from Movement_DAO
        //search_movements
        //search_movement (as well, because of the list)
            //pending-transfer/shipment
        //do_movement
    
    //Both methods will depend on the param
    //that MOVEMENT_UI is going to receive
        
}

//Candidata a ser eliminada
