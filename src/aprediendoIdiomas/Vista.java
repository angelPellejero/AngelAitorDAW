package aprediendoIdiomas;

import java.util.Scanner;

public class Vista {

    public void juego(ListaDePalabras lp) {

        Scanner sc = new Scanner(System.in);
        String ingles, frances;
        Marcador m = new Marcador();
        while (true) {
            int aux = 0;
            Palabras p = lp.damePalabraAleatoria();
            System.out.println("La palabra " + p.getEspañol() + " se dice en : ");
            System.out.println("Ingles: ");
            ingles = sc.nextLine();
            System.out.println("Frances: ");
            frances = sc.nextLine();
            if (ingles.equals(p.getIngles())) {
                aux++;
            }
            if (frances.equals(p.getFrances())) {
                aux++;
            }
            m.ponAcierto(aux);
            System.out.println(m.toString());
        }
    }

}
