/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaMVC;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Ángel
 */
public class VistaSwing extends JFrame implements InterfazVistasBarcos {

    private JPanel jpMain;
    private JLabel jlNombre, jlMatricula, jlMetros;
    private JTextArea jtNombre, jtMatricula, jtMetros;
    private JButton jbAñadir, jbBorrar, jbModificar, jbSalir;

    public VistaSwing() {
        jlNombre = new JLabel("Nombre");
        jlMatricula = new JLabel("Matricula");
        jlMetros = new JLabel("Metros");
        jtNombre = new JTextArea("           ");
        jtMatricula = new JTextArea("           ");
        jtMetros = new JTextArea("           ");
        jbAñadir = new JButton("Añadir");
        jbBorrar = new JButton("Borrar");
        jbModificar = new JButton("Modificar");
        jbSalir=new JButton("Salir");

        jpMain = new JPanel(new GridLayout(0, 2, 5, 5));
        jpMain.add(jlNombre);
        jpMain.add(jtNombre);
        jpMain.add(jlMatricula);
        jpMain.add(jtMatricula);
        jpMain.add(jlMetros);
        jpMain.add(jtMetros);
        jpMain.add(jbAñadir);
        jpMain.add(jbBorrar);
        jpMain.add(jbModificar);
        jpMain.add(jbSalir);

        add(jpMain);
        setVisible(true);//hacer visible la ventana
        setLocationRelativeTo(null);//para que la ventana salga centrada
        setTitle("Calculadora");//titulo de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//para terminar proceso al cerrar ventana
        pack();//para que los botones se adaptel al tamaño de la ventana
    }

    public static void main(String[] args) {
        new VistaSwing();
    }

    @Override
    public Barco getBarco() {
        Barco aux = new Barco();
        aux.setNombre(jtNombre.getText().trim());
        aux.setMatricula(Integer.parseInt(jtMatricula.getText().trim()));
        aux.setMetros(Integer.parseInt(jtMetros.getText().trim()));
        return aux;
    }

    @Override
    public void setControlador(Controlador con) {
        jbAñadir.setActionCommand("BotonAñadir");
        jbAñadir.addActionListener(con);
        jbBorrar.setActionCommand("BotonBorrar");
        jbBorrar.addActionListener(con);
        jbModificar.setActionCommand("BotonModificar");
        jbModificar.addActionListener(con);
        jbSalir.setActionCommand("BotonSalir");
        jbSalir.addActionListener(con);
    }

    @Override
    public void setResultadoAñadido(boolean b) {
        if (b) {
            JOptionPane.showMessageDialog(this, "El barco fue añadido ", "ok", 1);
        } else {
            JOptionPane.showMessageDialog(this, "El barco ya existe ", "Error", 1);
        }
    }

    @Override
    public void setResultadoBorrado(boolean b) {
        if (b) {
            JOptionPane.showMessageDialog(this, "El barco fue borrado ", "ok", 1);
        } else {
            JOptionPane.showMessageDialog(this, "El barco no existe ", "Error", 1);
        }
    }

    @Override
    public void setResultadoModificado(boolean b) {
        if (b) {
            JOptionPane.showMessageDialog(this, "El barco fue actualizado ", "ok", 1);
        } else {
            JOptionPane.showMessageDialog(this, "El barco no existe ", "Error", 1);
        }
    }

}
