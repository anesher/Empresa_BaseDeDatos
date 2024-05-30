package empresa;

import java.sql.*;

public class Metodos implements Interfaz {

    public void borrarTabla() {
        String sqlDrop = "DROP TABLE IF EXISTS usuarios";
        try (Connection cn = Conectar.conectar();
             Statement stm = cn.createStatement()) {

            stm.executeUpdate(sqlDrop);
            System.out.println("Tabla usuarios borrada correctamente");
        } catch (SQLException e) {
            System.out.println("No se pudo borrar la tabla usuarios");
            e.printStackTrace();
        }
    }
    public void crearTabla() {
        Connection cn = null;
        Statement stm = null;
        ResultSet resultado = null;

        try {
            cn = Conectar.conectar();
            stm = cn.createStatement();
            resultado = stm.executeQuery("SHOW TABLES LIKE 'usuarios';");
            //para ver si esta la tabla hecha
            if (!resultado.next()) {
                String sql = "CREATE TABLE usuarios ("
                        + "id_user INT NOT NULL AUTO_INCREMENT,"
                        + "username VARCHAR(200) NOT NULL, "
                        + "password INT NOT NULL,"
                        + "permisos VARCHAR(255) NOT NULL,"
                        + "PRIMARY KEY (id_user));";
                stm.executeUpdate(sql);
                System.out.println("Tabla creada correctamente");
            } else {
                System.out.println("La Tabla ya existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertarDato() {
        Connection cn = null;
        Statement stm = null;
        ResultSet resultado = null;

        try {
            cn = Conectar.conectar();
            stm = cn.createStatement();
            stm.executeUpdate("INSERT INTO usuarios (username, password, permisos) VALUES ('antonio', 6525, 'todos');");
            System.out.println("Usuario insertado correctamente");
        } catch (SQLException e) {
            System.out.println("Usuario no se ha podido agregar");
            e.printStackTrace();
        }
    }
}
