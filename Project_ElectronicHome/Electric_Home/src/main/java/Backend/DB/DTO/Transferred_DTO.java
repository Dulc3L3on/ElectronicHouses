/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

/**
 *
 * @author phily
 */
public class Transferred_DTO {
    private long _code;
    private String _transfer;
    private Stock_DTO _stock_DTO;
    private int _quantity;
    private int sended;
    
    public Transferred_DTO(long _code, String _transfer, Stock_DTO _stock_DTO, int _quantity) {
        this._code = _code;
        this._transfer = _transfer;
        this._stock_DTO = _stock_DTO;
        this._quantity = _quantity;
    }

    public long getCode() {
        return _code;
    }

    public void setCode(long _code) {
        this._code = _code;
    }
    
    public String getTransfer() {
        return _transfer;
    }

    public void setTransfer(String _transfer) {
        this._transfer = _transfer;
    }

    public Stock_DTO getStockDTO() {
        return _stock_DTO;
    }

    public void setProduct(Stock_DTO _stock_DTO) {
        this._stock_DTO = _stock_DTO;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int _quantity) {
        this._quantity = _quantity;
    }

    public int getSended() {
        return sended;
    }

    public void setSended(int sended) {
        this.sended = sended;
    }        
}
