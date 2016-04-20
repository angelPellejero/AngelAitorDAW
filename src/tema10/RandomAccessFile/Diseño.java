package tema10.RandomAccessFile;

import tema10.ProgressBar.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Diseño extends JFrame implements ActionListener {

    private JPanel jpColumna;
    private JLabel jlOrigen, jlOrigenRuta, jlDestino, jlDestinoRuta, jlTamano;
    private JFileChooser jfOrigen, jfDestino;
    private JTextArea jlTamanoIndicado;
    private JButton jbGo, jbOrigen, jbDestino;
    private File fileLectura, fileEscritura;
    private RandomAccessFile raLeer, raEscribir;
//si lo quiero en balnco Texarea

    public Diseño() {

        jpColumna = new JPanel(new GridLayout(3, 3));
        jfOrigen = new JFileChooser();
        jfDestino = new JFileChooser();
        fileEscritura = new File("");
        fileLectura = new File("");
        //Para poder elegir solo el directorio
//        jfDestino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        jlOrigen = new JLabel("Origen");

        jlOrigenRuta = new JLabel("");
        jlOrigenRuta.setBackground(Color.WHITE);

        jlTamanoIndicado = new JTextArea("");
        jlTamanoIndicado.setBackground(Color.WHITE);

        jlTamano = new JLabel("Tamaño");

        jlDestino = new JLabel("Destino");

        jlDestinoRuta = new JLabel("");
        jlDestinoRuta.setBackground(Color.WHITE);

        jbOrigen = new JButton("Selecionar");
        jbOrigen.addActionListener(this);
        jbOrigen.setAlignmentX(CENTER_ALIGNMENT);

        jbDestino = new JButton("Guardar donde");
        jbDestino.addActionListener(this);
        jbDestino.setAlignmentX(CENTER_ALIGNMENT);

        jbGo = new JButton("empezar!!!");
        jbGo.setAlignmentX(CENTER_ALIGNMENT);
        jbGo.addActionListener(this);

        jpColumna.add(jlOrigen);
        jpColumna.add(jlOrigenRuta);
        jpColumna.add(jbOrigen);
        jpColumna.add(jlDestino);
        jpColumna.add(jlDestinoRuta);
        jpColumna.add(jbDestino);
        jpColumna.add(jlTamano);
        jpColumna.add(jlTamanoIndicado);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(jpColumna);

        getContentPane().add(jbGo);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JFileChooser getJfOrigen() {
        return jfOrigen;
    }

    public void setJfOrigen(JFileChooser jfOrigen) {
        this.jfOrigen = jfOrigen;
    }

    public JFileChooser getJfDestino() {
        return jfDestino;
    }

    public void setJfDestino(JFileChooser jfDestino) {
        this.jfDestino = jfDestino;
    }

    public File getFileLectura() {
        return fileLectura;
    }

    public File getFileEscritura() {
        return fileEscritura;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal;
        if (e.getSource() == jbOrigen) {
            returnVal = jfOrigen.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    fileLectura = jfOrigen.getSelectedFile();
                    jlOrigenRuta.setText(fileLectura.getPath());
                    raLeer = new RandomAccessFile(fileLectura, "r");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Diseño.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                jlOrigenRuta.setText("fallo al cargar el archivo");
            }
            //System.out.println(returnVal);
        } else if (e.getSource() == jbDestino) {
            returnVal = jfDestino.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    fileEscritura = jfDestino.getSelectedFile();
                    jlDestinoRuta.setText(fileEscritura.getPath());
                    raEscribir = new RandomAccessFile(fileEscritura, "rw");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Diseño.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                jlDestinoRuta.setText("fallo al cargar el archivo");
            }
            // System.out.println(returnVal);
        } else {
            if ((jlOrigenRuta.getText() != "") && (jlDestinoRuta.getText() != "")) {
                try {
                    int aux = Integer.parseInt(jlTamanoIndicado.getText());
                    byte datos[] = new byte[aux];
//                    //comprobar antes que el archivo este vacio
                    int valor = raLeer.read();
                    if (valor != -1) {
                        //posicionar y leer
                        raLeer.seek(fileEscritura.length());
                        raLeer.read(datos);
                        //posicionar y escribir
                        raEscribir.seek(fileEscritura.length());
                        raEscribir.write(datos);
                    }

                } catch (FileNotFoundException ex) {
                    System.out.println("Fichero no encontrado");
                } catch (IOException ex) {
                    System.out.println("Fallo de la IO");
                } finally {
                    try {
                        raLeer.close();
                        raEscribir.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Diseño.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Diseño a = new Diseño();
    }

}
