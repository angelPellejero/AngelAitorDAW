//hacer un programa que lea unos números de un fichero y muestre la suma. Usando fileinputstream
package tema10Fichertos;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Suma1 {

    public static void main(String[] args) {
        FileInputStream fis = null;
        int aux = 0, suma = 0;

        try {
            fis = new FileInputStream("F:\\Programación angel\\terceraeva\\src\\tema10Fichertos\\numeros.txt");
            while ((aux = fis.read()) != -1) {
                suma+=aux;
            }
            System.out.println("La suma es: " + suma);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Suma1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Suma1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Suma1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
