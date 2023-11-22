package Pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.DatabaseMetaData;

@SuppressWarnings("unused")
public class Con_class {
	
	Scanner sc = new Scanner(System.in);
	
	//Thread TIME = new Thread();
    private String url;
    private String user;
    private String password;

    public Con_class() {
        // Default constructor
    }

    public void WelcomeA() {
        System.out.println("Welcome to the app!");
    }

    public void Reg_Drivermysql() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public void dtb_reg(String url, String user, String password) throws SQLException, InterruptedException {
        this.url = url;
        this.user = user;
        this.password = password;

        // Test the database connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	Thread.sleep(1000);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed. Please check your connection details.");
            throw e;
        }
    }

    public void createDatabase(String databaseName) throws SQLException, InterruptedException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            System.out.println("Creating database...");
            Thread.sleep(1000);
            String sql = "CREATE DATABASE IF NOT EXISTS " + databaseName;
            statement.executeUpdate(sql);
            System.out.println("Database created successfully...\n");
        } catch (SQLException e) {
            System.out.println("Error creating database: " + e.getMessage());
            throw e;
        }
    }
    
    
    public void deleteDatabase(String databaseName) throws SQLException, InterruptedException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            System.out.println("Deleting Database database...");
            Thread.sleep(1000);
            String sql = "DROP DATABASE IF EXISTS " + databaseName;
            statement.executeUpdate(sql);
            System.out.println("Database deleted successfully...\n");
        } catch (SQLException e) {
            System.out.println("Error deleted database: " + e.getMessage());
            throw e;
        }
    }
    
    
    public void createtable(String TableName) throws SQLException {
    	try (Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement()) {
    		 System.out.println("Deleting Database database...");
             Thread.sleep(1000);
             String sql = "create table ?(? varchar(50),\r\n? varchar(50),\r\nShoes varchar(50),\r\nid int,\r\norderamt int\r\n" + TableName;
             statement.executeUpdate(sql);
             System.out.println("Database deleted successfully...\n");
         } catch (SQLException e) {
             System.out.println("Error deleted database: " + e.getMessage());
             throw e;
         } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
    		
    
    public void viewDatabases() throws SQLException {
    Connection connection = DriverManager.getConnection(url, user, password);
    	
    	 java.sql.DatabaseMetaData metaData = connection.getMetaData();

         // Get the list of databases
         ResultSet resultSet = metaData.getCatalogs();

         System.out.println("List of databases:");
         while (resultSet.next()) {
             String dbName = resultSet.getString("TABLE_CAT");
             System.out.println(dbName);
         }

         // Close the resultSet and connection
         resultSet.close();
         connection.close();
     }
    
    
    public void con(String databaseName) throws SQLException {
    	Connection connection = DriverManager.getConnection(url, user, password);
    	String selectedJdbcUrl = url + "/" + databaseName;
    	 Statement statement = connection.createStatement();
         statement.execute("USE " + databaseName);
	}
    
    public void Addtable(String tbname) throws SQLException {
    	Connection connection = DriverManager.getConnection(url, user, password);
    	System.out.println("Enter the details for each column (type 'done' when finished):");
        Statement stmt = connection.createStatement();
        StringBuilder sql = new StringBuilder("CREATE TABLE " + tbname + "(");
        while (true) {
            System.out.print("Enter column name (or 'done' to finish): ");
            String columnName = sc.nextLine();
            if (columnName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter data type for " + columnName + ": ");
            String dataType = sc.nextLine();
            sql.append(columnName).append(" ").append(dataType).append(", ");
        }
        sql.setLength(sql.length() - 2);
        sql.append(", PRIMARY KEY (id))");
        stmt.executeUpdate(sql.toString());
        System.out.println("Created table in the given database...");
        stmt.close();
        connection.close();
        sc.close();
}





}



