import HandlingMethods.ImageHandling;
import Views.LoginGUIs.AdminLoginGUI;
import Views.LoginGUIs.ClientLoginGUI;

import javax.swing.*;
import java.awt.*;
public class Main extends JFrame {
    public Main() {
        this.setTitle("Đăng nhập");
        JPanel Content=new JPanel();
        Content.setSize(400,400);
        JPanel header=new JPanel();
        header.setBounds(0,0,400,50);
        Content.add(header);
        JLabel logo=new JLabel();
        ImageIcon logoIcon=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Views/Icons/VKUDorm.png")));
        logoIcon = ImageHandling.imgIconAuto(logoIcon,400,50);
        logo.setIcon(logoIcon);
        logo.setBounds(0,0,400,50);
        header.setLayout(null);
        header.add(logo);
        setSize(Content.getSize());
        JTabbedPane TabbedPane=new JTabbedPane();
        TabbedPane.setBounds(0,50,400,350);
        Content.add(TabbedPane);
        TabbedPane.add("Đăng nhập sinh viên",new ClientLoginGUI(Content.getWidth(),Content.getHeight()));
        TabbedPane.add("Đăng nhập hệ thống quản lý",new AdminLoginGUI(Content.getWidth(),Content.getHeight()));
//        JButton adminLogin=new JButton("Quản trị viên");
//        adminLogin.setBounds(100,100,200,50);
//        adminLogin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setContentPane(new AdminLoginGUI(Content.getWidth(),Content.getHeight()));
//            }
//        });
//        Content.add(adminLogin);
//
//        JButton clientLogin=new JButton("Sinh viên");
//        clientLogin.setBounds(100,170,200,50);
//        clientLogin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setContentPane(new ClientLoginGUI(Content.getWidth(),Content.getHeight()));
//            }
//        });
//        Content.add(clientLogin);
//
        setContentPane(Content);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();
    }
}