package patronMVCcontrolador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import patronMVCCVIsta.VistaConsola;
import patronMVCCVIsta.VistaSwing;
import patronMVCModelo.Modelo;

public class CalculadoraControlador implements ActionListener {

//    private VistaSwing vista;
    private VistaConsola vista;
    private Modelo modelo;

    public CalculadoraControlador(VistaConsola vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        //informamos a la vista que esta clase es el controlador
        vista.setControlador(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getActionCommand().equals("BotonCalcular")) {
            String op1 = vista.getOperando1();
            String op2 = vista.getOperando2();
            String simbolo = vista.getOperador();
            String res = modelo.realizaOperacion(op1, op2, simbolo);
            vista.setResultado(res);
        } else if (e.getActionCommand().equals("BotonSalir"))
            System.exit(0);
    }

}
