package universidaddelquindio.example.parcial1progra2.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Programa {
    private String codigo;
    private String nombre;
    private String idioma;
    private String descripcion;
    private int duracionMeses;
    private double valorMensual;
    private EstadoPrograma estado;
    private List<Beneficio> beneficios;

    public Programa(String codigo, String nombre, String idioma, String descripcion,
                    int duracionMeses, double valorMensual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idioma = idioma;
        this.descripcion = descripcion;
        this.duracionMeses = duracionMeses;
        this.valorMensual = valorMensual;
        this.estado = EstadoPrograma.ACTIVO;
        this.beneficios = new ArrayList<>();
    }

    public double calcularValorBase() {
        return valorMensual * duracionMeses;
    }

    public abstract double calcularValorFinal();

    public void agregarBeneficio(Beneficio beneficio) {
        beneficios.add(beneficio);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getDuracionMeses() { return duracionMeses; }
    public void setDuracionMeses(int duracionMeses) { this.duracionMeses = duracionMeses; }

    public double getValorMensual() { return valorMensual; }
    public void setValorMensual(double valorMensual) { this.valorMensual = valorMensual; }

    public EstadoPrograma getEstado() { return estado; }
    public void setEstado(EstadoPrograma estado) { this.estado = estado; }

    public List<Beneficio> getBeneficios() { return beneficios; }
}