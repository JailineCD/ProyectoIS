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
import umg.edu.gt.DTO.TipoExamenDTO;
/**
 *
 * @author Luis Velasquez
 */
public class TipoExamenDAO implements Serializable {
    
    
    public List<TipoExamenDTO> findAllTipoExamen() {
        Transaction transaction = null;
        List<TipoExamenDTO> TipoExamen = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            TipoExamen = session.createQuery("FROM TipoExamenDTO", TipoExamenDTO.class).list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al realizar la consulta: " + ex.getMessage());
        }
        return TipoExamen;
    }
    
    
    public void insertarTipoExamen(TipoExamenDTO tipoExamen) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tipoExamen.setEstado("ACTIVO"); 
            session.save(tipoExamen);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al insertar el tipo de examen de laboratorio", e);
        }
    }
    
    public void actualizarTipoExamen(TipoExamenDTO tipoExamen) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(tipoExamen);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void eliminarTipoExamen(TipoExamenDTO tipoExamen) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tipoExamen.setEstado("INACTIVO");
            session.update(tipoExamen);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
}
