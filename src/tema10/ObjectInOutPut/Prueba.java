package tema10.ObjectInOutPut;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba {

    File fichero;
    ArrayList<Punto> coleccion;

    public Prueba() {
        ObjectInputStream lector = null;
        fichero = new File("prueba.obj");
        leer();
        ObjectOutputStream escritor = null;
        coleccion = new ArrayList();
        Punto uno = new Punto(1, 1);
        Punto dos = new Punto(2, 2);
        coleccion.add(uno);
        coleccion.add(dos);
        coleccion.add(uno);
        try {
            escritor = new ObjectOutputStream(new FileOutputStream(fichero));
            escritor.writeObject(coleccion);
        } catch (IOException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escritor.close();
            } catch (IOException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void leer() {
        if (fichero.exists()) {
            ObjectInputStream lector = null;
            try {
                lector = new ObjectInputStream(new FileInputStream(fichero));
                ArrayList a = (ArrayList) lector.readObject();
                a.add(new Punto(1,1));
                System.out.println("Leer");
            } catch (IOException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
            try {
                lector.close();
            } catch (IOException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }

    public static void main(String[] args) {
        new Prueba();
    }

}
