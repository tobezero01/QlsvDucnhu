package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entity.Student;
import solution.StudentSolution;
import view.StudentView;

public class StudentController {
    private StudentSolution studentSolution;
    private StudentView studentView;

    public StudentController(StudentView view) {
        this.studentView = view;
        studentSolution = new StudentSolution();

        view.addAddStudentListener(new AddStudentListener());
        view.addEdiStudentListener(new EditStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addSortStudentGPAListener(new SortStudentGPAListener());
        view.addSortStudentNameListener(new SortStudentNameListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
        view.addSearchBTnListener(new SearchSTudent());
    }

    public void showStudentView() {
        List<Student> studentList = studentSolution.getListStudents();
        studentView.setVisible(true);
        studentView.showListStudents(studentList);
    }
    
    class SearchSTudent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String h = studentView.getsField().getText();
			Student student1 = studentView.getStudentInfo();
			String s = student1.getLastName();
			if(studentSolution.search(s, h)) {					
				studentView.showStudent(student1);
				studentView.showMessage("Tìm thành công!");
			}else {
				studentView.showListStudents(studentSolution.getListStudents());
				studentView.showMessage("Tìm thất bại!");
			}
		}
    	
    }
    /**
     * Lớp AddStudentListener 
     * chứa cài đặt cho sự kiện click button "Add"
     */
    
    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentSolution.add(student);
                studentView.showStudent(student);
                studentView.showListStudents(studentSolution.getListStudents());
                studentView.showMessage("Thêm thành công!");
            }
        }
    }

    /**
     * Lớp EditStudentListener 
     * chứa cài đặt cho sự kiện click button "Edit"
     */
    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();         
            if (student != null) {
                studentSolution.edit(student);
                studentView.showStudent(student);
                studentView.showListStudents(studentSolution.getListStudents());
                studentView.showMessage("Cập nhật thành công!");
            } else {
            	studentView.showMessage("Cập nhật thất bại!");
            }
        }
    }

    /**
     * Lớp DeleteStudentListener 
     * chứa cài đặt cho sự kiện click button "Delete"
     */
    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentSolution.delete(student);
                studentView.clearStudentInfo();
                studentView.showListStudents(studentSolution.getListStudents());
                studentView.showMessage("Xóa thành công!");
            }
        }
    }

    /**
     * Lớp ClearStudentListener 
     * chứa cài đặt cho sự kiện click button "Clear"
     */
    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
        }
    }

    /**
     * Lớp SortStudentGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By GPA"
     */
    class SortStudentGPAListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentSolution.sortStudentByGPA();
            studentView.showListStudents(studentSolution.getListStudents());
        }
    }

    /**
     * Lớp SortStudentGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By Name"
     */
    class SortStudentNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentSolution.sortStudentByName();
            studentView.showListStudents(studentSolution.getListStudents());
        }
    }

    /**
     * Lớp ListStudentSelectionListener 
     * chứa cài đặt cho sự kiện chọn student trong bảng student     */
    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            studentView.fillStudentFromSelectedRow();
        }
    }
}
