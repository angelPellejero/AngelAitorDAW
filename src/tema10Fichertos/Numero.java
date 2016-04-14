/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema10Fichertos;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PROF_VESPERTINO
 */
public class Numero {

    private URL url;
    private String fichero;
    private FileInputStream fis;

    public Numero() {
        int dato;

        fichero = "numeros.txt";
        url = getClass().getResource("/com/iescomercio/ficheros/" + fichero);

    }

    public void abrirFichero() {
        try {
            fis = new FileInputStream(url.getFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Numero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int leerDatos() {
        int aux, cont = 0;
        try {
            // Tratamiento
            aux = fis.read();
            while (aux != -1) {
                if (aux!=13 && aux!=10) 
                    cont = cont + (aux-48);
                aux = fis.read();
            }
            return cont;
        } catch (IOException ex) {
            Logger.getLogger(Numero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
            try {
                fis.close(); // Cerrar fichero
            } catch (IOException ex) {
                Logger.getLogger(Numero.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return 0;
    }

}
