package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploGridPane extends Application {

	@Override
	public void start(Stage stage) {
		// Creo un panel vertical, según se añaden cosas se van mostrando una encima de
		// otra
		GridPane panelGrid = new GridPane();

		// Creamos los controles
		Label lblNombre = new Label("Nombre:");
		Label lblCiudad = new Label("Ciudad:");
		Label lblSexo = new Label("Sexo:");
		Label lblObs = new Label("Observaciones: ");
		GridPane.setValignment(lblObs, javafx.geometry.VPos.TOP);

		TextField txtNombre = new TextField("Pedro");

		CheckBox cbxTerms = new CheckBox("Acepto los Terminos y Condiciones");
		ChoiceBox chbCiudades = new ChoiceBox();

		RadioButton radHombre = new RadioButton("Hombre");
		RadioButton radMujer = new RadioButton("Mujer");
		ToggleGroup tglSexo = new ToggleGroup();
		radHombre.setToggleGroup(tglSexo);
		radMujer.setToggleGroup(tglSexo);
		radHombre.setSelected(true);
		tglSexo.getSelectedToggle();

		TextArea txtObserv = new TextArea();

		DatePicker dpNacimiento = new DatePicker();

		ColorPicker cpBackground = new ColorPicker();

		FileChooser fcIcono = new FileChooser();

		Button btnBoton = new Button("Aceptar");

		chbCiudades.getItems().addAll("Cádiz", "El Pto. de Sta. Mª", "San Fernando", "Rota");
		// Utilizamos el selectionMode para marcar por defecto Cádiz
		chbCiudades.getSelectionModel().select(0);

		// Estilos
		panelGrid.setMargin(lblNombre, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(lblCiudad, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(lblSexo, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(lblObs, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(txtNombre, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(cbxTerms, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(chbCiudades, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(btnBoton, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(radHombre, new Insets(5, 0, 5, 0));
		panelGrid.setMargin(radMujer, new Insets(5, 0, 5, 70));
		panelGrid.setMargin(txtObserv, new Insets(5, 20, 5, 0));
		panelGrid.setMargin(dpNacimiento, new Insets(0, 20, 5, 20));
		panelGrid.setMargin(cpBackground, new Insets(0, 20, 5, 20));
		txtNombre.setMaxWidth(300);

		// Scene es el contenido de la ventana, cuando se crea se define su tamaño por
		// defecto
		// Cuando creamos la escena asignamos el contenido que es compatible con node
		var scene = new Scene(new StackPane(panelGrid), 800, 600);

		// Es la ventana exterior
		stage.setTitle("Mi primer panel Grid");
		stage.setScene(scene);
		stage.show();

		// Añadimos al PanelGrid los controles
		panelGrid.add(lblNombre, 0, 0);
		panelGrid.add(txtNombre, 1, 0);
		panelGrid.add(lblCiudad, 0, 1);
		panelGrid.add(chbCiudades, 1, 1);
		panelGrid.add(cbxTerms, 0, 2, 2, 1);
		panelGrid.add(lblSexo, 0, 3);
		panelGrid.add(radHombre, 1, 3);
		panelGrid.add(radMujer, 1, 3);
		panelGrid.add(lblObs, 0, 4, 1, 3);
		panelGrid.add(txtObserv, 1, 4, 2, 3);
		panelGrid.add(dpNacimiento, 0, 7);
		panelGrid.add(cpBackground, 1, 7);

		// panelGrid.getChildren().addAll(lblNombre, txtNombre, cbxTerms, chbCiudades,
		// btnBoton);
	}

	public static void main(String[] args) {
		launch();

	}

}