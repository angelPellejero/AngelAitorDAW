
package blackJack;


public class Persona {
    private String nombre;
    private Mano mano;

    public Persona(String nombre) {
        this.nombre = nombre;
        mano = new Mano();
    }

    public String getNombre() {
        return nombre;
    }

    public Mano getMano() {
        return mano;
    }   
}
