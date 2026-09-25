package universidaddelquindio.example.parcial1progra2.Repositories;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import universidaddelquindio.example.parcial1progra2.Controllers.AcademiaController;
import universidaddelquindio.example.parcial1progra2.Model.Academia;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Academia academia = new Academia(
                "LinguaPlus",
                "900123456-7",
                "Calle 10 # 5-20",
                "6067491234",
                "contacto@linguaplus.com",
                "www.linguaplus.com"
        );

        FXMLLoader loader = new FXMLLoader(
                HelloApplication.class.getResource(
                        "/universidaddelquindio/example/parcial1progra2/academia-view.fxml"
                )
        );

        Scene scene = new Scene(
                loader.load(),
                1200,
                800
        );

        AcademiaController controller =
                loader.getController();

        controller.setAcademia(academia);

        stage.setTitle("LinguaPlus - Sistema de gestion");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}