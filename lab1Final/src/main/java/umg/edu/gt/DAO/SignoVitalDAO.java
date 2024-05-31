package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.SignoVitalDTO;
/**
 *
 * @author Luis Velasquez
 */
public class SignoVitalDAO implements Serializable {

    public void guardar(SignoVitalDTO signoVital) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(signoVital);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al guardar el signo vital: " + e.getMessage());
        }
    }
}
