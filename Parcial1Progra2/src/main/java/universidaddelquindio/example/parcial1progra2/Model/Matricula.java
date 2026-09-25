package universidaddelquindio.example.parcial1progra2.Model;

import java.time.LocalDate;

public class Matricula {
    private long numero;
    private LocalDate fechaInicio;
    private double descuento;
    private String observaciones;
    private ComprobantePago comprobantePago;
    private AsignacionTutor asignacionTutor;

    public Matricula(long numero, LocalDate fechaInicio, double descuento, String observaciones, ComprobantePago comprobantePago, AsignacionTutor asignacionTutor) {
        this.numero = numero;
        this.fechaInicio = fechaInicio;
        this.descuento = descuento;
        this.observaciones = observaciones;
        this.comprobantePago = comprobantePago;
        this.asignacionTutor = asignacionTutor;
    }

    //Metodo que calcula cuanto es el total a pagar de la matrícula
    public double calcularTotal(){
        double total = 0;

        return total;
    }
    //Metodo que agrega un servicio si este es requerido por el usuario
    public void agregarServicios(Servicios servicios){

    }

    //Metodo que asigna un tutor si el usuario lo necesita
    public void asignarTutor(Docente docente){

    }

    //Metodo que genera el comprobante de pago
    public ComprobantePago generarComprobantePago(){

        return null;
    }


    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public ComprobantePago getComprobantePago() {
        return comprobantePago;
    }
    public void setComprobantePago(ComprobantePago comprobantePago) {
        this.comprobantePago = comprobantePago;
    }

    public AsignacionTutor getAsignacionTutor() {
        return asignacionTutor;
    }
    public void setAsignacionTutor(AsignacionTutor asignacionTutor) {
        this.asignacionTutor = asignacionTutor;
    }

}
