/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 *
 * @author phily
 */
public class Tool {
    
    public java.util.Date toUtilDate(String date){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            return formatoFecha.parse(date);
     
        } catch (ParseException ex) {
            System.out.println("Error: turning to Util.Date");
        }        
        return null;        
    }
    
    public java.sql.Date toSQLDate(String date){
        return new java.sql.Date(this.toUtilDate(date).getTime());
    }
    
    public String generatePwd(){
        Random caracterAleatorio = new Random();
        Random tamanioAleatorio = new Random();
        String contrasenia = "";
        
        int tamanio = 8 + tamanioAleatorio.nextInt(13);//recuerda que comieza desde 0...
        
        for (int caracterActual = 0; caracterActual < tamanio; caracterActual++) {            
            contrasenia+= Character.toString(33+caracterAleatorio.nextInt(94));            
        }
        
        return contrasenia;
    }
    
}//se empleará para otra cosa
