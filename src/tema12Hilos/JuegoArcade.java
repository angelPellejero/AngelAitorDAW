
package tema12Hilos;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class JuegoArcade extends JFrame implements KeyListener{
    private JPanel jpPrincipal;
    private JLabel jlPelota, jlBloque;
    private ImageIcon imagenBola;
    private static BolaDirecciones bola;
    private static String aux;
    private static URL url1;

    public JuegoArcade(){
        jpPrincipal = new JPanel(new FlowLayout());
        jlBloque= new JLabel();
        
        getContentPane().setLayout(null);
        this.add(jpPrincipal);
        jpPrincipal.setSize(500, 500);
        jpPrincipal.setFocusable(true);
        jpPrincipal.addKeyListener(this);
        
        url1 = getClass().getResource("/imagenes/bola.png");
        imagenBola = new ImageIcon(url1);
        jlPelota = new JLabel(imagenBola);
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
