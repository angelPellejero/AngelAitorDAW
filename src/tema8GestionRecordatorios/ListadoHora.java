
package tema8GestionRecordatorios;

import java.util.Comparator;
import java.util.GregorianCalendar;


public class ListadoHora implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        int aux;
        Apunte ap1 = (Apunte) o1;
        Apunte ap2 = (Apunte) o2;
        ap1.getFecha().set(GregorianCalendar.YEAR, ap2.getFecha().get(GregorianCalendar.YEAR));
        ap1.getFecha().set(GregorianCalendar.MONTH, ap2.getFecha().get(GregorianCalendar.MONTH));
        ap1.getFecha().set(GregorianCalendar.DAY_OF_MONTH, ap2.getFecha().get(GregorianCalendar.DAY_OF_MONTH));
        aux=ap1.compareTo(ap2);
        return aux;
    }
    
}
