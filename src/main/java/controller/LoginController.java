package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import solution.UserSolution;
import entity.User;
import view.LoginView;
import view.StudentView;

public class LoginController {
    private UserSolution userSolution;
    private LoginView loginView;
    private StudentView studentView;
    
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userSolution = new UserSolution();
        view.addLoginListener(new LoginListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    /**
     * Lớp LoginListener 
     * chứa cài đặt cho sự kiện click button "Login"
     * 
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (userSolution.checkUser()) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                studentView = new StudentView();
                StudentController studentController = new StudentController(studentView);
                studentController.showStudentView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
