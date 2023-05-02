package connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
public class UserDao {
     public List<User> getAllUser() {
    	 List<User> a = new ArrayList<>();
         Connection connection = JDBCConnection.getJDBCConnection();
    	 
    	 String sql = "select * from user";
    	 
    	 try {
			
    		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
    		 ResultSet rs =  preparedStatement.executeQuery();
    		 
    		 while ( rs.next()) {
    			 User u = new User();
    			 
    			 u.setIdUser(rs.getInt("idUser"));
    			 u.setUserName(rs.getString("userName"));
    			 u.setPassword(rs.getString("password"));
    			 a.add(u);
    		 }
    	 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return a;
     }
}
