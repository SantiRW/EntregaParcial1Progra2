module universidaddelquindio.example.parcial1progra2 {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    // CONTROLADORES
    exports universidaddelquindio.example.parcial1progra2.Controllers;
    opens universidaddelquindio.example.parcial1progra2.Controllers
            to javafx.fxml;

    // REPOSITORIES / CLASES DE ARRANQUE
    exports universidaddelquindio.example.parcial1progra2.Repositories;
    opens universidaddelquindio.example.parcial1progra2.Repositories
            to javafx.fxml;

    // MODELO
    exports universidaddelquindio.example.parcial1progra2.Model;
}