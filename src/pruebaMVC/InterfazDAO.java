package pruebaMVC;


public interface InterfazDAO {

    public abstract boolean añadirBarco(Barco b);

    public abstract boolean BorrarBarco(Barco b);
    
    public abstract boolean ExisteBarco(Barco b);

    public abstract boolean ModificarBarco(Barco b);
}
