package patronMVCCVIsta;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.*;
import patronMVCcontrolador.CalculadoraControlador;
import patronMVCcontrolador.InterfazVistas;

public class VistaSwing extends JFrame  implements InterfazVistas{

    private JPanel jpLeft, jpRight;
    private JLabel jlOp1, jlOp2, jlOp3, jlRs1, jlRs2;
    private JTextArea jtOp1, jtOp3;
    private JComboBox jcSymbol;
    private JButton jbCal, jbExit;

    public VistaSwing() {
        jlOp1 = new JLabel("Operando 1");
        jlOp2 = new JLabel("Operador");
        jlOp3 = new JLabel("Operando 2");
        jlRs1 = new JLabel("Resultado");
        jlRs2 = new JLabel("0");
        jtOp1 = new JTextArea("                     ");
        jtOp3 = new JTextArea("                     ");
        jcSymbol = new JComboBox();
        jcSymbol.addItem("+");
        jcSymbol.addItem("-");
        jbCal = new JButton("Calcular");
        jbExit = new JButton("Salir");

        jpLeft = new JPanel(new GridLayout(4, 2, 10, 10));
        jpRight = new JPanel();
        jpRight.setLayout(new BoxLayout(jpRight, BoxLayout.Y_AXIS));
        
        getContentPane().setLayout(new BorderLayout(10, 10));

        jpLeft.add(jlOp1);
        jpLeft.add(jtOp1);
        jpLeft.add(jlOp2);
        jpLeft.add(jcSymbol);
        jpLeft.add(jlOp3);
        jpLeft.add(jtOp3);
        jpLeft.add(jlRs1);
        jpLeft.add(jlRs2);

        jpRight.add(jbCal);
        jpRight.add(jbExit);

        add(jpLeft, BorderLayout.WEST);
        add(jpRight, BorderLayout.EAST);

        setVisible(true);//hacer visible la ventana
        setLocationRelativeTo(null);//para que la ventana salga centrada
        setTitle("Calculadora");//titulo de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//para terminar proceso al cerrar ventana
        pack();//para que los botones se adaptel al tamaño de la ventana
    }



    @Override
    public String getOperando1() {
       return  jtOp1.getText().trim();
    }

    @Override
    public String getOperando2() {
        return  jtOp3.getText().trim();
    }

    @Override
    public String getOperador() {
        return jcSymbol.getSelectedItem().toString().trim();
    }

    @Override
    public void setResultado(String dato) {
        jlRs2.setText(dato);
    }

    @Override
    public void setControlador(CalculadoraControlador objeto) {
        jbCal.setActionCommand("BotonCalcular");
        jbCal.addActionListener(objeto);
        jbExit.setActionCommand("BotonSalir");
        jbExit.addActionListener(objeto);    
    }



}
