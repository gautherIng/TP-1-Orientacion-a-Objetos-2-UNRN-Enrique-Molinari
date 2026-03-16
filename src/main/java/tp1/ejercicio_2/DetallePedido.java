package tp1.ejercicio_2;

public class DetallePedido {
    private Menu item;
    private int cantidad;

    public DetallePedido(Menu item, int cantidad) {
        this.item = item;
        this.cantidad = cantidad;
    }

    public Menu getItem() {
        return item;
    }

    public double calcularSubtotal() {
        return item.getPrecio() * cantidad;
    }
}