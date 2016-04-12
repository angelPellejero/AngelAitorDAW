package tema12Hilos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;

public class Tenis extends JFrame implements Runnable, KeyListener {

    private JPanel jpPrincipal;
    private JLabel jlbPelota, jlbBloque, jlPuntos;
    private ImageIcon imagenPelota, imagenBarra;
    private URL urlPelota, urlBarra;
    private Dimension d;
    private int puntos, vidas;

    public Tenis() {
        //instanciar objetos
        jpPrincipal = new JPanel(null);
        urlPelota = getClass().getResource("/imagenes/pelota21.png");
        urlBarra = getClass().getResource("/imagenes/barra.png");
        imagenBarra = new ImageIcon(urlBarra);
        imagenPelota = new ImageIcon(urlPelota);
        jlbPelota = new JLabel(imagenPelota);
        jlbBloque = new JLabel(imagenBarra);
        jlPuntos = new JLabel("Puntos: " + puntos);
        d = new Dimension(1090, 700);
        vidas = 2;
        puntos = 0;

        //sacar el panel por defecto
        getContentPane().setLayout(new FlowLayout());

        //add panel principal al por defecto con su tamaño
        this.add(jpPrincipal);
        jpPrincipal.setSize(d);

        //add labels al panel principal y destino
        jpPrincipal.add(jlbPelota);
        jlbPelota.setBounds(500, 1, imagenPelota.getIconWidth(), imagenPelota.getIconHeight());
        jpPrincipal.add(jlbBloque);
        jlbBloque.setBounds(420, 600, imagenBarra.getIconWidth(), imagenBarra.getIconHeight());
        jpPrincipal.add(jlPuntos);
        jlPuntos.setBounds(1, 1, 100, 30);

        //para indicar que se pueda mover el focusable y el listener para atender las llamadas por teclado
        jpPrincipal.addKeyListener(this);
        jpPrincipal.setFocusable(true);

        //orden de aparicion 
        this.setComponentZOrder(jpPrincipal, 1);

        this.setSize(d);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Tenis");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        Tenis t = new Tenis();
        //creacion de un hiloy su llamada
        Thread hilo = new Thread(t);
        hilo.start();
    }

    @Override
    public void run() {
        int x1 = 1, y1 = 1;
        boolean aux = true;
        try {
            while (aux == true) {
                puntos++;
                if (jlbPelota.getLocation().x == 0 || jlbPelota.getLocation().x == (d.width - imagenPelota.getIconWidth())) {
                    x1 = x1 * (-1);
                }
                if (jlbPelota.getLocation().y == 0 || jlbPelota.getLocation().y == (d.height - imagenPelota.getIconHeight())) {
                    y1 = y1 * (-1);
                }

                if (jlbPelota.getLocation().y + imagenPelota.getIconHeight() == jlbBloque.getLocation().y + 40//comprobar que choquen en altura
                        //comprobar que choca dentro del rango de la barra
                        && jlbPelota.getLocation().x + imagenPelota.getIconHeight()/2 > jlbBloque.getLocation().x
                        && jlbPelota.getLocation().x + imagenPelota.getIconHeight()/2 < jlbBloque.getLocation().x + imagenBarra.getIconWidth()) {
                    y1 = y1 * (-1);
                }
                jlbPelota.setLocation(jlbPelota.getLocation().x + x1, jlbPelota.getLocation().y + y1);
                sleep(5);
                jlPuntos.setText("Puntos: " + puntos);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Tenis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == e.VK_LEFT)) {
            if (jlbBloque.getLocation().x > 0) {// 0 seria el extremo para x a la izquierda
                jlbBloque.setLocation(jlbBloque.getLocation().x - 10, jlbBloque.getLocation().y);
            }
        } else {
            if (jlbBloque.getLocation().x < (d.width - imagenBarra.getIconWidth())) {//controlar la longitud del icono con el ancho para el limite a la derecha
                jlbBloque.setLocation(jlbBloque.getLocation().x + 10, jlbBloque.getLocation().y);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
