import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner ;
/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
    public static Scanner sc = new Scanner(System.in);


    public static void menu() {

        int opcion;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Seleccione una opción:");
            System.out.println("0 - Reducir velocidad");
            System.out.println("1 - Aumentar velocidad");
            System.out.println("2 - Cambiar velocidad");
            System.out.println("3 - Crear coche");
            System.out.println("4 - mostrar coches");
            System.out.println("5 - mostrar coche individual");
            System.out.println("6 - Salir");


            opcion = sc.nextInt();

            switch (opcion) {
                case 0 -> Controller.disminuirVelocidad();
                case 1 -> Controller.aumentarVelocidad();
                case 2 -> Controller.cambiarVelocidad();
                case 3 -> Controller.crearCoche();
                case 4 -> Controller.mostrarCoches(); // mostramos el metodo de la view , meto un get para el get parking y lo meto en la funcion de mostrarListaCoches
                case 5 -> Controller.mostrarCocheIndividual();
                case 6 -> {
                    mostrarMensaje("Saliendo...");
                    System.exit(0);
                }
                default -> mostrarError("Opción inválida.");
            }

            menu(); // Volver al menú después de cada acción
        }while (opcion != 6);
    }

    public static String Matricula() {
        System.out.print("Introduce la matrícula: ");
        return sc.next();
    }

    public static String Modelo() {
        System.out.print("Introduce el modelo: ");
        return sc.next();
    }

    public static int Velocidad() {
        System.out.print("Introduce la velocidad: ");
        return sc.nextInt();
    }


    public static void mostrarVelocidad(String matricula, int velocidad) {
        System.out.println(matricula + ": " + velocidad + " km/h");
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarError(String error) {
        System.out.println("[ERROR] " + error);
    }

    public static void mostrarCocheIndividual(Coche c){
        System.out.println("Datos del coche:");
        System.out.println("Matrícula: " + c.matricula);
        System.out.println("Modelo: " + c.modelo);
        System.out.println("Velocidad: " + c.velocidad + " km/h");
    }
    public static void mostrarListaCoches(ArrayList<Coche> lista) {
        if (lista.isEmpty()) {
            mostrarMensaje("No hay coches en el parking.");
        } else {
            for (Coche c : lista) {
                mostrarCocheIndividual(c);
            }
        }
    }

}