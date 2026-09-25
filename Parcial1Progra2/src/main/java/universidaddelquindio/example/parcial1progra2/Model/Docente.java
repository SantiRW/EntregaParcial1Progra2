package universidaddelquindio.example.parcial1progra2.Model;

public class Docente {
    private String identificacion;
    private String nombre;
    private String idiomaEspecialidad;
    private String telefono;
    private double tarifaSecion;

    public Docente(String identificacion, String nombre, String idiomaEspecialidad, String telefono, double tarifaSecion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.idiomaEspecialidad = idiomaEspecialidad;
        this.telefono = telefono;
        this.tarifaSecion = tarifaSecion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdiomaEspecialidad() {
        return idiomaEspecialidad;
    }

    public void setIdiomaEspecialidad(String idiomaEspecialidad) {
        this.idiomaEspecialidad = idiomaEspecialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getTarifaSecion() {
        return tarifaSecion;
    }

    public void setTarifaSecion(double tarifaSecion) {
        this.tarifaSecion = tarifaSecion;
    }
}
