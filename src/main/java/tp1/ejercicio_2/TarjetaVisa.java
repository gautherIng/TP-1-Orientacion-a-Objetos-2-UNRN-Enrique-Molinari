package tp1.ejercicio_2;

public class TarjetaVisa extends TarjetaCredito {
    @Override
    public double calcularDescuento(Pedido pedido) {

        //Visa: 3% de descuento solo sobre bebidas
        return pedido.getSubtotalBebidas() * 0.03;
    }
}