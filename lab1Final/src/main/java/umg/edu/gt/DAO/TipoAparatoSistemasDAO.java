/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.TipoAparatoSistemasDTO;

/**
 *
 * @author Douglas
 */
public class TipoAparatoSistemasDAO {
    
    public void insertarTipoAparatoSistemas(TipoAparatoSistemasDTO tipoAparatoSistemas) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tipoAparatoSistemas.setCreate_time(LocalDateTime.now());
            session.save(tipoAparatoSistemas);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el tipo de aparato o sistema", e);
        }
    }
    
    public List<TipoAparatoSistemasDTO> obtenerListaAparatos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from TipoAparatoSistemasDTO", TipoAparatoSistemasDTO.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la lista de tipos de aparatos o sistemas", e);
        }
    }

    public void actualizarTipoAparatoSistemas(TipoAparatoSistemasDTO tipoAparatoSistemas) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tipoAparatoSistemas.setUpdate_time(LocalDateTime.now());
            session.update(tipoAparatoSistemas);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el tipo de aparato o sistema", e);
        }
    }

    public void eliminarTipoAparatoSistemas(TipoAparatoSistemasDTO tipoAparatoSistemas) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tipoAparatoSistemas);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el tipo de aparato o sistema", e);
        }
    }
    
}
