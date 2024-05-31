package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction; 
import umg.edu.gt.DTO.ObservacionGeneroDTO;
/**
 *
 * @author Luis Velasquez
 */
public class ObservacionGeneroDAO implements Serializable {

    public void guardar(ObservacionGeneroDTO observacionGenero) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(observacionGenero);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al guardar el observacion genero: " + e.getMessage());
        }
        
        
    }
}
