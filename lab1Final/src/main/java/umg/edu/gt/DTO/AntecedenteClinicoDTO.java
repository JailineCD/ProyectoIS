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
@Table(name = "antecedente_clinico")
public class AntecedenteClinicoDTO implements Serializable {

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
    @JoinColumn(name = "id_paciente", referencedColumnName = "id", nullable = false)
    private PacienteDTO idPaciente;

    @ManyToOne
    @JoinColumn(name = "id_antecedente_clinico", referencedColumnName = "id", nullable = false)
    private TipoAntecedenteClinicoDTO idAntecedenteClinico;

    @Column(name = "respuesta", length = 255)
    private String respuesta;

    @Column(name = "usuario", length = 255)
    private String usuario;

    @Column(name = "observaciones", length = 255)
    private String observaciones;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime; 

    // Constructor vacío
    public AntecedenteClinicoDTO() {}

    @PrePersist
    @PreUpdate
    public void prePersistUpdate() {
        this.updateTime = LocalDateTime.now();
        if (this.createdTime == null) {
            this.createdTime = LocalDateTime.now();
        }
    }

    // Getters y Setters

    public PacienteDTO getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(PacienteDTO idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TipoAntecedenteClinicoDTO getIdAntecedenteClinico() {
        return idAntecedenteClinico;
    }

    public void setIdAntecedenteClinico(TipoAntecedenteClinicoDTO idAntecedenteClinico) {
        this.idAntecedenteClinico = idAntecedenteClinico;
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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
