/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.ExamenFisicoDTO;

/**
 *
 * @author Luis Velasquez
 */
public class ExamenFisicoDAO implements Serializable {
    public void guardar(ExamenFisicoDTO examenFisico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(examenFisico);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al guardar el examen fisico: " + e.getMessage());
        }
        
        
    }
    
}
