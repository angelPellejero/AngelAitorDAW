package patronMVCCVIsta;

import java.awt.event.ActionEvent;
import java.util.Scanner;
import patronMVCcontrolador.CalculadoraControlador;
import patronMVCcontrolador.InterfazVistas;

public class VistaConsola implements InterfazVistas {

    private CalculadoraControlador objecto;
    private String accion, accion1, accion2, op1, op2, op, res;
    private Scanner sc;

    public VistaConsola() {
        accion1 = "calculo";
        accion2 = "salir";
        sc = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            do {
                System.out.println("¿Que deseas hacer? calculo o salir");
                accion = sc.nextLine();
                if (!(accion.equals(accion1) || accion.equals(accion2))) {
                    System.out.println("Solo puedes elegir la opcion 'calculo' o 'salir' pasame uno de los dos");
                }
            } while (!(accion.equals(accion1) || accion.equals(accion2)));
            if (accion.equals(accion1)) {
                do {
                    System.out.println("Pasame el primer operando: ");
                    op1 = sc.nextLine();
                    System.out.println("Pasame el tipo de operacion + || -: ");
                    op = sc.nextLine();
                    System.out.println("Pasame el segundo operando: ");
                    op2 = sc.nextLine();
                    if (!(Character.isDigit(op1.charAt(0)) || Character.isDigit(op2.charAt(0)) || op.equals("+") || op.equals("-"))) {
                        System.out.println("Solo puedes pasar al operando numeros y el tipo de operacion solo puede ser '+' o '-'");
                    }
                } while (!(Character.isDigit(op1.charAt(0)) || Character.isDigit(op2.charAt(0)) || op.equals("+") || op.equals("-")));
                objecto.actionPerformed(new ActionEvent(this, 1, "BotonCalcular"));
                System.out.println("Resultado de la operacion: " + res);
            } else if (accion.equals(accion2)) {
                objecto.actionPerformed(new ActionEvent(this, 2, "BotonSalir"));
            }
        }
    }

    @Override
    public String getOperando1() {
        return op1.trim();
    }

    @Override
    public String getOperando2() {
        return op2.trim();
    }

    @Override
    public String getOperador() {
        return op.trim();
    }

    @Override
    public void setResultado(String dato) {
        res = dato;
    }

    @Override
    public void setControlador(CalculadoraControlador objecto) {
        this.objecto = objecto;
        menu();
    }

}
