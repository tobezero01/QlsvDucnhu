package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.Student;
import entity.StudentXML;
import utils.FileUtils;
import view.StudentView;
/**
 * StudentSolution class
 * 
 * @author duc
 */

public class StudentSolution {
    private static final String STUDENT_FILE_NAME = "student.xml";
    private List<Student> listStudents;

    public StudentSolution() {
        this.listStudents = readListStudents();
        if (listStudents == null) {
            listStudents = new ArrayList<Student>();
        }
    }

    /**
     * Lưu các đối tượng student vào file student.xml
     * 
     * @param students
     */
    public void writeListStudents(List<Student> students) {
        StudentXML studentXML = new StudentXML();
        studentXML.setStudent(students);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, studentXML);
    }

    /**
     * Đọc các đối tượng student từ file student.xml
     * 
     * @return list student
     */
    public List<Student> readListStudents() {
        List<Student> list = new ArrayList<Student>();
        StudentXML studentXML = (StudentXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, StudentXML.class);
        if (studentXML != null) {
            list = studentXML.getStudent();
        }
        return list;
    }
    

    /**
     * thêm student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public boolean search(String s, String h) {	
    	if(h.equalsIgnoreCase(s)) {
    		return true;
    	}
    	return false;
    }
    
    
    public void add(Student student) {
        int id = 1;
        if (listStudents != null && listStudents.size() > 0) {
            id = listStudents.size() + 1;
        }
        student.setId(id);
        listStudents.add(student);
        writeListStudents(listStudents);
    }
    
    
    /**
     * cập nhật student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public void edit(Student student) {
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                listStudents.get(i).setName(student.getName());
                listStudents.get(i).setLastName(student.getLastName());
                listStudents.get(i).setAge(student.getAge());
                listStudents.get(i).setGender(student.getGender());
                listStudents.get(i).setAddress(student.getAddress());
                listStudents.get(i).setPhoneNumber(student.getPhoneNumber());
                listStudents.get(i).setEmail(student.getEmail());
                listStudents.get(i).setMajor(student.getMajor());
                listStudents.get(i).setDate(student.getDate());
                listStudents.get(i).setGpa(student.getGpa());
                writeListStudents(listStudents);
                break;
            }
        }
    }

    /**
     * xóa student từ listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public boolean delete(Student student) {
        boolean isFound = false;
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                student = listStudents.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listStudents.remove(student);
            writeListStudents(listStudents);
            return true;
        }
        return false;
    }


    public void sortStudentByName() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getLastName().compareTo(student2.getLastName());
            }
        });
    }

    public void sortStudentByGPA() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                if (student1.getGpa() > student2.getGpa()) {
                    return 1;
                }
                return -1;
            }
        });
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

}