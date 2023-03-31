/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.FrontendAuxiliar;

import Backend.DB.DTO.Sold_DTO;
import Backend.DB.DTO.Stock_DTO;
import Backend.DB.DTO.Transfer_DTO;
import Backend.DB.DTO.Transferred_DTO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phily
 */
public class TableAuxiliar {
   
    /**
     * It will be used when
     * a CHANGE on sale is
     * requested.
     */

    public void setAlreadyList(JTable tabla, ArrayList<Sold_DTO> data){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        clear(modelo, tabla);        
        
        for(int index = 0; index < data.size(); index++) {
            modelo.addRow
                (new Object[]
                    {data.get(index).getCode(), 
                     data.get(index).getStockDTO().getProduct().getAppliance().getName(), 
                     data.get(index).getStockDTO().getProduct().getAppliance().getBrand(),
                     data.get(index).getStockDTO().getID(),
                     data.get(index).getStockDTO().getProduct().getPrice(),
                     data.get(index).getStockDTO().getQuantity(),
                     data.get(index).getSubtotal()});
        }
        //serial, code, name, brand, stockID, price, quantity, subtotal
    }//READY: a pesar del nombre general, no aplica a transferred, puesto que no es función del salesPerson
     //el ver estas solicitudes.
    
    public void setSimilar(JTable tabla, ArrayList<Stock_DTO> data){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        clear(modelo, tabla);        
        
        for(int index = 0; index < data.size(); index++) {
            modelo.addRow
                (new Object[]
                    {data.get(index).getProduct().getID(), 
                     data.get(index).getProduct().getAppliance().getName(),
                     data.get(index).getProduct().getAppliance().getBrand(),
                     data.get(index).getID(),
                     data.get(index).getQuantity(),
                     data.get(index).getProduct().getPrice()});
        }//code, name, brand, stockID, available, price
    }
    
    /**
     * It will be used to Sold_DTO
     * and as well with transferred_DTO
     */
    public void setAlready(JTable tabla, Sold_DTO data1, Transferred_DTO data2){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        modelo.addRow
                (new Object[]
                    {((data1!=null)?data1.getCode():data2.getCode()),
                     ((data1!=null)?data1.getStockDTO().getProduct().getID()
                                   :data2.getStockDTO().getProduct().getID()),
                     ((data1!=null)?data1.getStockDTO().getProduct()
                                                    .getAppliance().getName()
                                   :data2.getStockDTO().getProduct()
                                                    .getAppliance().getName()),
                     ((data1!=null)?data1.getStockDTO().getProduct()
                                                   .getAppliance().getBrand()
                                   :data2.getStockDTO().getProduct()
                                                   .getAppliance().getBrand()),
                     ((data1!=null)?data1.getStockDTO().getID()
                                   :data2.getStockDTO().getID()),
                     ((data1!=null)?data1.getStockDTO().getProduct().getPrice()
                                   :data2.getStockDTO().getProduct().getPrice()),
                     ((data1!=null)?data1.getStockDTO().getQuantity()
                                   :data2.getStockDTO().getQuantity()),
                     ((data1!=null)?data1.getSubtotal()
                                   :"--")});
    }
    
    public void setInventaryTab(JTable tabla, ArrayList<Stock_DTO> data){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        clear(modelo, tabla);        
        
        for(int index = 0; index < data.size(); index++) {
            modelo.addRow
                (new Object[]
                    {data.get(index).getProduct().getID(), 
                     data.get(index).getOffice(),
                     data.get(index).getProduct().getAppliance().getName(),
                     data.get(index).getProduct().getAppliance().getBrand(),
                     data.get(index).getID(),
                     data.get(index).getQuantity(),
                     data.get(index).getProduct().getPrice()});
        }//code, name, brand, stockID, available, price
    }
    
    public void setTransferTable(JTable table, ArrayList<Transfer_DTO> data){
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        
        clear(modelo, table);        
        
        for(int index = 0; index < data.size(); index++) {
            modelo.addRow
                (new Object[]
                    {data.get(index).getOrigin(), 
                     data.get(index).getDestiny(),
                     data.get(index).getSince(),
                     data.get(index).getUntil(),
                     data.get(index).getState()});
        }
    }
    
    public void clear(DefaultTableModel modelo, JTable tabla){
        try {            
            while(tabla.getRowCount()>0){
                modelo.removeRow(0);                
            }            
            tabla.updateUI();
        } catch (Exception e) {
            System.out.println("Error al limpiar la tabla" + e.getMessage());
        }        
    }    
    
    public int getNumberOfRows(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        return model.getRowCount();        
    }
    
}
