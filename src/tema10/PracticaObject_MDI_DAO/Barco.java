
package tema10.PracticaObject_MDI_DAO;

import java.io.Serializable;

public class Barco implements Serializable{
    
    private String nombre_barco;
    private int km, matricula, anoFabricacion;

    public Barco(String nombre_barco, int km, int matricula, int anoFabricacion) {
        this.nombre_barco = nombre_barco;
        this.km = km;
        this.matricula = matricula;
        this.anoFabricacion = anoFabricacion;
    }

    public Barco() {
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.matricula;
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
        final Barco other = (Barco) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre_barco + " Km: " + km + " Matricula: " + matricula + ", Año de Fabricación: " + anoFabricacion ;
    }
   

}
