package DB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	//private static final String serverAddress = "jdbc:sqlserver://hildur.ucn.dk";
	private static final String serverAddress = "jdbc:sqlserver://localhost:1433";
	private static final String databaseName = ";databaseName=DMA-CSD-S223_10461236";
	//private static String userName = ";user=DMA-CSD-S223_10461236";
	private static String userName = ";user=sa";
	//private static String password = ";password=Password1!";
	private static String password = ";password=secret2023";
    
    private static String encryption = ";encrypt=false";
	private static Connection con;
	private static DatabaseMetaData dma;
	
	private static DBConnection instance = null;
	
	private DBConnection() {
		String url = serverAddress + databaseName + userName + password + encryption;	
		
		try {
			con = DriverManager.getConnection(url);
			con.setAutoCommit(true);
			dma = con.getMetaData();
			System.out.println("Connected to " + dma.getURL());
		}
		catch(Exception e) {
			System.out.println("Problems connecting to the database");
			System.out.println(e.getMessage());
		}
	}
	
	public static void closeConnection() {
		try {
			con.close();
			instance = null;
			System.out.println("Connection closed");
		}
		catch(Exception e) {
			System.out.println("Error while closing database");
			System.out.println(e.getMessage());
		}
	}
	
	public void startTransaction(){
		try {
			con.setAutoCommit(false);			
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void commitTransaction(){
		try {
			con.commit();
			con.setAutoCommit(true);			
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void rollbackTransaction(){
		try {
			con.rollback();
			con.setAutoCommit(true);			
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public Connection getDBCon() {
		return con;
	}
	
	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	

}
