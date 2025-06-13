package ABIKO;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DatabaseHandler {

	private static DatabaseHandler handler = null;
	private static boolean initDB = false;

	private static final String DB_URL = "jdbc:mysql://localhost:3306/abiko";
	private static Connection conn = null;
	private static Statement stmt = null;

	private DatabaseHandler() {
		createConnection();
		setupMenuTable();
		setupOrderTable();
	}

	public static boolean shouldInitDB() {
		return initDB;
	}

	public static DatabaseHandler getInstance() {
		if (handler == null) {
			handler = new DatabaseHandler();
		}
		return handler;
	}

	public void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, "root", "76001870sb");
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setupMenuTable() {
		String TABLE_NAME = "MENU";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

			if (tables.next()) {
				System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
			} else {
				stmt.execute("CREATE TABLE " + TABLE_NAME + "(" + "     id VARCHAR(200) PRIMARY KEY,\n"
						+ "     name VARCHAR(200),\n" + "     price VARCHAR(200)" + ")");
				System.out.println("CREATE TABLE MENU");
				initDB = true;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage() + " - - - setupDatabase");
		} finally {

		}

	}

	public void setupOrderTable() {
		String TABLE_NAME = "ORDER_TABLE";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

			if (tables.next()) {
				System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
			} else {
				stmt.execute("CREATE TABLE " + TABLE_NAME + "("
						+ "     userID int PRIMARY KEY,\n"
						+ "     orderID VARCHAR(200),\n" + "     menuID VARCHAR(200),\n" + "     name VARCHAR(200),\n"
						+ "     price VARCHAR(200),\n" + "     count VARCHAR(200),\n"
						+ "     orderedTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n"
						+ "     FOREIGN KEY (menuID) REFERENCES MENU(id)" + ")");
				System.out.println("CREATE TABLE ORDER");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage() + " - - - setupDatabase");
		} finally {

		}
	}

	public ResultSet execQuery(String query) {
		ResultSet result;
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery(query);
		} catch (SQLException ex) {
			System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
			return null;
		} finally {

		}
		return result;
	}

	public boolean execAction(String qu) {
		try {
			stmt = conn.createStatement();
			stmt.execute(qu);
			return true;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
			return false;
		} finally {

		}
	}

}
