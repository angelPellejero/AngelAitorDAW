package pruebaMVC;

import java.awt.event.ActionEvent;
import java.util.Scanner;

public class VistaConsola implements InterfazVistasBarcos {

    private Controlador c;
    private String añadir, borrar, actualizar;
    private int opcion1, opcion2;
    private Scanner sc;
    private boolean bAñadir, bBorrar, bActualizar;

    public VistaConsola() {
        añadir = "añadir";
        borrar = "Borrar";
        actualizar = "actualizar";
        sc = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("Que deseas hacer 1 para trabajar o 2 para salir");
            opcion1 = sc.nextInt();
            if (opcion1 == 1) {
                System.out.println("Que deseas hacer añadir:1, Borrar:2, Actualizar:3");
                opcion2 = sc.nextInt();
                if (opcion2 == 1) {
                    c.actionPerformed(new ActionEvent(this, 1, "BotonAñadir"));
                    if (bAñadir) {
                        System.out.println("Barco fue añadido");
                    } else {
                        System.out.println("El barco ya existe");
                    }
                } else if (opcion2 == 2) {
                    c.actionPerformed(new ActionEvent(this, 1, "BotonBorrar"));
                    if (bBorrar) {
                        System.out.println("Barco fue borrado");
                    } else {
                        System.out.println("El barco no existe");
                    }
                } else if (opcion2 == 3) {
                    c.actionPerformed(new ActionEvent(this, 1, "BotonModificar"));
                    if (bBorrar) {
                        System.out.println("El barco no existe");
                        
                    } else {
                        System.out.println("Barco fue modficado");
                    }
                }
            } else {
                c.actionPerformed(new ActionEvent(this, 4, "BotonSalir"));
            }
        }
    }

    @Override
    public Barco getBarco() {
        Barco aux = new Barco();
        System.out.println("Dime el nombre del barco");
        sc.nextLine();
        aux.setNombre(sc.nextLine().trim());
        System.out.println("Dime la matricula del barco");
        aux.setMatricula(sc.nextInt());
        System.out.println("Dime los metros del barco");
        aux.setMetros(sc.nextInt());
        return aux;
    }

    @Override
    public void setResultadoAñadido(boolean b) {
        bAñadir = b;
    }

    @Override
    public void setResultadoBorrado(boolean b) {
        bBorrar = b;
    }

    @Override
    public void setResultadoModificado(boolean b) {
        bActualizar = b;
    }

    @Override
    public void setControlador(Controlador con) {
        c = con;
        menu();
    }

}
