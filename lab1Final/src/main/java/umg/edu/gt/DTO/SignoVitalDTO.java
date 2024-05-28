/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author Douglas
 */
@Entity
@Table(name = "signo_vital")
public class SignoVitalDTO implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteDTO id_paciente;
    
    @ManyToOne
    @JoinColumn(name = "id_signo_vital")
    private TipoSignoVitalDTO id_signo_vital;
    
    @Column(name = "valor")
    private String valor;
    
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
        setCreate_time(LocalDateTime.now());
        setUpdate_time(LocalDateTime.now());
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
     * @return the id_signo_vital
     */
    public TipoSignoVitalDTO getId_signo_vital() {
        return id_signo_vital;
    }

    /**
     * @param id_signo_vital the id_signo_vital to set
     */
    public void setId_signo_vital(TipoSignoVitalDTO id_signo_vital) {
        this.id_signo_vital = id_signo_vital;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
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
