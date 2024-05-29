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
    private List<TipoSignoVitalDTO> tipoSignoVitalList;
    private TipoSignoVitalDAO tipoSignoVitalDAO = new TipoSignoVitalDAO();
    
    
    private String clave;
    private String descripcion;
    
    public void guardarSignoVital() {
        tipoSignoVital = new TipoSignoVitalDTO();
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
    
    
    
    @PostConstruct
    public void init() {
        tipoSignoVitalList = tipoSignoVitalDAO.findAll();
    }

       
    public void guardarTipoSignoVital() {
    try {
        System.out.println("Ingresando a guardar tipo de signo vital: " + tipoSignoVital);
        if (tipoSignoVital.getClave() == null || tipoSignoVital.getClave().isEmpty() 
                || tipoSignoVital.getDescripcion() == null || tipoSignoVital.getDescripcion().isEmpty()) {
            System.out.println("Error. Clave y descripción no deben estar vacios");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "La clave y descripción no deben estar vacios.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            tipoSignoVitalDAO.insertarTipoSignoVital(tipoSignoVital);
            this.clave = "";
            this.descripcion = "";
            this.tipoSignoVital = new TipoSignoVitalDTO();
            //System.out.println("el tipo signo vital ha insertado correctamente");
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El Tipo de Signo Vital ha sido insertado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
            // Actualizar la lista de tipos de signo vital si es necesario
        }
    } catch (Exception e) {
        e.printStackTrace();
        //System.out.println("error al insertar el tipo de signo vital " + e.getMessage());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al insertar el Tipo de Signo Vital: " + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}



    public void updateTipoSignoVital() {
        try {
            tipoSignoVitalDAO.actualizarTipoSignoVital(tipoSignoVital);
            // Actualizar la lista en la vista si es necesario
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores, agregar mensaje de error a la vista
        }
    }

    public void deleteTipoSignoVital(TipoSignoVitalDTO tipoSignoVital) {
        try {
            tipoSignoVitalDAO.eliminarTipoSignoVital(tipoSignoVital);
            tipoSignoVitalList.remove(tipoSignoVital);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores, agregar mensaje de error a la vista
        }
    }

    // Getters y Setters
    public TipoSignoVitalDTO getTipoSignoVital() {
        return tipoSignoVital;
    }

    public void setTipoSignoVital(TipoSignoVitalDTO tipoSignoVital) {
        this.tipoSignoVital = tipoSignoVital;
    }

    public List<TipoSignoVitalDTO> getTipoSignoVitalList() {
        return tipoSignoVitalList;
    }

    public void setTipoSignoVitalList(List<TipoSignoVitalDTO> tipoSignoVitalList) {
        this.tipoSignoVitalList = tipoSignoVitalList;
    }

}


