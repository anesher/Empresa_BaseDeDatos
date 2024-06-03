package empresa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodosTrans implements InterfazTrans {

    Connection cn = null;
    Statement stm = null;
    ResultSet resultado = null;
        public void creartablaForanea(){

            try {
                cn = Conectar.conectar();
                stm = cn.createStatement();
                resultado = stm.executeQuery("SHOW TABLES LIKE 'transicion';");
                //para ver si esta la tabla hecha
                if (!resultado.next()) {
                    String sql = "CREATE TABLE transicion ("
                            + "id_transicion INT NOT NULL AUTO_INCREMENT,"
                            + "nombre VARCHAR(200) NOT NULL, "
                            + "departamento VARCHAR(255) NOT NULL,"
                            + "importe INT NOT NULL,"
                            + "concepto VARCHAR (255) NOT NULL,"
                            + "id_user INT NOT NULL,"
                            + "PRIMARY KEY (id_transicion),"
                            + "FOREIGN KEY (id_user) REFERENCES usuarios(id_user));";
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
        public void insertarDato(String nombre, String departamento, double importe, String concepto, int id_user) {

            Connection cn = null;
            Statement stm = null;
            ResultSet rs = null;

            try {
                cn = Conectar.conectar();
                stm = cn.createStatement();
                String sql = String.format(
                        "INSERT INTO transicion (nombre, departamento, importe, concepto, id_user) VALUES ('%s', '%s', '%s', '%s', '%s');",
                        nombre, departamento, importe, concepto, id_user
                );
                stm.executeUpdate(sql);
                System.out.println("Transación insertada correctamente");
            } catch (SQLException e) {
                System.out.println("La transación no se ha podido insertar");
                e.printStackTrace();
            }
        }
    }
// id_transicion, nombre, departamento, importe, concepto, id_user
