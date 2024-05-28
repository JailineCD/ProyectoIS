/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author Douglas
 */
@Entity
@Table(name = "paciente")
public class PacienteDTO implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "cue")
    private int cue;

    @Column(name = "id_tipo_examen")
    private int idTipoExamen;

    @Column(name = "recomendacion", length = 200)
    private String recomendacion;

    @Column(name = "apto_laborar")
    private boolean aptoLaborar;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_time", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @Column(name = "usuario", length = 50)
    private String usuario;

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

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cue
     */
    public int getCue() {
        return cue;
    }

    /**
     * @param cue the cue to set
     */
    public void setCue(int cue) {
        this.cue = cue;
    }

    /**
     * @return the idTipoExamen
     */
    public int getIdTipoExamen() {
        return idTipoExamen;
    }

    /**
     * @param idTipoExamen the idTipoExamen to set
     */
    public void setIdTipoExamen(int idTipoExamen) {
        this.idTipoExamen = idTipoExamen;
    }

    /**
     * @return the recomendacion
     */
    public String getRecomendacion() {
        return recomendacion;
    }

    /**
     * @param recomendacion the recomendacion to set
     */
    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    /**
     * @return the aptoLaborar
     */
    public boolean isAptoLaborar() {
        return aptoLaborar;
    }

    /**
     * @param aptoLaborar the aptoLaborar to set
     */
    public void setAptoLaborar(boolean aptoLaborar) {
        this.aptoLaborar = aptoLaborar;
    }

    /**
     * @return the fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    
    
    
}
