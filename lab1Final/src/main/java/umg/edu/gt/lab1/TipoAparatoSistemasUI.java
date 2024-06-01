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
import umg.edu.gt.DAO.TipoAparatoSistemasDAO;
import umg.edu.gt.DTO.TipoAparatoSistemasDTO;

/**
 *
 * @author Douglas
 */
@ManagedBean(name = "bkn_Tipo_Aparato_Sistemas")
@ViewScoped
public class TipoAparatoSistemasUI implements Serializable {
    
    private TipoAparatoSistemasDTO tipoAparatoSistemas = new TipoAparatoSistemasDTO();
    private TipoAparatoSistemasDAO tipoAparatoSistemasDAO = new TipoAparatoSistemasDAO();
    private List<TipoAparatoSistemasDTO> listaAparatos;
    
    private String clave;
    private String descripcion;
    
    @PostConstruct
    public void init() {
        actualizarListaAparatos();
    }

    public void actualizarListaAparatos() {
        setListaAparatos(tipoAparatoSistemasDAO.obtenerListaAparatos());
    }

    public void addTipoAparatoSistemas() {
        tipoAparatoSistemas = new TipoAparatoSistemasDTO();
    }

    public TipoAparatoSistemasDTO getTipoAparatoSistemas() {
        return tipoAparatoSistemas;
    }

    public void setTipoAparatoSistemas(TipoAparatoSistemasDTO tipoAparatoSistemas) {
        this.tipoAparatoSistemas = tipoAparatoSistemas;
    }

    public void guardarTipoAparatoSistemas() {
        try {
            if (tipoAparatoSistemas.getClave() == null || tipoAparatoSistemas.getClave().isEmpty() ||
                tipoAparatoSistemas.getDescripcion() == null || tipoAparatoSistemas.getDescripcion().isEmpty()) {
                System.out.println("Error: clave y descripcion son obligatorios");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Clave y descripción son obligatorios");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                tipoAparatoSistemasDAO.insertarTipoAparatoSistemas(tipoAparatoSistemas);
                actualizarListaAparatos();
                System.out.println("Insertado correctamente");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se ha insertado correctamente");
                FacesContext.getCurrentInstance().addMessage(null, message);
                this.clave = "";
                this.descripcion = "";
                tipoAparatoSistemas = new TipoAparatoSistemasDTO(); // Resetear el formulario
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el tipo de aparato o sistema " + e.getMessage());
        }
    }
    
    public void guardarCambios(TipoAparatoSistemasDTO aparato) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            tipoAparatoSistemasDAO.actualizarTipoAparatoSistemas(aparato);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cambios guardados correctamente"));
            actualizarListaAparatos();
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los cambios del tipo de aparato o sistema " + e.getMessage()));
        }
    }

    public void onRowEdit(RowEditEvent<TipoAparatoSistemasDTO> event) {
        TipoAparatoSistemasDTO aparatoEditado = event.getObject();
        guardarCambios(aparatoEditado);
    }

    public void onRowCancel(RowEditEvent<TipoAparatoSistemasDTO> event) {
        TipoAparatoSistemasDTO aparatoCancelado = event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición cancelada", "Se canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void eliminar(TipoAparatoSistemasDTO aparato) {
        try {
            tipoAparatoSistemasDAO.eliminarTipoAparatoSistemas(aparato);
            actualizarListaAparatos();
            System.out.println("Eliminado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el tipo de aparato o sistema " + e.getMessage());
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

    public List<TipoAparatoSistemasDTO> getListaAparatos() {
        return listaAparatos;
    }

    public void setListaAparatos(List<TipoAparatoSistemasDTO> listaAparatos) {
        this.listaAparatos = listaAparatos;
    }
}
