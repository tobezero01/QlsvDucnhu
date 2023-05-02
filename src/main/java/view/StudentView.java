package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entity.Student;

public class StudentView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addStudentBtn;
    private JButton editStudentBtn;
    private JButton deleteStudentBtn;
    private JButton clearBtn;
    private JButton sortStudentGPABtn;
    private JButton sortStudentNameBtn;
    private JScrollPane jScrollPaneStudentTable;
    private JScrollPane jScrollPaneAddress;
    private JTable studentTable;
    
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel gpaLabel;
    
    private JLabel genderLabel;
    private JTextField gendertTextField;
	
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	
	private JLabel phoneNumberLabel;
	private JTextField phoneNumberTextField;
	
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel majorLabel;
	private JTextField majorTextField;
	private JLabel dateLabel;
	private JTextField dateTextField;
	
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea addressTA;
    private JTextField gpaField;
    
    private JButton searchBtn;
    private JTextField sField;
    // định nghĩa các cột của bảng student
    private String [] columnNames = new String [] {
            "ID", "Name","Last Name", "Age","Gender", "Address","PhoneNumber","Email","Major","CourseStart", "GPA"};
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private Object data = new Object [][] {};
    
	public StudentView() {
        initComponents();          
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        searchBtn = new JButton("SearchByLastName");
        addStudentBtn = new JButton("Add");
        editStudentBtn = new JButton("Edit");
        deleteStudentBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        sortStudentGPABtn = new JButton("Sort By GPA");
        sortStudentNameBtn = new JButton("Sort By Name");
        // khởi tạo bảng student
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();
        
        // khởi tạo các label
        sField = new JTextField(10);
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Name");
        lastNameLabel = new JLabel("Last name");
        ageLabel = new JLabel("Age");
        phoneNumberLabel = new JLabel("PhoneNumber");
        majorLabel = new JLabel("Major");
        emailLabel = new JLabel("Email");
        dateLabel = new JLabel("CourseStart");
        addressLabel = new JLabel("Address");
        gpaLabel = new JLabel("GPA");
        
        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        lastNameTextField = new JTextField(15);
        ageField = new JTextField(6);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        phoneNumberTextField = new JTextField(15);
        emailTextField = new JTextField(15);
        majorTextField = new JTextField(15);
        dateTextField = new JTextField(15);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        gpaField = new JTextField(6);
        
        genderLabel = new JLabel("Gender");
        gendertTextField= new JTextField(10);
 	    
        // cài đặt các cột và data cho bảng student
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension (850,600));
        
         // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(1200, 720);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);
        
        panel.add(addStudentBtn);
        panel.add(editStudentBtn);
        panel.add(deleteStudentBtn);
        panel.add(clearBtn);
        panel.add(sortStudentGPABtn);
        panel.add(sortStudentNameBtn);
        
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(addressLabel);
        panel.add(gpaLabel);
        panel.add(phoneNumberLabel);
        panel.add(lastNameLabel);
        panel.add(majorLabel);
        panel.add(emailLabel);
        panel.add(dateLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(jScrollPaneAddress);
        panel.add(gpaField);
        panel.add(phoneNumberTextField);
        panel.add(lastNameTextField);
        panel.add(majorTextField);
        panel.add(emailTextField);
        panel.add(dateTextField);
        
        panel.add(genderLabel);
        panel.add(gendertTextField);
        
        panel.add(searchBtn);
        panel.add(sField);
        // cài đặt vị trí các thành phần trên màn hình login      
        
        
        
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, idField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, lastNameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lastNameLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lastNameTextField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lastNameTextField, 70, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 100, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, genderLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, genderLabel, 130, SpringLayout.NORTH, panel);       
        layout.putConstraint(SpringLayout.WEST, gendertTextField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH,gendertTextField, 130, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 160, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 160, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, phoneNumberLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNumberLabel, 260, SpringLayout.NORTH, panel); 
        layout.putConstraint(SpringLayout.WEST, phoneNumberTextField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNumberTextField, 260, SpringLayout.NORTH, panel);  
                                              
        layout.putConstraint(SpringLayout.WEST, emailLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, emailLabel, 290, SpringLayout.NORTH, panel); 
        layout.putConstraint(SpringLayout.WEST, emailTextField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH,emailTextField, 290, SpringLayout.NORTH, panel); 
        
        layout.putConstraint(SpringLayout.WEST, majorLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, majorLabel, 320, SpringLayout.NORTH, panel); 
        layout.putConstraint(SpringLayout.WEST, majorTextField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH,majorTextField, 320, SpringLayout.NORTH, panel); 
        
        layout.putConstraint(SpringLayout.WEST, dateLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dateLabel, 350, SpringLayout.NORTH, panel); 
        layout.putConstraint(SpringLayout.WEST, dateTextField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH,dateTextField, 350, SpringLayout.NORTH, panel); 
        
        layout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaLabel, 380, SpringLayout.NORTH, panel); 
        layout.putConstraint(SpringLayout.WEST, gpaField, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH,gpaField, 380, SpringLayout.NORTH, panel); 
        
        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 320, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addStudentBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 500, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, editStudentBtn, 60, SpringLayout.WEST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, editStudentBtn, 500, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 60, SpringLayout.WEST, editStudentBtn);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 500, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteStudentBtn);
        
        layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, 500, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, sortStudentGPABtn, 320, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortStudentGPABtn, 630, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, sortStudentNameBtn, 145, SpringLayout.WEST, sortStudentGPABtn);
        layout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, 630, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, searchBtn, 145, SpringLayout.WEST, sortStudentNameBtn);
        layout.putConstraint(SpringLayout.NORTH, searchBtn, 630, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sField, 160, SpringLayout.WEST, searchBtn);
        layout.putConstraint(SpringLayout.NORTH, sField, 630, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Student Information");
        this.setSize(1200, 720);
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
        this.setLocationRelativeTo(null);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    /**
     * hiển thị list student vào bảng studentTable
     * 
     * @param list
     */
    public void showListStudents(List<Student> list) {
        int size = list.size(); 
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student 
        Object [][] students = new Object[size][11];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getLastName();
            students[i][3] = list.get(i).getAge();
            students[i][4] = list.get(i).getGender();
            students[i][5] = list.get(i).getAddress();
            students[i][6] = list.get(i).getPhoneNumber();
            students[i][7] = list.get(i).getEmail();
            students[i][8] = list.get(i).getMajor();
            students[i][9] = list.get(i).getDate();
            students[i][10] = list.get(i).getGpa();
        }
        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }
    
	/**
     * điền thông tin của hàng được chọn từ bảng student 
     * vào các trường tương ứng của student.
     */
    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = studentTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
            lastNameTextField.setText(studentTable.getModel().getValueAt(row, 2).toString());
            ageField.setText(studentTable.getModel().getValueAt(row, 3).toString());
            gendertTextField.setText(studentTable.getModel().getValueAt(row, 4).toString());
            addressTA.setText(studentTable.getModel().getValueAt(row, 5).toString());
            phoneNumberTextField.setText(studentTable.getModel().getValueAt(row, 6).toString());
            emailTextField.setText(studentTable.getModel().getValueAt(row, 7).toString());
            majorTextField.setText(studentTable.getModel().getValueAt(row, 8).toString());
            dateTextField.setText(studentTable.getModel().getValueAt(row, 9).toString());
            gpaField.setText(studentTable.getModel().getValueAt(row, 10).toString());
            // enable Edit and Delete buttons
            editStudentBtn.setEnabled(true);
            deleteStudentBtn.setEnabled(true);
            // disable Add button
            addStudentBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin student
     */
    public void clearStudentInfo() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        addressTA.setText("");
        gpaField.setText("");
        gendertTextField.setText("");
        phoneNumberTextField.setText("");
        majorTextField.setText("");
        emailTextField.setText("");
        dateTextField.setText("");
        lastNameTextField.setText("");
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }
    
    /**
     * hiện thị thông tin student
     * 
     * @param student
     */
    public void showStudent(Student student) {
        idField.setText("" + student.getId());
        nameField.setText(student.getName());
        lastNameTextField.setText(student.getLastName());
        ageField.setText("" + student.getAge());
        gendertTextField.setText( student.getGender());       
        addressTA.setText(student.getAddress());
        phoneNumberTextField.setText(student.getPhoneNumber());
        emailTextField.setText(student.getEmail());
        majorTextField.setText(student.getMajor());
        dateTextField.setText(student.getDate());        
        gpaField.setText("" + student.getGpa());
        // enable Edit and Delete buttons
        editStudentBtn.setEnabled(true);
        deleteStudentBtn.setEnabled(true);
        // disable Add button
        addStudentBtn.setEnabled(false);
    }
    
    /**
     * lấy thông tin student
     * 
     * @return
     */
    public Student getStudentInfo() {
//        if (!validateName() || !validateAge() || !validateAddress() ||  !validateGPA() || !validateDate() || !validatePhone() || !validateEmail()){
//            return null;
//        }
        try {
        	Student student = new Student();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                student.setId(Integer.parseInt(idField.getText()));
            }
            student.setName(nameField.getText().trim());
            student.setLastName(lastNameTextField.getText().trim());
            student.setAge(Byte.parseByte(ageField.getText().trim()));
            student.setGender(gendertTextField.getText().trim());
            student.setAddress(addressTA.getText().trim());
            student.setPhoneNumber(phoneNumberTextField.getText().trim());
            student.setEmail(emailTextField.getText().trim());
            student.setMajor(majorTextField.getText().trim());
            student.setDate(dateTextField.getText().trim());
            student.setGpa(Double.parseDouble(gpaField.getText().trim()));
            return student;
        } catch (Exception e) {
        	showMessage(e.getMessage());
		}
        return null;        
    }
    
//    private boolean validateEmail() {
//    	try {
//    		String email = emailTextField.getText().trim();
//        	String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\." + 
//                    "[a-zA-Z0-9_+&*-]+)*@" +
//                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
//                    "A-Z]{2,7}$";
//        	if(!email.matches(emailPattern)  || email == null || "".equals(email)) {
//        		emailTextField.requestFocus();
//				showMessage("gmail is not empty or not valid !");
//				return false;
//        	}
//        		
//		} catch (Exception e) {
//			emailTextField.requestFocus();
//			showMessage("Phone Number is not valid !");
//			return false;
//		}
//    	return true;
//    }
//    
//    private boolean validateDate() {
//    		String date = emailTextField.getText().trim();
//        	
//        	if( date == null || "".equals(date)) {
//        		emailTextField.requestFocus();
//				showMessage("date is not empty !");
//				return false;
//        	}
//    	return true;
//    }
//    private boolean validateName() {
//        String name = nameField.getText();
//        if (name == null || "".equals(name.trim())) {
//            nameField.requestFocus();
//            showMessage("Name is not empty.");
//            return false;
//        }
//        return true;
//    }
//    private boolean validatePhone() {
//		try {
//			String phoneNumber = phoneNumberTextField.getText();
//			if(phoneNumber == null || "".equals(phoneNumber.trim()) ) {
//				phoneNumberTextField.requestFocus();
//				showMessage("Phone Number is not empty !");
//				return false;
//			} 
//		}catch (Exception e) {
//			phoneNumberTextField.requestFocus();
//            showMessage("Phone Number is not valid!");
//            return false;
//		}
//		return true;
//    }
//    
//    private boolean validateAddress() {
//        String address = addressTA.getText();
//        if (address == null || "".equals(address.trim())) { 
//            addressTA.requestFocus();
//            showMessage("Address is not empty !.");
//            return false;
//        }
//        return true;
//    }
//    
//    private boolean validateAge() {
//        try {
//            Byte age = Byte.parseByte(ageField.getText().trim());
//            if (age < 0 || age > 100) {
//                ageField.requestFocus();
//                showMessage("Age is not valid");
//                return false;
//            }
//        } catch (Exception e) {
//            ageField.requestFocus();
//            showMessage("Age is not valid!");
//            return false;
//        }
//        return true;
//    }
////    private boolean validateGender() {
////    	String gender = gendertTextField.getText();
////    	try {
////	    	if("".equals(gender.trim()) || !"Male".equals(gender.trim()) || !"Female".equals(gender.trim())) {
////	    		gendertTextField.requestFocus();
////	    		showMessage("Gender is not empty and gender must be 'Male' or 'Female' !");
////	    		return false;
////	    	}
////    	}catch (Exception e) {
////    		gendertTextField.requestFocus();
////    		showMessage("Gender is not empty and gender must be 'Male' or 'Female' !");
////		    return false;
////    	}return true;
////    }
//    private boolean validateGPA() {
//        try {
//            Float gpa = Float.parseFloat(gpaField.getText().trim());
//            if (gpa < 0 || gpa > 4) {
//                gpaField.requestFocus();
//                showMessage("GPA is not valid!");
//                return false;
//            }
//        } catch (Exception e) {
//            gpaField.requestFocus();
//            showMessage("GPA is not valid!");
//            return false;
//        }
//        return true;
//    }
//    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    
    public void addSearchBTnListener(ActionListener listener) {
    	searchBtn.addActionListener(listener);
    }
    public void addAddStudentListener(ActionListener listener) {
        addStudentBtn.addActionListener(listener);
    }
    
    public void addEdiStudentListener(ActionListener listener) {
        editStudentBtn.addActionListener(listener);
    }
    
    public void addDeleteStudentListener(ActionListener listener) {
        deleteStudentBtn.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    
    public void addSortStudentGPAListener(ActionListener listener) {
        sortStudentGPABtn.addActionListener(listener);
    }
    
    public void addSortStudentNameListener(ActionListener listener) {
        sortStudentNameBtn.addActionListener(listener);
    }
    
    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }
    public JTable getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(JTable studentTable) {
		this.studentTable = studentTable;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public JTextField getsField() {
		return sField;
	}

	public void setsField(JTextField sField) {
		this.sField = sField;
	}

}
