package ABIKO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginController implements Initializable {
	
	@FXML
	private AnchorPane loginDialog;
	@FXML
	private TextField txtUserName;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Label lblStatus;
	@FXML
	private Button loginBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	public void login(ActionEvent event) throws IOException {
		if (txtUserName.getText().equals("admin") && txtPassword.getText().equals("admin")) {
			closeStage();
			lblStatus.setAccessibleText("Login Success");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("listOrder.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("listOrder.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
		} else {
			lblStatus.setText("Login Failed");
		}
	}
	
	public void closeStage() {
		Stage stage = (Stage) loginBtn.getScene().getWindow();
		Platform.runLater(() -> {
			stage.close();
		});
	}
}
