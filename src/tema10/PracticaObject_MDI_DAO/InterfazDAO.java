package tema10.PracticaObject_MDI_DAO;

public interface InterfazDAO {

    public boolean alta(Barco barco);
    
    public int existeBarco (Barco barco);

    public boolean baja(int matricula);

    public boolean modificacion(int posicion, Barco nuevo);

    public String consulta(int matricula);

    public Barco dameSiguiente();

    public Barco dameAnterior();

    public boolean cargarDatos();

    public boolean salvarDatos();

}
