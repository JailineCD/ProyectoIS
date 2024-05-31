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
import umg.edu.gt.DAO.TipoExamenFisicoDAO;
import umg.edu.gt.DTO.TipoExamenFisicoDTO;

/**
 *
 * @author duper
 */
@ManagedBean(name = "bkn_TipoExamenFisico")
@ViewScoped
public class TipoExamenFisicoUI implements Serializable {
    
    private TipoExamenFisicoDTO tipoExamenFisico = new TipoExamenFisicoDTO();
    private TipoExamenFisicoDAO tipoExamenFisicoDAO = new TipoExamenFisicoDAO();
    private List<TipoExamenFisicoDTO> listaExamenes;

    private String clave;
    private String descripcion;

    
    @PostConstruct
    public void init() {
        actualizarListaExamenes();
    }

    public void actualizarListaExamenes() {
        setListaExamenes(tipoExamenFisicoDAO.obtenerTiposExamenFisico());
    }

    public void addTipoExamenFisico() {
        tipoExamenFisico = new TipoExamenFisicoDTO();
    }

    public TipoExamenFisicoDTO getTipoExamenFisico() {
        return tipoExamenFisico;
    }

    public void setTipoExamenFisico(TipoExamenFisicoDTO tipoExamenFisico) {
        this.tipoExamenFisico = tipoExamenFisico;
    }

    public void guardarTipoExamenFisico() {
        try {
            if (tipoExamenFisico.getClave() == null || tipoExamenFisico.getClave().isEmpty() ||
                tipoExamenFisico.getDescripcion() == null || tipoExamenFisico.getDescripcion().isEmpty()) {
                System.out.println("Error clave y descripcion son obligatorios");
            } else {
                tipoExamenFisicoDAO.insertarTipoExamenFisico(tipoExamenFisico);
                actualizarListaExamenes();
                System.out.println("Insertado correctamente");
                this.clave = "";
                this.descripcion = "";
                tipoExamenFisico = new TipoExamenFisicoDTO(); // Resetear el formulario
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el tipo de examen físico " + e.getMessage());
        }
    }
    
    public void guardarCambios(TipoExamenFisicoDTO examen) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            tipoExamenFisicoDAO.actualizarTipoExamenFisico(examen);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cambios guardados correctamente"));
            actualizarListaExamenes();
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los cambios del tipo de examen físico " + e.getMessage()));
        }
    }

    public void onRowEdit(RowEditEvent<TipoExamenFisicoDTO> event) {
        TipoExamenFisicoDTO examenEditado = event.getObject();
        guardarCambios(examenEditado);
    }

    public void onRowCancel(RowEditEvent<TipoExamenFisicoDTO> event) {
        TipoExamenFisicoDTO examenCancelado = event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición cancelada", "Se canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void eliminar(TipoExamenFisicoDTO examen) {
        try {
            tipoExamenFisicoDAO.eliminarTipoExamenFisico(examen);
            actualizarListaExamenes();
            System.out.println("Eliminado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el tipo de examen físico " + e.getMessage());
        }
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
     * @return the listaExamenes
     */
    public List<TipoExamenFisicoDTO> getListaExamenes() {
        return listaExamenes;
    }

    /**
     * @param listaExamenes the listaExamenes to set
     */
    public void setListaExamenes(List<TipoExamenFisicoDTO> listaExamenes) {
        this.listaExamenes = listaExamenes;
    }
    
}
