package pruebaMVC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class ModeloBD implements InterfazDAO {

    private Statement stm;

    public ModeloBD() {
        try {
            stm = ConexionBD.getConexion().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean añadirBarco(Barco b) {
        if (!ExisteBarco(b)) {
            try {
                stm.executeUpdate("insert into datos (nombre, matricula, metros) "
                        + "values (" + "'" + b.getNombre() + "'" + "," + b.getMatricula() + "," + b.getMetros() + ")");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ModeloBD.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean BorrarBarco(Barco b) {
        if (ExisteBarco(b)) {
            try {
                stm.executeUpdate("delete from datos where matricula=" + b.getMatricula() + ";");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ModeloBD.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean ExisteBarco(Barco b) {
        try {
            return (stm.executeQuery("select * from datos where matricula=" + b.getMatricula() + ";").first());
        } catch (SQLException ex) {
            Logger.getLogger(ModeloBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean ModificarBarco(Barco b) {
        if (ExisteBarco(b)) {
            try {
                stm.executeUpdate("update datos set nombre='"+b.getNombre()+"', metros="+ b.getMetros()+" where matricula=" + b.getMatricula() + ";");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ModeloBD.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

}
