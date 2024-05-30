/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.DAO;

import Util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import umg.edu.gt.DTO.AntecedenteClinicoDTO;

/**
 * Clase de acceso a datos para AntecedenteClinico
 * 
 * @autor Luis Velasquez
 */
public class AntecedenteClinicoDAO implements Serializable {

    public void guardar(AntecedenteClinicoDTO antecedenteClinico) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // Guardar el antecedente clínico y obtener el ID generado
            session.update(antecedenteClinico);
            session.flush();  
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al guardar el antecedente clínico: " + e.getMessage());
        }
    }
}
