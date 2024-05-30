package umg.edu.gt.lab1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import umg.edu.gt.DAO.EmpleadosDAO;
import umg.edu.gt.DTO.EmpleadosDTO;

@ManagedBean(name = "inicioEmpleado")
@ViewScoped
public class InicioEmpleadoUI implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<EmpleadosDTO> listaEmpleados;
    private List<Long> listaCues;
    private Long selectedCue;
    private EmpleadosDTO selectedEmpleado;

    @PostConstruct
    public void init() {
        mostrarEmpleados();
        cargarCues();
    }

    public void mostrarEmpleados() {
        EmpleadosDAO consulta = new EmpleadosDAO();
        try {
            listaEmpleados = consulta.findAllEmpleados();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al obtener la lista de empleados");
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println("Error al obtener la lista de empleados: " + ex.getMessage());
        }
    }

    public void cargarCues() {
        if (listaEmpleados != null) {
            listaCues = new ArrayList<>();
            for (EmpleadosDTO empleado : listaEmpleados) {
                listaCues.add(empleado.getCue());
            }
        } else {
            listaCues = new ArrayList<>(); // Manejar el caso donde listaEmpleados es nulo
        }
    }

    public void seleccionarEmpleado() {
        if (selectedCue != null) {
            for (EmpleadosDTO empleado : listaEmpleados) {
                if (empleado.getCue().equals(selectedCue)) {
                    selectedEmpleado = empleado;
                    break;
                }
            }
        }
    }

    // Getters y Setters

    public List<EmpleadosDTO> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<EmpleadosDTO> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Long> getListaCues() {
        return listaCues;
    }

    public void setListaCues(List<Long> listaCues) {
        this.listaCues = listaCues;
    }

    public Long getSelectedCue() {
        return selectedCue;
    }

    public void setSelectedCue(Long selectedCue) {
        this.selectedCue = selectedCue;
    }

    public EmpleadosDTO getSelectedEmpleado() {
        return selectedEmpleado;
    }

    public void setSelectedEmpleado(EmpleadosDTO selectedEmpleado) {
        this.selectedEmpleado = selectedEmpleado;
    }
}
