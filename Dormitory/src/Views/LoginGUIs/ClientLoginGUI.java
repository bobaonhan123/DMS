package Views.LoginGUIs;
import Controllers.AdminLogin;
import Controllers.ClientLogin;
import Views.Alert;
import Views.Use.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientLoginGUI extends JPanel {
    ClientLogin cl;
    public ClientLoginGUI(int Width,int Height) {

        setSize(Width,Height);
        JLabel login=new JLabel("HỆ THỐNG ĐĂNG KÝ");
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.setBounds(120,20,200,50);
        add(login);
        JLabel UsernameLabel=new JLabel("EMAIL");
        UsernameLabel.setBounds(50,70,120,30);
        JTextField username=new JTextField();
        username.setBounds(50,100,300,40);
//        username.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        username.setBackground(Color.GRAY);
        add(UsernameLabel);
        add(username);
        UsernameLabel.setForeground(Color.GRAY);
        JLabel PasswordLabel=new JLabel("MẬT KHẨU");
        PasswordLabel.setForeground(Color.GRAY);
        PasswordLabel.setBounds(50,140,100,30);
        JPasswordField password=new JPasswordField();
        //username.setBackground(Color.RED);
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
                cl=new ClientLogin();
                if(cl.checkLogin(username.getText(),password.getText())){
                    new ClientGUI(username.getText());
                }
                else {
                    new Alert("Lỗi","Sai email hoặc mật khẩu");
                }
            }
        });
        setBackground(Color.WHITE);
        setVisible(true);
        add(submit);
        setLayout(null);
    }

}
