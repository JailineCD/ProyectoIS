/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.lab1;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import umg.edu.gt.DAO.PacienteDAO;
import umg.edu.gt.DTO.PacienteDTO;

/**
 *
 * @author Luis Velasquez
 */
@ManagedBean(name = "Paciente")
@ViewScoped
public class PacienteUI implements Serializable {

    private PacienteDTO paciente;
    private PacienteDAO pacienteDAO;

    public PacienteUI() {
        paciente = new PacienteDTO();
        pacienteDAO = new PacienteDAO();
    }

    public void guardarPaciente() {
        try {
            pacienteDAO.guardar(paciente);
            // Agregar mensaje de éxito o realizar alguna otra acción
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
        }
    }

    public void updatePaciente() {
        try {
            //pacienteDAO.update(paciente);
            // Agregar mensaje de éxito o realizar alguna otra acción
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
        }
    }

    public void deletePaciente() {
        try {
            //pacienteDAO.delete(paciente);
            // Agregar mensaje de éxito o realizar alguna otra acción
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
        }
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }
}