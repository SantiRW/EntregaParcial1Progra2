package universidaddelquindio.example.parcial1progra2.Model;

import java.util.List;

public abstract class Programa {
    private String codigo;
    private String idioma;
    private String descripcion;
    private int duracionMeses;
    private double valorMensual;
    private EstadoPrograma estado;
    private List<Beneficio> beneficios;

    public Programa(String codigo, String idioma, String descripcion, int duracionMeses, double valorMensual, EstadoPrograma estado, List<Beneficio> beneficios) {
        this.codigo = codigo;
        this.idioma = idioma;
        this.descripcion = descripcion;
        this.duracionMeses = duracionMeses;
        this.valorMensual = valorMensual;
        this.estado = estado;
        this.beneficios = beneficios;
    }

    public double calcularValorBase(){
        double valorBase = 0.0;


        return valorBase;
    }
}
