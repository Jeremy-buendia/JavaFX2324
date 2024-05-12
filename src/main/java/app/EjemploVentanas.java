package app;

import app.panels.PanelFormulario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EjemploVentanas extends Application {

	Label lblInfo;

	@Override
	public void start(Stage stage) {
		PanelFormulario panelF = new PanelFormulario();

		VBox panelVertical = new VBox();

		panelVertical.getChildren().add(panelF);

		Button btnVentanaInfo = new Button("Ventana Info");
		Button btnVentanaConf = new Button("Ventana confirmacion");
		Button btnVentanaPers1 = new Button("Ventana Personalizada interactiva");
		Button btnVentanaPers2 = new Button("Ventana Personalizada modal");

		lblInfo = new Label("Informacion");

		btnVentanaInfo.setOnAction(event -> {
			mostrarAlerta(Alert.AlertType.INFORMATION);

		});

		btnVentanaConf.setOnAction(event -> {
			mostrarAlerta(Alert.AlertType.CONFIRMATION);

		});

		btnVentanaPers1.setOnAction(e -> {
			abrirVentanaContacto();
		});

		btnVentanaPers2.setOnAction(e -> {
			abrirVentanaModal(stage);
		});

		panelVertical.setMargin(btnVentanaInfo, new Insets(5, 10, 5, 10));
		panelVertical.setMargin(lblInfo, new Insets(5, 10, 5, 10));
		panelVertical.setMargin(btnVentanaConf, new Insets(5, 10, 5, 10));
		panelVertical.setMargin(btnVentanaPers1, new Insets(5, 10, 5, 10));
		panelVertical.setMargin(btnVentanaPers2, new Insets(5, 10, 5, 10));

		// Añadimos los elementos panel Vertical
		panelVertical.getChildren().addAll(btnVentanaInfo, lblInfo, btnVentanaConf, btnVentanaPers1, btnVentanaPers2);

		// Añadimos a la escena el panel vertical
		Scene scene = new Scene(panelVertical, 600, 600);
		stage.setScene(scene);
		stage.setTitle("Formulario de Contacto");
		stage.show();
	}

	public void abrirVentanaModal(Stage stage) {
		Stage ventanaEmergente = new Stage();

		StackPane stackPane = new StackPane();

		stackPane.getChildren().add(new Label("Contenido de prueba"));

		Scene scene = new Scene(stackPane, 300, 300);

		// Bloqueamos la ventana padre definiendo cual es el padre y poner la modalidad
		ventanaEmergente.initOwner(stage);
		ventanaEmergente.initModality(Modality.WINDOW_MODAL);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Contacto");
		ventanaEmergente.show();
	}

	/**
	 * Función que abre la ventana del formulario de contacto
	 */
	public void abrirVentanaContacto() {
		Stage ventanaEmergente = new Stage();
		PanelFormulario panelForm = new PanelFormulario();

		Scene scene = new Scene(panelForm, 300, 300);

		// Añadimos un evento al boton del formulario
		panelForm.btnAceptar.setOnAction(e -> {
			this.lblInfo.setText(panelForm.txtObs.getText());
		});

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Contacto");
		ventanaEmergente.show();
	}

	// Función que muestra una ventana de alerta.
	public void mostrarAlerta(AlertType tipoAlerta) {

		if (tipoAlerta == Alert.AlertType.INFORMATION) {
			Alert infoAlert = new Alert(tipoAlerta);
			infoAlert.setTitle("Información relevante (titulo)");
			infoAlert.setHeaderText("No es un robo (encabezado)");
			infoAlert.setContentText("Dame tus leuros (contenido)");
			infoAlert.showAndWait();
		}

		if (tipoAlerta == Alert.AlertType.CONFIRMATION) {
			Alert confirmAlert = new Alert(tipoAlerta);
			confirmAlert.setTitle("Mayoría de edad (titulo)");
			confirmAlert.setHeaderText("Confirma los datos");
			confirmAlert.setContentText("¿Eres mayor de edad?");

			// Al mostrar la ventana, esta nos devuelve el tipo de boton que se ha pulsado
			ButtonType btnPulsado = confirmAlert.showAndWait().orElse(ButtonType.NO);

			if (btnPulsado == ButtonType.CANCEL) {
				this.lblInfo.setText("El usuario es menor de edad");
			} else {
				this.lblInfo.setText("El usuario es mayor de edad");
			}
		}
	}

	public static void main(String[] args) {
		launch();
	}

}
