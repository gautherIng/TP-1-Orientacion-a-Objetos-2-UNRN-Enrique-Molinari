package tp1.ejercicio_2;

public class PlatoPrincipal extends Menu {

    public PlatoPrincipal(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public boolean esBebida() {
        return false; // "No, no soy una bebida"
    }
}