/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.TipoSignoVitalDTO;


/**
 *
 * @author duper
 */
public class TipoSignoVitalDAO implements Serializable {
   
    public void insertarTipoSignoVital(TipoSignoVitalDTO nuevoTipoSignoVital) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
             nuevoTipoSignoVital.setCreate_time(LocalDateTime.now());
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

    public List<TipoSignoVitalDTO> obtenerTiposSignosVitales() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM TipoSignoVitalDTO", TipoSignoVitalDTO.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los tipos de signos vitales", e);
        }
    }

    public void actualizarTipoSignoVital(TipoSignoVitalDTO tipoSignoVital) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tipoSignoVital.setUpdate_time(LocalDateTime.now());
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
