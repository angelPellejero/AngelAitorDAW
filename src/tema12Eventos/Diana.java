package tema12Eventos;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.*;

public class Diana extends JFrame implements MouseListener {

    private JLabel jblDiana, jblDardo;
    private ImageIcon dardo1, diana1;

    public Diana() {
        try {
            //creacion de los iconos
            URL urlDiana = getClass().getResource("/imagenes/diana.jpg");
            diana1 = new ImageIcon(urlDiana);
            URL urlDardo = getClass().getResource("/imagenes/dardo.png");
            dardo1 = new ImageIcon(urlDardo);

            //instanciar el label con el icono de la diana
            jblDiana = new JLabel(diana1);

            //layout null para el panel por defecto ya que queremos poner los label en la parte que queramos
            getContentPane().setLayout(null);

            //add el label de diana al panel por defecto
            this.add(jblDiana);

           //en el orden de prioridad del panel por defecto darle uno que no sea el principal asi el dardo que es 0 se pondra por delante
            this.setComponentZOrder(jblDiana, 1);

            //tamaño de la ventana (panel por defecto) por ser layout null
            this.setPreferredSize(new Dimension(diana1.getIconHeight() + 15, diana1.getIconWidth() + 35));

            //cordenadas y tamaño del label dentro del label
            jblDiana.setBounds(0, 0, 626, 626);

            //auditar los movimientos que hacemos con el raton en label de la diana
            jblDiana.addMouseListener(this);

            this.setMinimumSize(new Dimension(diana1.getIconHeight() + 15, diana1.getIconWidth() + 35));//Le doy el tamaño que quiero por defecto
            setVisible(true);//hacer visible la ventana
            setLocationRelativeTo(null);//para que la ventana salga centrada
            setTitle("Diana");//titulo de la ventana
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//para terminar proceso al cerrar ventana
            //el pack en el null no se pone
        } catch (Exception e) {
            System.out.println("Ups algo falla");
        }
    }

    public static void main(String[] args) {
        new Diana();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            //instanciar el label del icono del dardo
            jblDardo = new JLabel(dardo1);
            
            //decir donde se va poner este label con cordenadas X e Y con sus dimensiones
            jblDardo.setBounds(e.getX(), e.getY(), dardo1.getIconHeight(), dardo1.getIconWidth());
            
            //add el label al panel por defecto
            getContentPane().add(jblDardo);
            
            //en el orden de prioridad del panel por defecto darle el principal que es el 0 asi saldra por encima del anterior label diana
            this.setComponentZOrder(jblDardo, 0);
            
            //Necesario para que el tema del orden de prioridad tenga efecto
            repaint();
        } catch (Exception a) {
            System.out.println("Ups algo falla");
        }
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
