/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 *
 * @author Douglas
 */
@Entity
@Table(name = "aparato_sistemas")
public class AparatoSistemasDTO {
    
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteDTO id_paciente;

    @ManyToOne
    @JoinColumn(name = "id_aparato_sistema")
    private TipoAparatoSistemasDTO id_aparato_sistema;
    
    @Column(name = "respuesta")
    private int respuesta;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Column(name = "create_time")
    private LocalDateTime create_time;
    
    @Column(name = "update_time")
    private LocalDateTime update_time;
    
    
    @PrePersist
    @PreUpdate
    public void prePersistUpdate() {
        create_time = LocalDateTime.now();
        update_time = LocalDateTime.now();
    }
    
    /**
     * @return the id_paciente
     */
    public PacienteDTO getId_paciente() {
        return id_paciente;
    }

    /**
     * @param id_paciente the id_paciente to set
     */
    public void setId_paciente(PacienteDTO id_paciente) {
        this.id_paciente = id_paciente;
    }

    /**
     * @return the id_aparato_sistema
     */
    public TipoAparatoSistemasDTO getId_aparato_sistema() {
        return id_aparato_sistema;
    }

    /**
     * @param id_aparato_sistema the id_aparato_sistema to set
     */
    public void setId_aparato_sistema(TipoAparatoSistemasDTO id_aparato_sistema) {
        this.id_aparato_sistema = id_aparato_sistema;
    }

    /**
     * @return the respuesta
     */
    public int getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the create_time
     */
    public LocalDateTime getCreate_time() {
        return create_time;
    }

    /**
     * @param create_time the create_time to set
     */
    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    /**
     * @return the update_time
     */
    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    /**
     * @param update_time the update_time to set
     */
    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }
    
    
}
