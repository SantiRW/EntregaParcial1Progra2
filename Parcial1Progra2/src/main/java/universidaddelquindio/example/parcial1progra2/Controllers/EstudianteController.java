package universidaddelquindio.example.parcial1progra2.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import universidaddelquindio.example.parcial1progra2.Model.Academia;
import universidaddelquindio.example.parcial1progra2.Model.Estudiante;

import java.time.LocalDate;

public class EstudianteController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEdad;

    @FXML
    private DatePicker dpFechaRegistro;

    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    @FXML
    private TableColumn<Estudiante, String> columnaNombre;

    @FXML
    private TableColumn<Estudiante, String> columnaDocumento;

    @FXML
    private TableColumn<Estudiante, String> columnaTelefono;

    @FXML
    private TableColumn<Estudiante, String> columnaCorreo;

    @FXML
    private TableColumn<Estudiante, Integer> columnaEdad;

    private Academia academia;

    /**
     * Recibe la Academia que contiene los datos del sistema.
     */
    public void setAcademia(Academia academia) {
        this.academia = academia;

        configurarTabla();
        actualizarTabla();
    }

    /**
     * Configura qué atributo del Estudiante
     * debe mostrar cada columna.
     */
    private void configurarTabla() {

        columnaNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombreCompleto")
        );

        columnaDocumento.setCellValueFactory(
                new PropertyValueFactory<>("documento")
        );

        columnaTelefono.setCellValueFactory(
                new PropertyValueFactory<>("telefono")
        );

        columnaCorreo.setCellValueFactory(
                new PropertyValueFactory<>("correo")
        );

        columnaEdad.setCellValueFactory(
                new PropertyValueFactory<>("edad")
        );
    }

    /**
     * Actualiza la tabla con los estudiantes
     * que existen actualmente en Academia.
     */
    private void actualizarTabla() {

        tablaEstudiantes.getItems().clear();

        if (academia != null) {
            tablaEstudiantes
                    .getItems()
                    .addAll(academia.getListaEstudiantes());
        }
    }

    /**
     * Se ejecuta cuando el usuario presiona
     * el botón "Registrar estudiante".
     */
    @FXML
    private void registrarEstudiante() {

        if (academia == null) {
            mostrarAlerta(
                    "Error",
                    "La Academia no ha sido inicializada."
            );
            return;
        }

        try {

            String nombre = txtNombre.getText().trim();
            String documento = txtDocumento.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String correo = txtCorreo.getText().trim();
            String edadTexto = txtEdad.getText().trim();

            LocalDate fechaRegistro = dpFechaRegistro.getValue();

            if (nombre.isEmpty()
                    || documento.isEmpty()
                    || telefono.isEmpty()
                    || correo.isEmpty()
                    || edadTexto.isEmpty()
                    || fechaRegistro == null) {

                mostrarAlerta(
                        "Datos incompletos",
                        "Por favor complete todos los campos."
                );

                return;
            }

            int edad = Integer.parseInt(edadTexto);

            if (edad <= 0) {
                mostrarAlerta(
                        "Edad inválida",
                        "La edad debe ser mayor que cero."
                );

                return;
            }

            Estudiante estudiante = new Estudiante(
                    nombre,
                    documento,
                    telefono,
                    correo,
                    edad,
                    fechaRegistro
            );

            academia.registrarEstudiante(estudiante);

            actualizarTabla();
            limpiarFormulario();

            mostrarAlerta(
                    "Registro exitoso",
                    "El estudiante fue registrado correctamente."
            );

        } catch (NumberFormatException e) {

            mostrarAlerta(
                    "Error",
                    "La edad debe ser un número entero."
            );
        }
    }

    /**
     * Limpia los campos del formulario.
     */
    @FXML
    private void limpiarFormulario() {

        txtNombre.clear();
        txtDocumento.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtEdad.clear();
        dpFechaRegistro.setValue(null);
    }

    /**
     * Muestra una ventana de información.
     */
    private void mostrarAlerta(String titulo, String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
}