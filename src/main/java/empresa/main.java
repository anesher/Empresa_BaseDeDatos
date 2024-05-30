package empresa;


public class main {
    public static void main(String[] args) {
      Conectar.conectar();

        Metodos metodos= new Metodos();
       metodos.crearTabla();
       metodos.insertarDato();
    }
}
