package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection() {
    	final String url = "jdbc:mysql://localhost:3306/studentmanage";
    	final String user = "root";
    	final String password = "ducnhu1234";
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return null;
     }
}
