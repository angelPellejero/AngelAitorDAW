package aprediendoIdiomas;

public class Main {

    public static void main(String[] args) {
        Palabras p1 = new Palabras("coche", "car", "voiture");
        Palabras p2 = new Palabras("casa", "house", "maison");
        Palabras p3 = new Palabras("jardin", "garden", "jardin");
        ListaDePalabras l = new ListaDePalabras();
        Vista v = new Vista();

        l.añadir(new Integer("0"), p1);
        l.añadir(new Integer("1"), p2);
        l.añadir(new Integer("2"), p3);
        v.juego(l);
    }
}
