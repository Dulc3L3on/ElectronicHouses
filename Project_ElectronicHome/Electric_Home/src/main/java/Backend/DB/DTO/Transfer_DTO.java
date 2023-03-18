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
public class Transfer_DTO {
    private long _code;
    private String _state;
    private String _origin;
    private String _destiny;
    private Date _since;
    private Date _until;
    private Date _did;
    private String _reason;//pero lo debes pasar a blob o no se porque en realidad es un TEXT

    public long getCode() {
        return _code;
    }

    public void setCode(long _code) {
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

    public Date getSince() {
        return _since;
    }

    public void setSince(Date _since) {
        this._since = _since;
    }

    public Date getUntil() {
        return _until;
    }

    public void setUntil(Date _until) {
        this._until = _until;
    }

    public Date getDid() {
        return _did;
    }

    public void setDid(Date _did) {
        this._did = _did;
    }

    public String getReason() {
        return _reason;
    }

    public void setReason(String _reason) {
        this._reason = _reason;
    }
    
}
