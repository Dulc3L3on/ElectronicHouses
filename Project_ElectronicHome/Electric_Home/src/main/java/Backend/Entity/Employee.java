/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Entity;

/**
 *
 * @author phily
 */
public record Employee(String type, String ID, String CUI, 
                        String name, String password) {
    
    //a menos que hiciera una página para que el empleado pueda usar
    //solo para su persona (como cosmos o una simple donde cheque sus
    //statistic and data) entonces since si valdría la pena.
    
}//RECUERDA que estas clases, que están en entidad será empleadas
 //para almacenar info persistente, no como los DTO que se encargan de almacenar
 //data que está super propensa a cambiar.
