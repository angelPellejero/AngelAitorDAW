package tema11.Clientes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cursor {

    private Statement stm;
    private ResultSet rs;

    public Cursor() {
        try {
            stm = ConexionBD.getConexion().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Cursor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean userExists(Cliente cliente) { //comprobar si existe el usuario
        try {
            return stm.executeQuery("select * from datos where dni=" + cliente.getDni() + ";").first();
        } catch (SQLException ex) {
            Logger.getLogger(Cursor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean add(Cliente cliente) {
        boolean valido = userExists(cliente);
        if (valido==false) {
            try {
                stm.executeUpdate("insert into datos (nombre, apellido, dni, edad) "
                        + "values ("+ "'"+ cliente.getNombre()+ "'"+ "," + "'"+ cliente.getApellido()+ "'" + ","
                         +cliente.getDni()+ "," +  cliente.getEdad() + ")");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Cursor.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean delete(int dni) {
        Cliente aux = new Cliente();
        aux.setDni(dni);
        boolean valido = userExists(aux);
        if (valido) {
            try {
                stm.executeUpdate("delete from datos where dni=" + aux.getDni() + ";");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Cursor.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    public String showData() {
        StringBuilder sb = new StringBuilder();
        try {
            rs = stm.executeQuery("select * from datos;");
            while (rs.next()){
                sb.append(rs.getString(1)+ " " + rs.getString(2)+ " " + rs.getInt(3)+ " " + rs.getInt(4)+ "\n");
            }
            return sb.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Cursor.class.getName()).log(Level.SEVERE, null, ex);
            return "fallo";
        }
    }

    public boolean change( Cliente nuevo) {
        return true;
    }
    
    public boolean guardarCambios(){
        try {
            stm.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cursor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
