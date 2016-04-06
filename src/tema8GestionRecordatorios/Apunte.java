package tema8GestionRecordatorios;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;
import sun.util.calendar.Gregorian;

public class Apunte implements Comparable {

    private String asunto, texto;
    private GregorianCalendar fecha;

    public Apunte() {
        this.fecha = new GregorianCalendar();
    }

    public Apunte(String asunto, String texto) {
        this.asunto = asunto;
        this.texto = texto;
        this.fecha = new GregorianCalendar();
    }

    public String getAsunto() {
        return asunto;
    }

    public String getTexto() {
        return texto;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Apunte{" + "asunto=" + asunto + ", texto=" + texto + ", fecha=" + fecha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Apunte other = (Apunte) obj;
        if (!Objects.equals(this.asunto, other.asunto)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) { // establecido el "orden natural" de Alumno
        int aux;
        Apunte apunte = (Apunte) o;
        apunte.getFecha().set(GregorianCalendar.HOUR, this.fecha.get(GregorianCalendar.HOUR));
        apunte.getFecha().set(GregorianCalendar.MINUTE, this.fecha.get(GregorianCalendar.MINUTE));
        apunte.getFecha().set(GregorianCalendar.SECOND, this.fecha.get(GregorianCalendar.SECOND));
        aux = apunte.getFecha().compareTo(this.fecha);
        return aux;
    }

}
