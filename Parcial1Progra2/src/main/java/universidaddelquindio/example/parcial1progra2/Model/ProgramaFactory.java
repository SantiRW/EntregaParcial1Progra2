package universidaddelquindio.example.parcial1progra2.Model;


public class ProgramaFactory {

    public enum TipoPrograma {
        BASICO, INTENSIVO, PERSONALIZADO
    }

    private ProgramaFactory() {
        // clase de utilidad, no se instancia
    }

    public static Programa crear(TipoPrograma tipo, String codigo, String nombre, String idioma,
                                 String descripcion, int duracionMeses, double valorMensual) {
        return switch (tipo) {
            case BASICO -> new ProgramaBasico(codigo, nombre, idioma, descripcion, duracionMeses, valorMensual);
            case INTENSIVO -> new ProgramaIntensivo(codigo, nombre, idioma, descripcion, duracionMeses, valorMensual);
            case PERSONALIZADO -> throw new IllegalArgumentException(
                    "ProgramaPersonalizado necesita sesionesTutor, nivelRequerido y objetivos; "
                            + "use crearPersonalizado(...)");
        };
    }

    public static Programa crearPersonalizado(String codigo, String nombre, String idioma, String descripcion,
                                              int duracionMeses, double valorMensual,
                                              int sesionesTutor, String nivelRequerido, String objetivos) {
        return new ProgramaPersonalizado(codigo, nombre, idioma, descripcion, duracionMeses, valorMensual,
                sesionesTutor, nivelRequerido, objetivos);
    }
}