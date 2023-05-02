package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import entity.Student;
import entity.User;

public class InsertStatement {
     public static void insertStudent(Student student) {
    	 Connection connection = JDBCConnection.getJDBCConnection();
    	 
    	 String sql = "INSERT INTO student (id, name, lastName, age, gender, address, phoneNumber, email, major, date, gpa) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
         
    	 try {
			PreparedStatement pst = connection.prepareStatement(sql);
		    
			pst.setInt(1, student.getId());
			pst.setString(2, student.getName());
			pst.setString(3, student.getLastName());
			pst.setInt(4, student.getAge());
			pst.setString(5, student.getGender());
			pst.setString(6, student.getAddress());
			pst.setString(7, student.getPhoneNumber());
			pst.setString(8, student.getEmail());
			pst.setString(9, student.getMajor());
			pst.setString(10, student.getDate());
			pst.setDouble(11, student.getGpa());
			
			pst.executeUpdate();
    	 } catch (SQLException e) {
            System.out.println("Insert fail !");
			e.printStackTrace();
		}
     }
     
     public static void insertUser(User user) {
    	 Connection connection = JDBCConnection.getJDBCConnection();
    	 
    	 String sql = "insert into user (idUser, userName, password) values (?,?,?)";
         
    	 try {
			PreparedStatement pst = connection.prepareStatement(sql);
		    
			pst.setInt(1, user.getIdUser());
			pst.setString(2,user.getUserName() );
			pst.setString(3,user.getPassword() );
				
			pst.executeUpdate();
    	 } catch (SQLException e) {
            System.out.println("Insert fail !");
			e.printStackTrace();
		}
     }
}
