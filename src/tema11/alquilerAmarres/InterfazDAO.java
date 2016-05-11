package tema11.alquilerAmarres;

public interface InterfazDAO {

    public abstract boolean alta(Object object);

    public abstract boolean existeBarco(Object object);

    public abstract boolean baja(Object matricula);

    public abstract boolean modificacion(Object objectOld, Object objectNew);
    

    public abstract Object consulta(Object object);

    public abstract Object dameSiguiente();

    public abstract Object dameAnterior();

    public abstract boolean cargarDatos();

    public abstract boolean salvarDatos();
}
