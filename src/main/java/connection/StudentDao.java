package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import entity.Student;
import view.StudentView;
public class StudentDao {
	private StudentView stView;
	public List<Student> getAllStudent(){
		List<Student> students = new ArrayList<>();
		Object [][] Students = new Object[students.size()][11];
		Connection con = JDBCConnection.getJDBCConnection();
		
		String sql = "Select *from student";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Student student = new Student();
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setLastName(rs.getString("lastName"));
				student.setAge(rs.getInt("age"));			
				student.setGender(rs.getString("gender"));
				student.setAddress(rs.getString("address"));
				student.setPhoneNumber(rs.getString("phoneNumber"));
				student.setEmail(rs.getString("email"));
				student.setMajor(rs.getString("major"));
				student.setDate(rs.getString("date"));
				student.setGpa(rs.getDouble("gpa"));
				
				students.add(student);
				
			}
			for (int i = 0; i < students.size(); i++) {
	            Students[i][0] = students.get(i).getId();
	            Students[i][1] = students.get(i).getName();
	            Students[i][2] = students.get(i).getLastName();
	            Students[i][3] = students.get(i).getAge();
	            Students[i][4] = students.get(i).getGender();
	            Students[i][5] = students.get(i).getAddress();
	            Students[i][6] = students.get(i).getPhoneNumber();
	            Students[i][7] = students.get(i).getEmail();
	            Students[i][8] = students.get(i).getMajor();
	            Students[i][9] = students.get(i).getDate();
	            Students[i][10] = students.get(i).getGpa();
	        }
			stView.getStudentTable().setModel(new DefaultTableModel(Students, stView.getColumnNames()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}
}
