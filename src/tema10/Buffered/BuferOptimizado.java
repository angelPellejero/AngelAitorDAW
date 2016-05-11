package tema10.Buffered;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;

public class BuferOptimizado extends JFrame implements ActionListener {

    private JPanel jpTop, jpBottom;
    private JLabel jlOrigen, jlDestino;
    private JTextArea jtOrigen, jtDestino;
    private JButton jbtOrigen, jbtDestino, jbtGo;
    private JFileChooser jfcOrigen, jfcDestino;
    private File flOrigen, flDestino;

    public BuferOptimizado() {
        jbtDestino = new JButton("?");
        jbtDestino.addActionListener(this);
        jbtOrigen = new JButton("+");
        jbtOrigen.addActionListener(this);
        jbtGo = new JButton("go");
        jbtGo.addActionListener(this);
        jtDestino = new JTextArea(" ");
        jtOrigen = new JTextArea(" ");
        jlOrigen = new JLabel("orgien");
        jlDestino = new JLabel("destino");

        getContentPane().setLayout(new BorderLayout());
        jpTop = new JPanel(new GridLayout(2, 3, 5, 5));
        jpTop.add(jlOrigen);
        jpTop.add(jtOrigen);
        jpTop.add(jbtOrigen);
        jpTop.add(jlDestino);
        jpTop.add(jtDestino);
        jpTop.add(jbtDestino);
        this.add(jpTop, BorderLayout.NORTH);

        jpBottom = new JPanel();
        jpBottom.setLayout(new BoxLayout(jpBottom, BoxLayout.Y_AXIS));
        this.add(jpBottom, BorderLayout.SOUTH);

        jpBottom.add(jbtGo);
        jbtGo.setAlignmentX(CENTER_ALIGNMENT);

        pack();
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BuferOptimizado();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtOrigen) {
            jfcOrigen = new JFileChooser();
            int resultado = jfcOrigen.showOpenDialog(jpTop);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                flOrigen = jfcOrigen.getSelectedFile();
                jtOrigen.setText(flOrigen.getAbsolutePath());
            }
        }
        if (e.getSource() == jbtDestino) {
            jfcDestino = new JFileChooser();
            jfcDestino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int resultado = jfcDestino.showSaveDialog(jpTop);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                flDestino = jfcDestino.getSelectedFile();
                jtDestino.setText(flDestino.getAbsolutePath());
            }
        }
        if (e.getSource() == jbtGo) {
            jtOrigen.setText(" ");
            jtDestino.setText(" ");
            lector();
        }
    }

    public void lector() {
        BufferedReader lector = null;
        StringBuilder sb[] = new StringBuilder[26];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        int posicion;
        try {
            lector = new BufferedReader(new FileReader(flOrigen));
            String linea = lector.readLine();
            while (linea != null) {
                posicion = linea.charAt(10) - 65;
                if (posicion >= 0 && posicion <= 26) {
                    sb[posicion].append(linea.substring(10, 50) + "\t");
                }
                linea = lector.readLine();
            }
            escritor(sb);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BuferOptimizado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BuferOptimizado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lector.close();
            } catch (IOException ex) {
                Logger.getLogger(BuferOptimizado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void escritor(StringBuilder sb[]) {
        BufferedWriter escritor = null;
        char letra = 'A';
        try {
            for (int i = 0; i < sb.length; i++) {
                escritor = new BufferedWriter(new FileWriter(flDestino.getAbsolutePath() + "\\" + letra + ".txt"));
                letra++;
                escritor.write(sb[i].toString());
                try {
                    escritor.close();
                } catch (IOException ex) {
                    Logger.getLogger(BuferOptimizado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(BuferOptimizado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
