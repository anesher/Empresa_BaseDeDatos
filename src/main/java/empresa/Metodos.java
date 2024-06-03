package empresa;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Metodos implements Interfaz {


    @Override
    public void insertarUsuario(String username, String password, String permisos) {
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            cn = Conectar.conectar();
            stm = cn.createStatement();
            String sql = String.format(
                    "INSERT INTO usuarios (username, password, permisos) VALUES ('%s', '%s', '%s');",
                    username, password, permisos
            );
            stm.executeUpdate(sql);
            System.out.println("Usuario insertado correctamente");
        } catch (SQLException e) {
            System.out.println("El usuario no se ha podido insertar");
            e.printStackTrace();
        }
    }
    @Override
    public UsuarioDTO getUsuario(String user, String password){
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            cn = Conectar.conectar();
            stm = cn.createStatement();
            String sql = String.format(
                    "SELECT * FROM usuarios WHERE username = '%s' AND password = '%s';",
                    user, password
            );
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt("id_user");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                String permisos = rs.getString("permisos");
                UsuarioDTO usuarioDTO = new UsuarioDTO(id, username, pass, permisos);
                return usuarioDTO;
            }else{
                throw new Exception("El usuario no existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }
        /* public void borrarTabla() {
        String sqlDrop = "DROP TABLE IF EXISTS empresa";
        try (Connection cn = Conectar.conectar();
             Statement stm = cn.createStatement()) {

            stm.executeUpdate(sqlDrop);
            System.out.println("Tabla usuarios borrada correctamente");
        } catch (SQLException e) {
            System.out.println("No se pudo borrar la tabla usuarios");
            e.printStackTrace();
        }
    }*/

    /*
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
    } */


