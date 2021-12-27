package ABIKO;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.effects.JFXDepthManager;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller implements Initializable {

	// Curry
	@FXML
	private ImageView curry001img;
	@FXML
	private ImageView curry002img;
	@FXML
	private ImageView curry003img;
	@FXML
	private ImageView curry004img;
	@FXML
	private ImageView curry005img;
	@FXML
	private ImageView curry006img;
	@FXML
	private ImageView curry007img;
	@FXML
	private ImageView curry008img;
	@FXML
	private ImageView curry009img;
	@FXML
	private ImageView curry010img;
	@FXML
	private JFXButton curry001add;
	@FXML
	private JFXButton curry002add;
	@FXML
	private JFXButton curry003add;
	@FXML
	private JFXButton curry004add;
	@FXML
	private JFXButton curry005add;
	@FXML
	private JFXButton curry006add;
	@FXML
	private JFXButton curry007add;
	@FXML
	private JFXButton curry008add;
	@FXML
	private JFXButton curry009add;
	@FXML
	private JFXButton curry010add;
	@FXML
	private Label curry001count;
	@FXML
	private Label curry002count;
	@FXML
	private Label curry003count;
	@FXML
	private Label curry004count;
	@FXML
	private Label curry005count;
	@FXML
	private Label curry006count;
	@FXML
	private Label curry007count;
	@FXML
	private Label curry008count;
	@FXML
	private Label curry009count;
	@FXML
	private Label curry010count;
	@FXML
	private JFXButton curry001remove;
	@FXML
	private JFXButton curry002remove;
	@FXML
	private JFXButton curry003remove;
	@FXML
	private JFXButton curry004remove;
	@FXML
	private JFXButton curry005remove;
	@FXML
	private JFXButton curry006remove;
	@FXML
	private JFXButton curry007remove;
	@FXML
	private JFXButton curry008remove;
	@FXML
	private JFXButton curry009remove;
	@FXML
	private JFXButton curry010remove;

	// udon
	@FXML
	private ImageView udon001img;
	@FXML
	private ImageView udon002img;
	@FXML
	private ImageView udon003img;
	@FXML
	private ImageView udon004img;
	@FXML
	private ImageView udon005img;
	@FXML
	private ImageView udon006img;
	@FXML
	private JFXButton udon001add;
	@FXML
	private JFXButton udon002add;
	@FXML
	private JFXButton udon003add;
	@FXML
	private JFXButton udon004add;
	@FXML
	private JFXButton udon005add;
	@FXML
	private JFXButton udon006add;
	@FXML
	private Label udon001count;
	@FXML
	private Label udon002count;
	@FXML
	private Label udon003count;
	@FXML
	private Label udon004count;
	@FXML
	private Label udon005count;
	@FXML
	private Label udon006count;
	@FXML
	private JFXButton udon001remove;
	@FXML
	private JFXButton udon002remove;
	@FXML
	private JFXButton udon003remove;
	@FXML
	private JFXButton udon004remove;
	@FXML
	private JFXButton udon005remove;
	@FXML
	private JFXButton udon006remove;

	// pasta
	@FXML
	private ImageView pasta001img;
	@FXML
	private ImageView pasta002img;
	@FXML
	private ImageView pasta003img;
	@FXML
	private ImageView pasta004img;
	@FXML
	private JFXButton pasta001add;
	@FXML
	private JFXButton pasta002add;
	@FXML
	private JFXButton pasta003add;
	@FXML
	private JFXButton pasta004add;
	@FXML
	private Label pasta001count;
	@FXML
	private Label pasta002count;
	@FXML
	private Label pasta003count;
	@FXML
	private Label pasta004count;
	@FXML
	private JFXButton pasta001remove;
	@FXML
	private JFXButton pasta002remove;
	@FXML
	private JFXButton pasta003remove;
	@FXML
	private JFXButton pasta004remove;

	// hayashiRice
	@FXML
	private ImageView hayashi001img;
	@FXML
	private ImageView hayashi002img;
	@FXML
	private ImageView hayashi003img;
	@FXML
	private ImageView hayashi004img;
	@FXML
	private JFXButton hayashi001add;
	@FXML
	private JFXButton hayashi002add;
	@FXML
	private JFXButton hayashi003add;
	@FXML
	private JFXButton hayashi004add;
	@FXML
	private Label hayashi001count;
	@FXML
	private Label hayashi002count;
	@FXML
	private Label hayashi003count;
	@FXML
	private Label hayashi004count;
	@FXML
	private JFXButton hayashi001remove;
	@FXML
	private JFXButton hayashi002remove;
	@FXML
	private JFXButton hayashi003remove;
	@FXML
	private JFXButton hayashi004remove;

	// donburry

	@FXML
	private ImageView donburry001img;
	@FXML
	private ImageView donburry002img;
	@FXML
	private ImageView donburry003img;
	@FXML
	private JFXButton donburry001add;
	@FXML
	private JFXButton donburry002add;
	@FXML
	private JFXButton donburry003add;
	@FXML
	private Label donburry001count;
	@FXML
	private Label donburry002count;
	@FXML
	private Label donburry003count;
	@FXML
	private JFXButton donburry001remove;
	@FXML
	private JFXButton donburry002remove;
	@FXML
	private JFXButton donburry003remove;

	// set

	@FXML
	private ImageView set001img;
	@FXML
	private ImageView set002img;
	@FXML
	private ImageView set003img;
	@FXML
	private ImageView set004img;
	@FXML
	private ImageView set005img;
	@FXML
	private ImageView set006img;
	@FXML
	private ImageView set007img;
	@FXML
	private JFXButton set001add;
	@FXML
	private JFXButton set002add;
	@FXML
	private JFXButton set003add;
	@FXML
	private JFXButton set004add;
	@FXML
	private JFXButton set005add;
	@FXML
	private JFXButton set006add;
	@FXML
	private JFXButton set007add;
	@FXML
	private Label set001count;
	@FXML
	private Label set002count;
	@FXML
	private Label set003count;
	@FXML
	private Label set004count;
	@FXML
	private Label set005count;
	@FXML
	private Label set006count;
	@FXML
	private Label set007count;
	@FXML
	private JFXButton set001remove;
	@FXML
	private JFXButton set002remove;
	@FXML
	private JFXButton set003remove;
	@FXML
	private JFXButton set004remove;
	@FXML
	private JFXButton set005remove;
	@FXML
	private JFXButton set006remove;
	@FXML
	private JFXButton set007remove;

	// tab
	@FXML
	private JFXTabPane tabContainer;
	@FXML
	private Tab curryTab;
	@FXML
	private Tab udonTab;
	@FXML
	private Tab pastaTab;
	@FXML
	private Tab hayashiTab;
	@FXML
	private Tab donburryTab;
	@FXML
	private Tab setTab;

	private double tabWidth = 100.0;
	public static int lastSelectedTabIndex = 0;

	// orderList
	@FXML
	public JFXListView<String> myOrder;

	@FXML
	private JFXButton cancelOrder;

	@FXML
	private JFXButton orderBtn;

	@FXML
	private JFXButton adminButton;

	@FXML
	private Label lblStatus;
	@FXML
	private TextField txtUserName;
	@FXML
	private PasswordField txtPassword;

	private static DatabaseHandler databaseHandler;
	public static ArrayList<Order> orderList;
	private static HashMap<String, Order> orderMap;
	public static ObservableMap<String, String> countMap;

	private Stage primaryStage;

	public Controller() {

	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private void configureView() {
		tabContainer.setTabMinWidth(tabWidth);
		tabContainer.setTabMaxWidth(tabWidth);
		tabContainer.setTabMinHeight(tabWidth);
		tabContainer.setTabMaxHeight(tabWidth);
		tabContainer.setRotateGraphic(true);

		EventHandler<Event> replaceBackgroundColorHandler = event -> {
			lastSelectedTabIndex = tabContainer.getSelectionModel().getSelectedIndex();

			Tab currentTab = (Tab) event.getTarget();
			if (currentTab.isSelected()) {
				currentTab.setStyle("-fx-background-color: -fx-focus-color;");
			} else {
				currentTab.setStyle("-fx-background-color: -fx-accent;");
			}
		};

		configureTab(curryTab, "Curry", "Order/resources/images/menu/curry/curry.png", replaceBackgroundColorHandler);
		configureTab(udonTab, "Udon", "Order/resources/images/menu/udon/udon.png", replaceBackgroundColorHandler);
		configureTab(pastaTab, "Pasta", "Order/resources/images/menu/pasta/creamCurryPasta.png",
				replaceBackgroundColorHandler);
		configureTab(hayashiTab, "HayashiRice", "Order/resources/images/menu/hayashi/hayashiRice.png",
				replaceBackgroundColorHandler);
		configureTab(donburryTab, "Donburry", "Order/resources/images/menu/donburry/donburry.png",
				replaceBackgroundColorHandler);
		configureTab(setTab, "Set", "Order/resources/images/menu/set/set.png", replaceBackgroundColorHandler);

		curryTab.setStyle("-fx-background-color: -fx-focus-color;");
	}

	private void configureTab(Tab tab, String title, String iconPath, EventHandler<Event> onSelectionChangedEvent) {
		double imageWidth = 40.0;

		ImageView imageView = new ImageView(new Image(iconPath));
		imageView.setFitHeight(imageWidth);
		imageView.setFitWidth(imageWidth);

		Label label = new Label(title);
		label.setMaxWidth(tabWidth - 20);
		label.setPadding(new Insets(20, 0, 0, 5));
		label.setStyle("-fx-text-fill: black; -fx-font-size: 8pt; -fx-font-weight: normal;");
		label.setTextAlignment(TextAlignment.CENTER);

		BorderPane tabPane = new BorderPane();
		tabPane.setRotate(90.0);
		tabPane.setMaxWidth(tabWidth);
		tabPane.setCenter(imageView);
		tabPane.setBottom(label);

		tab.setText("");
		tab.setGraphic(tabPane);
		tab.setOnSelectionChanged(onSelectionChangedEvent);
	}

	@FXML
	public void orderCancel(ActionEvent event) {
		clearOrder();
	}

	@FXML
	public void orderMenu(ActionEvent event) {

		if (orderList.size() == 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Please add items for order");
			alert.showAndWait();
			System.out.println("Please add items for order");
			return;
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(now);
		for (Order orderItem : orderList) {
			String qu = "INSERT INTO ORDER_TABLE(orderID, menuID, name, price, count, orderedTime) VALUES (" + "'"
					+ dtf.format(now) + "'," + "'" + orderItem.getId() + "'," + "'" + orderItem.getName() + "'," + "'"
					+ orderItem.getPrice() + "'," + "'" + countMap.get(orderItem.getId()) + "'," + "'" + timestamp + "'"
					+ ")";
			System.out.print(qu);
			if (databaseHandler.execAction(qu)) {
				System.out.println(" - OK");
			} else {
				System.out.println(" - FAIL");
			}
		}

		String qu = "SELECT * FROM ORDER_TABLE";
		ResultSet rs = databaseHandler.execQuery(qu);
		System.out.println(qu);
		try {
			while (rs.next()) {
				String id = rs.getString("userID");
				String orderID = rs.getString("orderID");
				String menuID = rs.getString("menuID");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String count = rs.getString("count");
				Timestamp orderedTime = rs.getTimestamp("orderedTime");
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

		clearOrder();

		try {

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primaryStage);
			dialog.setTitle("Order Complete");

			AnchorPane anchorPane = (AnchorPane) FXMLLoader.load(getClass().getResource("/ABIKO/receipt/receipt.fxml"));

			Scene scene = new Scene(anchorPane);

			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearOrder() {
		for (String key : countMap.keySet()) {
			countMap.put(key, "0");
		}
		orderList.clear();
		myOrder.getItems().clear();
	}

	public static void lateInit() {
		if (DatabaseHandler.shouldInitDB()) {
			addMenuItemAllToDB();
		}
		setDataFromDB();
	}

	@FXML
	public void loginDialog(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Stage stage = new Stage(StageStyle.DECORATED);

			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public void closeStage() {
		Stage stage = (Stage) orderBtn.getScene().getWindow();
		Platform.runLater(() -> {
			stage.close();
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		configureView();

		orderMap = new HashMap<>();
		orderList = new ArrayList<>();
		countMap = FXCollections.observableHashMap();

		// curry
		JFXDepthManager.setDepth(curry001img, 1);
		JFXDepthManager.setDepth(curry002img, 1);
		JFXDepthManager.setDepth(curry003img, 1);
		JFXDepthManager.setDepth(curry004img, 1);
		JFXDepthManager.setDepth(curry005img, 1);
		JFXDepthManager.setDepth(curry006img, 1);
		JFXDepthManager.setDepth(curry007img, 1);
		JFXDepthManager.setDepth(curry008img, 1);
		JFXDepthManager.setDepth(curry009img, 1);
		JFXDepthManager.setDepth(curry010img, 1);
		curry001add.setOnAction(e -> increaseCount("curry001"));
		curry002add.setOnAction(e -> increaseCount("curry002"));
		curry003add.setOnAction(e -> increaseCount("curry003"));
		curry004add.setOnAction(e -> increaseCount("curry004"));
		curry005add.setOnAction(e -> increaseCount("curry005"));
		curry006add.setOnAction(e -> increaseCount("curry006"));
		curry007add.setOnAction(e -> increaseCount("curry007"));
		curry008add.setOnAction(e -> increaseCount("curry008"));
		curry009add.setOnAction(e -> increaseCount("curry009"));
		curry010add.setOnAction(e -> increaseCount("curry010"));
		curry001remove.setOnAction(e -> decreaseCount("curry001"));
		curry002remove.setOnAction(e -> decreaseCount("curry002"));
		curry003remove.setOnAction(e -> decreaseCount("curry003"));
		curry004remove.setOnAction(e -> decreaseCount("curry004"));
		curry005remove.setOnAction(e -> decreaseCount("curry005"));
		curry006remove.setOnAction(e -> decreaseCount("curry006"));
		curry007remove.setOnAction(e -> decreaseCount("curry007"));
		curry008remove.setOnAction(e -> decreaseCount("curry008"));
		curry009remove.setOnAction(e -> decreaseCount("curry009"));
		curry010remove.setOnAction(e -> decreaseCount("curry010"));
		curry001count.textProperty().bind(Bindings.valueAt(countMap, "curry001"));
		curry002count.textProperty().bind(Bindings.valueAt(countMap, "curry002"));
		curry003count.textProperty().bind(Bindings.valueAt(countMap, "curry003"));
		curry004count.textProperty().bind(Bindings.valueAt(countMap, "curry004"));
		curry005count.textProperty().bind(Bindings.valueAt(countMap, "curry005"));
		curry006count.textProperty().bind(Bindings.valueAt(countMap, "curry006"));
		curry007count.textProperty().bind(Bindings.valueAt(countMap, "curry007"));
		curry008count.textProperty().bind(Bindings.valueAt(countMap, "curry008"));
		curry009count.textProperty().bind(Bindings.valueAt(countMap, "curry009"));
		curry010count.textProperty().bind(Bindings.valueAt(countMap, "curry010"));

		// udon
		JFXDepthManager.setDepth(udon001img, 1);
		JFXDepthManager.setDepth(udon002img, 1);
		JFXDepthManager.setDepth(udon003img, 1);
		JFXDepthManager.setDepth(udon004img, 1);
		JFXDepthManager.setDepth(udon005img, 1);
		JFXDepthManager.setDepth(udon006img, 1);
		udon001add.setOnAction(e -> increaseCount("udon001"));
		udon002add.setOnAction(e -> increaseCount("udon002"));
		udon003add.setOnAction(e -> increaseCount("udon003"));
		udon004add.setOnAction(e -> increaseCount("udon004"));
		udon005add.setOnAction(e -> increaseCount("udon005"));
		udon006add.setOnAction(e -> increaseCount("udon006"));
		udon001remove.setOnAction(e -> decreaseCount("udon001"));
		udon002remove.setOnAction(e -> decreaseCount("udon002"));
		udon003remove.setOnAction(e -> decreaseCount("udon003"));
		udon004remove.setOnAction(e -> decreaseCount("udon004"));
		udon005remove.setOnAction(e -> decreaseCount("udon005"));
		udon006remove.setOnAction(e -> decreaseCount("udon006"));
		udon001count.textProperty().bind(Bindings.valueAt(countMap, "udon001"));
		udon002count.textProperty().bind(Bindings.valueAt(countMap, "udon002"));
		udon003count.textProperty().bind(Bindings.valueAt(countMap, "udon003"));
		udon004count.textProperty().bind(Bindings.valueAt(countMap, "udon004"));
		udon005count.textProperty().bind(Bindings.valueAt(countMap, "udon005"));
		udon006count.textProperty().bind(Bindings.valueAt(countMap, "udon006"));

		// pasta
		JFXDepthManager.setDepth(pasta001img, 1);
		JFXDepthManager.setDepth(pasta002img, 1);
		JFXDepthManager.setDepth(pasta003img, 1);
		JFXDepthManager.setDepth(pasta004img, 1);
		pasta001add.setOnAction(e -> increaseCount("pasta001"));
		pasta002add.setOnAction(e -> increaseCount("pasta002"));
		pasta003add.setOnAction(e -> increaseCount("pasta003"));
		pasta004add.setOnAction(e -> increaseCount("pasta004"));
		pasta001remove.setOnAction(e -> decreaseCount("pasta001"));
		pasta002remove.setOnAction(e -> decreaseCount("pasta002"));
		pasta003remove.setOnAction(e -> decreaseCount("pasta003"));
		pasta004remove.setOnAction(e -> decreaseCount("pasta004"));
		pasta001count.textProperty().bind(Bindings.valueAt(countMap, "pasta001"));
		pasta002count.textProperty().bind(Bindings.valueAt(countMap, "pasta002"));
		pasta003count.textProperty().bind(Bindings.valueAt(countMap, "pasta003"));
		pasta004count.textProperty().bind(Bindings.valueAt(countMap, "pasta004"));

		// hayashiRice
		JFXDepthManager.setDepth(hayashi001img, 1);
		JFXDepthManager.setDepth(hayashi002img, 1);
		JFXDepthManager.setDepth(hayashi003img, 1);
		JFXDepthManager.setDepth(hayashi004img, 1);
		hayashi001add.setOnAction(e -> increaseCount("hayashiRice001"));
		hayashi002add.setOnAction(e -> increaseCount("hayashiRice002"));
		hayashi003add.setOnAction(e -> increaseCount("hayashiRice003"));
		hayashi004add.setOnAction(e -> increaseCount("hayashiRice004"));
		hayashi001remove.setOnAction(e -> decreaseCount("hayashiRice001"));
		hayashi002remove.setOnAction(e -> decreaseCount("hayashiRice002"));
		hayashi003remove.setOnAction(e -> decreaseCount("hayashiRice003"));
		hayashi004remove.setOnAction(e -> decreaseCount("hayashiRice004"));
		hayashi001count.textProperty().bind(Bindings.valueAt(countMap, "hayashiRice001"));
		hayashi002count.textProperty().bind(Bindings.valueAt(countMap, "hayashiRice002"));
		hayashi003count.textProperty().bind(Bindings.valueAt(countMap, "hayashiRice003"));
		hayashi004count.textProperty().bind(Bindings.valueAt(countMap, "hayashiRice004"));

		// donburry
		JFXDepthManager.setDepth(donburry001img, 1);
		JFXDepthManager.setDepth(donburry002img, 1);
		JFXDepthManager.setDepth(donburry003img, 1);
		donburry001add.setOnAction(e -> increaseCount("donburry001"));
		donburry002add.setOnAction(e -> increaseCount("donburry002"));
		donburry003add.setOnAction(e -> increaseCount("donburry003"));
		donburry001remove.setOnAction(e -> decreaseCount("donburry001"));
		donburry002remove.setOnAction(e -> decreaseCount("donburry002"));
		donburry003remove.setOnAction(e -> decreaseCount("donburry003"));
		donburry001count.textProperty().bind(Bindings.valueAt(countMap, "donburry001"));
		donburry002count.textProperty().bind(Bindings.valueAt(countMap, "donburry002"));
		donburry003count.textProperty().bind(Bindings.valueAt(countMap, "donburry003"));

		// set
		JFXDepthManager.setDepth(set001img, 1);
		JFXDepthManager.setDepth(set002img, 1);
		JFXDepthManager.setDepth(set003img, 1);
		JFXDepthManager.setDepth(set004img, 1);
		JFXDepthManager.setDepth(set005img, 1);
		JFXDepthManager.setDepth(set006img, 1);
		JFXDepthManager.setDepth(set007img, 1);
		set001add.setOnAction(e -> increaseCount("set001"));
		set002add.setOnAction(e -> increaseCount("set002"));
		set003add.setOnAction(e -> increaseCount("set003"));
		set004add.setOnAction(e -> increaseCount("set004"));
		set005add.setOnAction(e -> increaseCount("set005"));
		set006add.setOnAction(e -> increaseCount("set006"));
		set007add.setOnAction(e -> increaseCount("set007"));
		set001remove.setOnAction(e -> decreaseCount("set001"));
		set002remove.setOnAction(e -> decreaseCount("set002"));
		set003remove.setOnAction(e -> decreaseCount("set003"));
		set004remove.setOnAction(e -> decreaseCount("set004"));
		set005remove.setOnAction(e -> decreaseCount("set005"));
		set006remove.setOnAction(e -> decreaseCount("set006"));
		set007remove.setOnAction(e -> decreaseCount("set007"));
		set001count.textProperty().bind(Bindings.valueAt(countMap, "set001"));
		set002count.textProperty().bind(Bindings.valueAt(countMap, "set002"));
		set003count.textProperty().bind(Bindings.valueAt(countMap, "set003"));
		set004count.textProperty().bind(Bindings.valueAt(countMap, "set004"));
		set005count.textProperty().bind(Bindings.valueAt(countMap, "set005"));
		set006count.textProperty().bind(Bindings.valueAt(countMap, "set006"));
		set007count.textProperty().bind(Bindings.valueAt(countMap, "set007"));
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

	public void increaseCount(String id) {
		Order order = orderMap.get(id);
		int count = Integer.parseInt(countMap.get(id));

		Order newOrder = new Order(id, order.getName(), order.getPrice(), ++count);
		countMap.put(id, count + "");

		if (count == 1) {
			// new item
			orderList.add(newOrder);
		} else {
			// more than one item
			orderList.set(orderList.indexOf(order), newOrder);
		}
		reRenderList();
	}

	public void decreaseCount(String id) {
		Order order = orderMap.get(id);
		int count = Integer.parseInt(countMap.get(id));

		if (count == 0) {
			return;
		}

		Order newOrder = new Order(id, order.getName(), order.getPrice(), --count);
		countMap.put(id, count + "");

		if (count == 0) {
			orderList.remove(orderList.indexOf(order));
		} else {
			orderList.set(orderList.indexOf(order), newOrder);
		}
		reRenderList();
	}

	private void reRenderList() {

		myOrder.getItems().clear();
		ObservableList<String> orderData = FXCollections.observableArrayList();
		BigDecimal sum = new BigDecimal(0);
		BigDecimal price;
		BigDecimal count;

		orderData.add("MENU                  COUNT        PRICE");
		orderData.add("========================================");

		for (Order orderItem : orderList) {
			price = new BigDecimal(orderItem.getPrice() + "");
			count = new BigDecimal(orderItem.getCount() + "");
			orderData
					.add(String.format("%-22.19s %-4d %,11d", orderItem.getName(), count.intValue(), price.intValue()));
			sum = sum.add(price.multiply(count));
		}

		if (orderList.size() > 0) {
			orderData.add("========================================");
			orderData.add(String.format("%s %,d", "Sum :", sum.intValue()));
		}
		myOrder.getItems().addAll(orderData);
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
	 * DB�� �޴�id, �޴� �̸�, ���� �߰��ϴ� �޼���
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
}
