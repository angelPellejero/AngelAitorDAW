package tema12Eventos;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Encuesta extends JFrame {

    private JLabel jlbPregunta, jlbSies, jlbNoes;
    private JButton jbtSi, jbtNo;
    private JPanel jpSiNo;
    private int si, no;

    public Encuesta() {
        //Instanciar objetos
        si = 0;
        no = 0;
        jlbPregunta = new JLabel("¿Sabes programar?");
        jlbSies = new JLabel("Si es: ");
        jlbNoes = new JLabel("No es: ");
        jbtSi = new JButton("Sí");
        jbtNo = new JButton("No");
        jpSiNo = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        //meter botones
        jpSiNo.add(jbtSi);
        jpSiNo.add(jbtNo);

        //configurar ventana
        getContentPane().setLayout(new GridLayout(4, 1, 10, 10));
        this.add(jlbPregunta);
        this.add(jpSiNo);
        this.add(jlbSies);
        this.add(jlbNoes);
        
        //Creacion de eventos
        jbtSi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                metodoAlHacerClickBoton1();
            }
        });
        
        jbtNo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                metodoAlHacerClickBoton2();
            }
        });
        
        Image icon = new ImageIcon(getClass().getResource("/imagenes/mario.png")).getImage();//Crear objeto de imagen y añadir el icono
        setIconImage(icon);//poner el icono en la ventana
        setVisible(true);//hacer visible la ventana
        setLocationRelativeTo(null);//para que la ventana salga centrada
        setTitle("Encuesta 1");//titulo de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//para terminar proceso al cerrar ventana
        pack();//para que los botones se adaptel al tamaño de la ventana
    }
    
    public void metodoAlHacerClickBoton1(){
        si++;
        jlbSies.setText("Si es: "+ si);
    }
    
    public void metodoAlHacerClickBoton2(){
        no++;
        jlbNoes.setText("No es: "+ no);
    }

    public static void main(String[] args) {
        Encuesta e = new Encuesta();
    }
}
