package pruebaMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

//    VistaSwing vista;
    ModeloBD modelo;
    VistaConsola vista;

    public Controlador(VistaConsola vista, ModeloBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("BotonAñadir")) {
            vista.setResultadoAñadido(modelo.añadirBarco(vista.getBarco()));
        } else if (e.getActionCommand().equals("BotonBorrar")) {
            vista.setResultadoBorrado(modelo.BorrarBarco(vista.getBarco()));
        } else if (e.getActionCommand().equals("BotonModificar")) {
             vista.setResultadoModificado(modelo.ModificarBarco(vista.getBarco()));
        } else if (e.getActionCommand().equals("BotonSalir")) {
             System.exit(0);
        }    
    }

}
