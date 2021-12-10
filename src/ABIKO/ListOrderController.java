package ABIKO;


import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;

public class ListOrderController implements Initializable {

    private DatabaseHandler databaseHandler;
    private ObservableList<OrderInfo> orders;
    private XYChart.Series<String, Number> series;

    @FXML
    private PieChart pieChart;

    @FXML
    private JFXButton loadChart;

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private TableView<OrderInfo> orderTable;

    @FXML
    private TableColumn<OrderInfo, Integer> idCol;

    @FXML
    private TableColumn<OrderInfo, String> orderIDCol;

    @FXML
    private TableColumn<OrderInfo, String> nameCol;

    @FXML
    private TableColumn<OrderInfo, Double> priceCol;

    @FXML
    private TableColumn<OrderInfo, Integer> countCol;

    @FXML
    private TableColumn<OrderInfo, String> timeCol;

    @FXML
    void loadLineChart(ActionEvent event) {
        lineChart.getData().clear();

        BigDecimal sum[] = new BigDecimal[13];
        BigDecimal price;
        BigDecimal count;
        for (int i = 1; i <= 12; i++) {
            sum[i] = new BigDecimal("0");
            String qu =
                "SELECT price, count, orderedTime FROM ORDER_TABLE WHERE EXTRACT (MONTH FROM orderedTime) IN (" + i + ")";
            ResultSet rs = databaseHandler.execQuery(qu);
            System.out.println(qu);
            try {
                while (rs.next()) {
                    price = new BigDecimal(rs.getInt("price") + "");
                    count = new BigDecimal(rs.getInt("count") + "");
                    Timestamp orderedTime = rs.getTimestamp("orderedTime");
                    int month = orderedTime.toLocalDateTime().getMonthValue();
                    sum[month] = sum[month].add(price.multiply(count));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            series.getData().add(new XYChart.Data<>(getMonth(i), sum[i].intValue()));
        }
        series.setName("Sales by Month");
        lineChart.getData().add(series);
        loadChart.setDisable(true);
    }

    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        databaseHandler = DatabaseHandler.getInstance();
        orders = FXCollections.observableArrayList();
        series = new XYChart.Series<>();

        initCol();
        loadOrderDataFromDB();
        orderTable.getItems().addAll(orders);
        lineChart.getXAxis().setTickLabelFont(Font.font("monospace"));
        lineChart.getXAxis().setAnimated(false);
        drawPieChart();
    }

    private void initCol() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        orderIDCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        countCol.setCellValueFactory(new PropertyValueFactory<>("count"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
    }

    public void drawPieChart() {

        HashMap<String, BigDecimal> sum = new HashMap<>();
        if (orders.size() == 0) {
            return;
        }
        BigDecimal price;
        BigDecimal count;

        sum.put("curry", new BigDecimal("0"));
        sum.put("udon", new BigDecimal("0"));
        sum.put("pasta", new BigDecimal("0"));
        sum.put("hayashiRice", new BigDecimal("0"));
        sum.put("donburry", new BigDecimal("0"));
        sum.put("set", new BigDecimal("0"));
        for (OrderInfo order : orders) {
            String menuID = order.getMenuID();
            String category = menuID.substring(0, menuID.length()-3);

            switch (category) {
                case "curry":
                    price = new BigDecimal(order.getPrice() + "");
                    count = new BigDecimal(order.getCount() + "");
                    sum.put(category, new BigDecimal(sum.get(category).add(price.multiply(count)) + ""));
                    break;
                case "udon":
                    price = new BigDecimal(order.getPrice() + "");
                    count = new BigDecimal(order.getCount() + "");
                    sum.put(category, new BigDecimal(sum.get(category).add(price.multiply(count)) + ""));
                    break;
                case "pasta":
                    price = new BigDecimal(order.getPrice() + "");
                    count = new BigDecimal(order.getCount() + "");
                    sum.put(category, new BigDecimal(sum.get(category).add(price.multiply(count)) + ""));
                    break;
                case "hayashiRice":
                    price = new BigDecimal(order.getPrice() + "");
                    count = new BigDecimal(order.getCount() + "");
                    sum.put(category, new BigDecimal(sum.get(category).add(price.multiply(count)) + ""));
                    break;
                case "donburry":
                    price = new BigDecimal(order.getPrice() + "");
                    count = new BigDecimal(order.getCount() + "");
                    sum.put(category, new BigDecimal(sum.get(category).add(price.multiply(count)) + ""));
                    break;
                case "set":
                    price = new BigDecimal(order.getPrice() + "");
                    count = new BigDecimal(order.getCount() + "");
                    sum.put(category, new BigDecimal(sum.get(category).add(price.multiply(count)) + ""));
                    break;
            }
        }
        ObservableList<Data> pieChartData = FXCollections.observableArrayList();
        for (String s : sum.keySet()) {
            pieChartData.add(new PieChart.Data(s, sum.get(s).intValue()));
        }
        pieChart.setTitle("Total Sales");
        pieChart.setData(pieChartData);
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
