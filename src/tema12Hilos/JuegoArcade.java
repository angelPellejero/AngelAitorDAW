package tema12Hilos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class JuegoArcade extends JFrame implements KeyListener{

    private JPanel jpPanel;
    private JLabel jlbAsterisco, jlRaqueta;
    private static JuegoArcade juego;

    public JuegoArcade() {
        jpPanel = new JPanel(null);
        jlbAsterisco = new JLabel("*");
        jlRaqueta = new JLabel("Raqueta");

        //panel por defecto como boxlayout
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        //add panel layout null al panel principal
        getContentPane().add(jpPanel);

        jpPanel.setBackground(Color.WHITE);
        jpPanel.setSize(300, 300);

        //meter labels al panel null con su posicion inicial
        jpPanel.add(jlbAsterisco);
 
        jpPanel.add(jlRaqueta);
        jlRaqueta.setBounds(120, 220, 50, 20);

        //orden de apariencia
        this.setComponentZOrder(jpPanel, 1);
        this.setComponentZOrder(jlRaqueta, 0);
        this.setComponentZOrder(jlbAsterisco, 0);

        //para indicar que se pueda mover el focusable y el listener para atender las llamadas por teclado
        jpPanel.addKeyListener(this);
        jpPanel.setFocusable(true);

        //llamada al hilo
        HiloAsteriscoArcade hac = new HiloAsteriscoArcade(this);
        Thread hilo = new Thread(hac);
        hilo.start();

        this.setSize(300, 300);
        setTitle("Padel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JLabel getJlbAsterisco() {
        return jlbAsterisco;
    }

    public JLabel getJlRaqueta() {
        return jlRaqueta;
    }

    public static void main(String[] args) {
        juego = new JuegoArcade();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_LEFT) {
            if (jlRaqueta.getLocation().x > 10) {
                jlRaqueta.setLocation(jlRaqueta.getLocation().x - 3, jlRaqueta.getLocation().y);
            }
        } else {
            if (jlRaqueta.getLocation().x < 243) {
                jlRaqueta.setLocation(jlRaqueta.getLocation().x + 3, jlRaqueta.getLocation().y);
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
