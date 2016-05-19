package pruebaMVC;

public class Main {

    public static void main(String[] args) {
//        VistaSwing v = new VistaSwing();
        VistaConsola v = new VistaConsola();
        ModeloBD m = new ModeloBD();
        Controlador c = new Controlador(v, m);
    }
}
