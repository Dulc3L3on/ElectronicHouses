/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.FrontendAuxiliar;

import javax.swing.DefaultCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author phily
 */
public class TableAuxiliar {
    
    /*public void setSpinner(JTable table){
        TableColumn column = table.getColumnModel().getColumn(8);
    
        JSpinner spinner = new JSpinner();        
        
        column. (new DefaultCellEditor(spinner));
    }*///en esta vrs de java, esto ya no funciona. Ahora lo que se debe
    //usar en un TableCellEditor, pero eso hace las cosas más dificiles,
    //entonces lo que haré es simplemente crear un método que permita
    //que al momento de estar editando, no se pase del número que aparece
    //en available
    
}
