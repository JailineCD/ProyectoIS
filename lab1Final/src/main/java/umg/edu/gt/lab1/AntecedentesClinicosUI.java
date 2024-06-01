/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import umg.edu.gt.DAO.AntecedenteClinicoDAO;
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DTO.PacienteDTO;
import umg.edu.gt.DTO.AntecedenteClinicoDTO;
import umg.edu.gt.DTO.TipoAntecedenteClinicoDTO;

/**
 *
 * @author Luis Velasquez
 */ 
@ManagedBean(name = "antecedentesClinicosUI")
@ViewScoped
public class AntecedentesClinicosUI implements Serializable {
    private List<AntecedenteClinicoDTO> antecedentesClinicos;
    private List<TipoAntecedenteClinicoDTO> tiposAntecedentesClinicos;
    private AntecedenteClinicoDTO nuevoAntecedenteClinico;
    private Date fechaRegistro;
    private int selectedTipoAntecedenteId;
    private int selectedPacienteId;
    private String usuario;
    private String observaciones;
    private String respuesta;
    public AntecedentesClinicosUI() {
        cargarTiposAntecedentesClinicos(); 
    }
    
    
    public List<AntecedenteClinicoDTO> getAntecedentesClinicos() {
        return antecedentesClinicos;
    }

    public void setAntecedentesClinicos(List<AntecedenteClinicoDTO> antecedentesClinicos) {
        this.antecedentesClinicos = antecedentesClinicos;
    }

    public List<TipoAntecedenteClinicoDTO> getTiposAntecedentesClinicos() {
        return tiposAntecedentesClinicos;
    }

    public void setTiposAntecedentesClinicos(List<TipoAntecedenteClinicoDTO> tiposAntecedentesClinicos) {
        this.tiposAntecedentesClinicos = tiposAntecedentesClinicos;
    }

    public AntecedenteClinicoDTO getNuevoAntecedenteClinico() {
        return nuevoAntecedenteClinico;
    }

    public void setNuevoAntecedenteClinico(AntecedenteClinicoDTO nuevoAntecedenteClinico) {
        this.nuevoAntecedenteClinico = nuevoAntecedenteClinico;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getSelectedTipoAntecedenteId() {
        return selectedTipoAntecedenteId;
    }

    public void setSelectedTipoAntecedenteId(int selectedTipoAntecedenteId) {
        this.selectedTipoAntecedenteId = selectedTipoAntecedenteId;
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

    public void cargarTiposAntecedentesClinicos() {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            tiposAntecedentesClinicos = session.createQuery("FROM TipoAntecedenteClinicoDTO WHERE estado = 'ACTIVO'", TipoAntecedenteClinicoDTO.class).list();
        } finally {
            conexion.CerrarSesion(session);
        }
    }
    public void cargarAntecedenteClinico(Long idPaciente) {
    ConexionDAO conexion = new ConexionDAO();
    Session session = conexion.obtenerSesion();
    try {
        String queryStr = "FROM AntecedenteClinicoDTO ac WHERE ac.idPaciente.id = :idPaciente";
        antecedentesClinicos = session.createQuery(queryStr, AntecedenteClinicoDTO.class)
                                     .setParameter("idPaciente", idPaciente)
                                     .list();
    } finally {
        conexion.CerrarSesion(session);
    }
}

    public void agregarAntecedenteClinico() {
        if (nuevoAntecedenteClinico != null) {
            // Asigna los valores del UI al nuevoAntecedenteClinico
            //nuevoAntecedenteClinico.setTipoAntecedenteClinico(findTipoAntecedenteById(selectedTipoAntecedenteId));
            nuevoAntecedenteClinico.setUsuario(usuario);
            nuevoAntecedenteClinico.setObservaciones(observaciones);
            nuevoAntecedenteClinico.setRespuesta(respuesta);
            nuevoAntecedenteClinico.setIdPaciente(findPacienteById(selectedPacienteId));
            
            antecedentesClinicos.add(nuevoAntecedenteClinico);
            nuevoAntecedenteClinico = new AntecedenteClinicoDTO();
        }
    }
    /*public List<AntecedenteClinicoDTO> getAntecedentesClinicosPorIdPaciente(Long idPaciente) {
    List<AntecedenteClinicoDTO> antecedentesFiltrados = new ArrayList<>();
    for (AntecedenteClinicoDTO antecedente : antecedentesClinicos) {
        if (antecedente.getIdPaciente().getId().equals(idPaciente)) {
            antecedentesFiltrados.add(antecedente);
        }
    }
    return antecedentesFiltrados;
    }*/

    public void guardarAntecedentesClinicos() {
        AntecedenteClinicoDAO antecedenteClinicoDAO = new AntecedenteClinicoDAO();
        for (AntecedenteClinicoDTO antecedente : antecedentesClinicos) {
            antecedenteClinicoDAO.guardar(antecedente);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se ha insertado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        //antecedentesClinicos.clear();
    }

    private TipoAntecedenteClinicoDTO findTipoAntecedenteById(int id) {
        for (TipoAntecedenteClinicoDTO tipo : tiposAntecedentesClinicos) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        return null;
    }
    public List<AntecedenteClinicoDTO> getAntecedentesClinicosPorIdPaciente(Long idPaciente) {
    List<AntecedenteClinicoDTO> antecedentesFiltrados = new ArrayList<>();
    if (idPaciente != null) {
        for (AntecedenteClinicoDTO antecedente : antecedentesClinicos) {
            if (antecedente.getIdPaciente().getId().equals(idPaciente)) {
                antecedentesFiltrados.add(antecedente);
            }
        }
    }
    return antecedentesFiltrados;
}
    private PacienteDTO findPacienteById(int id) {
        // Implementar lógica para encontrar el paciente por ID
        // Esto podría involucrar una consulta a la base de datos
        return null; // Placeholder
    }
}
