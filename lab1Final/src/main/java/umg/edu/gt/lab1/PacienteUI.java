package umg.edu.gt.lab1;

import Util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static jdk.internal.joptsimple.internal.Messages.message;
import org.hibernate.Session;
import umg.edu.gt.DAO.ConexionDAO;
import umg.edu.gt.DAO.PacienteDAO;
import umg.edu.gt.DAO.SignoVitalDAO;
import umg.edu.gt.DTO.AntecedenteClinicoDTO;
import umg.edu.gt.DTO.EmpleadosDTO;
import umg.edu.gt.DTO.PacienteDTO;
import umg.edu.gt.DTO.SignoVitalDTO;
import umg.edu.gt.DTO.TipoExamenDTO; 

@ManagedBean(name = "pacienteUI")
@ViewScoped
public class PacienteUI implements Serializable {

    /**
     * @return the observacionGenerosUI
     */
    public ObservacionGenerosUI getObservacionGenerosUI() {
        return observacionGenerosUI;
    }

    /**
     * @param observacionGenerosUI the observacionGenerosUI to set
     */
    public void setObservacionGenerosUI(ObservacionGenerosUI observacionGenerosUI) {
        this.observacionGenerosUI = observacionGenerosUI;
    }

    /**
     * @return the examenFisicosUI
     */
    public ExamenFisicosUI getExamenFisicosUI() {
        return examenFisicosUI;
    }

    /**
     * @param examenFisicosUI the examenFisicosUI to set
     */
    public void setExamenFisicosUI(ExamenFisicosUI examenFisicosUI) {
        this.examenFisicosUI = examenFisicosUI;
    }

    /**
     * @return the aparatoSistemasUI
     */
    public AparatoSistemasUI getAparatoSistemasUI() {
        return aparatoSistemasUI;
    }

    /**
     * @param aparatoSistemasUI the aparatoSistemasUI to set
     */
    public void setAparatoSistemasUI(AparatoSistemasUI aparatoSistemasUI) {
        this.aparatoSistemasUI = aparatoSistemasUI;
    }

    /**
     * @return the signosVitalesUI
     */
    public SignosVitalesUI getSignosVitalesUI() {
        return signosVitalesUI;
    }

    /**
     * @param signosVitalesUI the signosVitalesUI to set
     */
    public void setSignosVitalesUI(SignosVitalesUI signosVitalesUI) {
        this.signosVitalesUI = signosVitalesUI;
    }
    
    @ManagedProperty("#{antecedentesClinicosUI}")
    private AntecedentesClinicosUI antecedentesClinicosUI; // Inyectamos el bean
     
    
    private AntecedenteClinicoDTO nuevoAntecedenteClinico;
    
    
    @ManagedProperty("#{signosVitalesUI}")
    private SignosVitalesUI signosVitalesUI; // Inyectamos el bean
     
    
    private SignoVitalDTO nuevoSignoVital;
    // Getter y setter para antecedentesClinicosUI
    public AntecedentesClinicosUI getAntecedentesClinicosUI() {
        return antecedentesClinicosUI;
    }

    public void setAntecedentesClinicosUI(AntecedentesClinicosUI antecedentesClinicosUI) {
        this.antecedentesClinicosUI = antecedentesClinicosUI;
    }
    
    public AntecedenteClinicoDTO getNuevoAntecedenteClinico() {
        return nuevoAntecedenteClinico;
    }

    public void setNuevoAntecedenteClinico(AntecedenteClinicoDTO nuevoAntecedenteClinico) {
        this.nuevoAntecedenteClinico = nuevoAntecedenteClinico;
    }
    @ManagedProperty("#{aparatoSistemasUI}")
    private AparatoSistemasUI aparatoSistemasUI;
    @ManagedProperty("#{examenFisicosUI}")
    private ExamenFisicosUI examenFisicosUI;
    @ManagedProperty("#{observacionGenerosUI}")
    private ObservacionGenerosUI observacionGenerosUI;
    @Override
    public String toString() {
        return "PacienteDTO@" + Integer.toHexString(hashCode());
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isAptoLaborar() {
        return aptoLaborar;
    }

    public void setAptoLaborar(boolean aptoLaborar) {
        this.aptoLaborar = aptoLaborar;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    private int selectedEmpleadoCue;
    private int selectedTipoExamenId;
    private Date fecha;
    private String recomendacion;
    private boolean aptoLaborar;
    private Date fechaVencimiento;
    private List<EmpleadosDTO> empleados;
    private List<TipoExamenDTO> tiposExamen;

    public PacienteUI() {
        cargarEmpleados();
        cargarTiposExamen(); 
    }

    public int getSelectedEmpleadoCue() {
        return selectedEmpleadoCue;
    }

    public void setSelectedEmpleadoCue(int selectedEmpleadoCue) {
        this.selectedEmpleadoCue = selectedEmpleadoCue;
    }

    public int getSelectedTipoExamenId() {
        return selectedTipoExamenId;
    }

    public void setSelectedTipoExamenId(int selectedTipoExamenId) {
        this.selectedTipoExamenId = selectedTipoExamenId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<EmpleadosDTO> getEmpleados() {
        return empleados;
    }

    public List<TipoExamenDTO> getTiposExamen() {
        return tiposExamen;
    }

    public void cargarEmpleados() {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            empleados = session.createQuery("FROM EmpleadosDTO", EmpleadosDTO.class).list();
        } finally {
            conexion.CerrarSesion(session);
        }
    }

    public void cargarTiposExamen() {
        ConexionDAO conexion = new ConexionDAO();
        Session session = conexion.obtenerSesion();
        try {
            tiposExamen = session.createQuery("FROM TipoExamenDTO", TipoExamenDTO.class).list();
        } finally {
            conexion.CerrarSesion(session);
        }
    }

    public List<AntecedenteClinicoDTO> getAntecedentesClinicosPorIdPaciente(Long idPaciente) {
        List<AntecedenteClinicoDTO> antecedentesClinicos = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String queryStr = "SELECT * FROM AntecedenteClinicoDTO ac WHERE ac.idPaciente.id = :idPaciente";
            antecedentesClinicos = session.createQuery(queryStr, AntecedenteClinicoDTO.class)
                                          .setParameter("idPaciente", idPaciente)
                                          .list();
        } catch (Exception e) {
            System.out.println("Error al obtener los antecedentes clínicos por ID de paciente: " + e.getMessage());
        }
        return antecedentesClinicos;
    }
    
    public void filtro() {
    // Verificar si ya existe un registro con la misma fecha, paciente y tipo de examen
    PacienteDAO pacienteDAO = new PacienteDAO();
    PacienteDTO pacienteExistente = pacienteDAO.obtenerPacienteExistente(fecha, selectedEmpleadoCue, selectedTipoExamenId);
    
    if (pacienteExistente != null) {
        // Se encontró un paciente existente, cargar los campos adicionales
        setRecomendacion(pacienteExistente.getRecomendacion());
        setAptoLaborar(pacienteExistente.isAptoLaborar());
        setFechaVencimiento(pacienteExistente.getFechaVencimiento());
        
        // Cargar los antecedentes clínicos asociados al paciente existente
        Long idPacienteExistente = pacienteExistente.getId();
        antecedentesClinicosUI.cargarAntecedenteClinico(idPacienteExistente);
        signosVitalesUI.cargarSignosVitales(idPacienteExistente);
        aparatoSistemasUI.cargarAparatoSistemas(idPacienteExistente);
        examenFisicosUI.cargarExamenFisico(idPacienteExistente);
        observacionGenerosUI.cargarObservacionGeneros(idPacienteExistente);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Se encontró un registro existente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    } else {
        // No se encontró un registro existente
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "No se encontró ningún registro existente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void guardarPaciente() {
        PacienteDAO pacienteDAO = new PacienteDAO(); 
        // Verificar si ya existe un registro con los mismos valores de fecha, paciente y tipo de examen
        boolean registroExistente = pacienteDAO.existeRegistroExistente(fecha, selectedEmpleadoCue, selectedTipoExamenId);
        if (registroExistente) {
            // Obtener el paciente existente
            PacienteDTO pacienteExistente = pacienteDAO.obtenerPacienteExistente(fecha, selectedEmpleadoCue, selectedTipoExamenId);
            // Actualizar los campos del paciente existente con los nuevos valores
            pacienteExistente.setRecomendacion(getRecomendacion());
            pacienteExistente.setAptoLaborar(aptoLaborar);
            pacienteExistente.setFechaVencimiento(fechaVencimiento); 
            pacienteDAO.actualizar(pacienteExistente); 
            Long generatedId = pacienteExistente.getId();
            antecedentesClinicosUI.cargarAntecedenteClinico(generatedId);
            signosVitalesUI.cargarSignosVitales(generatedId);
            aparatoSistemasUI.cargarAparatoSistemas(generatedId);
            examenFisicosUI.cargarExamenFisico(generatedId);
            observacionGenerosUI.cargarObservacionGeneros(generatedId);
        } else {
            // Si no existe un registro con los mismos valores, guardar un nuevo paciente
            PacienteDTO pacienteNuevo = new PacienteDTO();
            pacienteNuevo.setFecha(fecha);
            pacienteNuevo.setRecomendacion(getRecomendacion());
            pacienteNuevo.setCue(selectedEmpleadoCue);
            pacienteNuevo.setAptoLaborar(aptoLaborar);
            pacienteNuevo.setIdTipoExamen(selectedTipoExamenId);
            pacienteNuevo.setFechaVencimiento(fechaVencimiento);

            pacienteDAO.guardar(pacienteNuevo); 
            // Cargar los antecedentes clínicos asociados al nuevo paciente
            Long generatedId = pacienteNuevo.getId();
            antecedentesClinicosUI.cargarAntecedenteClinico(generatedId); 
            signosVitalesUI.cargarSignosVitales(generatedId); 
            aparatoSistemasUI.cargarAparatoSistemas(generatedId);
            examenFisicosUI.cargarExamenFisico(generatedId);
            observacionGenerosUI.cargarObservacionGeneros(generatedId);
        }
    }

    
}
