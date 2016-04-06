
package tema9;


public class TestLog {
    public static void main(String[] args) {
        Log log = new Log("angel");
        log.añadir("prueba1");
        log.añadir("prueba2");
        log.añadir("prueba3");
        log.almacenaFichero();
    }
}
