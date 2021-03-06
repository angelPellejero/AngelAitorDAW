
package tema12Hilos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author PROF_VESPERTINO
 */
public class Asterisco2 extends JFrame implements ActionListener {

    private JPanel jpPanel;
    private JLabel jlbAsterisco;
    private JButton jbBoton;
    private static Asterisco2 a;

    public Asterisco2() {
        jpPanel = new JPanel();
        jlbAsterisco = new JLabel("*");
        jbBoton = new JButton("Go!");

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpPanel);
        getContentPane().add(jbBoton);
        getContentPane().setPreferredSize(new Dimension(300, 200));
        jpPanel.setLayout(null);
        jbBoton.addActionListener(this);
        jpPanel.add(jlbAsterisco);
        jlbAsterisco.setBounds(10, 10, 10, 10);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JLabel getjlbAsterisco () {
        return jlbAsterisco;
    }    
    
    
    
    public static void main(String[] args) {
        a = new Asterisco2();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HiloHijo hh = new HiloHijo(this);
        Thread t = new Thread(hh);
        t.start();
    }

    

}
