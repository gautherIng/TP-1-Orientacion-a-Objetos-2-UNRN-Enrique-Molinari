package tp1.ejercicio_2;

public class TarjetaMastercard extends TarjetaCredito {
    @Override
    public double calcularDescuento(Pedido pedido) {

        //Mastercard: 2% de descuento solo sobre platos principales
        return pedido.getSubtotalPlatos() * 0.02;
    }
}