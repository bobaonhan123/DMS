package Views.Use.AdminCom;

import Controllers.Admin;
import Controllers.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RoomManager extends JPanel {
    JTable tb;
    JScrollPane LeftPanel;
    private String BuildingNow;
    public RoomManager() {
        Admin ad = new Admin();
        setSize(900,700);
        JLabel Title=new JLabel("Quản lý phòng");
        Title.setBounds(200,20,700,70);
        Title.setFont(new Font("VEDANA", Font.BOLD, 25));
        add(Title);
        JLabel LeftLabel = new JLabel("DANH SÁCH PHÒNG");
        LeftLabel.setBounds(110,110,300,30);
        LeftLabel.setFont(new Font("VEDANA", Font.BOLD, 16));
        add(LeftLabel);
        LeftPanel=new JScrollPane();
        LeftPanel.setBounds(10,160,460,500);
        add(LeftPanel);
        tb=new JTable(ad.RoomList(true,true,true,true,true,true,""));
        LeftPanel.setViewportView(tb);
        JPanel LineCenter=new JPanel();
        LineCenter.setVisible(true);
        add(LineCenter);
        LineCenter.setBounds(480,100,2,550);
        LineCenter.setBackground(Color.DARK_GRAY);
        LineCenter.setLayout(null);
        JPanel Filter=new JPanel();
        Filter.setBounds(490,100,900-490,600);
        Filter.setLayout(null);
        add(Filter);
        JLabel FilterLabel = new JLabel("LỌC DANH SÁCH");
        FilterLabel.setBounds(120,10,200,30);
        FilterLabel.setFont(new Font("VEDANA", Font.BOLD, 16));
        Filter.add(FilterLabel);
        JCheckBox[] cb=new JCheckBox[4];
        String[] BuildingName={"Dãy 1","Dãy 2","Dãy 3","Dãy dịch vụ"};
        JLabel[] BuildingNameLabel=new JLabel[4];
        for(int i=0;i<4;i++){
            cb[i]=new JCheckBox();
            if(i==0){
                cb[i].setBounds(20,70,20,20);
            }
            else if(i<3) {
                cb[i].setBounds(cb[i-1].getX()+130,cb[i-1].getY(),20,20);
            }
            else{
                cb[i].setBounds(20,180,20,20);
            }
            cb[i].setSelected(true);
            Filter.add(cb[i]);
            BuildingNameLabel[i]=new JLabel(BuildingName[i]);
            BuildingNameLabel[i].setBounds(cb[i].getX()+20,cb[i].getY(),100,20);
            Filter.add(BuildingNameLabel[i]);
        }
        JCheckBox[] type=new JCheckBox[2];
        String[] RoomType={"4 người","6 người"};
        JLabel[] RoomTypeLabel=new JLabel[2];
        for(int i=0;i<2;i++){
            type[i]=new JCheckBox();
            if(i==0){
                type[i].setBounds(cb[2].getX(),cb[2].getY()+30,20,20);
            }
            else {
                type[i].setBounds(cb[2].getX(),type[i-1].getY()+30,20,20);
            }
            RoomTypeLabel[i]=new JLabel(RoomType[i]);
            RoomTypeLabel[i].setBounds(type[i].getX()+20,type[i].getY(),100,20);
            Filter.add(RoomTypeLabel[i]);
            type[i].setSelected(true);
            Filter.add(type[i]);
        }
        cb[2].addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cb[2].isSelected()){
                    for(int i=0;i<2;i++){
                        type[i].setVisible(true);
                        RoomTypeLabel[i].setVisible(true);
                    }
                }
                else {
                    for(int i=0;i<2;i++){
                        type[i].setSelected(false);
                        type[i].setVisible(false);
                        RoomTypeLabel[i].setVisible(false);
                    }
                }
            }
        });
        JLabel SearchFieldTitle=new JLabel("Nhập số phòng cần tra cứu");
        SearchFieldTitle.setBounds(20,250,200,30);
        SearchFieldTitle.setForeground(Color.GRAY);
        Filter.add(SearchFieldTitle);
        JTextField SearchField=new JTextField();
        SearchField.setBounds(20,275,370,40);
        Filter.add(SearchField);
        JButton SubmitFilter = new JButton("Tra cứu");
        SubmitFilter.setBounds(250,330,130,40);
        SubmitFilter.setBackground(new Color(76,140,245,255));
        SubmitFilter.setForeground(Color.WHITE);
        SubmitFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tb=new JTable(ad.RoomList(cb[0].isSelected(),cb[1].isSelected(),cb[2].isSelected()
                        ,type[0].isSelected(),type[1].isSelected(),cb[3].isSelected(),SearchField.getText()));
                add(LeftPanel);
                LeftPanel.setViewportView(tb);
            }
        });
        Filter.add(SubmitFilter);
        JButton Change=new JButton("Xem phòng");
        Change.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Change.setBackground(new Color(50,55,59,255));
        Change.setForeground(Color.WHITE);
        JRadioButton[] rb=new JRadioButton[4];
        ButtonGroup RoomGroup=new ButtonGroup();
        JLabel[] BuildingNameLabel2=new JLabel[4];
        for(int i=0;i<4;i++){
            rb[i]=new JRadioButton();
            if(i==0){
                rb[i].setBounds(20,400,20,20);
            }
            else if(i<3) {
                rb[i].setBounds(rb[i-1].getX()+130,rb[i-1].getY(),20,20);
            }
            else{
                rb[i].setBounds(20,450,20,20);
            }
            Filter.add(rb[i]);
            BuildingNameLabel2[i]=new JLabel(BuildingName[i]);
            BuildingNameLabel2[i].setBounds(rb[i].getX()+20,rb[i].getY(),100,20);
            Filter.add(BuildingNameLabel2[i]);
            RoomGroup.add(rb[i]);
        }
        rb[0].setSelected(true);
        String[] BuildingID={"1","2","3","dv"};
        BuildingNow="1";
        JLabel RoomNumberLabel2=new JLabel("Nhập số phòng");
        RoomNumberLabel2.setBounds(20,480,195,20);
        RoomNumberLabel2.setFont(new Font("Arial", Font.BOLD, 12));
        RoomNumberLabel2.setForeground(Color.GRAY);
        Filter.add(RoomNumberLabel2);
        JTextField RoomNumber2=new JTextField();
        RoomNumber2.setBounds(20,500,195,40);
        Filter.add(RoomNumber2);
        for(int i=0;i<4;i++) {
            int finalI = i;
            rb[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (rb[finalI].isSelected()) {
                        BuildingNow = BuildingID[finalI];
                    }
                }
            });
        }
        Change.setBounds(230,500,150,40);
        Filter.add(Change);
        Change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RoomAdminView(BuildingNow,RoomNumber2.getText());
            }
        });
        setLayout(null);
        setVisible(false);
    }
}
