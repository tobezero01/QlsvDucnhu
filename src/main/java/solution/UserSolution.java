package solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.JDBCConnection;
import entity.User;

public class UserSolution {
	private Connection conn;
    public boolean checkUser1(String username, String pass) throws SQLException {
          conn = JDBCConnection.getJDBCConnection();

          try {
        	  String sql = "SELECT userName,password FROM user WHERE userName= '"+ username +"' AND password='" + pass + "'";
        	  PreparedStatement statement =  conn.prepareStatement(sql);	          
	         	          
	          ResultSet resultSet = statement.executeQuery();
	          if (resultSet.next()) {
	              User user = new User( resultSet.getString("username"), resultSet.getString("password"));
	              if (user.getUserName().equals(username) && user.getPassword().equals(pass)) {
	                  return true;
	               }
	          }
          } catch (SQLException e) {
              e.printStackTrace();
		  }
//        if (user != null) {
//            if ("".equals(user.getUserName()) 
//                    && "".equals(user.getPassword())) {
//                return true;
//            }
//        }
        return false;
    }
    
    public boolean checkUser() {
    	try {
			if (checkUser1("ducnhuad", "ducnhu090323") ||checkUser1("trungdz", "trungmegai") ||checkUser1("tungdz", "tungtien123")) {
			    return true;
			}
		} catch (SQLException e) {		
			e.printStackTrace();
			return false;
		}return false;
    }
}
