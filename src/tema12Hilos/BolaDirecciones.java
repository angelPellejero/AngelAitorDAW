package tema12Hilos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.*;

public class BolaDirecciones extends JFrame implements KeyListener, Runnable {

    //ATRIBUTOS Y PROPIEDADES
    private JPanel jPanelPrincipal;
    private JLabel jLabelBola;
    private ImageIcon imagenBola;
    private static BolaDirecciones bola;
    private static String aux;
    private static URL url1;

    //constructor
    public BolaDirecciones() {

        jPanelPrincipal = new JPanel();
        this.getContentPane().setLayout(new FlowLayout());

        //ponemos el panel sin layout
        jPanelPrincipal.setLayout(null);
        jPanelPrincipal.setBackground(Color.white);
        jPanelPrincipal.setFocusable(true);//al arrancar la app
        jPanelPrincipal.addKeyListener(this);

        //imagen dentro del label
        url1 = getClass().getResource("/imagenes/bola.png");
        imagenBola = new ImageIcon(url1);
        jLabelBola = new JLabel(imagenBola);

        //añadimos bola al panel
        jPanelPrincipal.add(jLabelBola);

        //añadimos panel principal al jframe
        this.add(jPanelPrincipal);
        jPanelPrincipal.setSize(500, 500);

        jLabelBola.setBounds(15, 15, imagenBola.getIconWidth(), imagenBola.getIconHeight());//posicionamos

        //orden de apariencia
        this.setComponentZOrder(jPanelPrincipal, 1);
        this.setComponentZOrder(jLabelBola, 0);


        this.setTitle("Pelota");
        this.setSize(500, 500);//tamaño
        this.setLocationRelativeTo(null);//centramos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para cerrar despues de la ejecucion
        this.setVisible(true);//visualizar    

    }//fin constructor

    //main 
    public static void main(String[] args) {
        bola = new BolaDirecciones();
    }//fin main

    //metodo para la accion del raton CON KEYLISTNER
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        aux = "";
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            aux = "izquierda";
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            aux = "derecha";
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            aux = "arriba";
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            aux = "abajo";
        }
        Thread t = new Thread(bola);
        t.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        try {
            if (aux.equals("izquierda") && jLabelBola.getLocation().x > - 187) {
                jLabelBola.setLocation(jLabelBola.getLocation().x - 3, jLabelBola.getLocation().y);
            } else if (aux.equals("derecha") && jLabelBola.getLocation().x < 194) {
                jLabelBola.setLocation(jLabelBola.getLocation().x + 3, jLabelBola.getLocation().y);
            } else if (aux.equals("arriba") && jLabelBola.getLocation().y > - 152) {
                jLabelBola.setLocation(jLabelBola.getLocation().x, jLabelBola.getLocation().y - 3);
            } else {
                if (jLabelBola.getLocation().y < 205) {
                    jLabelBola.setLocation(jLabelBola.getLocation().x, jLabelBola.getLocation().y + 3);
                }
            }
            repaint();
        } catch (Exception ex) {
            System.out.println("Habido un error");
        }
    }
}//fin clase
