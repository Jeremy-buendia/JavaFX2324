package application;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {
		var javaVersion = SystemInfo.javaVersion();
		var javafxVersion = SystemInfo.javafxVersion();

		// Creo un panel vertical, según se añaden cosas se van mostrando una encima de
		// otra
		VBox panelVertical = new VBox();

		// Creamos los controles
		Label lblInfo = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		Label lblNombre = new Label("Nombre:");
		TextField txtNombre = new TextField("Pedro");
		CheckBox cbxTerms = new CheckBox("Acepto los Terminos y Condiciones");
		ChoiceBox chbCiudades = new ChoiceBox();
		Button btnBoton = new Button("Aceptar");

		chbCiudades.getItems().addAll("Cádiz", "El Pto. de Sta. Mª", "San Fernando", "Rota");

		// Estilos
		panelVertical.setMargin(lblInfo, new Insets(10, 20, 10, 20));
		panelVertical.setMargin(lblNombre, new Insets(10, 20, 10, 20));
		panelVertical.setMargin(txtNombre, new Insets(10, 20, 10, 20));
		panelVertical.setMargin(cbxTerms, new Insets(10, 20, 10, 20));
		panelVertical.setMargin(chbCiudades, new Insets(10, 20, 10, 20));
		panelVertical.setMargin(btnBoton, new Insets(10, 20, 10, 20));
		txtNombre.setMaxWidth(300);

		// Scene es el contenido de la ventana, cuando se crea se define su tamaño por
		// defecto
		// Cuando creamos la escena asignamos el contenido que es compatible con node
		var scene = new Scene(new StackPane(panelVertical), 800, 600);

		// Es la ventana exterior
		stage.setTitle("Mi primera aplicacion");
		stage.setScene(scene);
		stage.show();

		// Añadimos al VBox los controles
		panelVertical.getChildren().addAll(lblInfo, lblNombre, txtNombre, cbxTerms, chbCiudades, btnBoton);
	}

	public static void main(String[] args) {
		launch();

		try {
			// Crear un documento
			Document document = new Document();

			// PDF
			FileOutputStream pdfFile = new FileOutputStream("fichero.pdf");

			// asociar el documento al OutputStream
			PdfWriter.getInstance(document, pdfFile);

			// abrir el documento
			document.open();

			// agregar un párrafo
			document.add(new Paragraph("¡Hola, mundo! Este es mi primer PDF con iText."));

			// Agreagar una imagen (reemplaza 'pingu.png' con la ruta de tu imagen)
			Image image = Image.getInstance("img/imagen.png");
			// Ajustar el tamaño de la imagen
			image.scaleToFit(200, 200);

			document.add(image);

			// Cerrar el documento
			document.close();

			System.out.println("Archivo PDF creado correctamente");
		} catch (Exception e) {

		}

	}

}