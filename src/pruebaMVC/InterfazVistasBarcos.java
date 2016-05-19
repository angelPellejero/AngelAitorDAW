package pruebaMVC;

public interface InterfazVistasBarcos {

    public abstract Barco getBarco();

    public abstract void setResultadoAñadido(boolean b);

    public abstract void setResultadoBorrado(boolean b);

    public abstract void setResultadoModificado(boolean b);

    public abstract void setControlador(Controlador con);
}
