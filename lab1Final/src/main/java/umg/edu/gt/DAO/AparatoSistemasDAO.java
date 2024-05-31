package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.AparatoSistemasDTO;
/**
 *
 * @author Luis Velasquez
 */
public class AparatoSistemasDAO implements Serializable {

    public void guardar(AparatoSistemasDTO aparatoSistemas) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(aparatoSistemas);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al guardar el aparato/sistema: " + e.getMessage());
        }
    }
}
