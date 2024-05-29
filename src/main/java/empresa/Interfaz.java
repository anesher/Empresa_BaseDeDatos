package empresa;

import java.sql.SQLException;

public interface Interfaz {
    void crearTabla() throws SQLException; // Método para crear la tabla usuarios si no existe
    void insertarUsuario(String ID, String empleado, String departamento, String euros, String concepto) throws SQLException; // Método para insertar un nuevo usuario
    void Consulta() throws SQLException;
}
