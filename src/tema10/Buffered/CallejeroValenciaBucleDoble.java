package tema10.Buffered;


import java.awt.*;
import java.awt.event.*;

import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

/*• En la IGU aparecerá una caja de texto para recoger el fichero de 
lectura y un JFileChooser y otra caja de texto para recoger el 
directorio destino.
• Dado el fichero de calles de ciudades entregado por vuestro profesor.
• Realizar un programa que particione dicho fichero, en ficheros 
cuyas calles empiecen por “a”, “b”, “c”.
• Dichos ficheros se guardarán en el directorio seleccionado por el usuario*/
public class CallejeroValenciaBucleDoble extends JFrame implements ActionListener, WindowListener{
    //empezamos con el componente grafico
    private JPanel panel;
    private JLabel jlOrigen, jlDestino, jlRuta1, jlRuta2;
    private JButton jbOrigen, jbDestino, jbCopiar;
    private JFileChooser jflOrigen, jflDestino;
    private File fOrigen, fDestino;
    private FileReader lector;
    private FileWriter escritor;
    private BufferedReader bffLector;
    private BufferedWriter bffEscritor;
    
    public CallejeroValenciaBucleDoble() {
        //iniciar las prpiedades
        
        panel=new JPanel(new GridLayout(2, 3));
        jlOrigen = new JLabel("Origen");
        jlDestino = new JLabel("Destino: ");
        jlRuta1 = new JLabel("");
        jlRuta2 = new JLabel("");
        jbOrigen=new JButton("Origen");
        jbDestino=new JButton("Dónde se guardar");
        jbCopiar=new JButton("Copiar!!");
        jflOrigen= new JFileChooser();
        jflDestino= new JFileChooser();
        
        //subscribimos los botones a los listener
        jbOrigen.addActionListener(this);
        jbDestino.addActionListener(this);
        jbCopiar.addActionListener(this);
        
        
        //iniciamos el panel principal y colocamos todos los elementos
        panel.add(jlOrigen);
        panel.add(jlRuta1);
        panel.add(jbOrigen);
        panel.add(jlDestino);
        panel.add(jlRuta2);
        panel.add(jbDestino);
        jbCopiar.setAlignmentX(CENTER_ALIGNMENT);
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(panel);
        getContentPane().add(jbCopiar);
        
        pack();
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public File getfOrigen() {
        return fOrigen;
    }

    public File getfDestino() {
        return fDestino;
    }
    

    //hacemos los listener en clases aparte para que quede mejor
   @Override
    public void actionPerformed(ActionEvent e) {
        try {
            escogeFicheros(e);
        } catch (IOException ex) {
            Logger.getLogger(CallejeroValenciaBucleDoble.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {
        cierraFicheros();
    }

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
    public void escogeFicheros(ActionEvent e) throws FileNotFoundException, IOException{
        int returnVal;
        if(e.getSource()==jbOrigen){
            returnVal=jflOrigen.showOpenDialog(this);
            if(returnVal==JFileChooser.APPROVE_OPTION){
                fOrigen= jflOrigen.getSelectedFile();
                jlRuta1.setText(fOrigen.getPath());
                lector = new FileReader(fOrigen);
                
            }else if(returnVal==JFileChooser.CANCEL_OPTION){
                jlRuta1.setText("Operación cancelada.");
            }
        }else if (e.getSource()==jbDestino){
            jflDestino.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            returnVal= jflDestino.showOpenDialog(this);
            if(returnVal==JFileChooser.APPROVE_OPTION){
                fDestino=jflDestino.getCurrentDirectory();
                jlRuta2.setText(fDestino.getPath());
                //bffEscritor=new BufferedWriter(escritor);
            }else if (returnVal==JFileChooser.CANCEL_OPTION){
                jlRuta2.setText("Operación cancelada");
            }
        }else if(e.getSource()==jbCopiar){
            guardaFicheros(fDestino.getPath());
        }
    }
    public void guardaFicheros(String path) throws IOException{
        /*hacemos un bucle y guardamos las calles que empiezan por
        la letra "a" x ejemplo en el a.txt del destino*/
        String linea="";
        String dep;
        
        //hacemos el bucle para guardarlo en el fichhero destino si coincide con las letras
        for (char a = 'A'; a <= 'Z'; a++) {
            // Abrimos el archivo de lectura
            lector = new FileReader(fOrigen);
            bffLector= new BufferedReader(lector);
            // Abrimos el archivo de escritura
            dep = path + "\\" + a+ ".txt";
            escritor = new FileWriter(dep);
            bffEscritor = new BufferedWriter(escritor);           
            
            linea=bffLector.readLine();
            while(linea!=null){                    
                if((linea.charAt(10)+"").equals(a+"")){
                    bffEscritor.write(linea.substring(10, 50));
                    bffEscritor.newLine();
                }
                linea=bffLector.readLine();
            }
            // Es necesario cerrar tanto 1º filtro con 2º estandar
            bffEscritor.close();
            escritor.close();            
            bffLector.close();  
            lector.close();
        }
        
            
    }
    public void cierraFicheros(){
        try {
            bffEscritor.close();
            bffLector.close();
        } catch (IOException ex) {
            Logger.getLogger(CallejeroValenciaBucleDoble.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        CallejeroValenciaBucleDoble cv = new CallejeroValenciaBucleDoble();
    }
   
    
}
