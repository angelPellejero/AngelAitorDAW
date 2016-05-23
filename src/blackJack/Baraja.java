package blackJack;

import java.util.ArrayList;

public class Baraja {

    private ArrayList<Carta> baraja;
    private int n_cartas;

    public Baraja() {
        baraja = new ArrayList();
        barajar();
    }

    public void barajar() {
        n_cartas = 51;//52 cartas
        baraja.clear();
        for (int i = 0; i < 4; i++) {//4 palos
            for (int j = 1; j < 14; j++) {//12 cartas de cada palo
                if (i == 0) {
                    baraja.add(new Carta('\u2660', j));
                } else if (i == 1) {
                    baraja.add(new Carta('\u2666', j));
                } else if (i == 2) {
                    baraja.add(new Carta('\u2663', j));
                } else if (i == 3) {
                    baraja.add(new Carta('\u2665', j));
                }
            }
        }
    }

    public Carta dameCarta() {
        Carta aux = baraja.get(AleatorioNum.dameAleatorio(0, n_cartas));
        n_cartas--;
        baraja.remove(aux);
        return aux;
    }

}
