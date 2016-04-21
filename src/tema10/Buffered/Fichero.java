/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema10.Buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PROF_VESPERTINO
 */
public class Fichero {

    public Fichero() {
        FileReader fr = null;
        String linea;
        BufferedReader br = null;
        int cont = 0;
        File f;
        URL url;

        try {
            // Abrir un archivo
            url = getClass().getResource("/tema10/buffered/quijote.txt");
            f = new File(url.getFile());
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            // Leer una linea
            linea = br.readLine();
            while (linea != null) {
                // Calcular el numero de vocales
                cont = cont + dameVocales(linea);
                linea = br.readLine();
            }
            // Guardar el resultado en un fichero destino
            guardaEnFichero(cont);
            System.out.println("Numero de vocales:" + cont);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                fr.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     private static int dameVocales(String linea) {
        int z = 0;
        String c;
        
        for (int i = 0; i < linea.length(); i++) {
            c= (linea.charAt(i) + "").toUpperCase();
            if (c.equals("A") || c.equals("E") || c.equals("I") || c.equals("O") || c.equals("U")) {
                z++;
            }
        }
        return z;
    }

    private void guardaEnFichero(int cont) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("c:\\resultado.txt");
            bw = new BufferedWriter(fw);
            bw.write("Numero de vocales: " + cont);            
        } catch (IOException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
