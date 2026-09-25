package universidaddelquindio.example.parcial1progra2.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import universidaddelquindio.example.parcial1progra2.Model.Academia;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador "coordinador" de la aplicacion.
 *
 * No maneja el modelo directamente (para eso ya existen
 * ProgramaController, EstudianteController, DocenteController
 * y MatriculaController). Su unica responsabilidad es:
 *
 *  1. Mantener la Academia compartida por toda la aplicacion.
 *  2. Cargar cada vista (FXML) la primera vez que se solicita.
 *  3. Inyectar la Academia en el controlador de esa vista.
 *  4. Mostrar la vista solicitada en el panel central.
 *
 * De esta forma, ninguna vista conoce a las demas: solo
 * conocen a su propio controlador, y este a su vez solo
 * conoce a la Academia. Quien las conecta a todas es
 * AcademiaController.
 */
public class AcademiaController {

    @FXML
    private StackPane panelCentral;

    @FXML
    private Label lblNombreAcademia;

    private Academia academia;

    /**
     * Guarda cada vista ya cargada junto con su controlador,
     * para no volver a leer el FXML cada vez que el usuario
     * navega (y para no perder lo que el usuario ya escribio
     * en los formularios al cambiar de pantalla).
     */
    private final Map<String, Parent> vistasCargadas = new HashMap<>();
    private final Map<String, Object> controladoresCargados = new HashMap<>();

    /**
     * Punto de entrada: HelloApplication llama a este metodo
     * una sola vez, apenas se crea la ventana principal.
     */
    public void setAcademia(Academia academia) {

        this.academia = academia;

        if (lblNombreAcademia != null && academia != null) {
            lblNombreAcademia.setText("- " + academia.getNombreComercial());
        }

        // Vista inicial al arrancar la aplicacion.
        mostrarProgramas();
    }

    @FXML
    private void mostrarProgramas() {

        ProgramaController controlador = (ProgramaController)
                mostrarVista(
                        "programa-view.fxml",
                        "programas"
                );

        if (controlador != null) {
            controlador.setAcademia(academia);
        }
    }

    @FXML
    private void mostrarEstudiantes() {

        EstudianteController controlador = (EstudianteController)
                mostrarVista(
                        "estudiante-view.fxml",
                        "estudiantes"
                );

        if (controlador != null) {
            controlador.setAcademia(academia);
        }
    }

    @FXML
    private void mostrarDocentes() {

        DocenteController controlador = (DocenteController)
                mostrarVista(
                        "docente-view.fxml",
                        "docentes"
                );

        if (controlador != null) {
            controlador.setAcademia(academia);
        }
    }

    @FXML
    private void mostrarMatriculas() {

        MatriculaController controlador = (MatriculaController)
                mostrarVista(
                        "matricula-view.fxml",
                        "matriculas"
                );

        if (controlador != null) {
            controlador.setAcademia(academia);
        }
    }

    /**
     * Carga la vista indicada la primera vez (y la deja en cache),
     * la coloca en el panel central y devuelve su controlador para
     * que el metodo que llamo pueda hacerle setAcademia(...).
     *
     * Llamar de nuevo a setAcademia(...) cada vez que se muestra
     * la vista es intencional: es la forma en que la tabla/combos
     * de cada pantalla se refrescan con los datos mas recientes
     * (por ejemplo, si registraste un Estudiante nuevo, al entrar
     * a Matriculas su combo ya lo debe mostrar).
     */
    private Object mostrarVista(String nombreFxml, String clave) {

        try {

            Parent vista = vistasCargadas.get(clave);
            Object controlador;

            if (vista == null) {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "/universidaddelquindio/example/parcial1progra2/"
                                        + nombreFxml
                        )
                );

                vista = loader.load();
                controlador = loader.getController();

                vistasCargadas.put(clave, vista);
                controladoresCargados.put(clave, controlador);

            } else {

                controlador = controladoresCargados.get(clave);
            }

            panelCentral.getChildren().setAll(vista);

            return controlador;

        } catch (IOException e) {

            mostrarAlerta(
                    "Error al cargar la vista",
                    "No se pudo cargar " + nombreFxml + ": " + e.getMessage()
            );

            return null;
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}