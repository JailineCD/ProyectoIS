/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.lab1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DAO.ExamenFisicoDAO;
import umg.edu.gt.DTO.PacienteDTO;
import umg.edu.gt.DTO.ExamenFisicoDTO;
import umg.edu.gt.DTO.TipoExamenFisicoDTO;

/**
 *
 * @author Luis Velasquez
 */ 
@ManagedBean(name = "examenFisicosUI")
@ViewScoped
public class ExamenFisicosUI implements Serializable {
    private List<ExamenFisicoDTO> examenFisicos;
    private List<TipoExamenFisicoDTO> tiposExamenFisicos;
    private ExamenFisicoDTO nuevoExamenFisico;
    private Date fechaRegistro;
    private int selectedTipoExamenFisico;
    private int selectedPacienteId;
    private String usuario;
    private String observaciones;
    private String respuesta;
    
    public ExamenFisicosUI() {
        cargarTiposExamenFisico(); 
    }
    
    
    public List<ExamenFisicoDTO> getExamenFisicos() {
        return examenFisicos;
    }

    public void setAntecedentesClinicos(List<ExamenFisicoDTO> examenFisicos) {
        this.examenFisicos = examenFisicos;
    }

    public List<TipoExamenFisicoDTO> getTiposAntecedentesClinicos() {
        return tiposExamenFisicos;
    }

    public void setTiposAntecedentesClinicos(List<TipoExamenFisicoDTO> tiposExamenFisicos) {
        this.tiposExamenFisicos = tiposExamenFisicos;
    }

    public ExamenFisicoDTO getNuevoExamenFisico() {
        return nuevoExamenFisico;
    }

    public void setNuevoExamenFisico(ExamenFisicoDTO nuevoExamenFisico) {
        this.nuevoExamenFisico = nuevoExamenFisico;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getSelectedTipoAntecedenteId() {
        return selectedTipoExamenFisico;
    }

    public void setSelectedTipoAntecedenteId(int selectedTipoExamenFisico) {
        this.selectedTipoExamenFisico = selectedTipoExamenFisico;
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

    public void cargarTiposExamenFisico() {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            tiposExamenFisicos = session.createQuery("FROM TipoExamenFisicoDTO WHERE estado = 'ACTIVO'", TipoExamenFisicoDTO.class).list();
        } finally {
            conexion.CerrarSesion(session);
        }
    }
    public void cargarExamenFisico(Long idPaciente) {
    ConexionDAO conexion = new ConexionDAO();
    Session session = conexion.obtenerSesion();
    try {
        String queryStr = "FROM ExamenFisicoDTO ac WHERE ac.idPaciente.id = :idPaciente";
        examenFisicos = session.createQuery(queryStr, ExamenFisicoDTO.class)
                                     .setParameter("idPaciente", idPaciente)
                                     .list();
    } finally {
        conexion.CerrarSesion(session);
    }
}

    public void agregarAntecedenteClinico() {
        if (nuevoExamenFisico != null) {
            // Asigna los valores del UI al nuevoExamenFisico
            //nuevoExamenFisico.setTipoAntecedenteClinico(findTiposExamenFisicoById(selectedTipoExamenFisico));
            nuevoExamenFisico.setUsuario(usuario);
            nuevoExamenFisico.setObservaciones(observaciones);
            nuevoExamenFisico.setIdPaciente(findPacienteById(selectedPacienteId));
            
            examenFisicos.add(nuevoExamenFisico);
            nuevoExamenFisico = new ExamenFisicoDTO();
        }
    }
    /*public List<ExamenFisicoDTO> getExamenFisicosPorIdPaciente(Long idPaciente) {
    List<ExamenFisicoDTO> examenesFiltrados = new ArrayList<>();
    for (ExamenFisicoDTO antecedente : examenFisicos) {
        if (antecedente.getIdPaciente().getId().equals(idPaciente)) {
            examenesFiltrados.add(antecedente);
        }
    }
    return examenesFiltrados;
    }*/

    public void guardarExamenFisicos() {
        ExamenFisicoDAO examenFisicoDAO = new ExamenFisicoDAO();
        for (ExamenFisicoDTO antecedente : examenFisicos) {
            examenFisicoDAO.guardar(antecedente);
        }
        //examenFisicos.clear();
    }

    private TipoExamenFisicoDTO findTiposExamenFisicoById(int id) {
        for (TipoExamenFisicoDTO tipo : tiposExamenFisicos) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        return null;
    }
    public List<ExamenFisicoDTO> getExamenFisicosPorIdPaciente(Long idPaciente) {
    List<ExamenFisicoDTO> examenesFiltrados = new ArrayList<>();
    if (idPaciente != null) {
        for (ExamenFisicoDTO examen : examenFisicos) {
            if (examen.getIdPaciente().getId().equals(idPaciente)) {
                examenesFiltrados.add(examen);
            }
        }
    }
    return examenesFiltrados;
}
    private PacienteDTO findPacienteById(int id) {
        // Implementar lógica para encontrar el paciente por ID
        // Esto podría involucrar una consulta a la base de datos
        return null; // Placeholder
    }
}
