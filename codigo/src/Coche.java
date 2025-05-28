public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;
    Integer gasolina;
    Integer metros;

    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.gasolina = 0;
        this.metros = 0;
    }
}