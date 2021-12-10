package ABIKO;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class waitController implements Initializable {

	@FXML
	private ImageView waitImage;

	private static DatabaseHandler databaseHandler;
	private static HashMap<String, Order> orderMap;
	private static ObservableMap<String, String> countMap;

	public static void lateInit() {
		if (DatabaseHandler.shouldInitDB()) {
			addMenuItemAllToDB();
		}
		setDataFromDB();
	}

	public static class Order {

		private String id;
		private String name;
		private int price;
		private int count;

		public Order(String id, String name, int price, int count) {
			this.id = id;
			this.name = name;
			this.price = price;
			this.count = count;
		}

		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getPrice() {
			return price;
		}

		public int getCount() {
			return count;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}

			if (!(obj instanceof Order)) {
				return false;
			}
			Order other = (Order) obj;
			if (((this.getId()).equals(other.getId())) && ((this.getName()).equals(other.getName()))
					&& ((this.getPrice() == this.getPrice()))) {
				return true;
			}
			return false;
		}
	}

	private static void setDataFromDB() {
		databaseHandler = DatabaseHandler.getInstance();
		String qu = "SELECT * FROM MENU";
		ResultSet rs = databaseHandler.execQuery(qu);
		System.out.println(qu);

		try {
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int price = Integer.parseInt(rs.getString("price"));
				orderMap.put(id, new Order(id, name, price, 0));
				countMap.put(id, "0");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/*
	 * DB에 메뉴id, 메뉴 이름, 가격 추가하는 메서드
	 */
	private static void addMenuItemAllToDB() {
		addMenuItemToDB("curry001", "Curry Plain", "6000");
		addMenuItemToDB("curry002", "Vegetable Curry", "7500");
		addMenuItemToDB("curry003", "Eggplant Curry", "7500");
		addMenuItemToDB("curry004", "Mushroom Curry", "8000");
		addMenuItemToDB("curry005", "Chicken Curry", "8500");
		addMenuItemToDB("curry006", "Pork Curry", "8500");
		addMenuItemToDB("curry007", "Hamburh Curry", "8500");
		addMenuItemToDB("curry008", "Beef Curry", "9500");
		addMenuItemToDB("curry009", "Shrimp Curry", "10000");
		addMenuItemToDB("curry010", "Seafood Curry", "10000");
		addMenuItemToDB("udon001", "Curry Udon Plain", "6000");
		addMenuItemToDB("udon002", "Beef Udon", "9500");
		addMenuItemToDB("udon003", "Seafood Udon", "10000");
		addMenuItemToDB("udon004", "Mushroom Udon", "8000");
		addMenuItemToDB("udon005", "Chicken Udon", "8500");
		addMenuItemToDB("udon006", "Shrimp Udon", "10000");
		addMenuItemToDB("pasta001", "Cream Curry Pasta Plain", "7000");
		addMenuItemToDB("pasta002", "Mushroom Cream Curry Pasta", "9000");
		addMenuItemToDB("pasta003", "Chicken Cream Curry Pasta", "9500");
		addMenuItemToDB("pasta004", "Hamburg Cream Curry Pasta", "8500");
		addMenuItemToDB("hayashiRice001", "Hayashirice Plain", "6500");
		addMenuItemToDB("hayashiRice002", "Mushroom Hayashirice", "7500");
		addMenuItemToDB("hayashiRice003", "Chicken Hayashirice", "9000");
		addMenuItemToDB("hayashiRice004", "Beef Hayashirice", "10500");
		addMenuItemToDB("donburry001", "Source Donburry", "8500");
		addMenuItemToDB("donburry002", "Chicken Mayonnaise Donburry", "8500");
		addMenuItemToDB("donburry003", "Beef Donburry", "8500");
		addMenuItemToDB("set001", "Pork Set", "13500");
		addMenuItemToDB("set002", "Beef Set", "13500");
		addMenuItemToDB("set003", "Chicken Set", "13500");
		addMenuItemToDB("set004", "Seafood Set", "15500");
		addMenuItemToDB("set005", "ABIKO Two Person Set A", "27000");
		addMenuItemToDB("set006", "ABIKO Two Person Set B", "27000");
		addMenuItemToDB("set007", "Kids Set", "7000");
	}

	private static void addMenuItemToDB(String id, String name, String price) {
		databaseHandler = DatabaseHandler.getInstance();

		String qu = "INSERT INTO MENU VALUES (" + "'" + id + "'," + "'" + name + "'," + "'" + price + "')";
		System.out.println(qu);
		if (databaseHandler.execAction(qu)) {
			System.out.println("OK");
		} else {
			System.out.println("FAIL");
		}
	}

	public void closeStage() {
		Stage stage = (Stage) waitImage.getScene().getWindow();
		Platform.runLater(() -> {
			stage.close();
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		databaseHandler = DatabaseHandler.getInstance();
		waitImage.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("orderView.fxml"));
					Stage stage = new Stage();
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("main.css").toString());

					stage.setScene(scene);
					stage.setTitle("ABIKO - ORDER");
					stage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}

				closeStage();
			}
		});
		lateInit();
	}
}
