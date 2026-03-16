package tp1.ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<DetallePedido> detalles;
    private boolean estadoConfirmado;

    public Pedido() {
        this.detalles = new ArrayList<>();
        this.estadoConfirmado = false;
    }

    public void agregarItem(Menu item, int cantidad) {
        if (!this.estadoConfirmado) {
            DetallePedido nuevoDetalle = new DetallePedido(item, cantidad);
            this.detalles.add(nuevoDetalle);
        }
        else {throw new RuntimeException("no podes modificar un pedido CONFIRMADO");}
    }

    public void confirmar() {
        this.estadoConfirmado = true;
    }

    //------------------------------------------------------------------------------------------------------------------
    //estos dos getSubtotal son para despues tener por separado a la hora de aplicar los descuentos por producto
    //logica interna para sumar las bebidas
    public double getSubtotalBebidas() {
        double totalBebidas = 0;
        for (DetallePedido detalle : this.detalles) {
            if (detalle.getItem() instanceof Bebida) {
                totalBebidas = totalBebidas + detalle.calcularSubtotal();
            }
        }
        return totalBebidas;
    }

    //logica interna para sumar platos principales
    public double getSubtotalPlatos() {
        double totalPlatos = 0;
        for (DetallePedido detalle : this.detalles) {
            if (detalle.getItem() instanceof PlatoPrincipal) {
                totalPlatos = totalPlatos + detalle.calcularSubtotal();
            }
        }
        return totalPlatos;
    }
    //------------------------------------------------------------------------------------------------------------------

    //total de la mesa sin ningun descuento
    public double getTotalSinDescuento() {
        return this.getSubtotalBebidas() + this.getSubtotalPlatos();
    }

    public double cobrar(TarjetaCredito tarjeta, int porcentajePropina) {

        if (porcentajePropina != 2 && porcentajePropina != 3 && porcentajePropina != 5) {
            throw new RuntimeException("la propina debe ser si o si del 2%, 3% o 5%");
        }

        double costoComida = this.getTotalSinDescuento();

        double descuento = tarjeta.calcularDescuento(this);

        double propina = costoComida * (porcentajePropina / 100.0);

        return (costoComida - descuento) + propina;
    }
}