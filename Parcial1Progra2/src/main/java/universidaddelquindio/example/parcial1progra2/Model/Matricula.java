package universidaddelquindio.example.parcial1progra2.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private static final double DESCUENTO_MAXIMO = 0.30; // regla de negocio: max 30%

    private long numero;
    private Estudiante estudiante;
    private Programa programa;
    private LocalDate fechaInicio;
    private double descuento;
    private String observaciones;
    private List<ServicioMatricula> servicios;
    private ComprobantePago comprobantePago;
    private AsignacionTutor asignacionTutor; // opcional

    public Matricula(long numero, Estudiante estudiante, Programa programa, LocalDate fechaInicio,
                     double descuento, String observaciones) {
        if (estudiante == null) {
            throw new IllegalArgumentException("La matricula requiere un estudiante");
        }
        if (programa == null) {
            throw new IllegalArgumentException("La matricula requiere un programa");
        }
        if (fechaInicio == null) {
            throw new IllegalArgumentException("La matricula requiere una fecha de inicio");
        }
        validarDescuento(descuento);

        this.numero = numero;
        this.estudiante = estudiante;
        this.programa = programa;
        this.fechaInicio = fechaInicio;
        this.descuento = descuento;
        this.observaciones = observaciones;
        this.servicios = new ArrayList<>();
        // El comprobante y el tutor NO son obligatorios al crear la matricula:
        // el comprobante se genera al final y el tutor solo si se asigna.
        this.comprobantePago = null;
        this.asignacionTutor = null;
    }

    private void validarDescuento(double descuento) {
        if (descuento < 0 || descuento > DESCUENTO_MAXIMO) {
            throw new IllegalArgumentException("El descuento no puede superar el 30% del valor del programa");
        }
    }

    // Total = (valor final del programa - descuento) + suma de servicios usados.
    public double calcularTotal() {
        double valorPrograma = programa.calcularValorFinal();
        double valorConDescuento = valorPrograma - (valorPrograma * descuento);

        double totalServicios = 0.0;
        for (ServicioMatricula sm : servicios) {
            totalServicios += sm.calcularSubtotal();
        }

        return valorConDescuento + totalServicios;
    }

    // Agrega un servicio adicional, validando que este disponible antes de sumarlo.
    public void agregarServicio(ServicioMatricula servicioMatricula) {
        if (servicioMatricula == null) return;
        if (!servicioMatricula.getServicioAdicional().estaDisponible()) {
            throw new IllegalStateException("El servicio '" + servicioMatricula.getServicioAdicional().getNombre()
                    + "' no esta disponible");
        }
        servicios.add(servicioMatricula);
    }

    public void asignarTutor(Docente docente) {
        this.asignacionTutor = new AsignacionTutor(estudiante, programa, docente, LocalDate.now());
    }

    public ComprobantePago generarComprobantePago() {
        double total = calcularTotal();
        this.comprobantePago = new ComprobantePago("CP-" + numero, total, LocalDate.now());
        this.comprobantePago.generar();
        return this.comprobantePago;
    }

    public long getNumero() { return numero; }
    public void setNumero(long numero) { this.numero = numero; }

    public Estudiante getEstudiante() { return estudiante; }

    public Programa getPrograma() { return programa; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) {
        validarDescuento(descuento);
        this.descuento = descuento;
    }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public List<ServicioMatricula> getServicios() { return servicios; }

    // Sin setter publico: el comprobante solo se crea via generarComprobantePago().
    public ComprobantePago getComprobantePago() { return comprobantePago; }

    // Sin setter publico: la asignacion solo se crea via asignarTutor().
    public AsignacionTutor getAsignacionTutor() { return asignacionTutor; }
}