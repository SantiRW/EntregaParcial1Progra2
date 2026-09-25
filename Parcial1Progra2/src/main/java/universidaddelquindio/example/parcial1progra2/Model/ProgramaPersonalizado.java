package universidaddelquindio.example.parcial1progra2.Model;


public class ProgramaPersonalizado extends Programa {

    private int sesionesTutor;
    private String nivelRequerido;
    private String objetivos;
    private static final double VALOR_POR_SESION = 15000.0; // ajustar segun tarifa real

    public ProgramaPersonalizado(String codigo, String nombre, String idioma, String descripcion,
                                 int duracionMeses, double valorMensual,
                                 int sesionesTutor, String nivelRequerido, String objetivos) {
        super(codigo, nombre, idioma, descripcion, duracionMeses, valorMensual);
        this.sesionesTutor = sesionesTutor;
        this.nivelRequerido = nivelRequerido;
        this.objetivos = objetivos;
    }

    @Override
    public double calcularValorFinal() {
        double base = calcularValorBase();
        double costoTutorias = sesionesTutor * VALOR_POR_SESION;
        return base + costoTutorias;
    }

    public int getSesionesTutor() { return sesionesTutor; }
    public void setSesionesTutor(int sesionesTutor) { this.sesionesTutor = sesionesTutor; }

    public String getNivelRequerido() { return nivelRequerido; }
    public void setNivelRequerido(String nivelRequerido) { this.nivelRequerido = nivelRequerido; }

    public String getObjetivos() { return objetivos; }
    public void setObjetivos(String objetivos) { this.objetivos = objetivos; }
}