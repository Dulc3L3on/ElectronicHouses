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
public class Sold_DAO {
    private DBMS connection;

    /**
     * Search a specific SOLD
     * by code. It will be useful
     * when there is a SALE
     * UPDATE to find the next ID
     * so it means that it will
     * return the last ID registered
     * to the specific SALE
     */
    public void findLastID(){
    
    }//By salesPerson
    
    /**
     *It will be useful when we will
     * want DELETE something, 'cause
     * the posi of the row on the table,
     * be the same code that the DB has
     * if there was a previous delete
     * and because we don't know, so...
     */
    public void searchToDelete(){
    
    }//By: salesPerson
     //param: code of product
    
    /**
     * It will be used to add
     * the individual sales
     * that a whole sale has
     * to allow fancy axns.
     */
    public void insert(){
    
    }//By: salesPerson
    
    /**
     * It will be used to delete
     * an individual sale, before
     * the sale was do or already
     * did because of a CAHNGE.
     */
    public void delete(){
    
    }//By: inventaryManager

    //DELETE: Por cada eliminación será necesario que se solicite el code
         //del de inventario, no importando si se app a una UPDATE o no
            //Y puesto que el code se obtendrá al pedirlo, entonces justo
            //después de eso se SEARCH el de inventario corresp y con ese
            //usario (si lo creara [pero en este caso solo se quedará en la
            //búsqueda]) se haría el acceso a la DB y se exe la axn
    
        //AL hacer un DELETE, se hará un INSERT con la axn del DAO inventary    
}
//esto se va a hacer uno por uno
    //pero después o cada vez que se esté agregando???
        //Si es c/v que se esté agregando, entonces o bien
            //usas COMMITs o a partir de los datos de la
            //SOLD que está pro borrarse, obtienes la cdad
            //que debes sumar...
    //si lo haces al final, esntonces solo sería planta, el pedir
    //El código :v 