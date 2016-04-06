package tema12;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class PruebaJframe1 extends JFrame {

    private javax.swing.JButton[] botones;//declaracion de un array de botones

    public PruebaJframe1() {
        botones = new JButton[5];
        //Poner el layout que queremos usar
        this.getContentPane().setLayout(new BorderLayout(5, 5));

        //Instanciar botones
        botones[0] = new JButton("Centro");
        botones[1] = new JButton("Norte");
        botones[2] = new JButton("Sur");
        botones[3] = new JButton("Este");
        botones[4] = new JButton("Oeste");

        add(botones[0], BorderLayout.CENTER);
        add(botones[1], BorderLayout.NORTH);
        add(botones[2], BorderLayout.SOUTH);
        add(botones[3], BorderLayout.WEST);
        add(botones[4], BorderLayout.EAST);

        pack();
        setTitle("Ejermplo de border Layout");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        PruebaJframe1 p = new PruebaJframe1();
    }
}
