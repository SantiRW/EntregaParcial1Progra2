package universidaddelquindio.example.parcial1progra2.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Academia {
    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;
    private String correo;
    private String paginaWeb;
    private List<Estudiante> listaEstudiantes;
    private List<Programa> listaProgramas;
    private List<ServicioAdicional> listaServicios;
    private List<Docente> listaDocentes;
    private List<Matricula> listaMatriculas;

    public Academia(String nombreComercial, String nit, String direccion, String telefono,
                    String correo, String paginaWeb) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.paginaWeb = paginaWeb;
        this.listaEstudiantes = new ArrayList<>();
        this.listaProgramas = new ArrayList<>();
        this.listaServicios = new ArrayList<>();
        this.listaDocentes = new ArrayList<>();
        this.listaMatriculas = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public void registrarDocente(Docente docente) {
        listaDocentes.add(docente);
    }

    public void registrarPrograma(Programa programa) {
        listaProgramas.add(programa);
    }

    public void registrarServicio(ServicioAdicional servicio) {
        listaServicios.add(servicio);
    }

    public void registrarMatricula(Matricula matricula) {
        listaMatriculas.add(matricula);
    }

    public String consultarEstudiantePorTelefono() {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.esTelefonoPerfecto()) {
                return estudiante.getNombreCompleto();
            }
        }
        return null;
    }


    public double ingresosEnPeriodo(LocalDate inicio, LocalDate fin) {
        double total = 0.0;
        for (Matricula matricula : listaMatriculas) {
            LocalDate fechaInicio = matricula.getFechaInicio();
            boolean dentroDelPeriodo = !fechaInicio.isBefore(inicio) && !fechaInicio.isAfter(fin);
            if (dentroDelPeriodo) {
                total += matricula.calcularTotal();
            }
        }
        return total;
    }

    public String getNombreComercial() { return nombreComercial; }
    public void setNombreComercial(String nombreComercial) { this.nombreComercial = nombreComercial; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPaginaWeb() { return paginaWeb; }
    public void setPaginaWeb(String paginaWeb) { this.paginaWeb = paginaWeb; }

    public List<Estudiante> getListaEstudiantes() { return listaEstudiantes; }
    public List<Programa> getListaProgramas() { return listaProgramas; }
    public List<ServicioAdicional> getListaServicios() { return listaServicios; }
    public List<Docente> getListaDocentes() { return listaDocentes; }
    public List<Matricula> getListaMatriculas() { return listaMatriculas; }
}