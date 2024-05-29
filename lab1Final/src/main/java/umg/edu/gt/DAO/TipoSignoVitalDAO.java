/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.TipoSignoVitalDTO;


/**
 *
 * @author duper
 */
public class TipoSignoVitalDAO {
   
    public void insertarTipoSignoVital(TipoSignoVitalDTO nuevoTipoSignoVital) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(nuevoTipoSignoVital);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw new Exception("Error al insertar TipoSignoVital. " + ex.getMessage());
        }
    }

    public TipoSignoVitalDTO findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(TipoSignoVitalDTO.class, id);
        }
    }

    public List<TipoSignoVitalDTO> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from TipoSignoVitalDTO", TipoSignoVitalDTO.class).list();
        }
    }

    public void actualizarTipoSignoVital(TipoSignoVitalDTO tipoSignoVital) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(tipoSignoVital);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw new Exception("Error al actualizar TipoSignoVital. " + ex.getMessage());
        }
    }

    public void eliminarTipoSignoVital(TipoSignoVitalDTO tipoSignoVital) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tipoSignoVital);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw new Exception("Error al eliminar TipoSignoVital. " + ex.getMessage());
        }
    }
}
