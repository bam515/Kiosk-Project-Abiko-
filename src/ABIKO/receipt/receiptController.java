package ABIKO.receipt;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import ABIKO.DatabaseHandler;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class receiptController implements Initializable {

	private DatabaseHandler databaseHandler;
	private ObservableList<OrderInfo> orders;

	@FXML
	private JFXButton homeBtn;
	@FXML
	private JFXButton receiptBtn;

	@FXML
	private Label orderNum;

	public void closeStage() {
		Stage stage = (Stage) homeBtn.getScene().getWindow();
		Platform.runLater(() -> {
			stage.close();
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		databaseHandler = DatabaseHandler.getInstance();
		orders = FXCollections.observableArrayList();
		loadOrderDataFromDB();
	}

	@FXML
	public void goHome(ActionEvent event) {
		closeStage();
	}

	@FXML
	public void openReceipt(ActionEvent event) {

		try {
			Stage stage = new Stage(StageStyle.DECORATED);
			Parent root = FXMLLoader.load(getClass().getResource("receiptDialog.fxml"));
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadOrderDataFromDB() {
		String qu = "SELECT * FROM ORDER_TABLE";
		ResultSet rs = databaseHandler.execQuery(qu);
		System.out.println(qu);
		try {
			while (rs.next()) {
				int id = rs.getInt("userID");
				String orderID = rs.getString("orderID");
				String menuID = rs.getString("menuID");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int count = rs.getInt("count");
				Timestamp orderedTime = rs.getTimestamp("orderedTime");
				orders.add(new OrderInfo(id, orderID, menuID, name, price, count, orderedTime.toString()));
				System.out.println("id: " + id);
				System.out.println("orderID: " + orderID);
				System.out.println("menuID: " + menuID);
				System.out.println("name: " + name);
				System.out.println("price: " + price);
				System.out.println("count: " + count);
				System.out.println("Time: " + orderedTime.toString());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public class OrderInfo {
		private final SimpleIntegerProperty id;
		private final SimpleStringProperty orderID;
		private final SimpleStringProperty menuID;
		private final SimpleStringProperty name;
		private final SimpleIntegerProperty price;
		private final SimpleIntegerProperty count;
		private final SimpleStringProperty time;

		public OrderInfo(int id, String orderID, String menuID, String name, int price, int count, String time) {
			this.id = new SimpleIntegerProperty(id);
			this.orderID = new SimpleStringProperty(orderID);
			this.menuID = new SimpleStringProperty(menuID);
			this.name = new SimpleStringProperty(name);
			this.price = new SimpleIntegerProperty(price);
			this.count = new SimpleIntegerProperty(count);
			this.time = new SimpleStringProperty(time);
		}

		public String getMenuID() {
			return menuID.get();
		}

		public SimpleStringProperty menuIDProperty() {
			return menuID;
		}

		public int getId() {
			return id.get();
		}

		public SimpleIntegerProperty idProperty() {
			return id;
		}

		public String getOrderID() {
			return orderID.get();
		}

		public SimpleStringProperty orderIDProperty() {
			return orderID;
		}

		public String getName() {
			return name.get();
		}

		public SimpleStringProperty nameProperty() {
			return name;
		}

		public double getPrice() {
			return price.get();
		}

		public SimpleIntegerProperty priceProperty() {
			return price;
		}

		public int getCount() {
			return count.get();
		}

		public SimpleIntegerProperty countProperty() {
			return count;
		}

		public String getTime() {
			return time.get();
		}

		public SimpleStringProperty timeProperty() {
			return time;
		}
	}
}