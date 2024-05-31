/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

import java.io.Serializable;
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
@Table(name = "examen_fisico")
public class ExamenFisicoDTO implements Serializable {

    /**
     * @return the idPaciente
     */
    public PacienteDTO getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(PacienteDTO idPaciente) {
        this.idPaciente = idPaciente;
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
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteDTO idPaciente;

    @ManyToOne
    @JoinColumn(name = "id_examen_fisico")
    private TipoExamenFisicoDTO id_examen_fisico;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Column(name = "respuesta")
    private String respuesta;
    
    @Column(name = "usuario")
    private String usuario;
    
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
     * @return the idPaciente
     */


    /**
     * @return the id_examen_fisico
     */
    public TipoExamenFisicoDTO getId_examen_fisico() {
        return id_examen_fisico;
    }
    
    

    /**
     * @param id_examen_fisico the id_examen_fisico to set
     */
    public void setId_examen_fisico(TipoExamenFisicoDTO id_examen_fisico) {
        this.id_examen_fisico = id_examen_fisico;
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
