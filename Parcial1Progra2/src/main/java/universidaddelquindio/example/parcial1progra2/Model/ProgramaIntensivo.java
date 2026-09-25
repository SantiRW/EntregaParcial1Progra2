package universidaddelquindio.example.parcial1progra2.Model;


public class ProgramaIntensivo extends Programa {

    private static final double RECARGO_INTENSIVO = 0.20; // 20% adicional

    public ProgramaIntensivo(String codigo, String nombre, String idioma, String descripcion,
                             int duracionMeses, double valorMensual) {
        super(codigo, nombre, idioma, descripcion, duracionMeses, valorMensual);
    }

    @Override
    public double calcularValorFinal() {
        double base = calcularValorBase();
        return base + (base * RECARGO_INTENSIVO);
    }
}