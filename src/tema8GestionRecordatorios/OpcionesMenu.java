package tema8GestionRecordatorios;

import java.util.Scanner;
import menu.*;

public class OpcionesMenu {

    private Scanner sc;
    private Archivador archivador;

    public OpcionesMenu() {
        sc = new Scanner(System.in);
        archivador = new Archivador();

    }

    // metodo crea una carpeta
    public void carpeta() {
        String nom;
        Carpeta carpeta;
        System.out.println("Pasame un nombre para la carpeta");
        nom = sc.nextLine();
        carpeta = new Carpeta(nom);

        archivador.añadirCarpeta(carpeta);
    }

    //añadir un apunte en una carpeta
    public void añadir() {
        Apunte apunte = new Apunte();
        Carpeta aux;
        System.out.println("Pasame el asunto del apunte");
        apunte.setAsunto(sc.nextLine());
        System.out.println("Pasame es texto del apunte");
        apunte.setTexto(sc.nextLine());

        aux = existeCarpeta();
        if (aux != null) {
            aux.añadirNota(apunte);
        } else {
            System.out.println("La carpeta no existe");
        }

    }

    //Comprobar existencia de dicha carpeta
    public Carpeta existeCarpeta() {
        String nombreCarpeta;
        System.out.println("Pasame el nombre de la carpeta");
        nombreCarpeta = sc.nextLine();
        return archivador.dameCarpeta(nombreCarpeta);
    }

    //Borrar un apunte en concreto
    public void borrarApunte() {
        Carpeta aux;
        String asuntoApunte;
        aux = existeCarpeta();
        if (aux != null) {
            System.out.println("Pasame el asunto del apunte a borrar");
            asuntoApunte = sc.nextLine();
            aux.borrarNota(asuntoApunte);
        } else {
            System.out.println("La carpeta no existe");
        }
    }

    //Ver un apunte en concreto
    public void ver() {
        Carpeta aux;
        String asuntoApunte;
        aux = existeCarpeta();
        if (aux != null) {
            System.out.println("Pasame el asunto del apunte a ver");
            asuntoApunte = sc.nextLine();
            System.out.println(aux.verNota(asuntoApunte));
        } else {
            System.out.println("La carpeta no existe");
        }
    }

    //modificar un apunte por otro apunte
    public void modificar() {
        Carpeta aux;
        Apunte auxApunte = new Apunte();
        String asuntoApunteOld;
        aux = existeCarpeta();
        if (aux != null) {
            System.out.println("Pasame el asunto del apunte a borrar");
            asuntoApunteOld = sc.nextLine();
            System.out.println("Pasame un asunto para el nuevo apunte");
            auxApunte.setAsunto(sc.nextLine());
            System.out.println("Pasame el texto");
            auxApunte.setTexto(sc.nextLine());
            System.out.println(aux.modificarNota(asuntoApunteOld, auxApunte));

        } else {
            System.out.println("La carpeta no existe");
        }
    }

    public void natural() {
        Carpeta aux;
        aux = existeCarpeta();
        if (aux != null) {
            aux.listadoNatural();
        } else {
            System.out.println("La carpeta no existe");
        }

    }

    public void horas() {
        Carpeta aux;
        aux = existeCarpeta();
        if (aux != null) {
            aux.listadoHora();
        } else {
            System.out.println("La carpeta no existe");
        }
    }

    public void salir() {
        System.out.println("salir apunte");
    }

}
