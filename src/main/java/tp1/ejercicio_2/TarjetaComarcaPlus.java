package tp1.ejercicio_2;

public class TarjetaComarcaPlus extends TarjetaCredito {
    @Override
    public double calcularDescuento(Pedido pedido) {

        //Comarca Plus: 2% de descuento sobre todo
        return pedido.getTotalSinDescuento() * 0.02;
    }
}