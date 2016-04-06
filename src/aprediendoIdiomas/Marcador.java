
package aprediendoIdiomas;

public class Marcador {
    private int puntos;

    public Marcador() {
        puntos=0;
    }
    
    public void ponAcierto(int n){
        if(n==2){
            puntos+=100;
        }else if(n==1){
            puntos+=50;
        }
    }

    @Override
    public String toString() {
        return "Su marcador es: " + puntos;
    }
    
    
}
