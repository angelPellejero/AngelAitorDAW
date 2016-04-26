package tema10.Buffered;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BufferPrac4_1bucle extends JFrame implements ActionListener {

    private JFileChooser jfcOrigen, jfcDestino;
    private JLabel jlbOrigen, jlbDestino, jlbTextorigen, jldTextoDestino;
    private JPanel panelPrincipal;
    private JButton jbtOrigen, jbtDestino, jbtCopiar;
    private File fchOrigen, fchDestino;
    private FileReader fr = null;
    private BufferedReader br = null;
    private String linea;

    public BufferPrac4_1bucle() {
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
        StringBuilder sb[] = new StringBuilder[26];
        int posicion;
        //comienta tratameinto
        try {
            fr = new FileReader(ficOrigen);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                posicion = linea.charAt(10) - 65;
                sb[posicion].append(linea.substring(10, 50) + "\t");
                linea = br.readLine();
            }
            guardarArchivos(sb);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BufferPractica4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BufferPractica4.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(BufferPrac4_1bucle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void guardarArchivos(StringBuilder[] calles) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        char letra = 'A';
        try {
            for (int i = 0; i < calles.length; i++) {
                fw = new FileWriter(fchDestino.getAbsolutePath() + "\\" + letra + ".txt");
                letra++;
                bw = new BufferedWriter(fw);
                bw.write(calles[i].toString());
            }

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
