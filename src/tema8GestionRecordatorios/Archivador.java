package tema8GestionRecordatorios;

import java.util.ArrayList;

public class Archivador {

    private ArrayList<Carpeta> archivar;

    public Archivador() {
        archivar = new ArrayList();
    }

    public void añadirCarpeta(Carpeta carpeta) {
        archivar.add(carpeta);
    }

    public ArrayList<Carpeta> getArchivar() {
        return archivar;
    }

    public Carpeta dameCarpeta(String nombre_carpeta) {
        int aux;
        Carpeta c = new Carpeta(nombre_carpeta);
        aux = archivar.indexOf(c);
        if (aux != -1) {
            return archivar.get(aux);
        } else {
            return null;
        }
    }

}
