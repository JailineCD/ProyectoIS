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

    private List<TipoExamenDTO> listaTipoExamen;  
    private TipoExamenDTO selectedTipoExamen; 
    @PostConstruct
    public void init() {
        mostrarTipoExamen();
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
    
}
