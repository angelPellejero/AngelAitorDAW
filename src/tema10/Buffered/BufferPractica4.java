//metodo trim borra los espacios de alante y atras
//hay que generar archivos de a... z.txt en cada archivo estaran las calles que empìecen por esa letra
//se recorre las 26 veces para cada letra 
package tema10.Buffered;

import com.sun.javafx.util.Utils;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BufferPractica4 extends JFrame implements ActionListener {

    private JFileChooser jfcOrigen, jfcDestino;
    private JLabel jlbOrigen, jlbDestino, jlbTextorigen, jldTextoDestino;
    private JPanel panelPrincipal;
    private JButton jbtOrigen, jbtDestino, jbtCopiar;
    private File fchOrigen, fchDestino;
    private FileReader fr = null;
    private BufferedReader br = null;
    private String linea;

    public BufferPractica4() {
        //estanciar
        jfcOrigen = new JFileChooser();
        jfcOrigen.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfcDestino = new JFileChooser();
        jfcDestino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//solo puedes seleccionar directorios

        jlbOrigen = new JLabel("Origen");
        jlbDestino = new JLabel("Destino");
        jlbTextorigen = new JLabel("");
        jldTextoDestino = new JLabel("");
        jbtOrigen = new JButton("?");
        jbtOrigen.addActionListener(this);
        jbtDestino = new JButton("x");
        jbtDestino.addActionListener(this);
        jbtCopiar = new JButton("Copiar");
        jbtCopiar.addActionListener(this);
        fchOrigen = new File("");
        fchDestino = new File("");
        linea = "";

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        panelPrincipal = new JPanel(new GridLayout(2, 3));
        panelPrincipal.add(jlbOrigen);
        panelPrincipal.add(jlbTextorigen);
        panelPrincipal.add(jbtOrigen);
        panelPrincipal.add(jlbDestino);
        panelPrincipal.add(jldTextoDestino);
        panelPrincipal.add(jbtDestino);

        this.add(panelPrincipal);

        this.add(jbtCopiar, CENTER_ALIGNMENT);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 150);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BufferPractica4();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bot = (JButton) e.getSource();
        if (bot.getText().equals("?")) {
            int seleccion = jfcOrigen.showOpenDialog(panelPrincipal);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fchOrigen = jfcOrigen.getSelectedFile();
                jlbTextorigen.setText(fchOrigen.getParent());
            }
        } else if (bot.getText().equals("x")) {
            int seleccion = jfcDestino.showSaveDialog(panelPrincipal);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fchDestino = jfcDestino.getSelectedFile();
                jldTextoDestino.setText(fchOrigen.getParent());
            }
        } else {
            leerFichero(fchOrigen);//llamar al metodo leeer fichero
        }

    }

    public void leerFichero(File ficOrigen) {
        //rellenar array con el abecedario
        int contador = 0;
        char abecedario[] = new char[27];
        for (char a = 'A'; a <= 'Z'; a++) {
            abecedario[contador] = a;
            contador++;
        }

        //comienta tratameinto
        try {
            StringBuilder sb = new StringBuilder("");
            fr = new FileReader(ficOrigen);
            br = new BufferedReader(fr);
            contador = 0;
            String aux[];
            char letra;
            br.mark((int) fchOrigen.length());//marco una linea para luego ser resetado
            for (int i = 0; i < abecedario.length; i++) {   //para comparar todas las letras  
                while ((linea = br.readLine()) != null) {
                    aux = Utils.split(linea, " ");    //partir las linea en un array
                    letra = aux[1].charAt(0);   //coger la primera letra de la calle
                    if (abecedario[i] == letra) {
                        sb.append(aux[1] + "\t");   //añadir nombre de calle con salto de linea
                    }
                }
                br.reset();//resetear
                guardarArchivos(abecedario[contador], sb.toString());
                sb = null;//borrar los datos 
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BufferPractica4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BufferPractica4.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                fr.close();

            } catch (IOException ex) {
                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void guardarArchivos(char letra, String calles) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(fchDestino.getAbsolutePath() + "\\" + letra + ".txt");
            bw = new BufferedWriter(fw);
            bw.write(calles);
        } catch (IOException ex) {
            Logger.getLogger(BufferPractica4.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
