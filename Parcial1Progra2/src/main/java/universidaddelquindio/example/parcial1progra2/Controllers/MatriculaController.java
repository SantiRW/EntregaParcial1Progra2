package universidaddelquindio.example.parcial1progra2.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import universidaddelquindio.example.parcial1progra2.Model.Academia;
import universidaddelquindio.example.parcial1progra2.Model.Docente;
import universidaddelquindio.example.parcial1progra2.Model.Estudiante;
import universidaddelquindio.example.parcial1progra2.Model.Matricula;
import universidaddelquindio.example.parcial1progra2.Model.Programa;
import universidaddelquindio.example.parcial1progra2.Model.ServicioAdicional;
import universidaddelquindio.example.parcial1progra2.Model.ServicioMatricula;

//import java.lang.classfile.attribute.LocalVariableTableAttribute;
import java.time.LocalDate;

public class MatriculaController {

    @FXML
    private TextField txtNumero;

    @FXML
    private ComboBox<Estudiante> comboEstudiante;

    @FXML
    private ComboBox<Programa> comboPrograma;

    @FXML
    private DatePicker fechaInicio;

    @FXML
    private TextField txtDescuento;

    @FXML
    private TextArea txtObservaciones;

    @FXML
    private ComboBox<ServicioAdicional> comboServicio;

    @FXML
    private TextField txtCantidadServicio;

    @FXML
    private ComboBox<Docente> comboDocente;

    @FXML
    private Label lblTotal;

    @FXML
    private TableView<Matricula> tablaMatriculas;

    @FXML
    private TableColumn<Matricula, Long> columnaNumero;

    @FXML
    private TableColumn<Matricula, String> columnaEstudiante;

    @FXML
    private TableColumn<Matricula, String> columnaPrograma;

    @FXML
    private TableColumn<Matricula, LocalDate> columnaFecha;

    @FXML
    private TableColumn<Matricula, Double> columnaDescuento;

    @FXML
    private TableColumn<Matricula, Double> columnaTotal;

    private Academia academia;

    private Matricula matriculaActual;

    public void setAcademia(Academia academia) {

        this.academia = academia;

        cargarCombos();

        configurarTabla();

        actualizarTabla();
    }

    private void cargarCombos() {

        if (academia == null) {
            return;
        }

        comboEstudiante.setItems(
                FXCollections.observableArrayList(
                        academia.getListaEstudiantes()
                )
        );

        comboPrograma.setItems(
                FXCollections.observableArrayList(
                        academia.getListaProgramas()
                )
        );

        comboServicio.setItems(
                FXCollections.observableArrayList(
                        academia.getListaServicios()
                )
        );

        comboDocente.setItems(
                FXCollections.observableArrayList(
                        academia.getListaDocentes()
                )
        );

        comboEstudiante.setCellFactory(param ->
                new javafx.scene.control.ListCell<Estudiante>() {

                    @Override
                    protected void updateItem(
                            Estudiante estudiante,
                            boolean empty) {

                        super.updateItem(estudiante, empty);

                        if (empty || estudiante == null) {
                            setText(null);
                        } else {
                            setText(
                                    estudiante.getDocumento()
                                            + " - "
                                            + estudiante.getNombreCompleto()
                            );
                        }
                    }
                }
        );

        comboEstudiante.setButtonCell(
                new javafx.scene.control.ListCell<Estudiante>() {

                    @Override
                    protected void updateItem(
                            Estudiante estudiante,
                            boolean empty) {

                        super.updateItem(estudiante, empty);

                        if (empty || estudiante == null) {
                            setText(null);
                        } else {
                            setText(
                                    estudiante.getDocumento()
                                            + " - "
                                            + estudiante.getNombreCompleto()
                            );
                        }
                    }
                }
        );


        comboPrograma.setCellFactory(param ->
                new javafx.scene.control.ListCell<Programa>() {

                    @Override
                    protected void updateItem(
                            Programa programa,
                            boolean empty) {

                        super.updateItem(programa, empty);

                        if (empty || programa == null) {
                            setText(null);
                        } else {
                            setText(
                                    programa.getCodigo()
                                            + " - "
                                            + programa.getNombre()
                            );
                        }
                    }
                }
        );

        comboPrograma.setButtonCell(
                new javafx.scene.control.ListCell<Programa>() {

                    @Override
                    protected void updateItem(
                            Programa programa,
                            boolean empty) {

                        super.updateItem(programa, empty);

                        if (empty || programa == null) {
                            setText(null);
                        } else {
                            setText(
                                    programa.getCodigo()
                                            + " - "
                                            + programa.getNombre()
                            );
                        }
                    }
                }
        );


        comboServicio.setCellFactory(param ->
                new javafx.scene.control.ListCell<ServicioAdicional>() {

                    @Override
                    protected void updateItem(
                            ServicioAdicional servicio,
                            boolean empty) {

                        super.updateItem(servicio, empty);

                        if (empty || servicio == null) {
                            setText(null);
                        } else {
                            setText(
                                    servicio.getCodigo()
                                            + " - "
                                            + servicio.getNombre()
                                            + " ($"
                                            + servicio.getPrecio()
                                            + ")"
                            );
                        }
                    }
                }
        );

        comboServicio.setButtonCell(
                new javafx.scene.control.ListCell<ServicioAdicional>() {

                    @Override
                    protected void updateItem(
                            ServicioAdicional servicio,
                            boolean empty) {

                        super.updateItem(servicio, empty);

                        if (empty || servicio == null) {
                            setText(null);
                        } else {
                            setText(
                                    servicio.getCodigo()
                                            + " - "
                                            + servicio.getNombre()
                            );
                        }
                    }
                }
        );


        comboDocente.setCellFactory(param ->
                new javafx.scene.control.ListCell<Docente>() {

                    @Override
                    protected void updateItem(
                            Docente docente,
                            boolean empty) {

                        super.updateItem(docente, empty);

                        if (empty || docente == null) {
                            setText(null);
                        } else {
                            setText(
                                    docente.getIdentificacion()
                                            + " - "
                                            + docente.getNombre()
                            );
                        }
                    }
                }
        );

        comboDocente.setButtonCell(
                new javafx.scene.control.ListCell<Docente>() {

                    @Override
                    protected void updateItem(
                            Docente docente,
                            boolean empty) {

                        super.updateItem(docente, empty);

                        if (empty || docente == null) {
                            setText(null);
                        } else {
                            setText(
                                    docente.getIdentificacion()
                                            + " - "
                                            + docente.getNombre()
                            );
                        }
                    }
                }
        );
    }

    private void configurarTabla() {

        columnaNumero.setCellValueFactory(
                new PropertyValueFactory<>("numero")
        );

        columnaEstudiante.setCellValueFactory(
                celda -> new javafx.beans.property.SimpleStringProperty(
                        celda.getValue()
                                .getEstudiante()
                                .getNombreCompleto()
                )
        );

        columnaPrograma.setCellValueFactory(
                celda -> new javafx.beans.property.SimpleStringProperty(
                        celda.getValue()
                                .getPrograma()
                                .getNombre()
                )
        );

        columnaFecha.setCellValueFactory(
                new PropertyValueFactory<>("fechaInicio")
        );

        columnaDescuento.setCellValueFactory(
                new PropertyValueFactory<>("descuento")
        );

        columnaTotal.setCellValueFactory(
                celda -> new javafx.beans.property.SimpleObjectProperty<>(
                        celda.getValue().calcularTotal()
                )
        );
    }

    private void actualizarTabla() {

        if (academia == null) {
            return;
        }

        tablaMatriculas.getItems().clear();

        tablaMatriculas.getItems().addAll(
                academia.getListaMatriculas()
        );
    }

    @FXML
    private void registrarMatricula() {

        if (academia == null) {

            mostrarAlerta(
                    "Error",
                    "No se ha configurado la academia."
            );

            return;
        }

        try {

            String numeroTexto =
                    txtNumero.getText().trim();

            if (numeroTexto.isEmpty()) {

                mostrarAlerta(
                        "Dato faltante",
                        "Ingrese el número de matrícula."
                );

                return;
            }

            long numero =
                    Long.parseLong(numeroTexto);

            Estudiante estudiante =
                    comboEstudiante.getValue();

            if (estudiante == null) {

                mostrarAlerta(
                        "Dato faltante",
                        "Seleccione un estudiante."
                );

                return;
            }

            Programa programa =
                    comboPrograma.getValue();

            if (programa == null) {

                mostrarAlerta(
                        "Dato faltante",
                        "Seleccione un programa."
                );

                return;
            }

            if (fechaInicio.getValue() == null) {

                mostrarAlerta(
                        "Dato faltante",
                        "Seleccione la fecha de inicio."
                );

                return;
            }

            String descuentoTexto =
                    txtDescuento.getText().trim();

            double descuento = 0.0;

            if (!descuentoTexto.isEmpty()) {

                descuento =
                        Double.parseDouble(descuentoTexto);
            }

            if (descuento > 1) {

                descuento =
                        descuento / 100.0;
            }

            String observaciones =
                    txtObservaciones.getText().trim();

            Matricula matricula =
                    new Matricula(
                            numero,
                            estudiante,
                            programa,
                            fechaInicio.getValue(),
                            descuento,
                            observaciones
                    );

            matriculaActual = matricula;

            academia.registrarMatricula(matricula);

            if (comboDocente.getValue() != null) {

                matricula.asignarTutor(
                        comboDocente.getValue()
                );
            }

            actualizarTabla();

            limpiarFormulario();

            mostrarAlerta(
                    "Matrícula registrada",
                    "La matrícula número "
                            + numero
                            + " fue registrada correctamente."
            );

        } catch (NumberFormatException e) {

            mostrarAlerta(
                    "Dato inválido",
                    "El número de matrícula y el descuento "
                            + "deben contener valores numéricos."
            );

        } catch (IllegalArgumentException e) {

            mostrarAlerta(
                    "Error en la matrícula",
                    e.getMessage()
            );
        }
    }

    @FXML
    private void agregarServicio() {

        if (matriculaActual == null) {

            mostrarAlerta(
                    "Primero cree una matrícula",
                    "Debe registrar la matrícula antes "
                            + "de agregar servicios."
            );

            return;
        }


        ServicioAdicional servicio =
                comboServicio.getValue();

        if (servicio == null) {

            mostrarAlerta(
                    "Servicio faltante",
                    "Seleccione un servicio adicional."
            );

            return;
        }


        try {

            int cantidad =
                    Integer.parseInt(
                            txtCantidadServicio
                                    .getText()
                                    .trim()
                    );

            if (cantidad <= 0) {

                mostrarAlerta(
                        "Cantidad inválida",
                        "La cantidad debe ser mayor que cero."
                );

                return;
            }


            if (!servicio.estaDisponible()) {

                mostrarAlerta(
                        "Servicio no disponible",
                        "El servicio seleccionado "
                                + "no está disponible."
                );

                return;
            }


            ServicioMatricula servicioMatricula =
                    new ServicioMatricula(
                            cantidad,
                            servicio.getPrecio(),
                            servicio
                    );


            matriculaActual.agregarServicio(
                    servicioMatricula
            );


            actualizarTotal();


            mostrarAlerta(
                    "Servicio agregado",
                    "El servicio "
                            + servicio.getNombre()
                            + " fue agregado correctamente."
            );


            comboServicio.getSelectionModel()
                    .clearSelection();

            txtCantidadServicio.clear();

        } catch (NumberFormatException e) {

            mostrarAlerta(
                    "Cantidad inválida",
                    "Ingrese una cantidad numérica válida."
            );

        } catch (IllegalStateException e) {

            mostrarAlerta(
                    "No se puede agregar",
                    e.getMessage()
            );
        }
    }

    @FXML
    private void calcularTotal() {

        if (matriculaActual == null) {

            mostrarAlerta(
                    "Sin matrícula",
                    "Primero registre una matrícula."
            );

            return;
        }

        actualizarTotal();
    }


    private void actualizarTotal() {

        if (matriculaActual == null) {

            lblTotal.setText("$0.00");

            return;
        }

        double total =
                matriculaActual.calcularTotal();

        lblTotal.setText(
                String.format("$%.2f", total)
        );
    }

    @FXML
    private void generarComprobante() {

        if (matriculaActual == null) {

            mostrarAlerta(
                    "Sin matrícula",
                    "Primero registre una matrícula."
            );

            return;
        }


        try {

            var comprobante =
                    matriculaActual.generarComprobantePago();


            mostrarAlerta(
                    "Comprobante generado",
                    "Comprobante: "
                            + comprobante.getClass()
                            .getSimpleName()
                            + "\n"
                            + "Matrícula: "
                            + matriculaActual.getNumero()
                            + "\n"
                            + "Total: $"
                            + String.format(
                            "%.2f",
                            matriculaActual.calcularTotal()
                    )
            );

        } catch (Exception e) {

            mostrarAlerta(
                    "Error",
                    "No fue posible generar el comprobante:\n"
                            + e.getMessage()
            );
        }
    }

    @FXML
    private void asignarTutor() {

        if (matriculaActual == null) {

            mostrarAlerta(
                    "Sin matrícula",
                    "Primero registre una matrícula."
            );

            return;
        }


        Docente docente =
                comboDocente.getValue();

        if (docente == null) {

            mostrarAlerta(
                    "Docente faltante",
                    "Seleccione un docente."
            );

            return;
        }


        matriculaActual.asignarTutor(docente);


        mostrarAlerta(
                "Tutor asignado",
                "El docente "
                        + docente.getNombre()
                        + " fue asignado como tutor."
        );
    }


    @FXML
    private void limpiarFormulario() {

        txtNumero.clear();

        comboEstudiante.getSelectionModel()
                .clearSelection();

        comboPrograma.getSelectionModel()
                .clearSelection();

        fechaInicio.setValue(null);

        txtDescuento.clear();

        txtObservaciones.clear();

        comboServicio.getSelectionModel()
                .clearSelection();

        txtCantidadServicio.clear();

        comboDocente.getSelectionModel()
                .clearSelection();

        lblTotal.setText("$0.00");

        matriculaActual = null;
    }


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