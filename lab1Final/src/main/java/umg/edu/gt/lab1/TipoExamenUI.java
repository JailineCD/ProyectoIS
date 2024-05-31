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
import umg.edu.gt.DAO.TipoExamenDAO;
import umg.edu.gt.DTO.TipoExamenDTO;

/**
 *
 * @author Luis Velasquez
 */
@ManagedBean(name = "inicioTipoExamen")
@ViewScoped
public class TipoExamenUI implements Serializable {

    /**
     * @return the listaTipoExamen
     */
    public List<TipoExamenDTO> getListaTipoExamen() {
        return listaTipoExamen;
    }

    /**
     * @param listaTipoExamen the listaTipoExamen to set
     */
    public void setListaTipoExamen(List<TipoExamenDTO> listaTipoExamen) {
        this.listaTipoExamen = listaTipoExamen;
    }

    /**
     * @return the selectedTipoExamen
     */
    public TipoExamenDTO getSelectedTipoExamen() {
        return selectedTipoExamen;
    }

    /**
     * @param selectedTipoExamen the selectedTipoExamen to set
     */
    public void setSelectedTipoExamen(TipoExamenDTO selectedTipoExamen) {
        this.selectedTipoExamen = selectedTipoExamen;
    }
    private static final long serialVersionUID = 1L;
    
    private TipoExamenDTO tipoExamen = new TipoExamenDTO();
    private TipoExamenDAO tipoExamenDAO = new TipoExamenDAO();
    private List<TipoExamenDTO> listaTipoExamen;  
    private TipoExamenDTO selectedTipoExamen; 
    
    private String clave;
    private String descripcion;
    
      public void actualizarListaExamenes() {
        listaTipoExamen = tipoExamenDAO.findAllTipoExamen();
    }


    public void addTipoExamenLaboratorio() {
        setTipoExamen(new TipoExamenDTO());
    }
      
    
    @PostConstruct
    public void init() {
        actualizarListaExamenes();
    }
    
    
    public void guardarTipoExamen() {
        try {
            if (getTipoExamen().getClave() == null || getTipoExamen().getClave().isEmpty() ||
                getTipoExamen().getDescripcion() == null || getTipoExamen().getDescripcion().isEmpty()) {
                System.out.println("Error: Clave y descripción son obligatorios.");
            } else {
                getTipoExamen().setEstado("Activo");
                tipoExamenDAO.insertarTipoExamen(getTipoExamen());
                System.out.println("Insertado correctamente");
                this.setClave("");
                this.setDescripcion("");
                setTipoExamen(new TipoExamenDTO()); // Resetear el formulario
                actualizarListaExamenes();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el tipo de examen de laboratorio: " + e.getMessage());
        }
    }
    
    
    public void mostrarTipoExamen() {
        TipoExamenDAO consulta = new TipoExamenDAO();
        try {
            setListaTipoExamen(consulta.findAllTipoExamen());
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al obtener la lista de Tipo de Examenes");
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println("Error al obtener la lista de Tipo de Examenes: " + ex.getMessage());
        }
    }

    
    public void guardarCambios(TipoExamenDTO examen) {
    FacesContext context = FacesContext.getCurrentInstance();
    try {
        tipoExamenDAO.actualizarTipoExamen(examen);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cambios guardados correctamente"));
        actualizarListaExamenes();
    } catch (Exception e) {
        e.printStackTrace();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los cambios del tipo de examen físico " + e.getMessage()));
    }
}
    
    
    public void onRowEdit(RowEditEvent<TipoExamenDTO> event) {
        TipoExamenDTO examenEditado = event.getObject();
        guardarCambios(examenEditado);
    }

    public void onRowCancel(RowEditEvent<TipoExamenDTO> event) {
        TipoExamenDTO examenCancelado = event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición cancelada", "Se canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    
    
    public void eliminar(TipoExamenDTO examen) {
        try {
            tipoExamenDAO.eliminarTipoExamen(examen);
            actualizarListaExamenes();
            System.out.println("Eliminado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el tipo de examen laboratorio " + e.getMessage());
        }
    }
    
    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tipoExamen
     */
    public TipoExamenDTO getTipoExamen() {
        return tipoExamen;
    }

    /**
     * @param tipoExamen the tipoExamen to set
     */
    public void setTipoExamen(TipoExamenDTO tipoExamen) {
        this.tipoExamen = tipoExamen;
    }
    
    
    
}
