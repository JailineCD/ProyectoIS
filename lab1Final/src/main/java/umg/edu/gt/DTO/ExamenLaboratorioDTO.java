/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Douglas
 */
@Entity
@Table(name = "examen_laboratorio")
public class ExamenLaboratorioDTO implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteDTO id_paciente;

    @ManyToOne
    @JoinColumn(name = "id_examen_laboratorio")
    private TipoExamenLaboratorioDTO id_examen_laboratorio;
    
    @Column(name = "resultado")
    private int resultado;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "create_time")
    private LocalDateTime create_time;
    
    @Column(name = "update_time")
    private LocalDateTime update_time;

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
     * @return the id_examen_laboratorio
     */
    public TipoExamenLaboratorioDTO getId_examen_laboratorio() {
        return id_examen_laboratorio;
    }

    /**
     * @param id_examen_laboratorio the id_examen_laboratorio to set
     */
    public void setId_examen_laboratorio(TipoExamenLaboratorioDTO id_examen_laboratorio) {
        this.id_examen_laboratorio = id_examen_laboratorio;
    }

    /**
     * @return the resultado
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
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