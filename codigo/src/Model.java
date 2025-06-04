import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.List;

/**
 * Clase encargada de manejar los datos
 */
public class Model {
    //creamos una lista que guardara objetos tipo Coche, con modelo, matricula y velocidad
    public static ArrayList<Coche> parking = new ArrayList<>();

    static Observer oGasolina = new ObserverGasolina();
    static ArrayList<Observer> observers = new ArrayList<>();

    /**
     * Creo un arraylist donde implementamos los obvservers, en este caso solo seria 1 asique
     * no haría falta, pero en caso de poner mas de 1, por ejemplo otro de exceso de velocidad
     */

    static {//añadimos
        observers.add(oGasolina);
    }

    /**
     * lee nuestro txt almacen donde se guardan los coches registrados y los carga en un arraylist
     * @param rutaArchivo el archivo donde estaban los coches
     */
    public static void cargarCochesDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {//el buffer nos perminte leer el archivo, podriamos hacer que al principio en la view nos pida el almacen que quieran
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" - ");//divide los datos cuando detecta de por medio un " - ", asi de manera sencilla los puedo guardan ordenadamente en la nueva clase
                Coche coche1 = new Coche(datos[0], datos[1]);// cada dato de arriba lo guarda en el array y simplemente creamos los objetos Coche

                /**
                 * importante, puse que al cargar los coches no se recogiera la velocidad, porque si los tienes en un parking o almacen sera de 0, pero si queremos que se cargue, simplemente
                 * hacemos datos[2], y en el crear coche tendriamos que añadir Int velocidad, y anteriormente un parseint para convertirlo a numero entero
                */

                parking.add(coche1);//añadimos al arraylist el coche
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Cremos el coche
     * @param modelo
     * @param matricula
     * @return
     */
    public static Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return coche o null si no existe
     */

    public static Coche getCoche(String matricula) {
        for (Coche c : parking) {
            if (c.matricula.equals(matricula)) {
                return c;
            }
        }
        return null;
    }

    public static Coche añadirGasolina(String matricula, int cantidad) {
        Coche c = getCoche(matricula);
        c.gasolina += cantidad;
        notifyObservers(c);//llama a la funcion para ver los obvservers
        return c;
    }

    public static int añadirMetros(String matricula, int metros) {
        Coche c = getCoche(matricula);
        c.metros += metros;
        return c.velocidad;
    }
    /**
     * Las siguientes funciones se encargan de cambiar la velocidad y devolver true o false segun si se pudo hacer o no
     * @param matricula
     * @param nuevaVelocidad
     * @return
     */
    public static boolean cambiarVelocidad(String matricula, int nuevaVelocidad) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad = nuevaVelocidad;
            return true;
        }
        return false;
    }

    public static boolean aumentarVelocidad(String matricula, int cantidad) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad += cantidad;
            return true;
        }
        return false;
    }

    public static boolean disminuirVelocidad(String matricula, int cantidad) {
        return aumentarVelocidad(matricula, -cantidad); // Reusamos lógica
    }

    /**
     * Nos devuelve la velocidad del coche
     * @param matricula para identificar el coche
     * @return
     */
    public static Integer getVelocidad(String matricula) {
        Coche c = getCoche(matricula);
        return c != null ? c.velocidad : null;
    }

    /**
     * Esta funcion sirve para saber si un coche existe mediante la matriucla
     * se podria hacer con un boolean
     * @param matricula del coche que queremos buscar
     * @return la matricula si existe
     */
    public static Coche getCochePorMatricula(String matricula) {
        return getCoche(matricula);
    }

    /**
     * Esta funcion es la ultima que se realizara del programa, sirve para actualizar nuestro txt.
     * @param parking la lista de coches que se guardaran
     */
    static void guardarParking(List<Coche> parking) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("almacen.txt"))) {//para escribir en el txt, al no haber puesto true, el archivo se sobreescribira, actualizandolo
            for (Coche coche : parking) {//un bucle eachfor con un objeto que recorre nuestro array de objetos
                bw.write(coche.modelo + " - " + coche.matricula + " - " + coche.velocidad);//escribimos los datos
                bw.newLine();//saltamos a la siguiente linea
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el parking: " + e.getMessage());//en caso de error
        }
    }

    /**
     * esta funcion recorre la lista de obversers, metiendo el coche en cada uno
     * @param coche
     */
    public static void notifyObservers(Coche coche) {
        // avisamos a todos los observadores
        for (Observer o: observers) {
            o.update(coche);
        }
    }

}