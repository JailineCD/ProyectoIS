package umg.ed.gt.DTO;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class EmpleadosDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cue")
    private Long cue;

    @Column(name = "dpi")
    private String dpi;

    @Column(name = "nombre1")
    private String nombre1;

    @Column(name = "nombre2")
    private String nombre2;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "apellidoc")
    private String apellidoc;


    @Column(name = "fecha_desde")
    private Date fechaDesde;

    @Column(name = "fecha_hasta")
    private Date fechaHasta;

    @Column(name = "estado")
    private String estado;

    // Constructor vacío
    public EmpleadosDTO() {}

    // Getters y Setters

    public Long getCue() {
        return cue;
    }

    public void setCue(Long cue) {
        this.cue = cue;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellidoc() {
        return apellidoc;
    }

    public void setApellidoc(String apellidoc) {
        this.apellidoc = apellidoc;
    }


    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
