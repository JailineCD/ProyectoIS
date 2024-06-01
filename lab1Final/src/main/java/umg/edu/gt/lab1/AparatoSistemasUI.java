package umg.edu.gt.lab1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import umg.edu.gt.DAO.AparatoSistemasDAO;
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DTO.AparatoSistemasDTO;
import umg.edu.gt.DTO.PacienteDTO;
import umg.edu.gt.DTO.TipoAparatoSistemasDTO;
/**
 *
 * @author Luis Velasquez
 */
@ManagedBean(name = "aparatoSistemasUI")
@ViewScoped
public class AparatoSistemasUI implements Serializable {
    private List<AparatoSistemasDTO> aparatoSistemasList;
    private List<TipoAparatoSistemasDTO> tiposAparatoSistemasList;
    private AparatoSistemasDTO nuevoAparatoSistemas;
    private int selectedTipoAparatoSistemasId;
    private int selectedPacienteId;
    private String usuario;
    private String observaciones;
    private String respuesta="Normal";

    public AparatoSistemasUI() {
        cargarTiposAparatoSistemas();
        respuesta="Normal";
        
    }

    public List<AparatoSistemasDTO> getAparatoSistemasList() {
        return aparatoSistemasList;
    }

    public void setAparatoSistemasList(List<AparatoSistemasDTO> aparatoSistemasList) {
        this.aparatoSistemasList = aparatoSistemasList;
    }

    public List<TipoAparatoSistemasDTO> getTiposAparatoSistemasList() {
        return tiposAparatoSistemasList;
    }

    public void setTiposAparatoSistemasList(List<TipoAparatoSistemasDTO> tiposAparatoSistemasList) {
        this.tiposAparatoSistemasList = tiposAparatoSistemasList;
    }

    public AparatoSistemasDTO getNuevoAparatoSistemas() {
        return nuevoAparatoSistemas;
    }

    public void setNuevoAparatoSistemas(AparatoSistemasDTO nuevoAparatoSistemas) {
        this.nuevoAparatoSistemas = nuevoAparatoSistemas;
    }

    public int getSelectedTipoAparatoSistemasId() {
        return selectedTipoAparatoSistemasId;
    }

    public void setSelectedTipoAparatoSistemasId(int selectedTipoAparatoSistemasId) {
        this.selectedTipoAparatoSistemasId = selectedTipoAparatoSistemasId;
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

    public void cargarTiposAparatoSistemas() {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            tiposAparatoSistemasList = session.createQuery("FROM TipoAparatoSistemasDTO", TipoAparatoSistemasDTO.class).list();
        } finally {
            conexion.CerrarSesion(session);
        }
    }

    public void cargarAparatoSistemas(Long idPaciente) {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            String queryStr = "FROM AparatoSistemasDTO aps WHERE aps.idPaciente.id = :idPaciente";
            aparatoSistemasList = session.createQuery(queryStr, AparatoSistemasDTO.class)
                                     .setParameter("idPaciente", idPaciente)
                                     .list();
        } finally {
            conexion.CerrarSesion(session);
        }
    }

    /*public void agregarAparatoSistemas() {
        if (nuevoAparatoSistemas != null) {
            nuevoAparatoSistemas.setUsuario(usuario);
            nuevoAparatoSistemas.setObservaciones(observaciones);
            nuevoAparatoSistemas.setRespuesta(respuesta);
            // Asigna el tipo de aparato/sistema seleccionado al nuevo aparato/sistema
            // nuevoAparatoSistemas.setIdAparatoSistema(findTipoAparatoSistemasById(selectedTipoAparatoSistemasId));
            aparatoSistemasList.add(nuevoAparatoSistemas);
            nuevoAparatoSistemas = new AparatoSistemasDTO();
        }
    }*/

    public void guardarAparatoSistemas() {
        AparatoSistemasDAO aparatoSistemasDAO = new AparatoSistemasDAO();
        for (AparatoSistemasDTO aparatoSistemas : aparatoSistemasList) {
            aparatoSistemasDAO.guardar(aparatoSistemas);
        }
    }
}
