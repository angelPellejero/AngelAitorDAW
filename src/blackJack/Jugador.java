package blackJack;

public class Jugador extends Persona {

    private float saldo, apuesta;
    

    public Jugador(float saldo,  String nombre) {
        super(nombre);
        this.saldo = saldo;
        this.apuesta = 0;
    }


    public void iniciar() {

    }

    public void jugar() {

    }

    public boolean apostar(float apuesta) {
        if(apuesta < saldo){
            this.apuesta = apuesta;
            saldo = saldo - apuesta;
            return true;
        }
        else{
            return false;
        }

    }


}
