package tema9;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class ControlDeErrores {

    public static int[] metodo1(int dividento, int divisor) {

        int[] resultado = new int[2];
        if (divisor == 0) {
            System.out.println("Divisor no puede ser 0");
            return null;
        }
        resultado[0] = dividento / divisor;
        resultado[1] = dividento % divisor;
        return resultado;
    }

    public static int[] metodo2(int dividendo, int divisor) {

        int[] resultado;
        try {
            resultado = new int[2];
            resultado[0] = dividendo / divisor;
            resultado[1] = dividendo % divisor;
            return resultado;
        } catch (ArithmeticException ae) {
            // This block is to catch divide-by-zero error
            System.out.println("Error: Don't divide a number by zero");
            return null;
        }
    }

    public static Integer metodo3(int indice) {
        LinkedList<Integer> lk = new LinkedList();
        Integer a, num = 0;
        for (int i = 0; i < 100; i++) {
            a = i;
            lk.add(a);
        }
        try {
            num = lk.get(indice);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esa poscion no esta en el indice");
            System.out.println(e.getMessage());
            return null;
        }
        return num;
    }
 // metodo llamado lanzar in int, si es > 5 mostrar tabla de multiplicar de ese numero, si es 1 o 3 proboca excepcion, monstrado el mensaje
    // no quiero impares pequeños, si es 2 o 4 mostrar pares tampoco y si es 0 lanzaremos excepcion SQLexception

    public static void lanzar(int a) {
        try {
            if (a > 5) {
                for (int i = 0; i < 11; i++) {
                    System.out.println(a * i);
                }
            } else if (a == 1 || a == 3) {
                throw new Exception("No quiero impares pequeños");
            } else if (a == 2 || a == 4) {
                throw new Exception("pares tampoco");
            } else if (a == 0) {
                throw new SQLException("Habido un error de sql");
            }else if(a<0){
                throw new MiExcepcion(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Hacer metodo 8
    public static void main(String[] args) {
//        metodo2(5, 2);
//        metodo1(5, 2);
//        metodo3(150);
        lanzar(-3);
    }
}
