package ABIKO.receipt;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ABIKO.Controller;
import ABIKO.DatabaseHandler;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class receiptDialogController extends Controller implements Initializable {

	@FXML
	public ListView<String> receiptDialogList = myOrder;
	
	private static DatabaseHandler databaseHandler;
	private static ArrayList<Order> orderListRe = orderList;
	private ObservableList<OrderInfo> orders;
	private static ObservableMap<String, String> countMap;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		databaseHandler = DatabaseHandler.getInstance();
		orderListRe = new ArrayList<>();
		orders = FXCollections.observableArrayList();
		loadOrderDataFromDB();
		reRenderList();
	}
	
	private void reRenderList() {

		receiptDialogList.getItems().clear();
		ObservableList<String> orderData = FXCollections.observableArrayList();
		BigDecimal sum = new BigDecimal(0);
		BigDecimal price;
		BigDecimal count;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		orderData.add("MENU                  COUNT        PRICE");
		orderData.add("========================================");
		orderData.add("\t\t\t\t\t\t\t\t\t" + dtf.format(now));

		for (Order orderItem : orderListRe) {
			price = new BigDecimal(orderItem.getPrice() + "");
			count = new BigDecimal(orderItem.getCount() + "");
			orderData.add(String.format("%-22.19s %-4d %12d", orderItem.getName(), count.intValue(), price.intValue()));
			sum = sum.add(price.multiply(count));
		}

		if (orderListRe.size() > 0) {
			orderData.add("========================================");
			orderData.add("Sum: " + sum.intValue());
		}
		receiptDialogList.getItems().addAll(orderData);
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
	
	public static ObservableMap<String, String> getCountMap() {
		return countMap;
	}

	public static void setCountMap(ObservableMap<String, String> countMap) {
		countMap = Controller.countMap;
	}
	
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(ArrayList<Order> orderList) {
		orderList = Controller.orderList;
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
