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
            String query = "SELECT * FROM empresa WHERE euros > 30 AND departamento = 'Informatica'";
            try (ResultSet rs = stm.executeQuery(query)) {
                while (rs.next()) {
                    // Procesa el resultado aquí
                    System.out.println("ID: " + rs.getString("id") +
                            ", Nombre: " + rs.getString("nombre") +
                            ", Departamento: " + rs.getString("departamento") +
                            ", Edad: " + rs.getString("edad") +
                            ", Euros: " + rs.getString("euros"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
