package tema10.PracticaObject_MDI_DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoObjectStream implements InterfazDAO {

    private ArrayList coleccion;
    private File fichero;
    private static int index;

    public DaoObjectStream() {
        coleccion = new ArrayList();
        fichero = new File("barcos.obj");
        index = 0;
        cargarDatos();
    }

    @Override
    public boolean alta(Barco barco) {
        int posicion = existeBarco(barco);
        if (posicion == -1) {
            return coleccion.add(barco);
        } else {
            return false;
        }
    }

    @Override
    public int existeBarco(Barco barco) {
        return coleccion.indexOf(barco);
    }

    @Override
    public boolean baja(int matricula) {
        Barco aux = new Barco();
        aux.setMatricula(matricula);
        int posicion = existeBarco(aux);
        if (posicion != -1) {
            coleccion.remove(posicion);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean modificacion(int posicion, Barco nuevo) {
        if (posicion != -1) {
            coleccion.set(posicion, nuevo);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Barco consulta(int matricula) {
        Barco aux = new Barco();
        aux.setMatricula(matricula);
        int posicion = existeBarco(aux);
        if (posicion != -1) {
            return (Barco) coleccion.get(posicion);
        }else{
            return null;
        }
    }

    @Override
    public Barco dameSiguiente() {

    }

    @Override
    public Barco dameAnterior() {
    }

    @Override
    public boolean cargarDatos() {
        if (fichero.exists()) {
            //si el fichero existe entra y lo lee , si no, al guardar los datos ya creara e archivo
            ObjectInputStream lector = null;
            try {

                lector = new ObjectInputStream(new FileInputStream(fichero));
                coleccion = (ArrayList) lector.readObject(); //introducir los datos al arraylist directamente
                return true;
            } catch (IOException ex) {
                Logger.getLogger(DaoObjectStream.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DaoObjectStream.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    lector.close();//cerrar el lector
                } catch (IOException ex) {
                    Logger.getLogger(DaoObjectStream.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public Barco salvarDatos() {

    }

}
