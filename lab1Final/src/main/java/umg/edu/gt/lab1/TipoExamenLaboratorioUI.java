/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.lab1;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import umg.edu.gt.DAO.TipoExamenLaboratorioDAO;
import umg.edu.gt.DTO.TipoExamenLaboratorioDTO;

/**
 *
 * @author Douglas
 */
@ManagedBean(name = "bkn_TipoExamenLaboratorio")
@ViewScoped
public class TipoExamenLaboratorioUI implements Serializable {

    /**
     * @return the estadoActual
     */
    public String getEstadoActual() {
        return estadoActual;
    }

    /**
     * @param estadoActual the estadoActual to set
     */
    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    private TipoExamenLaboratorioDTO tipoExamenLaboratorio = new TipoExamenLaboratorioDTO();
    private TipoExamenLaboratorioDAO tipoExamenLaboratorioDAO = new TipoExamenLaboratorioDAO();
    private List<TipoExamenLaboratorioDTO> listaExamenes;

    private String clave;
    private String descripcion;
    
       
      // Variables para almacenar los valores actuales de clave y descripción
    private String claveActual;
    private String descripcionActual;
    private String estadoActual;
    
    public void prepararEdicionTipoExamenLaboratorio(TipoExamenLaboratorioDTO examen) {
        this.tipoExamenLaboratorio = examen;
        this.claveActual = examen.getClave();
        this.descripcionActual = examen.getDescripcion();
        this.estadoActual = examen.getEstado();
    }

    
    @PostConstruct
    public void init() {
        actualizarListaExamenes();
    }

    public void actualizarListaExamenes() {
        listaExamenes = tipoExamenLaboratorioDAO.obtenerTiposExamenLaboratorio();
    }


    public void addTipoExamenLaboratorio() {
        tipoExamenLaboratorio = new TipoExamenLaboratorioDTO();
    }

    public TipoExamenLaboratorioDTO getTipoExamenLaboratorio() {
        return tipoExamenLaboratorio;
    }

    public void setTipoExamenLaboratorio(TipoExamenLaboratorioDTO tipoExamenLaboratorio) {
        this.tipoExamenLaboratorio = tipoExamenLaboratorio;
    }

    public void guardarTipoExamenLaboratorio() {
        try {
            if (tipoExamenLaboratorio.getClave() == null || tipoExamenLaboratorio.getClave().isEmpty() ||
                tipoExamenLaboratorio.getDescripcion() == null || tipoExamenLaboratorio.getDescripcion().isEmpty()) {
                System.out.println("Error: Clave y descripción son obligatorios.");
            } else {
                tipoExamenLaboratorio.setEstado("Activo");
                tipoExamenLaboratorioDAO.insertarTipoExamenLaboratorio(tipoExamenLaboratorio);
                System.out.println("Insertado correctamente");
                this.clave = "";
                this.descripcion = "";
                tipoExamenLaboratorio = new TipoExamenLaboratorioDTO(); // Resetear el formulario
                actualizarListaExamenes();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el tipo de examen de laboratorio: " + e.getMessage());
        }
    }
    
    
    public void prepararEdicion(TipoExamenLaboratorioDTO examen) {
        tipoExamenLaboratorio = examen;
    }

    public void guardarCambios(TipoExamenLaboratorioDTO examen) {
    FacesContext context = FacesContext.getCurrentInstance();
    try {
        tipoExamenLaboratorioDAO.actualizarTipoExamenLaboratorio(examen);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cambios guardados correctamente"));
        actualizarListaExamenes();
    } catch (Exception e) {
        e.printStackTrace();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los cambios del tipo de examen físico " + e.getMessage()));
    }
}
    
    
    public void onRowEdit(RowEditEvent<TipoExamenLaboratorioDTO> event) {
        TipoExamenLaboratorioDTO examenEditado = event.getObject();
        guardarCambios(examenEditado);
    }

    public void onRowCancel(RowEditEvent<TipoExamenLaboratorioDTO> event) {
        TipoExamenLaboratorioDTO examenCancelado = event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición cancelada", "Se canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    
    
    public void eliminar(TipoExamenLaboratorioDTO examen) {
        try {
            tipoExamenLaboratorioDAO.eliminarTipoExamenLaboratorio(examen);
            actualizarListaExamenes();
            System.out.println("Eliminado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el tipo de examen laboratorio " + e.getMessage());
        }
    }
    
    public List<TipoExamenLaboratorioDTO> getListaExamenes() {
        return listaExamenes;
    }

    public void setListaExamenes(List<TipoExamenLaboratorioDTO> listaExamenes) {
        this.listaExamenes = listaExamenes;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the claveActual
     */
    public String getClaveActual() {
        return claveActual;
    }

    /**
     * @param claveActual the claveActual to set
     */
    public void setClaveActual(String claveActual) {
        this.claveActual = claveActual;
    }

    /**
     * @return the descripcionActual
     */
    public String getDescripcionActual() {
        return descripcionActual;
    }

    /**
     * @param descripcionActual the descripcionActual to set
     */
    public void setDescripcionActual(String descripcionActual) {
        this.descripcionActual = descripcionActual;
    }
    
}
