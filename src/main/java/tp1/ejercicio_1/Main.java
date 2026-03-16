package tp1.ejercicio_1;

import java.time.Clock;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Clock relojReal = Clock.systemDefaultZone();
        Participante participante1 = new Participante("ima", "basterra", 0);
        Concurso concurso1 = new Concurso(LocalDate.of(2026,3,14), LocalDate.of(2026,4,15), relojReal);
        concurso1.inscribirParticipante(participante1);
    }
    }