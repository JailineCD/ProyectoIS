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
import umg.edu.gt.DAO.TipoAntecedenteClinicoDAO;
import umg.edu.gt.DTO.TipoAntecedenteClinicoDTO;

/**
 *
 * @author Douglas
 */
@ManagedBean(name = "bkn_TipoAntecedenteClinico")
@ViewScoped
public class TipoAntecedenteClinicoUI implements Serializable {
    
    private TipoAntecedenteClinicoDTO tipoAntecedenteClinico = new TipoAntecedenteClinicoDTO();
    private TipoAntecedenteClinicoDAO tipoAntecedenteClinicoDAO = new TipoAntecedenteClinicoDAO();
    private List<TipoAntecedenteClinicoDTO> listaAntecedentesClinicos;
    
    public void guardarAntecedenteClinico() {
        tipoAntecedenteClinico = new TipoAntecedenteClinicoDTO();
    }
    
    @PostConstruct
    public void init() {
        actualizarListaTipoAntecedentesClinicos();
    }
    
    public void actualizarListaTipoAntecedentesClinicos() {
        setListaAntecedentesClinicos(tipoAntecedenteClinicoDAO.obtenerTiposAntecedentesClinicos());
    }

    public void addTipoAntecedenteClinico() {
        tipoAntecedenteClinico = new TipoAntecedenteClinicoDTO();
    }

    public TipoAntecedenteClinicoDTO getTipoAntecedenteClinico() {
        return tipoAntecedenteClinico;
    }

    public void setTipoAntecedenteClinico(TipoAntecedenteClinicoDTO tipoAntecedenteClinico) {
        this.tipoAntecedenteClinico = tipoAntecedenteClinico;
    }

    public void guardarTipoAntecedenteClinico() {
        try {
            if (tipoAntecedenteClinico.getClave() == null || tipoAntecedenteClinico.getClave().isEmpty() ||
                tipoAntecedenteClinico.getDescripcion() == null || tipoAntecedenteClinico.getDescripcion().isEmpty()) {
                System.out.println("Error clave y descripcion son obligatorios");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Clave y descripción son obligatorios.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                tipoAntecedenteClinicoDAO.insertarTipoAntecedenteClinico(tipoAntecedenteClinico);
                actualizarListaTipoAntecedentesClinicos();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El Tipo de Antecedente Clínico se ha sido insertado correctamente.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                System.out.println("Insertado correctamente");
                tipoAntecedenteClinico = new TipoAntecedenteClinicoDTO(); // Resetear el formulario
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el tipo de antecedente clínico " + e.getMessage());
        }
    }
    
    public void guardarCambios(TipoAntecedenteClinicoDTO antecedenteClinico) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            tipoAntecedenteClinicoDAO.actualizarTipoAntecedenteClinico(antecedenteClinico);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cambios guardados correctamente"));
            actualizarListaTipoAntecedentesClinicos();
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los cambios del tipo de antecedente clínico " + e.getMessage()));
        }
    }

    public void eliminar(TipoAntecedenteClinicoDTO antecedenteClinico) {
        try {
            tipoAntecedenteClinicoDAO.eliminarTipoAntecedenteClinico(antecedenteClinico);
            actualizarListaTipoAntecedentesClinicos();
            System.out.println("Eliminado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el tipo de antecedente clínico " + e.getMessage());
        }
    }
    
    public void onRowEdit(RowEditEvent<TipoAntecedenteClinicoDTO> event) {
        TipoAntecedenteClinicoDTO tipoAntecedenteClinicoEditado = event.getObject();
        guardarCambios(tipoAntecedenteClinicoEditado);
    }

    public void onRowCancel(RowEditEvent<TipoAntecedenteClinicoDTO> event) {
        TipoAntecedenteClinicoDTO antecedenteClinicoCancelado = event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición cancelada", "Se canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the listaAntecedentesClinicos
     */
    public List<TipoAntecedenteClinicoDTO> getListaAntecedentesClinicos() {
        return listaAntecedentesClinicos;
    }

    /**
     * @param listaAntecedentesClinicos the listaAntecedentesClinicos to set
     */
    public void setListaAntecedentesClinicos(List<TipoAntecedenteClinicoDTO> listaAntecedentesClinicos) {
        this.listaAntecedentesClinicos = listaAntecedentesClinicos;
    }
    
}
