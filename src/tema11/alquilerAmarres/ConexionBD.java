package tema11.alquilerAmarres;
//patron SW SingleTon

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    private File datosConexion;
    private String cargarDriver, tipoBD, ip, ruta, usuario, contrasena, puerto;
    private static Connection conexion;

    private ConexionBD() {
        datosConexion = new File("datosConexionBD.ini");
        BufferedReader lector = null;
        String dato[] = new String[3];
        try {
            lector = new BufferedReader(new FileReader(datosConexion));
            String linea = lector.readLine();
            while (linea != null) {
                dato = linea.split("=");
                if (dato[0].equals("Cargar Driver")) {
                    cargarDriver = dato[1].trim();
                } else if (dato[0].equals("Tipo de base de datos")) {
                    tipoBD = dato[1].trim();
                } else if (dato[0].equals("IP")) {
                    ip = dato[1].trim();
                } else if (dato[0].equals("ruta")) {
                    ruta = dato[1].trim();
                } else if (dato[0].equals("usuario")) {
                    usuario = dato[1].trim();
                } else if (dato[0].equals("contraseña")) {
                    contrasena = dato[1].trim();
                } else if (dato[0].equals("Puerto")) {
                    puerto = dato[1].trim();
                }
                linea = lector.readLine();
            }
            //cargar driver
            Class.forName(cargarDriver);
            // crear conexion 
            //hacer conexion
            conexion = DriverManager.getConnection(tipoBD + ip + puerto + ruta, usuario, contrasena);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lector.close();
            } catch (IOException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Connection getConection() {
        if (conexion == null) {
            new ConexionBD();
            return conexion;
        } else {
            return conexion;
        }
    }
}
