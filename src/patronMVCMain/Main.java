
package patronMVCMain;

import patronMVCCVIsta.VistaConsola;
import patronMVCCVIsta.VistaSwing;
import patronMVCModelo.Modelo;
import patronMVCcontrolador.CalculadoraControlador;

public class Main {
    public static void main(String[] args) {
//        VistaSwing v = new VistaSwing();
        VistaConsola v = new VistaConsola();
        Modelo m = new Modelo();
        CalculadoraControlador cc = new CalculadoraControlador(v, m);
        
    }
}
