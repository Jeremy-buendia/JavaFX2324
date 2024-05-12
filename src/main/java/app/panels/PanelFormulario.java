package app.panels;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PanelFormulario extends GridPane {

	// Variables Miembro de la clase serán los controles accesibles del panel
	public TextField txtEmail;
	public TextField txtTema;
	public ChoiceBox chbCat;
	public TextArea txtObs;
	public Button btnAceptar;

	/**
	 * Constructor principal de la clase, dentro vamos a ir añadiendo los elementos
	 * que queramos
	 */
	public PanelFormulario() {
		Label lblEmail = new Label("Email");
		Label lblTema = new Label("Tema");
		Label lblCat = new Label("Categoría");
		Label lblObs = new Label("Observaciones");

		// Creamos los controles
		txtEmail = new TextField();
		txtTema = new TextField();
		chbCat = new ChoiceBox();
		txtObs = new TextArea();

		// Botón
		btnAceptar = new Button("Aceptar");

		// Añadimos elementos al ChoiceBox
		chbCat.getItems().add("Perfil");
		chbCat.getItems().add("Facturación");
		chbCat.getItems().add("Otros");

		// Posicionamos los elementos en mi panel grid
		this.add(lblEmail, 0, 0);
		this.add(txtEmail, 1, 0);

		this.add(lblTema, 0, 1);
		this.add(txtTema, 1, 1);

		this.add(lblCat, 0, 2);
		this.add(chbCat, 1, 2);

		this.add(lblObs, 0, 3);
		this.add(txtObs, 1, 3, 3, 3);

		this.add(btnAceptar, 0, 6, 4, 1);

		this.setMargin(lblEmail, new Insets(5, 10, 5, 10));
		this.setMargin(lblTema, new Insets(5, 10, 5, 10));
		this.setMargin(lblCat, new Insets(5, 10, 5, 10));
		this.setMargin(lblObs, new Insets(5, 10, 5, 10));

		this.setMargin(txtEmail, new Insets(5, 10, 5, 10));
		this.setMargin(txtTema, new Insets(5, 10, 5, 10));
		this.setMargin(chbCat, new Insets(5, 10, 5, 10));
		this.setMargin(txtObs, new Insets(5, 10, 5, 10));

		this.setMargin(btnAceptar, new Insets(5, 10, 5, 10));
	}
}
