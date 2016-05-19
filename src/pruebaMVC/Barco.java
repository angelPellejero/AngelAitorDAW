
package pruebaMVC;

import java.io.Serializable;


public class Barco implements Serializable{
    
    private String nombre;
    private int matricula, metros;

    public Barco() {
    }

    public Barco(String nombre, int matricula, int metros) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.metros = metros;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getMetros() {
        return metros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setMetros(int metros) {
        this.metros = metros;
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
        return "Nombre del Barco: " + nombre + " Matricula=: " + matricula + " Metros de eslora: " + metros + "metros";
    }
    
    
}
