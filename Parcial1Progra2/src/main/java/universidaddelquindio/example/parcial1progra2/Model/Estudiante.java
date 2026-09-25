package universidaddelquindio.example.parcial1progra2.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombreCompleto;
    private String documento;
    private String telefono;
    private String correo;
    private int edad;
    private LocalDate fechaRegistro;
    private List<Matricula> matriculas;

    public Estudiante(String nombreCompleto, String documento, String telefono, String correo,
                      int edad, LocalDate fechaRegistro) {
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
        this.fechaRegistro = fechaRegistro;
        this.matriculas = new ArrayList<>();
    }

    public boolean esTelefonoPerfecto() {
        long numero;
        try {
            numero = Long.parseLong(telefono.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            return false;
        }
        if (numero <= 1) return false;

        long sumaDivisores = 0;
        for (long i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }
        return sumaDivisores == numero;
    }

    public Matricula adquirirPrograma(Programa programa, long numeroMatricula, LocalDate fechaInicio, double descuento) {
        Matricula matricula = new Matricula(numeroMatricula, this, programa, fechaInicio, descuento, "");
        matriculas.add(matricula);
        return matricula;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public List<Matricula> getMatriculas() { return matriculas; }
}