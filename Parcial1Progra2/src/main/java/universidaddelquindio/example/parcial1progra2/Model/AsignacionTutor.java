package universidaddelquindio.example.parcial1progra2.Model;

import java.time.LocalDate;

public class AsignacionTutor {
    private LocalDate fechaAsignacion;

    public AsignacionTutor(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public boolean validarAsignacion(){

        return true;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }
    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
