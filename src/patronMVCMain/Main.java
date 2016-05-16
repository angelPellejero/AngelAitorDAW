
package patronMVCMain;

import patronMVCCVIsta.VistaSwing;
import patronMVCModelo.Modelo;
import patronMVCcontrolador.CalculadoraControlador;

public class Main {
    public static void main(String[] args) {
        VistaSwing v = new VistaSwing();
        Modelo m = new Modelo();
        CalculadoraControlador cc = new CalculadoraControlador(v, m);
    }
}
