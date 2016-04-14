package tema10Fichertos;

import java.io.File;

public class Fichero1 {

    public static void ficherosDatos(String url) {
        File c = new File(url);
        System.out.println("fichero direccion :" + c.getPath());
        System.out.println("fichero nombre :" + c.getName());
        System.out.println("fichero espacio total :" + c.getTotalSpace());

    }

    public static void main(String[] args) {
        ficherosDatos("G:/pruebaFile/pr1.png");
        ficherosDatos("G:/pruebaFile/pr2.doc");
        ficherosDatos("G:/pruebaFile/pr3.exe");
    }
}
