/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema11.Clientes;

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

/**
 *
 * @author VESPERTINO
 */
public class ConexionBD {

    private File f;
    private BufferedReader br;
    private String driver, bd, user, pw, port, host, ruta;
    private static Connection con;

    private ConexionBD() {
        String[] linea2 = new String[3];
        try {
            f = new File("datosConexionBD.ini");
            br = new BufferedReader(new FileReader(f));
            String linea = br.readLine();
            while (linea != null) {
                linea2 = linea.split("=");
                switch (linea2[0]) {
                    case "Cargar Driver":
                        driver = linea2[1].trim();
                        break;
                    case "usuario":
                        user = linea2[1].trim();
                        break;
                    case "pwd":
                        pw = linea2[1].trim();
                        break;
                    case "IP":
                        host = linea2[1].trim();
                        break;
                    case "Puerto":
                        port = linea2[1].trim();
                        break;
                    case "Tipo de base de datos":
                        bd = linea2[1].trim();
                        break;
                    case "ruta":
                        ruta = linea2[1].trim();
                        break;

                }
                linea = br.readLine();
            }
            Class.forName(driver);

            con = DriverManager.getConnection(bd + host + port + ruta, user, pw);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Connection getConexion() {
        if (con == null) {
            new ConexionBD();
        }
        return con;
    }
}
