package empresa;

public class UsuarioDTO {
    private int id_user;
    private String username;
    private String password;
    private String permisos;

    public UsuarioDTO(int id_user, String username, String password, String permisos) {
        this.id_user = id_user;
        this.username=username;
        this.password=password;
        this.permisos=permisos;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
}
