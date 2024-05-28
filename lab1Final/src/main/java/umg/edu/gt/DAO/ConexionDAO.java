package umg.edu.gt.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConexionDAO {
    
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session obtenerSesion() {
        return sessionFactory.openSession();
    }

    public void CerrarSesion(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void Credenciales(){
        Properties prop = new Properties();
        try {
            File configDirec = new File(System.getProperty("catalina.base"), "conf");
            File configFile = new File(configDirec, "umg-filesystem.properties");
            InputStream stream = new FileInputStream(configFile);
            prop.load(stream);
            String usuario = prop.getProperty("usuario");
            String contraseña = prop.getProperty("clave");
            String url = prop.getProperty("url");
        } catch (Exception ex) {
            System.out.println("Error de credenciales: " + ex);
        }
    }
}