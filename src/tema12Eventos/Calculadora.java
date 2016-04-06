package tema12Eventos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculadora extends JFrame implements ActionListener {

    private JButton[] botones;
    private JPanel[] paneles;
    private JLabel label;
    private Integer resultado;
    Integer op1, op2, aux;
    String numeros;
    char operador;

    public Calculadora() {
        botones = new JButton[14];
        paneles = new JPanel[3];
        resultado = 0;
        op1 = 0;
        op2 = 0;
        label = new JLabel("" + resultado);

        getContentPane().setLayout(new BorderLayout());

        //Panel de arriba
        paneles[0] = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        paneles[0].add(label);
        this.add(paneles[0], BorderLayout.NORTH);

        //Panel central
        paneles[1] = new JPanel(new GridLayout(4, 3));
        for (int i = 0; i < 10; i++) {
            botones[i] = new JButton(" " + i);
            paneles[1].add(botones[i]);
        }
        botones[10] = new JButton("+");
        botones[11] = new JButton("-");
        paneles[1].add(botones[10]);
        paneles[1].add(botones[11]);
        this.add(paneles[1], BorderLayout.CENTER);

        //panel de abajo
        botones[12] = new JButton("=");
        botones[13] = new JButton("CE");
        paneles[2] = new JPanel(new GridLayout(1, 2));
        paneles[2].add(botones[12]);
        paneles[2].add(botones[13]);
        this.add(paneles[2], BorderLayout.SOUTH);

        //Estanciar enventos
        for (int i = 0; i < botones.length; i++) {
            botones[i].addActionListener(this);
        }

        setVisible(true);//hacer visible la ventana
        Image icon = new ImageIcon(getClass().getResource("/imagenes/calculadora.png")).getImage();//Crear objeto de imagen y añadir el icono
        setIconImage(icon);//poner el icono en la ventana
        setLocationRelativeTo(null);//para que la ventana salga centrada
        setTitle("Calculadora");//titulo de la ventana
        this.setMinimumSize(new Dimension(240, 200));//Le doy el tamaño que quiero por defecto
        setResizable(false);//No se puede cambiar el tamaño de la ventana con esto
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//para terminar proceso al cerrar ventana
        pack();//para que los botones se adaptel al tamaño de la ventana
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        JButton bot = (JButton) e.getSource();//crease boton para sacar la fuente y saber que ha pulsado
        if (bot.getText().equals("+")) { //ha sido pulsado el +
            op1 = Integer.parseInt(label.getText().trim());//trim para quitar el tema de espacios delante y detras
            operador='+';
            label.setText(" ");
        } else if (bot.getText().equals("-")) { // Ha sido pulsado el -
            op1 = Integer.parseInt(label.getText().trim());
            operador='-';
            label.setText(" ");
        } else if (bot.getText().equals("=")) {
            op2= Integer.parseInt(label.getText().trim());// Ha sido pulsado el =
            if(operador=='+'){
                resultado = op1 + op2;
            }else{
                resultado = op1 - op2;
            }
            label.setText("" + resultado);
        }else if (bot.getText().equals("CE")){
            resultado=0;
            op1=0;
            op2=0;
            label.setText(" ");
        }else {
            label.setText(label.getText() + bot.getText().trim());
        }
        }catch (Exception ex){
             label.setText("Error");
        }
    }
}
