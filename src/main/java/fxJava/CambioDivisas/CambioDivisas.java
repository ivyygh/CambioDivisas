package fxJava.CambioDivisas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CambioDivisas extends Application {
	
	private TextField n;
	private ComboBox<Divisas> divisa1;
	private TextField ns;
	private ComboBox<Divisas> divisa2;
	private Button cambiar;
	Alert error = new Alert(AlertType.ERROR);

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Divisas euro = new Divisas("Euro", 1.0);
		Divisas libra = new Divisas("Libra", 0.8873);
		Divisas dolar = new Divisas("Dolar", 1.2007);
		Divisas yen = new Divisas("Yen", 133.59);
		
		
		n = new TextField();
		n.setPromptText("0");
		n.setMaxWidth(150);
		
		ns = new TextField();
		ns.setPromptText("0");
		ns.setMaxWidth(150);
		ns.setDisable(true);
		
		divisa1 = new ComboBox<Divisas>();
		divisa1.getItems().addAll(euro, libra, dolar, yen);
		divisa1.getSelectionModel().select(1);
		
		divisa2 = new ComboBox<Divisas>();
		divisa2.getItems().addAll(euro, libra, dolar, yen);
		divisa2.getSelectionModel().select(2);
		
		cambiar = new Button("Cambiar");
		cambiar.setDefaultButton(true);
		cambiar.setOnAction(e -> onCambiarAction());
		
		HBox primera = new HBox();
		primera.setSpacing(5);
		primera.setAlignment(Pos.CENTER);
		primera.getChildren().addAll(n, divisa1);
		
		HBox segunda = new HBox();
		segunda.setSpacing(5);
		segunda.setAlignment(Pos.CENTER);
		segunda.getChildren().addAll(ns, divisa2);
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(primera, segunda, cambiar);
		
		Scene scene = new Scene(root, 320, 200);
		primaryStage.setTitle("Cambio de divisas");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void onCambiarAction() {
		try {
			Divisas divisaEntrada = divisa1.getSelectionModel().getSelectedItem();
			Divisas divisaSalida = divisa2.getSelectionModel().getSelectedItem();
			double cantidad = Double.parseDouble(n.getText());
			Divisas.fromTo(divisaEntrada, divisaSalida,cantidad);
			ns.setText(Divisas.fromTo(divisaEntrada, divisaSalida,cantidad).toString());
			
		}catch(Exception a) {
			error.setTitle("Error.");
			error.setHeaderText("Ha habido un error.");
			error.showAndWait();
		}
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}
