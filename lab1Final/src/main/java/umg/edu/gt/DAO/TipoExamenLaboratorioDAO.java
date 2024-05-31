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
import org.hibernate.query.Query;
import umg.edu.gt.DTO.TipoExamenLaboratorioDTO;

/**
 *
 * @author Douglas
 */
public class TipoExamenLaboratorioDAO {
    
    public void insertarTipoExamenLaboratorio(TipoExamenLaboratorioDTO tipoExamenLaboratorio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tipoExamenLaboratorio.setCreate_time(LocalDateTime.now());
            tipoExamenLaboratorio.setEstado("Activo"); 
            session.save(tipoExamenLaboratorio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al insertar el tipo de examen de laboratorio", e);
        }
    }
    
    public void actualizarTipoExamenLaboratorio(TipoExamenLaboratorioDTO tipoExamenLaboratorio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tipoExamenLaboratorio.setUpdate_time(LocalDateTime.now());
            session.update(tipoExamenLaboratorio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void eliminarTipoExamenLaboratorio(TipoExamenLaboratorioDTO tipoExamenLaboratorio) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tipoExamenLaboratorio.setEstado("Inactivo");
            session.update(tipoExamenLaboratorio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<TipoExamenLaboratorioDTO> obtenerTiposExamenLaboratorio() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from TipoExamenLaboratorioDTO", TipoExamenLaboratorioDTO.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
