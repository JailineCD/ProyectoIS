/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Douglas
 */
@Entity
@Table(name = "paciente")
public class PuestoDTO implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpuesto")
    private Long id_puesto;
    
    @Column(name = "descripcion")
    private String descripcion;

    /**
     * @return the id_puesto
     */
    public Long getId_puesto() {
        return id_puesto;
    }

    /**
     * @param id_puesto the id_puesto to set
     */
    public void setId_puesto(Long id_puesto) {
        this.id_puesto = id_puesto;
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
