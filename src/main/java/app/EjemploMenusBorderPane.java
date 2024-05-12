package app;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploMenusBorderPane extends Application {

	@Override
	public void start(Stage stage) {

		BorderPane pnlDistribucion = new BorderPane();

		// ZONA SUPERIOR (menu)
		Label lblMenu = new Label("Menu");

		// Barra de menus principal
		MenuBar barraMenu = new MenuBar();

		// Menus que van en la barra de menus
		Menu mArchivo = new Menu("Archivo");
		Menu mOpciones = new Menu("Opciones");
		Menu mAyuda = new Menu("Ayuda");
		Menu mHerr = new Menu("Herramientas");

		// Opciones de menu que aparecen cuando seleccionamos el menu que las contiene
		MenuItem iCargar = new MenuItem("Cargar");
		MenuItem iGuardar = new MenuItem("Guardar");
		MenuItem iSalir = new MenuItem("Salir");

		MenuItem iPreferencias = new MenuItem("Preferencias");

		MenuItem iManual = new MenuItem("Manual Referencia");
		MenuItem iAcercaDe = new MenuItem("Acerca de");

		MenuItem iCopiar = new MenuItem("Copiar");
		MenuItem iPegar = new MenuItem("Pegar");

		// Insertamos los MenuItem a los Menús
		mArchivo.getItems().addAll(iCargar, iGuardar, iSalir);
		mOpciones.getItems().addAll(iPreferencias, mHerr);
		mAyuda.getItems().addAll(iManual, iAcercaDe);
		mHerr.getItems().addAll(iCopiar, iPegar);

		barraMenu.getMenus().addAll(mArchivo, mOpciones, mAyuda);

		// Zona lateral izquierda (conjunto de botones)
		VBox panelLateral = new VBox();
		Button btnCargar = new Button("Cargar");
		Button btnGuardar = new Button("Guardar");

		// Margenes y centrados
		pnlDistribucion.setTop(barraMenu);
		pnlDistribucion.setMargin(lblMenu, new Insets(10, 7, 10, 7));
		panelLateral.setMargin(btnCargar, new Insets(5, 7, 5, 7));
		panelLateral.setMargin(btnGuardar, new Insets(5, 7, 5, 7));
		pnlDistribucion.setAlignment(lblMenu, Pos.CENTER);

		// Añadimos los dos botones al panel vertical
		panelLateral.getChildren().addAll(btnCargar, btnGuardar);

		// En la zona izquierda del borderpane ponemos el Vbox con los botones
		pnlDistribucion.setLeft(panelLateral);

		// En la zona central del borderpane ponemos un textarea y un slider
		VBox panelCentral = new VBox();

		TextField txtValorNota = new TextField("40");
		txtValorNota.setMaxWidth(70);

		Slider slider = new Slider();
		slider.setMaxWidth(250);
		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(40);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(10);
		slider.setMinorTickCount(1);
		slider.setBlockIncrement(1);

		TextArea textoFich = new TextArea();

		// Añadimos el slider y el textArea al VBox
		panelCentral.getChildren().addAll(txtValorNota, slider, textoFich);

		panelLateral.setMargin(slider, new Insets(5, 7, 5, 7));
		panelLateral.setMargin(textoFich, new Insets(5, 7, 5, 7));

		// Añadimos el panelCentral al borderPane
		pnlDistribucion.setCenter(panelCentral);

		// *****GESTION DE EVENTOS*****
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				txtValorNota.setText(String.format("%.2f", new_val));
			}
		});

		// Cuando modificamos el valor en el campo, se cambia en la barra
		txtValorNota.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Le asignamos al valor del slider el numero contenido en el txtvalornota
				slider.setValue(Double.parseDouble(txtValorNota.getText()));
			}
		});

		// Cuando pulsamos en la opcion de menu salir cerramos la app
		iSalir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Cerramos la ventana principal
				stage.close();
			}
		});

		// ******************************

		Scene scene = new Scene(pnlDistribucion, 800, 600);

		stage.setScene(scene);
		stage.setTitle("Ejemplo Menú");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}