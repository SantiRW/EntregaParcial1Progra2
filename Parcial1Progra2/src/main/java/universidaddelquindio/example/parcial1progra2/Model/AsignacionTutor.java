package universidaddelquindio.example.parcial1progra2.Model;

import java.time.LocalDate;


public class AsignacionTutor {
    private Estudiante estudiante;
    private Programa programa;
    private Docente docente;
    private LocalDate fechaAsignacion;

    public AsignacionTutor(Estudiante estudiante, Programa programa, Docente docente, LocalDate fechaAsignacion) {
        this.estudiante = estudiante;
        this.programa = programa;
        this.docente = docente;
        this.fechaAsignacion = fechaAsignacion;
    }

    public boolean validarAsignacion() {
        return estudiante != null && programa != null && docente != null;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Programa getPrograma() { return programa; }
    public void setPrograma(Programa programa) { this.programa = programa; }

    public Docente getDocente() { return docente; }
    public void setDocente(Docente docente) { this.docente = docente; }

    public LocalDate getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDate fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }
}