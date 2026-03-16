package tp1.ejercicio_1;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class ConcursoTest {

    //Fechas que tomo de ejemplo para probar
    LocalDate inicio = LocalDate.of(2026, 3, 14);
    LocalDate fin = LocalDate.of(2026, 3, 20);

    //--------------------------------------------------------------------------------------------------------------------
    //Caso 1 - inscripcion normal
    public void test1() {
        //Esto lo pongo como forma de hardcodearle una fecha para el test, no se como mas se podria hacer sino
        Instant instantetest1 = LocalDate.of(2026, 3, 16).atStartOfDay(ZoneId.of("UTC")).toInstant();
        Clock reloj = Clock.fixed(instantetest1, ZoneId.of("UTC"));

        Concurso concurso = new Concurso(inicio, fin, reloj);
        Participante p = new Participante("Ima", "Basterra", 0);

        concurso.inscribirParticipante(p);

        if (concurso.getCantidadInscriptos() == 1 && p.getPuntos() == 0) {
            System.out.println("Caso 1 - adentro");
        } else {
            System.out.println("caso 1 - no anda");
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    //Caso 2 - primer dia (10 puntos)
    public void test2() {
        Instant instantetest2 = LocalDate.of(2026, 3, 14).atStartOfDay(ZoneId.of("UTC")).toInstant();
        Clock reloj = Clock.fixed(instantetest2, ZoneId.of("UTC"));

        Concurso concurso = new Concurso(inicio, fin, reloj);
        Participante p = new Participante("Ima", "Basterra", 0);

        concurso.inscribirParticipante(p);

        if (concurso.getCantidadInscriptos() == 1 && p.getPuntos() == 10) {
            System.out.println("Caso 2 - adentro");
        } else {
            System.out.println("Caso 2 - no anda");
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    //Caso 3 - antes de fecha (tiene que tirar error)
    public void test3() {
        Instant instantetest3 = LocalDate.of(2026, 3, 10).atStartOfDay(ZoneId.of("UTC")).toInstant();
        Clock reloj = Clock.fixed(instantetest3, ZoneId.of("UTC"));

        Concurso concurso = new Concurso(inicio, fin, reloj);
        Participante p = new Participante("Ima", "Basterra", 0);

        try {
            concurso.inscribirParticipante(p);
            System.out.println("Caso 3 - noanda");
        } catch (RuntimeException e) {
            if (e.getMessage().equals("el participante intento inscribirse fuera del plazo")) {
                System.out.println("Caso 3 - adentro");
            } else {
                System.out.println("Caso 3 - noanda (tiro un exception raro)");
            }
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    //Caso 4 - despues de fecha
    public void test4() {
        Instant instantetest4 = LocalDate.of(2026, 3, 25).atStartOfDay(ZoneId.of("UTC")).toInstant();
        Clock reloj = Clock.fixed(instantetest4, ZoneId.of("UTC"));
        Concurso concurso = new Concurso(inicio, fin, reloj);
        Participante p = new Participante("Ima", "Basterra", 0);

        try {
            concurso.inscribirParticipante(p);
            System.out.println("Caso 4 - no anda");
        } catch (RuntimeException e) {
            System.out.println("Caso 4 - adentro");
        }
    }
    //--------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        ConcursoTest pruebas = new ConcursoTest();
        pruebas.test1();
        pruebas.test2();
        pruebas.test3();
        pruebas.test4();
    }
}