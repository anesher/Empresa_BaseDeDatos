package empresa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {
        Conectar conexion = new Conectar();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            cn = conexion.conectar();
            stm = cn.createStatement();
            Interfaz metodo = new Metodos(cn);
            metodo.crearTabla();
            metodo.insertarUsuario("22", "francisco", "informatica", "30","dieta");
            metodo.insertarUsuario("23", "antonio", "RH", "22","dieta");
            metodo.insertarUsuario("24", "pepa", "informatica", "22","dieta");
            metodo.insertarUsuario("25", "miguel", "Ventas", "22","dieta");
            metodo.insertarUsuario("26", "paco", "RH", "22","dieta");
            metodo.insertarUsuario("27", "Jesús", "informatica", "40","dieta");
            metodo.insertarUsuario("28", "soledad", "informatica", "22","dieta");
            metodo.insertarUsuario("29", "maximiliano", "Ventas", "22","dieta");
            metodo.insertarUsuario("30", "teodoro", "informatica", "50","dieta");
            metodo.insertarUsuario("31", "cleopatra", "Ventas", "22","dieta");
            rs = stm.executeQuery("SELECT * FROM empleado WHERE euros > 30 && departamento = informatica");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
