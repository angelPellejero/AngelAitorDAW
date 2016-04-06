
package tema12;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Flow extends JFrame{
    
    private javax.swing.JButton jb1, jb2, jb3, jb4;
    
    public Flow(){
        //poner el layout que queremos utilizar
        this.getContentPane().setLayout(new FlowLayout());
        
        // instanciar comoponentes
        jb1 = new JButton("Boton 1");
        jb2 = new JButton("Boton 2");
        jb3 = new JButton("Boton 3");
        jb4 = new JButton("Boton 4");
        
        //meter los botones
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        
        //empaqueta los botones en el Jframe para que se adapte al tamaño de la ventana
        this.pack();
        
        //mostramos la ventana
        
        this.setVisible(true);
    }
    
    
}
