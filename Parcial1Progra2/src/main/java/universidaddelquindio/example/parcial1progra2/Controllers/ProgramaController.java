package universidaddelquindio.example.parcial1progra2.Controllers;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import universidaddelquindio.example.parcial1progra2.Model.Academia;
import universidaddelquindio.example.parcial1progra2.Model.Programa;
import universidaddelquindio.example.parcial1progra2.Model.ProgramaFactory;

public class ProgramaController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtIdioma;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtDuracionMeses;

    @FXML
    private TextField txtValorMensual;

    @FXML
    private ComboBox<ProgramaFactory.TipoPrograma> comboTipo;

    @FXML
    private TextField txtSesionesTutor;

    @FXML
    private TextField txtNivelRequerido;

    @FXML
    private TextArea txtObjetivos;

    @FXML
    private TableView<Programa> tablaProgramas;

    @FXML
    private TableColumn<Programa, String> columnaCodigo;

    @FXML
    private TableColumn<Programa, String> columnaNombre;

    @FXML
    private TableColumn<Programa, String> columnaIdioma;

    @FXML
    private TableColumn<Programa, Integer> columnaDuracion;

    @FXML
    private TableColumn<Programa, Double> columnaValorMensual;

    @FXML
    private TableColumn<Programa, String> columnaTipo;

    @FXML
    private TableColumn<Programa, String> columnaEstado;

    @FXML
    private TableColumn<Programa, Double> columnaValorFinal;

    private Academia academia;

    /**
     * Recibe la Academia que contiene los datos
     * del sistema.
     */
    public void setAcademia(Academia academia) {

        this.academia = academia;

        configurarComboTipo();
        configurarTabla();
        actualizarTabla();

        // Al comenzar, los campos exclusivos de
        // personalizado estarán desactivados.
        actualizarCamposPersonalizado();
    }

    /**
     * Configura las opciones del ComboBox.
     */
    private void configurarComboTipo() {

        comboTipo.getItems().clear();

        comboTipo.getItems().addAll(
                ProgramaFactory.TipoPrograma.BASICO,
                ProgramaFactory.TipoPrograma.INTENSIVO,
                ProgramaFactory.TipoPrograma.PERSONALIZADO
        );

        comboTipo.getSelectionModel().selectFirst();
    }

    /**
     * Configura las columnas de la tabla.
     */
    private void configurarTabla() {

        columnaCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo")
        );

        columnaNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        columnaIdioma.setCellValueFactory(
                new PropertyValueFactory<>("idioma")
        );

        columnaDuracion.setCellValueFactory(
                new PropertyValueFactory<>("duracionMeses")
        );

        columnaValorMensual.setCellValueFactory(
                new PropertyValueFactory<>("valorMensual")
        );

        columnaEstado.setCellValueFactory(
                new PropertyValueFactory<>("estado")
        );

        /*
         * Como Programa no tiene un atributo llamado "tipo",
         * calculamos el tipo dependiendo de la clase concreta.
         */
        columnaTipo.setCellValueFactory(
                celda -> {

                    Programa programa = celda.getValue();

                    String tipo;

                    if (programa instanceof universidaddelquindio.example.parcial1progra2.Model.ProgramaBasico) {

                        tipo = "Básico";

                    } else if (programa instanceof universidaddelquindio.example.parcial1progra2.Model.ProgramaIntensivo) {

                        tipo = "Intensivo";

                    } else {

                        tipo = "Personalizado";
                    }

                    return new ReadOnlyStringWrapper(tipo);
                }
        );

        /*
         * calcularValorFinal() pertenece a Programa,
         * por lo tanto podemos utilizarlo directamente.
         */
        columnaValorFinal.setCellValueFactory(
                celda -> {

                    Programa programa = celda.getValue();

                    return new javafx.beans.property.ReadOnlyObjectWrapper<>(
                            programa.calcularValorFinal()
                    );
                }
        );
    }

    /**
     * Actualiza la tabla con los programas
     * que existen actualmente en Academia.
     */
    private void actualizarTabla() {

        tablaProgramas.getItems().clear();

        if (academia != null) {

            tablaProgramas
                    .getItems()
                    .addAll(academia.getListaProgramas());
        }
    }

    /**
     * Se ejecuta cuando cambia el tipo de programa.
     */
    @FXML
    private void cambiarTipoPrograma() {

        actualizarCamposPersonalizado();
    }

    /**
     * Activa o desactiva los campos exclusivos
     * del ProgramaPersonalizado.
     */
    private void actualizarCamposPersonalizado() {

        if (comboTipo == null) {
            return;
        }

        boolean personalizado =
                comboTipo.getValue()
                        == ProgramaFactory.TipoPrograma.PERSONALIZADO;

        txtSesionesTutor.setDisable(!personalizado);
        txtNivelRequerido.setDisable(!personalizado);
        txtObjetivos.setDisable(!personalizado);
    }

    /**
     * Registra un nuevo programa.
     */
    @FXML
    private void registrarPrograma() {

        if (academia == null) {

            mostrarAlerta(
                    "Error",
                    "La Academia no ha sido inicializada."
            );

            return;
        }

        try {

            String codigo =
                    txtCodigo.getText().trim();

            String nombre =
                    txtNombre.getText().trim();

            String idioma =
                    txtIdioma.getText().trim();

            String descripcion =
                    txtDescripcion.getText().trim();

            String duracionTexto =
                    txtDuracionMeses.getText().trim();

            String valorMensualTexto =
                    txtValorMensual.getText().trim();

            ProgramaFactory.TipoPrograma tipo =
                    comboTipo.getValue();

            // Validamos los datos generales.

            if (codigo.isEmpty()
                    || nombre.isEmpty()
                    || idioma.isEmpty()
                    || descripcion.isEmpty()
                    || duracionTexto.isEmpty()
                    || valorMensualTexto.isEmpty()
                    || tipo == null) {

                mostrarAlerta(
                        "Datos incompletos",
                        "Complete todos los datos del programa."
                );

                return;
            }

            int duracionMeses =
                    Integer.parseInt(duracionTexto);

            double valorMensual =
                    Double.parseDouble(valorMensualTexto);

            if (duracionMeses <= 0) {

                mostrarAlerta(
                        "Duración inválida",
                        "La duración debe ser mayor que cero."
                );

                return;
            }

            if (valorMensual <= 0) {

                mostrarAlerta(
                        "Valor inválido",
                        "El valor mensual debe ser mayor que cero."
                );

                return;
            }

            Programa programa;

            /*
             * Si es PERSONALIZADO necesitamos
             * información adicional.
             */
            if (tipo == ProgramaFactory.TipoPrograma.PERSONALIZADO) {

                String sesionesTexto =
                        txtSesionesTutor.getText().trim();

                String nivel =
                        txtNivelRequerido.getText().trim();

                String objetivos =
                        txtObjetivos.getText().trim();

                if (sesionesTexto.isEmpty()
                        || nivel.isEmpty()
                        || objetivos.isEmpty()) {

                    mostrarAlerta(
                            "Datos incompletos",
                            "Los programas personalizados requieren "
                                    + "sesiones, nivel y objetivos."
                    );

                    return;
                }

                int sesionesTutor =
                        Integer.parseInt(sesionesTexto);

                if (sesionesTutor <= 0) {

                    mostrarAlerta(
                            "Sesiones inválidas",
                            "Las sesiones deben ser mayores que cero."
                    );

                    return;
                }

                /*
                 * Aquí utilizamos el método especial
                 * del Factory para personalizados.
                 */
                programa = ProgramaFactory.crearPersonalizado(
                        codigo,
                        nombre,
                        idioma,
                        descripcion,
                        duracionMeses,
                        valorMensual,
                        sesionesTutor,
                        nivel,
                        objetivos
                );

            } else {

                /*
                 * Para Básico e Intensivo utilizamos
                 * el método general del Factory.
                 */
                programa = ProgramaFactory.crear(
                        tipo,
                        codigo,
                        nombre,
                        idioma,
                        descripcion,
                        duracionMeses,
                        valorMensual
                );
            }

            /*
             * Finalmente enviamos el programa
             * al Modelo Academia.
             */
            academia.registrarPrograma(programa);

            actualizarTabla();

            limpiarFormulario();

            mostrarAlerta(
                    "Registro exitoso",
                    "El programa fue registrado correctamente."
            );

        } catch (NumberFormatException e) {

            mostrarAlerta(
                    "Datos inválidos",
                    "La duración, las sesiones y el valor mensual "
                            + "deben ser números válidos."
            );

        } catch (IllegalArgumentException e) {

            mostrarAlerta(
                    "Error al crear programa",
                    e.getMessage()
            );
        }
    }

    @FXML
    private void limpiarFormulario() {

        txtCodigo.clear();
        txtNombre.clear();
        txtIdioma.clear();
        txtDescripcion.clear();
        txtDuracionMeses.clear();
        txtValorMensual.clear();

        txtSesionesTutor.clear();
        txtNivelRequerido.clear();
        txtObjetivos.clear();

        comboTipo.getSelectionModel().selectFirst();

        actualizarCamposPersonalizado();
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