package tp1.ejercicio_1;

public class Participante {
    private String nombre;
    private String apellido;
    private int puntos;

    public Participante(String nombre, String apellido, int puntos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarPuntos(int p) {
        this.puntos = this.puntos + p;
    }

}
