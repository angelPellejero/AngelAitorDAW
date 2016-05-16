/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronMVCCVIsta;

import java.awt.event.ActionEvent;
import java.util.Scanner;
import patronMVCcontrolador.CalculadoraControlador;
import patronMVCcontrolador.InterfazVistas;

/**
 *
 * @author VESPERTINO
 */
public class VistaConsola implements InterfazVistas {
    private CalculadoraControlador objecto;
    private String accion, accion1, accion2, op1, op2, op;
    private Scanner sc;
    public VistaConsola() {
        accion1="Calculo";
        accion2="Salir";
        sc = new Scanner(System.in);
    } 
    
    public void menu(){
        System.out.println("¿Que deseas hacer? ");
        
    }

    @Override
    public String getOperando1() {
        System.out.println("Pasame el primer operando: ");
        
    }

    @Override
    public String getOperando2() {
         objecto.actionPerformed(new ActionEvent(this, 1, "BotonCalcular"));       
    }

    @Override
    public String getOperador() {
        
    }

    @Override
    public void setResultado(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setControlador(CalculadoraControlador objecto) {
        this.objecto=objecto;
//         objecto.actionPerformed(new ActionEvent(this, 2, "BotonSalir"));
    }
    
}
