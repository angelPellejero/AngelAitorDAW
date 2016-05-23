package blackJack;

public class Main {

    public static void main(String[] args) {
        Modelo m = new Modelo();
        VistaConsola v = new VistaConsola();
        Controlador cc= new Controlador(m, v);
    }
}
