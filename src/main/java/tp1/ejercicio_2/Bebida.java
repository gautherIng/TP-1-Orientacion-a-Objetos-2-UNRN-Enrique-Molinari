package tp1.ejercicio_2;

public class Bebida extends Menu {

    public Bebida(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public boolean esBebida() {
        return true;
    }

    @Override
    public boolean esPlatoPrincipal() {
        return false;
    }
}

