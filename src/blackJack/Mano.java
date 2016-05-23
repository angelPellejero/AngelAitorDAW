/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackJack;

import java.util.ArrayList;

/**
 *
 * @author Sagastagoitia
 */
public class Mano {

    private ArrayList<Carta> mano;
    private int puntuacion1, puntuacion2;
    private Baraja b;

    public Mano() {
        mano = new ArrayList();
        puntuacion1 = 0;
        puntuacion2 = 0;
        b = new Baraja();
    }

    public void añdirCarta() {
        Carta aux = b.dameCarta();
        mano.add(aux);
        calcularPuntuacion(aux);
    }

    public String mostrarCarta() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < mano.size(); i++) {
            sb.append(mano.get(i).toString() + "");
        }
        return sb.toString();
    }

    public int puntuacionActual() {
        if (puntuacion2 >= 21) {
            return puntuacion1;
        }else{
            return puntuacion2;
        }
    }

    private void calcularPuntuacion(Carta aux) {
        if (aux.getValor() == 1) {
            puntuacion1 = puntuacion1 + 1;
            puntuacion2 = puntuacion2 + 11;
        } else if (aux.getValor() < 11) {
            puntuacion1 = puntuacion1 + aux.getValor();
            puntuacion2 = puntuacion2 + aux.getValor();
        } else {
            puntuacion1 = puntuacion1 + 10;
            puntuacion2 = puntuacion2 + 10;
        }
    }

}
