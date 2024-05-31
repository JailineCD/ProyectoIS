/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.TipoExamenFisicoDTO;

/**
 *
 * @author duper
 */
public class TipoExamenFisicoDAO {
 
    public void insertarTipoExamenFisico(TipoExamenFisicoDTO tipoExamenFisico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tipoExamenFisico);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el tipo de examen físico", e);
        }
    }
    
    public void actualizarTipoExamenFisico(TipoExamenFisicoDTO tipoExamenFisico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(tipoExamenFisico);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el tipo de examen físico", e);
        }
    }

    public void eliminarTipoExamenFisico(TipoExamenFisicoDTO tipoExamenFisico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tipoExamenFisico);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el tipo de examen físico", e);
        }
    }

    public List<TipoExamenFisicoDTO> obtenerTiposExamenFisico() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM TipoExamenFisicoDTO", TipoExamenFisicoDTO.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los tipos de examen físico", e);
        }
    }
}
