package universidaddelquindio.example.parcial1progra2.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import universidaddelquindio.example.parcial1progra2.Model.Academia;
import universidaddelquindio.example.parcial1progra2.Model.Docente;

public class DocenteController {

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtIdiomaEspecialidad;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtTarifaSecion;

    @FXML
    private TableView<Docente> tablaDocentes;

    @FXML
    private TableColumn<Docente, String> columnaIdentificacion;

    @FXML
    private TableColumn<Docente, String> columnaNombre;

    @FXML
    private TableColumn<Docente, String> columnaIdioma;

    @FXML
    private TableColumn<Docente, String> columnaTelefono;

    @FXML
    private TableColumn<Docente, Double> columnaTarifa;

    private Academia academia;

    /**
     * Recibe la Academia que contiene los datos
     * del sistema.
     */
    public void setAcademia(Academia academia) {

        this.academia = academia;

        configurarTabla();
        actualizarTabla();
    }

    /**
     * Configura las columnas de la tabla.
     *
     * Cada PropertyValueFactory indica
     * qué atributo de Docente debe mostrar.
     */
    private void configurarTabla() {

        columnaIdentificacion.setCellValueFactory(
                new PropertyValueFactory<>("identificacion")
        );

        columnaNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        columnaIdioma.setCellValueFactory(
                new PropertyValueFactory<>("idiomaEspecialidad")
        );

        columnaTelefono.setCellValueFactory(
                new PropertyValueFactory<>("telefono")
        );

        columnaTarifa.setCellValueFactory(
                new PropertyValueFactory<>("tarifaSecion")
        );
    }

    /**
     * Coloca en la tabla todos los docentes
     * que actualmente existen en Academia.
     */
    private void actualizarTabla() {

        tablaDocentes.getItems().clear();

        if (academia != null) {

            tablaDocentes
                    .getItems()
                    .addAll(academia.getListaDocentes());
        }
    }

    /**
     * Se ejecuta cuando el usuario presiona
     * el botón "Registrar docente".
     */
    @FXML
    private void registrarDocente() {

        if (academia == null) {

            mostrarAlerta(
                    "Error",
                    "La Academia no ha sido inicializada."
            );

            return;
        }

        try {

            String identificacion =
                    txtIdentificacion.getText().trim();

            String nombre =
                    txtNombre.getText().trim();

            String idiomaEspecialidad =
                    txtIdiomaEspecialidad.getText().trim();

            String telefono =
                    txtTelefono.getText().trim();

            String tarifaTexto =
                    txtTarifaSecion.getText().trim();

            // Validamos que ningún campo esté vacío
            if (identificacion.isEmpty()
                    || nombre.isEmpty()
                    || idiomaEspecialidad.isEmpty()
                    || telefono.isEmpty()
                    || tarifaTexto.isEmpty()) {

                mostrarAlerta(
                        "Datos incompletos",
                        "Por favor complete todos los campos."
                );

                return;
            }

            // Convertimos la tarifa de String a double
            double tarifaSecion =
                    Double.parseDouble(tarifaTexto);

            if (tarifaSecion <= 0) {

                mostrarAlerta(
                        "Tarifa inválida",
                        "La tarifa debe ser mayor que cero."
                );

                return;
            }

            // Creamos el objeto del Modelo
            Docente docente = new Docente(
                    identificacion,
                    nombre,
                    idiomaEspecialidad,
                    telefono,
                    tarifaSecion
            );

            // Enviamos el docente a Academia
            academia.registrarDocente(docente);

            // Actualizamos la tabla
            actualizarTabla();

            // Limpiamos el formulario
            limpiarFormulario();

            mostrarAlerta(
                    "Registro exitoso",
                    "El docente fue registrado correctamente."
            );

        } catch (NumberFormatException e) {

            mostrarAlerta(
                    "Tarifa inválida",
                    "La tarifa debe ser un número."
            );
        }
    }

    /**
     * Limpia todos los campos del formulario.
     */
    @FXML
    private void limpiarFormulario() {

        txtIdentificacion.clear();
        txtNombre.clear();
        txtIdiomaEspecialidad.clear();
        txtTelefono.clear();
        txtTarifaSecion.clear();
    }

    /**
     * Muestra una ventana de información.
     */
    private void mostrarAlerta(
            String titulo,
            String mensaje) {

        Alert alerta =
                new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
}