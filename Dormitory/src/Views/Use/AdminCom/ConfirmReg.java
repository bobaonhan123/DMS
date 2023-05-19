package Views.Use.AdminCom;

import Controllers.Admin;
import Views.ActionAlert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmReg extends JPanel {
    JTable tb;
    Admin admin;
    public ConfirmReg() {
        admin=new Admin();
        setSize(900,700);
        setLayout(null);
        setVisible(true);
        JLabel Title=new JLabel("Duyệt đơn đăng ký");
        Title.setBounds(200,20,700,70);
        Title.setFont(new Font("VEDANA", Font.BOLD, 25));
        add(Title);

        JLabel LeftLabel = new JLabel("DANH SÁCH ĐƠN ĐĂNG KÝ");
        LeftLabel.setBounds(110,110,300,30);
        LeftLabel.setFont(new Font("VEDANA", Font.BOLD, 16));
        add(LeftLabel);
        JScrollPane LeftPanel=new JScrollPane();
        LeftPanel.setBounds(15,160,575,500);
        add(LeftPanel);
        tb=new JTable(admin.WaitingStudentsTable());
        LeftPanel.setViewportView(tb);
        JPanel LineCenter=new JPanel();
        LineCenter.setVisible(true);
        add(LineCenter);
        LineCenter.setBounds(600,100,2,550);
        LineCenter.setBackground(Color.DARK_GRAY);

        JPanel RightPanel=new JPanel();
        RightPanel.setBounds(600,100,300,600);
        RightPanel.setLayout(null);
        add(RightPanel);

        JLabel FilterLabel = new JLabel("DUYỆT DANH SÁCH");
        FilterLabel.setBounds(50,10,200,30);
        FilterLabel.setFont(new Font("VEDANA", Font.BOLD, 16));
        RightPanel.add(FilterLabel);

        JLabel EmailLabel=new JLabel("Nhập email");
        EmailLabel.setBounds(20,100,250,30);
        RightPanel.add(EmailLabel);
        EmailLabel.setForeground(Color.GRAY);
        JTextField EmailTF=new JTextField();
        RightPanel.add(EmailTF);
        EmailTF.setBounds(17,130,250,40);
        EmailTF.setVisible(true);
        JButton Submit1=new JButton("Duyệt");
        Submit1.setBounds(17,180,120,37);
        RightPanel.add(Submit1);
        Submit1.setBackground(new Color(76,140,245,255));
        Submit1.setForeground(Color.WHITE);
        Submit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionAlert alert=new ActionAlert("Xác nhận","Bạn có chắc chắn duyệt sinh viên này");
                alert.Submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        admin.RegConfirm(EmailTF.getText());
                        tb=new JTable(admin.WaitingStudentsTable());
                        LeftPanel.setViewportView(tb);
                    }
                });
            }
        });

        JButton Submit2=new JButton("Xóa");
        Submit2.setBounds(147,180,120,37);
        RightPanel.add(Submit2);
        Submit2.setBackground(new Color(76,140,245,255));
        Submit2.setForeground(Color.WHITE);
        Submit2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionAlert alert=new ActionAlert("Xác nhận","Bạn có chắc chắn xóa sinh viên này");
                alert.Submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        admin.del(EmailTF.getText());
                        tb=new JTable(admin.WaitingStudentsTable());
                        LeftPanel.setViewportView(tb);
                    }
                });
            }
        });

        JButton ComfirmAll=new JButton("Duyệt tất cả");
        ComfirmAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionAlert alert=new ActionAlert("Xác nhận","Bạn có chắc chắn duyệt tất cả");
                alert.Submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        admin.RegConfirm();
                        tb=new JTable(admin.WaitingStudentsTable());
                        LeftPanel.setViewportView(tb);
                    }
                });
            }
        });

        ComfirmAll.setBounds(17,250,250,60);
        RightPanel.add(ComfirmAll);
        ComfirmAll.setBackground(Color.BLUE);
        ComfirmAll.setForeground(Color.WHITE);

        JButton DelAll=new JButton("Xóa tất cả");
        DelAll.setBounds(17,320,250,60);
        RightPanel.add(DelAll);
        DelAll.setBackground(Color.BLUE);
        DelAll.setForeground(Color.WHITE);
        DelAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionAlert alert=new ActionAlert("Xác nhận","Bạn có chắc chắn xóa tất cả");
                alert.Submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        admin.del();
                        tb=new JTable(admin.WaitingStudentsTable());
                        LeftPanel.setViewportView(tb);
                    }
                });
            }
        });

        JButton ToCSVFile=new JButton("Xuất file danh sách");
        ToCSVFile.setBounds(17,390,250,60);
        RightPanel.add(ToCSVFile);
        ToCSVFile.setBackground(Color.BLUE);
        ToCSVFile.setForeground(Color.WHITE);
        ToCSVFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionAlert Al=new ActionAlert("Thông báo","Bạn có muốn xuất file CSV");
                Al.Submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        admin.WaitingStudentsCSV();
                    }
                });
            }
        });

    }
}
