/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.TipoAntecedenteClinicoDTO;

/**
 *
 * @author Douglas
 */
public class TipoAntecedenteClinicoDAO {
    
     public void insertarTipoAntecedenteClinico(TipoAntecedenteClinicoDTO tipoAntecedenteClinico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tipoAntecedenteClinico);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
     
     public void actualizarTipoAntecedenteClinico(TipoAntecedenteClinicoDTO tipoAntecedenteClinico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(tipoAntecedenteClinico);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void eliminarTipoAntecedenteClinico(TipoAntecedenteClinicoDTO tipoAntecedenteClinico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tipoAntecedenteClinico);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<TipoAntecedenteClinicoDTO> obtenerTiposAntecedentesClinicos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM TipoAntecedenteClinicoDTO", TipoAntecedenteClinicoDTO.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
