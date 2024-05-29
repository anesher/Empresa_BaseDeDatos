package empresa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {
        Conectar conexion = new Conectar();
        conexion.conectar();

        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            cn = conexion.conectar();
            stm = cn.createStatement();

            rs = stm.executeQuery("SELECT * FROM Clientes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
