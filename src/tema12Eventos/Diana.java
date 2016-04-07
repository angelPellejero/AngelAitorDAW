package tema12Eventos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.*;

public class Diana extends JFrame implements MouseListener {

    private JLabel diana, dardo;
    private ImageIcon dardo1, diana1;

    public Diana() {
        URL url1 = getClass().getResource("/imagenes/diana.jpg");
        diana1 = new ImageIcon(url1);
        URL url2 = getClass().getResource("/imagenes/dardo.png");
        dardo1 = new ImageIcon(url2);

        diana = new JLabel(diana1);

        //layout null
        getContentPane().setLayout(null);

        //add el label de diana
        this.add(diana);

        //tamaño de la ventana por ser layout null
        this.setPreferredSize(new Dimension(diana1.getIconHeight() + 15, diana1.getIconWidth() + 35));

        //cordenadas y tamaño del label dentro del label
        diana.setBounds(0, 0, 626, 626);

        this.setComponentZOrder(diana, 0);//para establecer la posicion la 0 es la mas profunda

        this.setMinimumSize(new Dimension(diana1.getIconHeight() + 15, diana1.getIconWidth() + 35));//Le doy el tamaño que quiero por defecto
        setVisible(true);//hacer visible la ventana
        setLocationRelativeTo(null);//para que la ventana salga centrada
        setTitle("Diana");//titulo de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//para terminar proceso al cerrar ventana
        repaint();//lo mismo que el pack para layout tipo null
        //el pack en el null no se pone
    }

    public static void main(String[] args) {
        new Diana();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dardo = new JLabel(dardo1);
        getContentPane().add(dardo);
        this.setComponentZOrder(diana, 1);
        dardo.setBounds(e.getX(), e.getY(), dardo1.getIconHeight(), dardo1.getIconWidth());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
