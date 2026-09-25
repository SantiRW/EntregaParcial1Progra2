package universidaddelquindio.example.parcial1progra2.Model;


public class ProgramaBasico extends Programa {

    public ProgramaBasico(String codigo, String nombre, String idioma, String descripcion,
                          int duracionMeses, double valorMensual) {
        super(codigo, nombre, idioma, descripcion, duracionMeses, valorMensual);
    }

    @Override
    public double calcularValorFinal() {
        return calcularValorBase();
    }
}