package blackJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private Modelo m;
    private VistaConsola v;

    public Controlador(Modelo mo, VistaConsola vi) {
        m = mo;
        v = vi;
        v.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("BotonNuevoJugador")) {
            String nombre = v.getNombre().trim();
            float saldo = v.getSaldo();
            m.crearJugador(saldo, nombre);
        } else if (e.getActionCommand().equals("BotonApuestaJugador")) {
            float apuesta = v.getApuesta();
            v.setCondicion(m.setApuesta(apuesta));
        } else if (e.getActionCommand().equals("BotonJugadorCarta")) {
            DatosCarta aux = m.cogerCartaJugador();
            v.setCartasJugdador(aux.getCartas());
            v.setPuntuacionJugador(aux.getPuntuacion());
        } else if (e.getActionCommand().equals("BotonCrupierCarta")) {
            DatosCarta aux = m.cogerCartaCrupier();
            v.setCartasCrupier(aux.getCartas());
            v.setPuntuacionCrupier(aux.getPuntuacion());
        }
    }

}
