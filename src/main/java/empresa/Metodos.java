package empresa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Metodos implements Interfaz {
    private final Connection conexion;

    // Constructor que recibe una conexión a la base de datos
    public Metodos (Connection conexion) {
        this.conexion = conexion;
    }

    // Crear la tabla usuarios si no existe
    @Override
    public void crearTabla() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "ID VARCHAR(12) NOT NULL PRIMARY KEY, "
                + "empleado VARCHAR(45), "
                + "departamento VARCHAR(45), "
                + "euros VARCHAR(45), "
                + "concepto VARCHAR(45))";
        try (Statement stm = conexion.createStatement()) {
            stm.executeUpdate(sql);
        }
    }

    @Override
    public void insertarUsuario(String ID, String empleado, String departamento, String euros, String concepto) throws SQLException {

    }

    @Override
    public void Consulta() throws SQLException {

    }

}
