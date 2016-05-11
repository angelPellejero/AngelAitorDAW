package tema11.alquilerAmarres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Veleros implements InterfazDAO {

    Statement stm;

    public DAO_Veleros() {
        try {
            stm = ConexionBD.getConection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Veleros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean alta(Object object) {
        Velero aux = (Velero) object;
        if (existeBarco(aux) == false) {//si entra aqui hara return y no lanzara false..
            try {
                stm.executeQuery("insert into Veleros values(" + aux.getNombre_barco() + "," + aux.getKm()+ ","+ aux.getMatricula() + "," + aux.getAnoFabricacion() + ");");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Veleros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean existeBarco(Object object) {
        ResultSet set = null;
        try {
            Velero aux = (Velero) object;
            set = stm.executeQuery("select count (*) from veleros where matricula=" + aux.getMatricula() + ";");
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Veleros.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (set.equals(0)) {
            return false;//quiere decir que el barco no existe
        } else {
            return true;//quiere decir que el barco si existe
        }
    }

    @Override
    public boolean baja(Object matricula) {
        Velero aux = (Velero) matricula;
        if (existeBarco(aux) == false) {//si entra aqui hara return y no lanzara false..
            try {
                stm.executeQuery("delete from Veleros where matricula=" + aux.getMatricula() + ";");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Veleros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean modificacion(Object objectOld, Object objectNew) {
        Velero aux = (Velero) objectOld;
        Velero nuevo = (Velero) objectNew;
        if (existeBarco(aux) == false) {//si entra aqui hara return y no lanzara false..
            try {
                stm.executeQuery("update Veleros set nombre_barco=" +nuevo.getNombre_barco()+ ", km="+nuevo.getKm()+", matricula="+nuevo.getMatricula()+
                                 "ano_fabricacion="+ aux.getAnoFabricacion()+ ";");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Veleros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Object consulta(Object object) {
        Velero aux = (Velero) object;
        ResultSet set = null;
        if (existeBarco(aux) == false) {
            try {
                set = stm.executeQuery("select count (*) from veleros where matricula=" + aux.getMatricula() + ";");
                Velero consulta = new Velero();
                consulta.setNombre_barco(set.getNString(1));
                consulta.setKm(set.getInt(2));
                consulta.setMatricula(set.getInt(3));
                consulta.setAnoFabricacion(set.getInt(4));
                return consulta;
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Veleros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public Object dameSiguiente() {
        return true;
    }

    @Override
    public Object dameAnterior() {
        return true;
    }

    @Override
    public boolean cargarDatos() {
        return true;
    }

    @Override
    public boolean salvarDatos() {
        return true;
    }

}
