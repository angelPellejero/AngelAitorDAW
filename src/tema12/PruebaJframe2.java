// un panel y set border layout, meter 3 panales (add panel)(meter un panel dentro de un panel que tiene ya un layout metido)
package tema12;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PruebaJframe2 extends JFrame {

    private JPanel jp1, jp2, jp3;

    public PruebaJframe2() {
        //Creacion del panel
        JFrame jfM = new JFrame("Panel principal");
        //border layout tiene definida 5 zonas
        jfM.setLayout(new BorderLayout(5, 5));
        //llamada a los metodos
        PanelCentro();
        PanelIzquierda();
        Centro();
        //establecer posicion de los paneles dentro del panel principal y añadirlos
        jfM.add(jp1, BorderLayout.NORTH);
        jfM.add(jp2, BorderLayout.WEST);
        jfM.add(jp3, BorderLayout.CENTER);

        pack();
        setTitle("Ejemplo 2");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void PanelCentro() {
        jp1 = new JPanel(new FlowLayout());

        //creacion de 10 botones
        JButton[] botones = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botones[i] = new JButton(i + "");
            add(botones[i]);
        }
        //Hacer el panel visible
        jp1.setVisible(true);
    }

    public void PanelIzquierda() {
        //Declarado como box (panel, vertical)
        jp2 = new JPanel(new BoxLayout(jp2, BoxLayout.X_AXIS));
        //creacion de 10 botones
        JButton[] botones = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botones[i] = new JButton(i + "");
            add(botones[i]);
        }
        //Hacer el panel visible
        jp2.setVisible(true);
    }

    public void Centro() {
        jp3 = new JPanel();
        JLabel label1 = new JLabel();
    }

    public static void main(String[] args) {
    PruebaJframe2 p = new PruebaJframe2();
    }
}
