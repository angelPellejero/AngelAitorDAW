package blackJack;

public class Modelo {

    Jugador jugador;
    Crupier crupier;

    public Modelo() {
        crupier = new Crupier("Crupier");
    }

    public void crearJugador(float saldo, String nombre) {
        jugador = new Jugador(saldo, nombre);
    }

    public boolean setApuesta(float apuesta) {
        return jugador.apostar(apuesta);
    }

    public DatosCarta cogerCartaJugador() {//cogela carta y devuelve la carta que es y su puntuacion
        DatosCarta aux = new DatosCarta();
        jugador.getMano().añdirCarta();
        aux.setCartas(jugador.getMano().mostrarCarta());
        aux.setPuntuacion(jugador.getMano().puntuacionActual());
        return aux;
    }

    public DatosCarta cogerCartaCrupier() {//lo mismo que del de arriba
        DatosCarta aux = new DatosCarta();
        crupier.getMano().añdirCarta();
         aux.setCartas(crupier.getMano().mostrarCarta());
        aux.setPuntuacion(crupier.getMano().puntuacionActual());
        return aux;
    }

    public int puntosJugador() {
        return jugador.getMano().puntuacionActual();
    }

    public int puntosCrupier() {
        return crupier.getMano().puntuacionActual();
    }
}
