/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Employee_DTO {
    private String _ID;
    private String _CUI;
    private String _name;        
    private String _password;
    private boolean _hired = true;
    private java.util.Date _since;
    
    private Contract_DTO _contract;
    
    public Employee_DTO(String ID, String CUI, String name, String password, 
                        java.sql.Date since, Contract_DTO contract){
        this._ID = ID;
        this._CUI = CUI;
        this._name = name;
        this._password = password;
        this._since = new java.util.Date(since.getTime());
        
        this._contract = contract;
    }

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

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }
    
    public void setHired(boolean isHired){
        this._hired = isHired;
    }//comunmente se empleará para setear en FALSE...

    public boolean getHired(){
        return this._hired;
    }
    
    public java.util.Date getSince() {
        return _since;
    }

    public void setSince(java.util.Date _since) {
        this._since = _since;
    }    
    
    public void setContract(Contract_DTO contract){
        this._contract = contract;
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
