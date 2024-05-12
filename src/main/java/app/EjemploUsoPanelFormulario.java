package app;

import app.panels.PanelFormulario;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EjemploUsoPanelFormulario extends Application {

	@Override
	public void start(Stage stage) {

		PanelFormulario panelF = new PanelFormulario();

		Scene scene = new Scene(panelF, 600, 600);

		stage.setScene(scene);
		stage.setTitle("Formulario de Contacto");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
