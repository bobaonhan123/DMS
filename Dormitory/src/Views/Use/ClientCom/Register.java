package Views.Use.ClientCom;

import Controllers.Client;
import Models.Student;
import Views.ActionAlert;
import com.toedter.calendar.JDateChooser;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Register extends JFrame {
    private boolean status;
    private Client cl;
    String BuildingNow;
    public Register(Student student) {
        cl=new Client();
        setTitle("Đăng ký phòng ký túc xá");
        setSize(680,275);
        JRadioButton[] BuildingSelect=new JRadioButton[4];
        String[] BuildingName={"Dãy 1", "Dãy 2", "Dãy 3","Dãy dịch vụ"};
        JLabel[] BuildingNameLabel=new JLabel[4];
        ButtonGroup bg= new ButtonGroup();
        JPanel Content=new JPanel();
        Content.setLayout(null);
        Content.setVisible(true);
        Content.setBounds(0,0,680,275);
        setContentPane(Content);
        String[] BuildingID={"1","2","3","dv"};
        BuildingNow="1";
        for(int i=0;i<4;i++) {
            BuildingSelect[i]=new JRadioButton();
            if(i==0) {
                BuildingSelect[i].setBounds(40,50,20,20);
            }
            else {
                BuildingSelect[i].setBounds(BuildingSelect[i-1].getX()+160,BuildingSelect[i-1].getY(),20,20);
            }
            bg.add(BuildingSelect[i]);
            Content.add(BuildingSelect[i]);

            BuildingNameLabel[i]=new JLabel(BuildingName[i]);
            BuildingNameLabel[i].setBounds(BuildingSelect[i].getX()+20,BuildingSelect[i].getY(),140,20);
            Content.add(BuildingNameLabel[i]);

        }
        BuildingSelect[0].setSelected(true);
        BuildingSelect[0].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (BuildingSelect[0].isSelected())
                    BuildingNow = BuildingID[0];
            }
        });
        BuildingSelect[1].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (BuildingSelect[1].isSelected())
                    BuildingNow = BuildingID[1];
            }
        });
        BuildingSelect[2].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (BuildingSelect[2].isSelected())
                    BuildingNow = BuildingID[2];
            }
        });
        BuildingSelect[3].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (BuildingSelect[3].isSelected())
                    BuildingNow = BuildingID[3];
            }
        });
        JLabel Description = new JLabel("Nhập số phòng");
        Description.setBounds(45,100,180,30);
        Description.setForeground(Color.GRAY);
        Content.add(Description);
        JTextField RoomTF=new JTextField();
        RoomTF.setBounds(40,125,180,30);
        Content.add(RoomTF);

        JLabel DBDescription=new JLabel("Chọn ngày nhận phòng");
        DBDescription.setBounds(295,100,200,30);
        DBDescription.setForeground(Color.GRAY);
        Content.add(DBDescription);

        JDateChooser DateBeginChooser=new JDateChooser();
        DateBeginChooser.setBounds(290,125,170,30);
        DateBeginChooser.setDateFormatString("yyyy-MM-dd");
        Content.add(DateBeginChooser);

        JLabel DEDescription=new JLabel("Chọn ngày trả phòng");
        DEDescription.setBounds(480,100,300,30);
        DEDescription.setForeground(Color.GRAY);
        Content.add(DEDescription);

        JDateChooser DateEndChooser=new JDateChooser();
        DateEndChooser.setBounds(480,125,170,30);
        DateEndChooser.setDateFormatString("yyyy-MM-dd");
        Content.add(DateEndChooser);

        JButton SubmitReg=new JButton("Đăng ký");
        SubmitReg.setBounds(400,190,120,30);
        SubmitReg.setBackground(new Color(76,140,245,255));
        SubmitReg.setForeground(Color.WHITE);
        JButton Cancel=new JButton("Thoát");
        Cancel.setBounds(550,190,100,30);
        Cancel.setBackground(new Color(76,140,245,255));
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        Content.add(Cancel);
        Content.add(SubmitReg);

        SubmitReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionAlert Sure=new ActionAlert("Thông báo","Bạn có chắc chắn muốn đăng ký");
                Sure.Submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cl.register(student,BuildingNow,Integer.parseInt(RoomTF.getText()),
                                DateBeginChooser.getDate(),DateEndChooser.getDate());

                    }
                });
            }
        });
        setVisible(true);
        setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

    }

//    public static void main(String[] args) {
//        new Register(new Student());
//    }
}
