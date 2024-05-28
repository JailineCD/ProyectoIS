/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Douglas
 */
@Entity
@Table(name = "centro_costo")
public class CentroCostoDTO implements Serializable {
    
    @Id
    @Column(name = "idcc")
    private Long idcc;
    
    @Column(name = "descripcion")
    private String descripcion;

    /**
     * @return the idcc
     */
    public Long getIdcc() {
        return idcc;
    }

    /**
     * @param idcc the idcc to set
     */
    public void setIdcc(Long idcc) {
        this.idcc = idcc;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
