package empresa;

import java.sql.*;

public class Metodos implements Interfaz {
    public void crearTabla() {
        Connection cn = null;
        Statement stm = null;
        ResultSet resultado = null;

        try {
            cn = Conectar.conectar();
            stm = cn.createStatement();
            resultado = stm.executeQuery("SHOW TABLES LIKE 'dietas';");
            //para ver si esta la tabla hecha
            if (!resultado.next()) {
                String sql = "CREATE TABLE dietas ("
                        + "id INT NOT NULL AUTO_INCREMENT,"
                        + "empleado VARCHAR(100) NOT NULL, "
                        + "departamento VARCHAR(100) NOT NULL,"
                        + "importe FLOAT NOT NULL,"
                        + "concepto VARCHAR(255) NOT NULL,"
                        + "PRIMARY KEY (id));";
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
            stm.executeUpdate("INSERT INTO dietas (empleado, departamento, importe, concepto) VALUES ('jose', 'comercial', 300, 'Envio rapido');");
            System.out.println("Usuario insertado correctamente");
        } catch (SQLException e) {
            System.out.println("Usuario no se ha podido agregar");
            e.printStackTrace();
        }
    }
}
