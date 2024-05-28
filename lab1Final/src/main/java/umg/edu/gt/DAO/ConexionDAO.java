package umg.edu.gt.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConexionDAO {
    
    private String url = "";
    private String usuario = "";
    private String contraseña = "";

    public void Credenciales() {
        Properties prop = new Properties();
        try {
            File configDirec = new File(System.getProperty("catalina.base"));
            File configFile = new File(configDirec, "conf/umg-filesystem.properties");
            InputStream stream;
            stream = new FileInputStream(configFile);
            prop.load(stream);

            usuario = prop.getProperty("usuario");
            contraseña = prop.getProperty("contraseña");
            url = prop.getProperty("url");
            System.out.println("Se ha obtenido las credenciales correctamente.");
        } catch (Exception ex) {
            System.out.println("Error al obtener las credenciales." + ex);
        }
    }

    public Connection conexionMysql() throws Exception {
        this.Credenciales();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection(getUrl(), getUsuario(), getContraseña());
        System.out.println("la conexion es exitosa: " + conexion);
        return conexion;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseÃ±a
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}