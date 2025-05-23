import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos
 */
public class Model {
    public static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
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


    /**
     * Cambia la velocidad de un coche
     * @return velocidad modificada
     */
    /**
     * Cambia la velocidad de un coche

     * @param matricula

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

    public static Integer getVelocidad(String matricula) {
        Coche c = getCoche(matricula);
        return c != null ? c.velocidad : null;
    }

    public static Coche getCochePorMatricula(String matricula) {
        return getCoche(matricula);
    }

}