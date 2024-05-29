package empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String sql = "CREATE TABLE IF NOT EXISTS empresa ("
                + "ID VARCHAR(12) NOT NULL PRIMARY KEY, "
                + "empleado VARCHAR(45) NOT NULL, "
                + "departamento VARCHAR(45) NOT NULL, "
                + "euros DECIMAL(10, 2) NOT NULL "
                + "concepto VARCHAR(45)NOT NULL )";
        try (Statement stm = conexion.createStatement()) {
            stm.executeUpdate(sql);
        }
    }

    @Override
    public void insertarUsuario(String ID, String empleado, String departamento, double euros, String concepto) throws SQLException {
        String sql = "INSERT INTO usuarios (DNI, nombre, pais) VALUES (?, ?, ?)";
        try (PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, ID);
            pst.setString(2, empleado);
            pst.setString(3, departamento);
            pst.setDouble(4, euros);
            pst.setString(5, concepto);
            pst.executeUpdate();
        }
    }


}
