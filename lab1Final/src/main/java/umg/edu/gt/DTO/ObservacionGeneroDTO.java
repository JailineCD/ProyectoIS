/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 * Entidad para representar los registros de la tabla aparato_sistemas
 * 
 * @autor Luis Velasquez
 */
@Entity
@Table(name = "observacion_genero")
public class ObservacionGeneroDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id", nullable = false)
    private PacienteDTO idPaciente; 
    @ManyToOne
    @JoinColumn(name = "id_observacion", referencedColumnName = "id", nullable = false)
    private TipoObservacionGeneroDTO idObservacion;

    @Column(name = "respuesta", length = 100)
    private String respuesta;

    @Column(name = "usuario", length = 100)
    private String usuario;

    @Column(name = "observaciones", length = 200)
    private String observaciones;

    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    // Constructor vacío
    public ObservacionGeneroDTO() {}

    @PrePersist
    @PreUpdate
    public void prePersistUpdate() {
        this.updateTime = LocalDateTime.now();
        if (this.createTime == null) {
            this.createTime = LocalDateTime.now();
        }
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PacienteDTO getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(PacienteDTO idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TipoObservacionGeneroDTO getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(TipoObservacionGeneroDTO idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
