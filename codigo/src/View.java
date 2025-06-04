import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner ;
/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Este será la interfaz cara al usuario
     */
    public static void menu() {

        int opcion;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Seleccione una opción:");
            System.out.println("0 - Reducir velocidad");
            System.out.println("1 - Aumentar velocidad");
            System.out.println("2 - Cambiar velocidad");
            System.out.println("3 - Crear coche");
            System.out.println("4 - mostrar coches");
            System.out.println("5 - mostrar coche individual");
            System.out.println("6 - añadir gasolina");
            System.out.println("7 - avanzar");
            System.out.println("8 - Salir");
            System.out.println(" ");


            opcion = sc.nextInt();
            //en el switch la view se comunicara con el controller para pedirle hacer la funcion que queramos
            switch (opcion) {
                case 0 -> Controller.disminuirVelocidad();
                case 1 -> Controller.aumentarVelocidad();
                case 2 -> Controller.cambiarVelocidad();
                case 3 -> Controller.crearCoche();
                case 4 -> Controller.mostrarCoches();
                case 5 -> Controller.mostrarCocheIndividual();
                case 6 -> Controller.añadirGasolina();
                case 7 -> Controller.añadirMetros();
                case 8 -> {
                    Controller.guardarDatos();
                    System.out.println(" ");
                    mostrarMensaje("Saliendo...");
                    System.exit(0);
                }
                default -> mostrarError("Opción inválida.");
            }
        //hasta que queramos salir se repetira el menu
        }while (opcion != 8);
    }

    /**
     * estas funciones sirven cuando el controller necesita datos del estilo el coche que queremos elegir
     * @return
     */
    public static String Matricula() {
        System.out.println(" ");
        System.out.print("Introduce la matrícula: ");
        System.out.println(" ");
        return sc.next();
    }

    public static String Modelo() {
        System.out.println(" ");
        System.out.print("Introduce el modelo: ");
        System.out.println(" ");
        return sc.next();
    }

    public static int Velocidad() {
        System.out.println(" ");
        System.out.print("Introduce la velocidad: ");
        System.out.println(" ");
        return sc.nextInt();
    }

    public static int Litros() {
        System.out.println(" ");
        System.out.print("Introduce los litros: ");
        System.out.println(" ");
        return sc.nextInt();
    }

    public static int Metros() {
        System.out.println(" ");
        System.out.print("Introduce los Metros: ");
        System.out.println(" ");
        return sc.nextInt();
    }

    /**
     * estos son funciones de resultado, que son las que simplemente son un output
     * @param matricula
     * @param velocidad
     */
    public static void mostrarVelocidad(String matricula, int velocidad) {
        System.out.println(" ");
        System.out.println(matricula + ": " + velocidad + " km/h");
        System.out.println(" ");
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(" ");
        System.out.println(mensaje);
        System.out.println(" ");
    }

    public static void mostrarError(String error) {
        System.out.println(" ");
        System.out.println("[ERROR] " + error);
        System.out.println(" ");
    }

    public static void mostrarCocheIndividual(Coche c){
        System.out.println(" ");
        System.out.println("Datos del coche:");
        System.out.println("Matrícula: " + c.matricula);
        System.out.println("Modelo: " + c.modelo);
        System.out.println("Velocidad: " + c.velocidad + " km/h");
        System.out.println("Gasolina: " + c.gasolina);
        System.out.println(" ");
    }

    public static void mostrarListaCoches(ArrayList<Coche> lista) {
        if (lista.isEmpty()) {
            System.out.println(" ");
            mostrarMensaje("No hay coches en el parking.");
            System.out.println(" ");
        } else {
            int i=0;
            for (Coche c : lista) {
                i++;
                System.out.println(" ");
                System.out.println("coche numero "+i);
                mostrarCocheIndividual(c);//mostramos los coches tal cual como si fueran individuales, pero uno detras de otro
            }
        }
    }
    public static void mensajeObserver() {
        System.out.println("[OBSERVER] Gasolina baja, añade más.");
    }

}