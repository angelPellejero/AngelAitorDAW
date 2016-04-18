package tema10Fichertos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JProgressBar;

public class Gui extends JFrame implements ActionListener {

    private JProgressBar jpBarra;
    private JButton jbGo, jbOrigen, jbDestino;
    private JLabel jlOrigen, jlDestino;
    private JTextField blanco1, blanco2;
    private JPanel panel;
    private JFileChooser fc;
    private File fichero1;
    private StringBuilder sb;

    public Gui() {
        //instanciar objetos
        jpBarra = new JProgressBar(0, 100);//Barra de progreso hay que revisar el constructor
        jpBarra.setStringPainted(true);//NECESARIO PARA QUE MEUSTRA EL % EN EL JPRrogressBar

        jlOrigen = new JLabel("Origen");
        jlDestino = new JLabel("Destino");
        blanco1 = new JTextField(" ");
        blanco1.setBackground(Color.white);
        blanco2 = new JTextField(" ");
        blanco2.setBackground(Color.white);
        jbGo = new JButton("Copiar");
        jbOrigen = new JButton("?");
        jbDestino = new JButton("x");
        panel = new JPanel(new GridLayout(2, 3));
        fc = new JFileChooser();
        fichero1 = new File("");
        sb = new StringBuilder("");

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(panel);
        panel.add(jlOrigen);
        panel.add(blanco1);
        panel.add(jbOrigen);
        panel.add(jlDestino);
        panel.add(blanco2);
        panel.add(jbDestino);
        jbGo.setAlignmentX(CENTER_ALIGNMENT);

        getContentPane().add(jpBarra);
        getContentPane().add(jbGo);
        jbGo.addActionListener(this);
        jbOrigen.addActionListener(this);
        jbDestino.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 300);
    }

    public static void main(String[] args) {
        Gui a = new Gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileWriter fw;
        JButton bot = (JButton) e.getSource();
        if (bot.getText().equals("?")) {
            int seleccion = fc.showOpenDialog(panel);//guardamos en int la seleccion
            if (seleccion == JFileChooser.APPROVE_OPTION) {//si selecciona aceptar entra en el if
                fichero1 = fc.getSelectedFile();//seleccionamos el fichero
                blanco1.setText(fichero1.getAbsolutePath());//guardamos la ruta en el label
                try {
                    FileReader fr = new FileReader(fichero1);
                    int valor = fr.read();
                    while (valor != -1) {
                        sb.append(valor);
                        valor = fr.read();
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (bot.getText().equals("x")) {//el caso de donde guardar
            int seleccion = fc.showSaveDialog(panel);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero1 = fc.getSelectedFile();
                blanco2.setText("Direccion guardara");//Mirar como coger esta direccion
            }

        } else {
            try {
                fw = new FileWriter(fichero1);
                fw.write(sb.toString());
                HiloBarraprogreso hp = new HiloBarraprogreso(this);
                Thread t = new Thread(hp);
                t.start();
                blanco1.setText(" ");
                blanco2.setText(" ");
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JProgressBar getBarra() {
        return jpBarra;
    }

}
