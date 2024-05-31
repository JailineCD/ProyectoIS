package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.EmpleadosDTO;

public class EmpleadosDAO implements Serializable {

    public List<EmpleadosDTO> findAllEmpleados() {
        Transaction transaction = null;
        List<EmpleadosDTO> empleados = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            empleados = session.createQuery("FROM EmpleadosDTO", EmpleadosDTO.class).list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al realizar la consulta: " + ex.getMessage());
        }
        return empleados;
    }
}
