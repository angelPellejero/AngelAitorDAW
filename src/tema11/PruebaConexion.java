package tema11;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import tema11.Clientes.ConexionBD;


public class PruebaConexion {

    Connection con;

    PruebaConexion() {
        try {
            //cargar driver
            Class.forName("com.mysql.jdbc.Driver");
             //hacer conexion
            
//            con=DriverManager.getConnection("jdbc:mysql://10.2.7.1:3306/negocios2011?zeroDateTimeBehavior=convertToNull", "root", "");
           //crear instruccion JDBC
                Statement stm = ConexionBD.getConexion().createStatement();
            //crear instruccion
            ResultSet rs =stm.executeQuery("select * from datos");
            while(rs.next()){
                System.out.println(rs.getString(1) +" "+ rs.getString(2));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new PruebaConexion();
    }
}
