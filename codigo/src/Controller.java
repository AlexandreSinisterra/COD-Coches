import java.util.ArrayList;

public class Controller {

    /**
     * Funcion para crear un coche
     * @return
     */
    public static String crearCoche(){

        String modelo = View.Modelo();
        String matricula = View.Matricula();
        Coche nuevo = Model.crearCoche(modelo, matricula);
        return nuevo.matricula;
    }

    /**
     * con esta funcion cargara nuestros datos del almacen
     */
    public static void iniciarPrograma() {
        Model.cargarCochesDesdeArchivo("almacen.txt");
        View.mostrarMensaje("Datos cargados correctamente.");
    }

    /**
     * Las siguientes 3 funciones funcionan basicamente de la misma forma y sirven para modificar la velocidad del vehiculo mediante
     * su matrícula y una cantidad en km/h
     *
     */

    public static void aumentarVelocidad() {
        String matricula = View.Matricula();
        int cantidad = View.Velocidad();
        boolean comprobacion = Model.aumentarVelocidad(matricula, cantidad);
        if (comprobacion) {
            Integer v = Model.getVelocidad(matricula);
            View.mostrarVelocidad(matricula, v);
        } else {
            View.mostrarError("Coche no encontrado.");
        }
    }

    public static void disminuirVelocidad() {
        String matricula = View.Matricula();
        int cantidad = View.Velocidad();
        boolean comprobacion = Model.disminuirVelocidad(matricula, cantidad);
        if (comprobacion) {
            Integer v = Model.getVelocidad(matricula);
            View.mostrarVelocidad(matricula, v);
        } else {
            View.mostrarError("Coche no encontrado.");
        }
    }

    public static void cambiarVelocidad() {
        String matricula = View.Matricula();
        int nuevaVelocidad = View.Velocidad();
        boolean comprobacion = Model.cambiarVelocidad(matricula, nuevaVelocidad);
        if (comprobacion) {
            Integer v = Model.getVelocidad(matricula);
            View.mostrarVelocidad(matricula, v);
        } else {
            View.mostrarError("Coche no encontrado.");
        }
    }

    /**
     * Esta funcion utiliza en bucle a la de abajo, la cual ira mostrando los coches 1 a 1
     */
    public static void mostrarCoches() {
        View.mostrarListaCoches(Model.parking);

    }

    public  static void mostrarCocheIndividual(){

        String matricula = View.Matricula();
        Coche c = Model.getCochePorMatricula(matricula);
        if (c != null){
            View.mostrarCocheIndividual(c);
        }
        else {
            View.mostrarError("Coche no encontrado.");
        }

    }

    /**
     * Cuando terminamos guardamos los coches en el txt
     */
    public static void guardarDatos() {
        Model.guardarParking(Model.parking);
        View.mostrarMensaje("Datos guardados correctamente.");
    }
}