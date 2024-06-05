package empresa;

public interface Interfaz {

    void insertarUsuario(String username, String password, String permisos);

    public UsuarioDTO getUsuario(String user, String password);

    void mostrarResultados();
}
