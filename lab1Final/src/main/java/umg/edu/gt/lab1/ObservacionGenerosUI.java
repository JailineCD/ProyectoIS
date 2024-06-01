/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.lab1;


import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session; 
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DAO.ObservacionGeneroDAO;
import umg.edu.gt.DTO.ObservacionGeneroDTO; 
import umg.edu.gt.DTO.TipoObservacionGeneroDTO;
/**
 *
 * @author Luis Velasquez
 */
@ManagedBean(name = "observacionGenerosUI")
@ViewScoped
public class ObservacionGenerosUI implements Serializable {
    private List<ObservacionGeneroDTO> observacionGeneros;
    private List<TipoObservacionGeneroDTO> tiposObservacionGeneros;
    private ObservacionGeneroDTO nuevoObservacioGeneros;
    private int selectedTipoObservacionGenerosId;
    private int selectedPacienteId;
    private String usuario;
    private String observaciones;
    private int respuesta;
    public ObservacionGenerosUI() {
        cargarTiposObservacioGeneros();
    }
    /**
     * @return the observacionGeneros
     */
    public List<ObservacionGeneroDTO> getObservacionGeneros() {
        return observacionGeneros;
    }

    /**
     * @param observacionGeneros the observacionGeneros to set
     */
    public void setObservacionGeneros(List<ObservacionGeneroDTO> observacionGeneros) {
        this.observacionGeneros = observacionGeneros;
    }

    /**
     * @return the tiposObservacionGeneros
     */
    public List<TipoObservacionGeneroDTO> getTiposObservacionGeneros() {
        return tiposObservacionGeneros;
    }

    /**
     * @param tiposObservacionGeneros the tiposObservacionGeneros to set
     */
    public void setTiposObservacionGeneros(List<TipoObservacionGeneroDTO> tiposObservacionGeneros) {
        this.tiposObservacionGeneros = tiposObservacionGeneros;
    }

    /**
     * @return the nuevoObservacioGeneros
     */
    public ObservacionGeneroDTO getNuevoObservacioGeneros() {
        return nuevoObservacioGeneros;
    }

    /**
     * @param nuevoObservacioGeneros the nuevoObservacioGeneros to set
     */
    public void setNuevoObservacioGeneros(ObservacionGeneroDTO nuevoObservacioGeneros) {
        this.nuevoObservacioGeneros = nuevoObservacioGeneros;
    }

    /**
     * @return the selectedTipoObservacionGenerosId
     */
    public int getSelectedTipoObservacionGenerosId() {
        return selectedTipoObservacionGenerosId;
    }

    /**
     * @param selectedTipoObservacionGenerosId the selectedTipoObservacionGenerosId to set
     */
    public void setSelectedTipoObservacionGenerosId(int selectedTipoObservacionGenerosId) {
        this.selectedTipoObservacionGenerosId = selectedTipoObservacionGenerosId;
    }

    /**
     * @return the selectedPacienteId
     */
    public int getSelectedPacienteId() {
        return selectedPacienteId;
    }

    /**
     * @param selectedPacienteId the selectedPacienteId to set
     */
    public void setSelectedPacienteId(int selectedPacienteId) {
        this.selectedPacienteId = selectedPacienteId;
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
    public int getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
    
    
    public void cargarTiposObservacioGeneros() {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            setTiposObservacionGeneros(session.createQuery("FROM TipoObservacionGeneroDTO", TipoObservacionGeneroDTO.class).list());
        } finally {
            conexion.CerrarSesion(session);
        }
    }

    public void cargarObservacionGeneros(Long idPaciente) {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            String queryStr = "FROM ObservacionGeneroDTO aps WHERE aps.idPaciente.id = :idPaciente";
            observacionGeneros = session.createQuery(queryStr, ObservacionGeneroDTO.class)
                                     .setParameter("idPaciente", idPaciente)
                                     .list();
        } finally {
            conexion.CerrarSesion(session);
        }
    }

    /*public void agregarAparatoSistemas() {
        if (nuevoObservacioGeneros != null) {
            nuevoObservacioGeneros.setUsuario(usuario);
            nuevoObservacioGeneros.setObservaciones(observaciones);
            nuevoObservacioGeneros.setRespuesta(respuesta);
            // Asigna el tipo de aparato/sistema seleccionado al nuevo aparato/sistema
            // nuevoObservacioGeneros.setIdAparatoSistema(findTipoAparatoSistemasById(selectedTipoObservacionGenerosId));
            observacionGenerosList.add(nuevoObservacioGeneros);
            nuevoObservacioGeneros = new ObservacionGeneroDTO();
        }
    }*/

    public void guardarObservacionGeneros() {
        ObservacionGeneroDAO observacionGenerosDAO = new ObservacionGeneroDAO();
        for (ObservacionGeneroDTO observacion : observacionGeneros) {
            observacionGenerosDAO.guardar(observacion);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se ha insertado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}