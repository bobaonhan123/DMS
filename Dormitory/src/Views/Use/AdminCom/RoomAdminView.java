package Views.Use.AdminCom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controllers.Admin;
import Views.ActionAlert;

public class RoomAdminView extends JFrame {
    Admin admin;
    JTable tb;
    public RoomAdminView(String BuildingID,String RoomNumber) {
        admin=new Admin();
        setSize(1000,540);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2-25);
        setLayout(null);
        setVisible(true);
        JPanel MemberListPanel = new JPanel();
        MemberListPanel.setLayout(null);
        MemberListPanel.setBounds(0,0,600,500);
        add(MemberListPanel);
        JLabel MemberListTitle=new JLabel("Danh sách thành viên");
        MemberListTitle.setBounds(170,20,400,50);
        MemberListTitle.setFont(new Font("Arial",Font.PLAIN,20));
        MemberListPanel.add(MemberListTitle);

        JScrollPane RoommatePane=new JScrollPane();

        tb=new JTable(admin.RoomateTable(BuildingID,RoomNumber));
        RoommatePane.setBounds(20,80,560,460);
        MemberListPanel.add(RoommatePane);
        RoommatePane.setViewportView(tb);
        JPanel LineCenter=new JPanel();
        LineCenter.setVisible(true);
        add(LineCenter);
        LineCenter.setBounds(600,20,2,470);
        LineCenter.setBackground(Color.DARK_GRAY);
        LineCenter.setLayout(null);

        JPanel RightPanel = new JPanel();
        RightPanel.setLayout(null);
        RightPanel.setBounds(600,0,390,500);
        add(RightPanel);
        JLabel EmailLabel=new JLabel("Nhập email");
        EmailLabel.setBounds(30,100,300,30);
        RightPanel.add(EmailLabel);
        EmailLabel.setForeground(Color.GRAY);
        JTextField EmailTF=new JTextField();
        RightPanel.add(EmailTF);
        EmailTF.setBounds(27,130,320,40);
        EmailTF.setVisible(true);
        JButton Submit=new JButton("Mời khỏi ktx");
        Submit.setBounds(227,180,119,37);
        RightPanel.add(Submit);
        Submit.setBackground(new Color(76,140,245,255));
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionAlert Sure=new ActionAlert("Cảnh báo","Bạn có chắc chắn muốn mời sinh viên này ra khỏi ktx");
                Sure.Submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        admin.del(EmailTF.getText());
                        tb=new JTable(admin.RoomateTable(BuildingID,RoomNumber));
                        RoommatePane.setViewportView(tb);
                    }
                });

            }
        });


    }

//    public static void main(String[] args) {
//        new RoomAdminView("dv","201");
//    }
}
