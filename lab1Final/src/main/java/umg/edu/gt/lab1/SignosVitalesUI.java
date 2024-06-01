package umg.edu.gt.lab1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import umg.edu.gt.DAO.SignoVitalDAO;
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DTO.AparatoSistemasDTO;
import umg.edu.gt.DTO.PacienteDTO;
import umg.edu.gt.DTO.SignoVitalDTO;
import umg.edu.gt.DTO.TipoSignoVitalDTO;
/**
 *
 * @author Luis Velasquez
 */
@ManagedBean(name = "signosVitalesUI")
@ViewScoped
public class SignosVitalesUI implements Serializable {

    /**
     * @return the aparatoSistemas
     */
    public List<AparatoSistemasDTO> getAparatoSistemas() {
        return aparatoSistemas;
    }

    /**
     * @param aparatoSistemas the aparatoSistemas to set
     */
    public void setAparatoSistemas(List<AparatoSistemasDTO> aparatoSistemas) {
        this.aparatoSistemas = aparatoSistemas;
    }
    private List<AparatoSistemasDTO> aparatoSistemas;
    private List<SignoVitalDTO> signosVitales;
    private List<TipoSignoVitalDTO> tiposSignosVitales;
    private SignoVitalDTO nuevoSignoVital;
    private Date fechaRegistro;
    private int selectedTipoSignoVitalId;
    private int selectedPacienteId;
    private String usuario;
    private String observaciones;
    private String respuesta;

    public SignosVitalesUI() {
        cargarTiposSignosVitales(); 
    }

    public List<SignoVitalDTO> getSignosVitales() {
        return signosVitales;
    }
    
    public void setSignosVitales(List<SignoVitalDTO> signosVitales) {
        this.signosVitales = signosVitales;
    }

    public List<TipoSignoVitalDTO> getTiposSignosVitales() {
        return tiposSignosVitales;
    }

    public void setTiposSignosVitales(List<TipoSignoVitalDTO> tiposSignosVitales) {
        this.tiposSignosVitales = tiposSignosVitales;
    }

    public SignoVitalDTO getNuevoSignoVital() {
        return nuevoSignoVital;
    }

    public void setNuevoSignoVital(SignoVitalDTO nuevoSignoVital) {
        this.nuevoSignoVital = nuevoSignoVital;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getSelectedTipoSignoVitalId() {
        return selectedTipoSignoVitalId;
    }

    public void setSelectedTipoSignoVitalId(int selectedTipoSignoVitalId) {
        this.selectedTipoSignoVitalId = selectedTipoSignoVitalId;
    }

    public int getSelectedPacienteId() {
        return selectedPacienteId;
    }

    public void setSelectedPacienteId(int selectedPacienteId) {
        this.selectedPacienteId = selectedPacienteId;
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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void cargarTiposSignosVitales() {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            tiposSignosVitales = session.createQuery("FROM TipoSignoVitalDTO", TipoSignoVitalDTO.class).list();
        } finally {
            conexion.CerrarSesion(session);
        }
    }

    public void cargarSignosVitales(Long idPaciente) {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            String queryStr = "FROM SignoVitalDTO sv WHERE sv.idPaciente.id = :idPaciente";
            signosVitales = session.createQuery(queryStr, SignoVitalDTO.class)
                                     .setParameter("idPaciente", idPaciente)
                                     .list();
        } finally {
            conexion.CerrarSesion(session);
        }
    }

    public void agregarSignoVital() {
        if (nuevoSignoVital != null) {
            nuevoSignoVital.setUsuario(usuario);
            nuevoSignoVital.setObservaciones(observaciones);
            nuevoSignoVital.setRespuesta(respuesta);
            // Asigna el tipo de signo vital seleccionado al nuevo signo vital
            // nuevoSignoVital.setIdSignoVital(findTipoSignoVitalById(selectedTipoSignoVitalId));
            signosVitales.add(nuevoSignoVital);
            nuevoSignoVital = new SignoVitalDTO();
        }
    }

    public void guardarSignosVitales() {
        SignoVitalDAO signoVitalDAO = new SignoVitalDAO();
        for (SignoVitalDTO signoVital : signosVitales) {
            signoVitalDAO.guardar(signoVital);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se ha insertado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
    }
      
}
