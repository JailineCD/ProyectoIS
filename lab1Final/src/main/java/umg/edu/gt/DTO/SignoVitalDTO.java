package umg.edu.gt.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "signo_vital")
public class SignoVitalDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id", nullable = false)
    private PacienteDTO idPaciente;

    @ManyToOne
    @JoinColumn(name = "id_signo_vital", referencedColumnName = "id", nullable = false)
    private TipoSignoVitalDTO idTipoSignoVital;

    @Column(name = "respuesta", length = 50)
    private String respuesta;

    @Column(name = "observaciones", length = 200)
    private String observaciones;
    
    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @PrePersist
    @PreUpdate
    public void prePersistUpdate() {
        this.updateTime = LocalDateTime.now();
        if (this.createTime == null) {
            this.createTime = LocalDateTime.now();
        }
    }

    // Constructor vacío
    public SignoVitalDTO() {}

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

    public TipoSignoVitalDTO getIdTipoSignoVital() {
        return idTipoSignoVital;
    }

    public void setIdTipoSignoVital(TipoSignoVitalDTO idTipoSignoVital) {
        this.idTipoSignoVital = idTipoSignoVital;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
