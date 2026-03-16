package tp1.ejercicio_1;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private LocalDate fechaInscripcionInicio;
    private LocalDate fechaInscripcionFin;
    private List<Participante> participantes;
    private Clock reloj;

    public Concurso(LocalDate inicio, LocalDate fin, Clock reloj) {
        this.fechaInscripcionInicio = inicio;
        this.fechaInscripcionFin = fin;
        this.participantes = new ArrayList<>();
        this.reloj = reloj;
    }

    public void inscribirParticipante(Participante p) {
        if(chequearFechaRango() == 1) {
            participantes.add(p);
            if(chequearFechaInscripcionHoy() == 1){p.sumarPuntos(10);}
        }
        else {throw new RuntimeException("el participante intento inscribirse fuera del plazo");}
    }

    public int chequearFechaInscripcionHoy() {
        int estado = 1;
        if(this.fechaInscripcionInicio.isBefore(LocalDate.now(this.reloj))) {estado = 0;}
        if(this.fechaInscripcionInicio.isAfter(LocalDate.now(this.reloj))) {estado = 0;}
        return estado;
    }

    public int chequearFechaRango() {
        int estado = 1;
        LocalDate hoy = LocalDate.now(this.reloj);
        if (hoy.isBefore(this.fechaInscripcionInicio) || hoy.isAfter(this.fechaInscripcionFin)) {estado = 0;}
        return estado;
    }

    public List<Participante> getParticipantes() {
        return this.participantes;
    }

    public int getCantidadInscriptos() {
        return this.participantes.size();
    }
}
