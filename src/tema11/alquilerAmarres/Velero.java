/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema11.alquilerAmarres;

/**
 *
 * @author VESPERTINO
 */
public class Velero {

    private String nombre_barco;
    private int km, matricula, anoFabricacion;

    public Velero() {
    }
    
    

    public Velero(String nombre_barco, int km, int matricula, int anoFabricacion) {
        this.nombre_barco = nombre_barco;
        this.km = km;
        this.matricula = matricula;
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

    public void setNombre_barco(String nombre_barco) {
        this.nombre_barco = nombre_barco;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.matricula;
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
        final Velero other = (Velero) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Datos Velero: \n" + 
                "Nombre del barco: " + nombre_barco + "\nKm: " + km +
                "\nMatricula: " + matricula + 
                "\nAño de Fabricación: " + anoFabricacion;
    }

}
