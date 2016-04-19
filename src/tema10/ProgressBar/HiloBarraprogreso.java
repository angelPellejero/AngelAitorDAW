/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema10.ProgressBar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PROF_VESPERTINO
 */
public class HiloBarraprogreso implements Runnable {

    private Gui gui;

    public HiloBarraprogreso(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        byte datos[] = new byte[1024];
        int lecturaBytes, contador = 0, numeroVueltas = 0, porcentajeBarra = 0;
        long longitud = 0;
        File fichero;
        try {
            //declaro fichero para sacar su longitud
            fichero = new File(gui.getFileLectura().getAbsolutePath());
            
            //regla de 3 para compensar la barra
            longitud = fichero.length();
            numeroVueltas = (int) longitud / 1024;
            porcentajeBarra = numeroVueltas/ 100;
            
            //calse que nos permite leer
            fi = new FileInputStream(gui.getFileLectura());
            //clase que nos permite escribir
            fo = new FileOutputStream(gui.getFileEscritura());
            //leo y guardo en un array de 1024 bytes.
            
            for (int i = 0; i < numeroVueltas; i++) {
                lecturaBytes = fi.read(datos);
                fo.write(datos);
                //Si la lectura es solo una pasada lleno la barra directamente
                gui.getBarra().setValue(gui.getBarra().getValue() + porcentajeBarra);
                sleep(100);
            }
            int aux = (int)(longitud-numeroVueltas*1024);
            lecturaBytes = fi.read(datos);
            fo.write(datos,0,aux);              
            gui.getBarra().setValue(100);//Esto es en el caso de que haya decimales y la barra no llegue a 100 completamente
            
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloBarraprogreso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HiloBarraprogreso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HiloBarraprogreso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fi.close();
                fo.close();
            } catch (IOException ex) {
                Logger.getLogger(HiloBarraprogreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
