//no puede haber clsaes jugador ni mano eso hay que cambiarlo luego
package blackJack;

import java.awt.event.ActionEvent;
import java.util.Scanner;

public class VistaConsola {

    private Scanner sc;
    private String nombre, cartasJugador, cartasCrupier;
    private float apuesta, saldo;
    private boolean jugar1, jugar2, condicion;
    private int opcion, puntuacioJugador, puntuacioCrupier;
    private Controlador controlador;

    public VistaConsola() {
        sc = new Scanner(System.in);
        jugar1 = true;
        jugar2 = true;
    }

    public void loop() {

        System.out.println("BlackJack modo Consola");
        System.out.println("Cual es tu nombre??");//creado nuevo jugador
        nombre = sc.nextLine();
        System.out.println("¿Cuanta pasta tienes?");
        saldo = sc.nextFloat();
        controlador.actionPerformed(new ActionEvent(this, 1, "BotonNuevoJugador"));

        do {
            System.out.println("¿Cuanto quieres apostar?");//Hacer apuesta
            apuesta = sc.nextFloat();
            controlador.actionPerformed(new ActionEvent(this, 2, "BotonApuestaJugador"));
            if (!condicion) {
                System.out.println("No tiene suficiente dinero haz una apuesta menor");
            }
        } while (!condicion);

        System.out.println("Comenzamos:");
        controlador.actionPerformed(new ActionEvent(this, 3, "BotonJugadorCarta"));
        controlador.actionPerformed(new ActionEvent(this, 4, "BotonCrupierCarta"));
        controlador.actionPerformed(new ActionEvent(this, 3, "BotonJugadorCarta"));
        controlador.actionPerformed(new ActionEvent(this, 4, "BotonCrupierCarta"));

        System.out.println("Estas son tus cartas:");
        System.out.println(cartasJugador + " Total en puntos son : " + puntuacioJugador);
        System.out.println("Estas son las cartas del crupier:");
        System.out.println(cartasCrupier + " Puntos Crupier : " + puntuacioCrupier);
        while (jugar1) {//jugador pide cartas hasta plantarse
            if (puntuacioJugador == 21 || puntuacioJugador > 21) {
                break;
            } else {
                System.out.println(nombre + " ¿Que quieres plantarte[1] o pedir carta[2]?");
                opcion = sc.nextInt();
                if (opcion == 1) {
                    break;
                } else {
                    controlador.actionPerformed(new ActionEvent(this, 3, "BotonJugadorCarta"));
                    System.out.println(cartasJugador + " Total en puntos son : " + puntuacioJugador);
                }
            }
        }
        if (puntuacioCrupier < 17) {
            while (jugar2) {
                if (puntuacioCrupier > 16) {
                    break;
                } else {
                    controlador.actionPerformed(new ActionEvent(this, 4, "BotonCrupierCarta"));
                }
            }

        }

        System.out.println("Veamos quien a ganado: ");
        System.out.println("Puntuacion jugador: " + puntuacioJugador + " Tus Cartas:   " + cartasJugador);
        System.out.println("Puntuacion Crupier: " + puntuacioCrupier + " Cartas Crupier:    " + cartasCrupier);
        if (puntuacioCrupier > 21 && puntuacioJugador <= 21) {
            System.out.println("Has ganado");
        } else if (puntuacioJugador > 21 && puntuacioCrupier <= 21) {
            System.out.println("has perdido");
        } else if (puntuacioCrupier > puntuacioJugador && puntuacioCrupier <= 21) {
            System.out.println("has perdido");
        } else if (puntuacioCrupier == puntuacioJugador) {
            System.out.println("habeis empatado");
        } else if (puntuacioCrupier < puntuacioJugador && puntuacioJugador <= 21) {
            System.out.println("has ganado");
        } else if (puntuacioCrupier > 21 && puntuacioJugador > 21) {
            System.out.println("habeis empatado");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getApuesta() {
        return apuesta;
    }

    public void setCondicion(boolean a) {
        condicion = a;
    }

    public void setPuntuacionJugador(int puntos) {
        puntuacioJugador = puntos;
    }

    public void setPuntuacionCrupier(int puntos) {
        puntuacioCrupier = puntos;
    }

    public void setCartasJugdador(String s) {
        cartasJugador = s;
    }

    public void setCartasCrupier(String s) {
        cartasCrupier = s;
    }

    public void setControlador(Controlador c) {
        controlador = c;
        loop();
    }

}
