//metodo trim borra los espacios de alante y atras
//hay que generar archivos de a... z.txt en cada archivo estaran las calles que empìecen por esa letra
//se recorre las 26 veces para cada letra 
package tema10.Buffered;

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
        
        //comienta tratameinto
        try {
            for (char abc = 'A'; abc <= 'Z'; abc++) {
                fr = new FileReader(ficOrigen);
                br = new BufferedReader(fr);
                StringBuilder sb = new StringBuilder("");
                linea = br.readLine();
                while (linea != null) {
                    if((linea.charAt(10)+"").equals(abc+"")){
                        sb.append(linea.substring(10, 50)+ "\t");
                    }
                    linea = br.readLine();
                }
                br.close();
                fr.close();
                guardarArchivos(sb.toString(), abc); 
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BufferPractica4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BufferPractica4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarArchivos(String calles, char abc) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
                fw = new FileWriter(fchDestino.getAbsolutePath() + "\\" + abc + ".txt");
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
