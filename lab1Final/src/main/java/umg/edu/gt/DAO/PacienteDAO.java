/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO; 
import Util.HibernateUtil;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import umg.edu.gt.DTO.PacienteDTO; 

/**
 *
 * @author Luis Velasquez
 */
public class PacienteDAO implements Serializable { 
    
    public Long obtenerIdPacienteExistente(Date fecha, int empleadoCue, int tipoExamenId) {
    Long idPacienteExistente = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        // Consultar el ID del paciente existente con los mismos valores de fecha, paciente y tipo de examen
        String queryStr = "SELECT p.id FROM PacienteDTO p " +
                          "WHERE p.fecha = :fecha " +
                          "AND p.cue = :empleadoCue " +
                          "AND p.idTipoExamen = :tipoExamenId";
        idPacienteExistente = (Long) session.createQuery(queryStr)
                                  .setParameter("fecha", fecha)
                                  .setParameter("empleadoCue", empleadoCue)
                                  .setParameter("tipoExamenId", tipoExamenId)
                                  .uniqueResult();
    } catch (Exception e) {
        System.out.println("Error al obtener el ID del paciente existente: " + e.getMessage());
    }
    return idPacienteExistente;
}
    public boolean existeRegistroExistente(Date fecha, int empleadoCue, int tipoExamenId) {
    boolean existeRegistro = false;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        // Consultar si existe un registro con los mismos valores de fecha, paciente y tipo de examen
        String queryStr = "SELECT COUNT(*) FROM PacienteDTO p " +
                          "WHERE p.fecha = :fecha " +
                          "AND p.cue = :empleadoCue " +
                          "AND p.idTipoExamen = :tipoExamenId";
        Long count = (Long) session.createQuery(queryStr)
                                  .setParameter("fecha", fecha)
                                  .setParameter("empleadoCue", empleadoCue)
                                  .setParameter("tipoExamenId", tipoExamenId)
                                  .uniqueResult();
        
        // Si el recuento es mayor que cero, significa que ya existe un registro con los mismos valores
        existeRegistro = count > 0;
    } catch (Exception e) {
        System.out.println("Error al verificar si existe un registro existente: " + e.getMessage());
    }
    return existeRegistro;
}
    public void guardar(PacienteDTO paciente) {
       Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // Filtrar los antecedentes clínicos por el ID del paciente
            
            // Guardar el paciente y obtener el ID generado
            session.save(paciente);
            session.flush();  
            Long generatedId = paciente.getId();
            // Llamar al procedimiento almacenado con el ID generado
            String callProcedure = "CALL insertarDatosPacientes(:id)";
            NativeQuery<?> query = session.createSQLQuery(callProcedure);
            query.setParameter("id", generatedId);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al guardar el paciente: " + e.getMessage());
        }
    }
    public PacienteDTO obtenerPacienteExistente(Date fecha, int empleadoCue, int tipoExamenId) {
    PacienteDTO pacienteExistente = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        String queryStr = "FROM PacienteDTO p " +
                          "WHERE p.fecha = :fecha " +
                          "AND p.cue = :empleadoCue " +
                          "AND p.idTipoExamen = :tipoExamenId";
        pacienteExistente = session.createQuery(queryStr, PacienteDTO.class)
                                  .setParameter("fecha", fecha)
                                  .setParameter("empleadoCue", empleadoCue)
                                  .setParameter("tipoExamenId", tipoExamenId)
                                  .uniqueResult();
    } catch (Exception e) {
        System.out.println("Error al obtener el paciente existente: " + e.getMessage());
    }
        return pacienteExistente;
    }


    
    public void actualizar(PacienteDTO paciente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // Actualizar el paciente en la base de datos
            session.update(paciente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al actualizar el paciente: " + e.getMessage());
        }
    }
}
