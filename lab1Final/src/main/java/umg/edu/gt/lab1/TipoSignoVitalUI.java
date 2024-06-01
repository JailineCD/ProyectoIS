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
import umg.edu.gt.DAO.TipoSignoVitalDAO;
import umg.edu.gt.DTO.TipoSignoVitalDTO;

/**
 *
 * @author duper
 */
@ManagedBean(name = "bkn_TipoSignoVital")
@ViewScoped
public class TipoSignoVitalUI implements Serializable {
    
    private TipoSignoVitalDTO tipoSignoVital = new TipoSignoVitalDTO();
    private TipoSignoVitalDAO tipoSignoVitalDAO = new TipoSignoVitalDAO();
    private List<TipoSignoVitalDTO> listaSignosVitales;
    
    
    private String clave;
    private String descripcion;
    private String estado;
    
    
    public void guardarSignoVital() {
        tipoSignoVital = new TipoSignoVitalDTO();
    }
    
   
   @PostConstruct
    public void init() {
        actualizarListaSignosVitales();
    }

    public void actualizarListaSignosVitales() {
        listaSignosVitales = tipoSignoVitalDAO.obtenerTiposSignosVitales();
    }

    public void addTipoSignoVital() {
        tipoSignoVital = new TipoSignoVitalDTO();
    }
       
    public void guardarTipoSignoVital() {
    try {
        System.out.println("Ingresando a guardar tipo de signo vital: " + tipoSignoVital);
        if (tipoSignoVital.getClave() == null || tipoSignoVital.getClave().isEmpty() 
                || tipoSignoVital.getDescripcion() == null || tipoSignoVital.getDescripcion().isEmpty()) {
            System.out.println("Error. Clave y descripción no deben estar vacios");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Clave y descripción son obligatorios");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            tipoSignoVitalDAO.insertarTipoSignoVital(tipoSignoVital);
            System.out.println("Insertado correctamente");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Se ha insertado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, message);
            actualizarListaSignosVitales();
            this.clave = "";
            this.descripcion = "";
            this.tipoSignoVital = new TipoSignoVitalDTO();
            // Actualizar la lista de tipos de signo vital si es necesario
        }
    } catch (Exception e) {
        e.printStackTrace();
        //System.out.println("error al insertar el tipo de signo vital " + e.getMessage());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al insertar el Tipo de Signo Vital: " + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}



    public void guardarCambios(TipoSignoVitalDTO signoVital) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            tipoSignoVitalDAO.actualizarTipoSignoVital(signoVital);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cambios guardados correctamente"));
            actualizarListaSignosVitales();
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar los cambios del tipo de signo vital " + e.getMessage()));
        }
    }

    public void eliminar(TipoSignoVitalDTO signoVital) {
        try {
            tipoSignoVitalDAO.eliminarTipoSignoVital(signoVital);
            actualizarListaSignosVitales();
            System.out.println("Eliminado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el tipo de signo vital " + e.getMessage());
        }
    }
    
    
    public void onRowEdit(RowEditEvent<TipoSignoVitalDTO> event) {
        TipoSignoVitalDTO signoVitalEditado = event.getObject();
        guardarCambios(signoVitalEditado);
    }

    public void onRowCancel(RowEditEvent<TipoSignoVitalDTO> event) {
        TipoSignoVitalDTO signoVitalCancelado = event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición cancelada", "Se canceló la edición");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // Getters y Setters
    public TipoSignoVitalDTO getTipoSignoVital() {
        return tipoSignoVital;
    }

    public void setTipoSignoVital(TipoSignoVitalDTO tipoSignoVital) {
        this.tipoSignoVital = tipoSignoVital;
    }

   public List<TipoSignoVitalDTO> getListaSignosVitales() {
        return listaSignosVitales;
    }

    public void setListaSignosVitales(List<TipoSignoVitalDTO> listaSignosVitales) {
        this.listaSignosVitales = listaSignosVitales;
    }
    
    // Getters y Setters para clave y descripcion
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}


