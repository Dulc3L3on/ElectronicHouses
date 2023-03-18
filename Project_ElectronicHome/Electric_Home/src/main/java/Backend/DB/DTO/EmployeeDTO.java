/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

import java.util.Date;

/**
 *
 * @author phily
 */
public class EmployeeDTO {
    private String _ID;
    private String _CUI;
    private String _name;
    private String _position;
    private Date _since;

    public String getID() {
        return _ID;
    }

    public void setID(String _ID) {
        this._ID = _ID;
    }

    public String getCUI() {
        return _CUI;
    }

    public void setCUI(String _CUI) {
        this._CUI = _CUI;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getPosition() {
        return _position;
    }

    public void setPosition(String _position) {
        this._position = _position;
    }

    public Date getSince() {
        return _since;
    }

    public void setSince(Date _since) {
        this._since = _since;
    }    
    
}


//INVENTARY
    //Puede manipular SUS productos
        //ADD (por medio de transfer)
        //SEARCH

//SALES_PERSON
    //Puede manipular CUSTOMERS
        //ADD
        //UPDATE
        //Delete no, porque es algo ilógico

//ADMIN
    //Puede manipular employees
        //ADD
        //UPDATE
        //DELETE
        //SEARCH

//STORE
    //Puede manipular SUS products
        //ADD
        //UPDATE? deplano que si cb el nombre o algo así y tb si debe haacer algo
            //envío?
                //**no ingrsa directamente el producto en la store pero
                //  si MODIF la cuantity, y deja como una nota "hacia quien"
                //**el de INVENTARY se encarga de ingresar lo que recibió
            //transfer
                //lo mismo que el de inventario
                    //eso implicaría add la misma interfaz/tab al de bodega

//pero a mi pensar, debería ser ENVÍO
