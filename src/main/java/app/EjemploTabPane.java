package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploTabPane extends Application {

	@Override
	public void start(Stage stage) {
		TabPane panelPestanas = new TabPane();

		// Creamos las pestañas
		Tab tab1 = new Tab("Formulario");
		Tab tab2 = new Tab("Image");
		Tab tab3 = new Tab("Music");
		Tab tab4 = new Tab("Nuevo");
		tab1.setClosable(false);
		tab2.setClosable(false);
		tab3.setClosable(false);
		tab4.setClosable(false);

		// Creamos las etiquetas
		Label lblForm = new Label("Aquí va el formulario");
		Label lblImg = new Label("Aquí va la imagen");
		Label lblMusic = new Label("Aquí va la musica");
		Label lblNuevo = new Label("Aquí va lo nuevo");

		// Añadimos contenido a las pestañas
		tab1.setContent(lblForm);
		tab2.setContent(lblImg);
		tab3.setContent(lblMusic);
		tab4.setContent(lblNuevo);

		// Creamos una imagen para añadirla a la segunda pestaña
		Image imagen;

		try {
			imagen = new Image(new FileInputStream("./img/imagen.png"));
			ImageView imgCaptura = new ImageView(imagen);

			// Forzamos que mantenga la relación de aspecto
			imgCaptura.setPreserveRatio(true);
			// Cambiamos ancho de la imagen
			imgCaptura.setFitWidth(200);

			tab2.setContent(imgCaptura);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// REPRODUCTOR DE VIDEO EN LA PESTAÑA 3
		Media music = new Media(new File("./sounds/musica.mp3").toURI().toString());
		MediaPlayer reproductor = new MediaPlayer(music);
		MediaView repMedios = new MediaView(reproductor);

		// Creamos un boton para ejecutar el reproductor
		Button btnPlay = new Button("Play");

		// Metemos en la pestaña el boton
		tab3.setContent(btnPlay);

		// Para que cuando se pulse se ejecute la música le ponemos un capturador de
		// eventos
		btnPlay.setOnAction(e -> reproductor.play());

		// Añadimos las tres pestañas al panel
		panelPestanas.getTabs().addAll(tab1, tab2, tab3, tab4);

		Scene scene = new Scene(panelPestanas, 800, 600);

		stage.setScene(scene);
		stage.setTitle("Ejemplo Pestañas Multimedia");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}