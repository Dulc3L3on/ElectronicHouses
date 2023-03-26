/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DB.DTO;

import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class Transfer_DTO {
    private String _code;
    private String _state;
    private String _origin;
    private String _destiny;
    private java.util.Date _since;
    private java.util.Date _until;
    private java.util.Date _did;
    private String _reason;//pero lo debes pasar a blob o no se porque en realidad es un TEXT

    //no dejé aquí la lista de TRANSFERRED puesto que sale tpco la tien
    //ya que cuando se requería en una ventana el acoplamiento de ambos
    //se buscaba por separado y así se enviaba para ser seteado...
        //lo cual es mucho más fácil xD
    
    public Transfer_DTO(String _code, String _state, String _origin, String _destiny,
        java.sql.Date _since, java.sql.Date _until, java.sql.Date _did, String _reason) {
        this._code = _code;
        this._state = _state;
        this._origin = _origin;
        this._destiny = _destiny;
        this._since = _since;
        this._until = _until;
        this._did = _did;
        this._reason = _reason;
    }    
    
    public String getCode() {
        return _code;
    }

    public void setCode(String _code) {
        this._code = _code;
    }

    public String getState() {
        return _state;
    }

    public void setState(String _state) {
        this._state = _state;
    }

    public String getOrigin() {
        return _origin;
    }

    public void setOrigin(String _origin) {
        this._origin = _origin;
    }

    public String getDestiny() {
        return _destiny;
    }

    public void setDestiny(String _destiny) {
        this._destiny = _destiny;
    }

    public java.util.Date getSince() {
        return _since;
    }

    public void setSince(java.util.Date _since) {
        this._since = _since;
    }

    public java.util.Date getUntil() {
        return _until;
    }

    public void setUntil(java.util.Date _until) {
        this._until = _until;
    }

    public java.util.Date getDid() {
        return _did;
    }

    public void setDid(java.util.Date _did) {
        this._did = _did;
    }

    public String getReason() {
        return _reason;
    }

    public void setReason(String _reason) {
        this._reason = _reason;
    }    
}
