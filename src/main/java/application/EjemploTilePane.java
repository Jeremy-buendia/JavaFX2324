package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploTilePane extends Application {

	@Override
	public void start(Stage stage) {
		TilePane tilePane = new TilePane();

		ScrollPane panelScroll = new ScrollPane();

		// Añadimos 100 botones al tilePane, funciona como el float left de css
		// posicionando arriba a la izquierda todo y cuando no entra en el ancho
		// pasa a la siguiente linea
		for (int i = 0; i < 100; i++) {
			ToggleButton tglBoton = new ToggleButton("Botón " + i);
			tilePane.getChildren().add(tglBoton);

			tilePane.setMargin(tglBoton, new Insets(5, 20, 5, 20));

		}

		// Para que un panel tenga scroll hay que meterlo dentro de un ScrollPane
		panelScroll.setContent(tilePane);

		// Creamos la escena on el panel dentro
		Scene scene = new Scene(panelScroll, 600, 400);

		// Le ponemos titulo a la aplicacion
		stage.setTitle("Ejemplo tile pane con Scroll");

		// Asignamos la escena a la ventana
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch();

	}
}