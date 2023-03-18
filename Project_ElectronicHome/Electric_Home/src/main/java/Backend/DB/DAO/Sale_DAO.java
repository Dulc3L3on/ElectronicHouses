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
public class Sale_DAO {
    private DBMS connection;
    
    /**
     * It will be useful to
     * a CHANGE of sale.
     */
    public void search(){
    
    }//By: salesPerson
    
    /**
     * It will be used to SALEs,
     * specifically after enter
     * or have the customer, 'cause
     * with this we will be able to
     * find the last SALE.
     * 
     */
    public void searchDisccount(){
    
    }
    
    /**
     * To insert/create the whole
     * sale that a customer did.
     */
    public void insert(){
        
                
    }//By: salesPerson
    
    /**
     * To do a CHANGE because there
     * was an issue with the original
     * product.
     */
    public void update(){
    
    }//BY and allow: inventory
    
    /**
     * It could be done JUST if
     * it will be applied to a 
     * SALE and not a CHANGE.
     */
    /*public void delete(){
        //A menos que sea antes de pagar, se podrá
        //hacer, pero no es obligatorio, Si quieres
        //lo haces si no no.
    }*///BY: sales person, (allowed) inventary
        //there will no more changes that delete a sale
        //but I think you only will ask for the code
        //to have a testified, because that is not a
        //job for an inventory manager (based on proj rules)
    
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
