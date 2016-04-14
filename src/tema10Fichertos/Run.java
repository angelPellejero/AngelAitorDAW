/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema10Fichertos;

/**
 *
 * @author PROF_VESPERTINO
 */
public class Run {

    public static void main(String[] args) {
        int dato;
        Numero n;

        n = new Numero();
        n.abrirFichero();
        dato = n.leerDatos();
        System.out.println("La suma es: " + dato);
    }
}
