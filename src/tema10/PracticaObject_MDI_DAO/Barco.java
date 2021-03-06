
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

    public void setNombre_barco(String nombre_barco) {
        this.nombre_barco = nombre_barco;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public String getNombre_barco() {
        return nombre_barco;
    }

    public int getKm() {
        return km;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
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
        return "Nombre: " + nombre_barco + "\nKm: " + km + "\nMatricula: " + matricula + "\nAño de Fabricación: " + anoFabricacion ;
    }
   

}
