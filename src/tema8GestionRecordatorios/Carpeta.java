package tema8GestionRecordatorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

public class Carpeta {

    private String nombreCarpeta;
    private ArrayList<Apunte> array;

    public Carpeta() {
    }

    public Carpeta(String nombreCarpeta) {
        this.nombreCarpeta = nombreCarpeta;
        array = new ArrayList();
    }

    public String getNombreCarpeta() {
        return nombreCarpeta;
    }

    public ArrayList<Apunte> getArray() {
        return array;
    }

    public void setNombreCarpeta(String nombreCarpeta) {
        this.nombreCarpeta = nombreCarpeta;
    }

    //Añadir carpeta
    public void añadirNota(Apunte apunte) {
        System.out.println(apunte);
        array.add(apunte);
    }

    public Apunte dameApunte(String asunto) {
        Apunte aux = new Apunte();
        aux.setAsunto(asunto);
        int indice;
        indice = array.indexOf(aux);
        if (indice != -1) {
            return array.get(indice);
        } else {
            return null;
        }
    }

    //borrar nota por su asunto
    public boolean borrarNota(String asunto) {
        Apunte aux = new Apunte();
        aux.setAsunto(asunto);
        if (array.indexOf(aux) != -1) {
            array.remove(array.indexOf(aux));
            return true;
        } else {
            return false;
        }
    }

    //ver nota pos su asunto
    public Apunte verNota(String asunto) {
        Apunte aux = new Apunte();
        aux.setAsunto(asunto);
        if (array.indexOf(aux) != -1) {
            return array.get(array.indexOf(aux));
        } else {
            return null;
        }
    }

    //modificar una nota
    public boolean modificarNota(String asunto, Apunte nuevo) {
        Apunte aux = new Apunte();
        aux.setAsunto(asunto);
        int indice = array.indexOf(aux);

        if (indice != -1) {
            array.set(indice, nuevo);
            return true;
        } else {
            return false;
        }
    }

    public void listadoNatural() { // Mostrar por orden natural, tambien se puede usar por indice
        Collections.sort(array);
        muestraArray();
    }

    private void muestraArray() {
        Iterator it = array.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void listadoHora() {//Mostrar por otro orden
        ListadoHora lh = new ListadoHora();
        Collections.sort(array, lh);
        muestraArray();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombreCarpeta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carpeta other = (Carpeta) obj;
        if (!Objects.equals(this.nombreCarpeta, other.nombreCarpeta)) {
            return false;
        }
        return true;
    }

}
