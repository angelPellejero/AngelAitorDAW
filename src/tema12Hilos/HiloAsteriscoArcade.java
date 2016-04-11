package tema12Hilos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloAsteriscoArcade implements Runnable {

    private JuegoArcade juego;

    public HiloAsteriscoArcade(JuegoArcade juego) {
        this.juego = juego;
    }

    @Override
    public void run() {
        boolean aux = true;
        int x1 = 3, y1 = 3;
//        int maxArriba = 25, maxAbajo = 274, maxIzquierda = 10, maxDerecha = 243;// limites de x e y
        int maxArriba = 10, maxAbajo = 10, maxIzquierda = 10, maxDerecha = 10;
        try {
            while (aux == true) {
                if (juego.getLocation().x == maxIzquierda || juego.getLocation().x == maxDerecha) {
                    x1 = x1 * (-1);//para cambiar el signo de positivo a negativo o viceversa
                }
                if (juego.getLocation().y == maxArriba || juego.getLocation().y == maxAbajo) {
                    y1 = y1 * (-1);
                }
                
                juego.getJlbAsterisco().setLocation(juego.getLocation().x + x1, juego.getLocation().y + y1);
                juego.repaint();
                sleep(1000);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(HiloAsteriscoArcade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
