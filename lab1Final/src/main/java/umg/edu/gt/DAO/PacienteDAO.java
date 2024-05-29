/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO; 
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.PacienteDTO;

/**
 *
 * @author Luis Velasquez
 */
public class PacienteDAO {
    public void guardar(PacienteDTO paciente) {
        System.out.println("El empleado con CUE " + paciente.getCue() + " no existe.");
    

        Transaction transaction = null;
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(paciente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al guardar el paciente: " + e.getMessage());
        }
    }
}
