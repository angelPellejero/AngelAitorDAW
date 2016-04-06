
package tema9;

public class MiExcepcion extends Exception{
    
    public MiExcepcion (int param){
        super("Has introducido un valor negativo "+ param);
    }
}
