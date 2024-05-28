/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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
@Table(name = "antecedente_clinico")
public class AntecedenteClinicoDTO implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteDTO id_paciente;
    
    @ManyToOne
    @JoinColumn(name = "id_antecedente_clinico")
    private TipoAntecedenteClinicoDTO id_antecedente_clinico;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "update_time")
    private LocalDateTime update_time;

    @Column(name = "created_time")
    private LocalDateTime created_time;

    /* Estas anotaciones indican que el método prePersistUpdate() debe ser llamado 
    antes de que la entidad se persista (se inserte por primera vez en la base de datos) 
    o se actualice. Dentro de este método, se establece updateTime a la fecha y hora actuales usando LocalDateTime.now() */
    @PrePersist
    @PreUpdate
    public void prePersistUpdate() {
        update_time = LocalDateTime.now();
        created_time = LocalDateTime.now();
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
     * @return the id_antecedente_clinico
     */
    public TipoAntecedenteClinicoDTO getId_antecedente_clinico() {
        return id_antecedente_clinico;
    }

    /**
     * @param id_antecedente_clinico the id_antecedente_clinico to set
     */
    public void setId_antecedente_clinico(TipoAntecedenteClinicoDTO id_antecedente_clinico) {
        this.id_antecedente_clinico = id_antecedente_clinico;
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
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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

    /**
     * @return the created_time
     */
    public LocalDateTime getCreated_time() {
        return created_time;
    }

    /**
     * @param created_time the created_time to set
     */
    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }


    
}
