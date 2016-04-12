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
        int x1 = 1, y1 = 1;
        int maxArriba = -95, maxAbajo = 160, maxIzquierda = 1, maxDerecha = 287;// limites de x e y
        juego.getJlbAsterisco().setBounds(0, 0, 5, 5);
        try {
            while (aux == true) {
                if (juego.getJlbAsterisco().getLocation().x == maxIzquierda || juego.getJlbAsterisco().getLocation().x == maxDerecha) {
                    x1 = x1 * (-1);//para cambiar el signo de positivo a negativo o viceversa
                }
                if (juego.getJlbAsterisco().getLocation().y == maxArriba || juego.getJlbAsterisco().getLocation().y == maxAbajo) {
                    y1 = y1 * (-1);
                }
                //comprobando el choque con la raqueta
                if (juego.getJlbAsterisco().getLocation().x >= juego.getJlRaqueta().getLocation().x
                        && juego.getJlbAsterisco().getLocation().x <= (juego.getJlRaqueta().getLocation().x + juego.getJlRaqueta().getWidth())
                        && juego.getJlbAsterisco().getLocation().y == juego.getJlRaqueta().getLocation().y) {
                    y1 = y1 * (-1);
                }
          
                juego.getJlbAsterisco().setLocation(juego.getJlbAsterisco().getLocation().x + x1, juego.getJlbAsterisco().getLocation().y + y1);

//              System.out.println("x: " + juego.getJlbAsterisco().getLocation().x + " y: " + juego.getJlbAsterisco().getLocation().y);
                juego.repaint();
                sleep(10);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(HiloAsteriscoArcade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
