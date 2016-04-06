package tema12;

import java.awt.*;
import javax.swing.*;

public class Ventana2 extends JFrame {

    private JPanel jpn, jps, jpi, jpd, jpc;
    private JButton[] botones;
    private JLabel[] labels, labelCentro;
    private Checkbox[] checks;
    private JRadioButton radio1, radio2;
    private JPanel[] panalesCentro;
    private JTextField[] caja_texto;

    public Ventana2() {
        jpn = new JPanel();
        jps = new JPanel();
        jpi = new JPanel();
        jpd = new JPanel();
        jpc = new JPanel();

        //sacar el primer panel por defecto y declarar el layout del principal contenedor
        this.getContentPane().setLayout(new BorderLayout());

        //getContentPane() es para referirise al panel principal por defecto aunque no es necesario indicarlo
        getContentPane().add(jpn, BorderLayout.NORTH);
        getContentPane().add(jps, BorderLayout.SOUTH);
        getContentPane().add(jpi, BorderLayout.WEST);
        getContentPane().add(jpd, BorderLayout.EAST);
        getContentPane().add(jpc, BorderLayout.CENTER);

        //establecer colores en los panteles
        jpn.setBackground(Color.red);
        jps.setBackground(Color.blue);
        jpi.setBackground(Color.yellow);
        jpd.setBackground(Color.pink);
        jpc.setBackground(Color.orange);

        //establecer en jpn el de la parte de arriba el layout FlowLayout y le introduzco 10 botones para que salgan en horizontal
        jpn.setLayout(new FlowLayout());
        botones = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botones[i] = new JButton(i + "");
            jpn.add(botones[i]);
        }

        //establecer en jpi el layout BoxLayout y meterle los labeles
        jpi.setLayout(new BoxLayout(jpi, BoxLayout.Y_AXIS));//constructor contenedor el propio panel y Y quiere decir en vertical o X en horizontal
        labels = new JLabel[9];
        for (int i = 0; i < 9; i++) {
            labels[i] = new JLabel("Opcion" + i);
            jpi.add(labels[i]);
        }

        //lo mismo que en jpi pero introduciendo checkbox
        jpd.setLayout(new BoxLayout(jpd, BoxLayout.Y_AXIS));
        checks = new Checkbox[9];
        for (int i = 0; i < 9; i++) {
            checks[i] = new Checkbox("Check" + i);
            jpd.add(checks[i]);
        }

        //en el panel sur le damos un layout null lo cual hay que declarar dimensiones
        jps.setLayout(null);
        radio1 = new JRadioButton("radio boton 1");
        radio2 = new JRadioButton("radio boton 2");
        jps.add(radio1);
        jps.add(radio2);
        jps.setPreferredSize(new Dimension(200, 100));//esto le dara un tamaño al panel
        radio1.setBounds(25, 25, 100, 25);//indicamos las cordenadas del radio boton  dentro del panel
        radio2.setBounds(200, 25, 100, 25);

        //en el panel centro le damos un layout CardLayout con sus dimensiones por defecto
        //este layout solo permite ver un objeto dentro de el porque coge un boton y lo adaptara al maximo tamaño posible 
        //introducir paneles con cajas de texto en plan panel1 ("label"nombre, "caja texto"apeliidos) panel2(telefono, edad) panel3 (domicilio, coche) "solo se vera uno"
        panalesCentro = new JPanel[3];
        jpc.setLayout(new CardLayout());

        for (int i = 0; i < 3; i++) {
            panalesCentro[i] = new JPanel(new GridLayout(2, 2));
            jpc.add(panalesCentro[i]);
        }

        caja_texto = new JTextField[6];
        labelCentro = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            labelCentro[i] = new JLabel("Caja" + i);
            caja_texto[i] = new JTextField();
            if (i == 0 || i == 1) {
                panalesCentro[0].add(labelCentro[i]);
                panalesCentro[0].add(caja_texto[i]);
            } else if (i == 2 || i == 3) {
                panalesCentro[1].add(labelCentro[i]);
                panalesCentro[1].add(caja_texto[i]);
            } else {
                panalesCentro[2].add(labelCentro[i]);
                panalesCentro[2].add(caja_texto[i]);
            }
        }
        setVisible(true);//hacer visible la ventana
        setLocationRelativeTo(null);//para que la ventana salga centrada
        setTitle("Uso del borderLayout");//titulo de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//para terminar proceso al cerrar ventana
        pack();//para que los botones se adaptel al tamaño de la ventana
    }

    public static void main(String[] args) {
        Ventana2 v = new Ventana2();
    }

}
