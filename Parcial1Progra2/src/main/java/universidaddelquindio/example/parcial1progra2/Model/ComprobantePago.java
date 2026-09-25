package universidaddelquindio.example.parcial1progra2.Model;

import java.time.LocalDate;

public class ComprobantePago {

    private String numero;
    private LocalDate fecha;
    private double total;

    public ComprobantePago(String numero, double total, LocalDate fecha) {
        this.numero = numero;
        this.total = total;
        this.fecha = fecha;
    }

    public void generar(){

    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
