package tp1.ejercicio_2;

public class PedidoTest {

    //Caso 1: Tarjeta Visa (3% descuento en bebidas)
    //descuento: 3% de 1000 = $30
    //comida con descuento: 2970, propina, 150, esperado: 3120
    public void test1_Visa() {
        Pedido pedido = new Pedido();
        pedido.agregarItem(new Bebida("Fernet", 1000), 1);
        pedido.agregarItem(new PlatoPrincipal("Milanesa", 2000), 1);

        TarjetaCredito visa = new TarjetaVisa();
        double totalPagado = pedido.cobrar(visa, 5);

        if (totalPagado == 3120.0) {
            System.out.println("Test 1: anda");
        } else {
            System.out.println("Test 1: no anda");
        }
    }

    //Caso 2: Tarjeta Mastercard (2% descuento en platos)
    //descuento: 2% de 2000 = $40
    //comida con descuento: 2960, propina: 150, esperado: 3110
    public void test2_Mastercard() {
        Pedido pedido = new Pedido();
        pedido.agregarItem(new Bebida("Fernet", 1000), 1);
        pedido.agregarItem(new PlatoPrincipal("Milanesa", 2000), 1);

        TarjetaCredito master = new TarjetaMastercard();
        double totalPagado = pedido.cobrar(master, 5);

        if (totalPagado == 3110.0) {
            System.out.println("Test 2: anda");
        } else {
            System.out.println("Test 2: no anda");
        }
    }

    //Caso 3: Tarjeta Comarca Plus (2% descuento en todo)
    //descuento: 2% de 3000 = $60
    //comida con descuento: 2940, propina: 150, esperado: 3090
    public void test3_ComarcaPlus() {
        Pedido pedido = new Pedido();
        pedido.agregarItem(new Bebida("Fernet", 1000), 1);
        pedido.agregarItem(new PlatoPrincipal("Milanesa", 2000), 1);

        TarjetaCredito comarca = new TarjetaComarcaPlus();
        double totalPagado = pedido.cobrar(comarca, 5);

        if (totalPagado == 3090.0) {
            System.out.println("Test 3: anda");
        } else {
            System.out.println("Test 3: no anda");
        }
    }

    //Caso 4: Tarjeta Viedma (sin descuento)
    //comida con descuento: 3000(no tiene), propina: 150, esperado: 3150
    public void test4_Viedma() {
        Pedido pedido = new Pedido();
        pedido.agregarItem(new Bebida("Fernet", 1000), 1);
        pedido.agregarItem(new PlatoPrincipal("Milanesa", 2000), 1);

        TarjetaCredito viedma = new TarjetaViedma();
        double totalPagado = pedido.cobrar(viedma, 5);

        if (totalPagado == 3150.0) {
            System.out.println("Test 4: anda");
        } else {
            System.out.println("Test 4: no anda");
        }
    }

    //Caso 5: rechazar propina invalida
    public void test5_PropinaInvalida() {
        Pedido pedido = new Pedido();
        pedido.agregarItem(new Bebida("Fernet", 1000), 1);
        TarjetaCredito visa = new TarjetaVisa();

        try {
            pedido.cobrar(visa, 4);
            System.out.println("Test 5: no anda (propina que no va)");
        } catch (RuntimeException e) {
            if (e.getMessage().equals("la propina debe ser si o si del 2%, 3% o 5%")) {
                System.out.println("Test 5: anda");
            } else {
                System.out.println("Test 5: no anda (tiró otro error)");
            }
        }
    }

    //Caso 6: rechazar agregar items a un pedido cerrado
    public void test6_PedidoCerrado() {
        Pedido pedido = new Pedido();
        pedido.agregarItem(new Bebida("Fernet", 1000), 1);

        pedido.confirmar();

        try {
            pedido.agregarItem(new PlatoPrincipal("Flan", 500), 1);
            System.out.println("Test 6: no anda (dejo agregar comida a una mesa cerrada)");
        } catch (RuntimeException e) {
            if (e.getMessage().equals("no podes modificar un pedido CONFIRMADO")) {
                System.out.println("Test 6: anda");
            }
        }
    }

    public static void main(String[] args) {
        PedidoTest pruebas = new PedidoTest();
        pruebas.test1_Visa();
        pruebas.test2_Mastercard();
        pruebas.test3_ComarcaPlus();
        pruebas.test4_Viedma();
        pruebas.test5_PropinaInvalida();
        pruebas.test6_PedidoCerrado();
    }
}