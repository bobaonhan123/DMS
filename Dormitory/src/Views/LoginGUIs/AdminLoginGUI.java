package Views.LoginGUIs;
import Controllers.Admin;
import Controllers.AdminLogin;
import Views.Use.AdminGUI;
import Views.Alert;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class AdminLoginGUI extends JPanel {
    AdminLogin al;
    public AdminLoginGUI(int Width,int Height) {

        setSize(Width,Height);
        JLabel login=new JLabel("HỆ THỐNG QUẢN LÝ");
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.setBounds(120,20,200,50);
        add(login);
        JLabel UsernameLabel=new JLabel("Tên đăng nhập ");
        UsernameLabel.setBounds(50,70,120,30);
        JTextField username=new JTextField();
        username.setBounds(50,100,300,40);
        add(UsernameLabel);
        add(username);
        UsernameLabel.setForeground(Color.GRAY);
        JLabel PasswordLabel=new JLabel("Mật khẩu ");
        PasswordLabel.setForeground(Color.GRAY);
        PasswordLabel.setBounds(50,140,100,30);
        JPasswordField password=new JPasswordField();
        password.setBounds(50,170,300,40);
        add(PasswordLabel);
        add(password);
        JButton submit=new JButton("Đăng nhập");
        submit.setBackground(new Color(76,140,245,255));
        submit.setForeground(Color.WHITE);
        submit.setBounds(50,220,300,40);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                al=new AdminLogin();
                if(al.checkLogin(username.getText(),password.getText())){
                    new AdminGUI(username.getText());
                }
                else {
                    new Alert("Lỗi","Sai tên tài khoản hoặc mật khẩu");
                }

            }
        });
        add(submit);
        setLayout(null);
    }
}
