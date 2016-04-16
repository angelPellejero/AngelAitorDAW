package tema10Fichertos;

import java.io.File;

public class Fichero1 {

    //Sacar info de archivos hay muchos mas
    public static void ficherosDatos(String url) {
        File c = new File(url);
        System.out.println("fichero direccion :" + c.getPath());
        System.out.println("fichero nombre :" + c.getName());
        System.out.println("fichero espacio total :" + c.getTotalSpace());
    }
    
    //Listar un directorio
    public static void listarDirectorio (String url){
        File f = new File(url);
        if(f.isDirectory()==true){
            for (int i = 0; i < f.listFiles().length; i++) {
                System.out.println(f.listFiles()[i]);
            }
        }
    }

    public static void main(String[] args) {
        ficherosDatos("G:/pruebaFile/pr1.png");
        ficherosDatos("G:/pruebaFile/pr2.doc");
        ficherosDatos("G:/pruebaFile/pr3.exe");
        listarDirectorio("G:/pruebaFile");
    }
}
