package empresa;


import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Interfaz usuario = new Metodos();
        UsuarioDTO usuarioActivo=null;
        InterfazTrans transacion = new MetodosTrans();
        int opcion;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Selecciones la opción que desea: ");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Realizar transación");
            System.out.println("9. Para el proceso");
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 1){
                System.out.println("Introduce user: ");
                String user = sc.next();
                System.out.println("Introduce password: ");
                String password = sc.next();
                try {
                    usuarioActivo = usuario.getUsuario(user, password);
                    System.out.print("El usuario ");
                    System.out.print(usuarioActivo.getUsername());
                    System.out.print(" inicia sesión correctamente");
                }catch (Exception e){
                    System.out.println("El usuario no existe");
                }
            }else if (opcion == 2){
                System.out.print("Introduce user: ");
                String user = sc.next();
                System.out.println("Introduce password: ");
                String password = sc.next();
                System.out.println("Introduce permisos: ");
                String permisos = sc.next();

                usuario.insertarUsuario(user, password, permisos);
            }else if(opcion ==3){
                if (usuario == null){
                    System.out.println("Tienes que iniciar sesión");
                }else{
                    System.out.print("Introduce nombre: ");
                    String nombre = sc.next();
                    System.out.println("Introduce departamento: ");
                    String departamento = sc.next();
                    System.out.println("Introduce importe: ");
                    float importe = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Introduce concepto: ");
                    String concepto = sc.next();
                    int id_user = usuarioActivo.getId_user();

                    transacion.insertarDato(nombre, departamento, importe, concepto, id_user);
                }
            }
        } while (opcion != 9);
    }
}
