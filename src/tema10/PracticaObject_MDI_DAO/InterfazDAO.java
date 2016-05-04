package tema10.PracticaObject_MDI_DAO;

public interface InterfazDAO {

    public abstract boolean alta(Barco barco);
    
    public abstract int existeBarco (Barco barco);

    public  abstract boolean baja(int matricula);

    public abstract boolean modificacion(int posicion, Barco nuevo);

    public abstract String consulta(int matricula);

    public abstract Barco dameSiguiente();

    public abstract Barco dameAnterior();

    public abstract boolean cargarDatos();

    public abstract boolean salvarDatos();

}
