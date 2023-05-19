package Views.Use.ClientCom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Controllers.Client;
import Models.Student;

public class SearchGUI extends JPanel {
    JTable tb;
    JScrollPane LeftPanel;
    public SearchGUI(Student student){
        Client cl=new Client();
        setSize(900,700);
        JLabel Title=new JLabel("Tra cứu phòng trống ký túc xá");
        Title.setBounds(200,20,700,70);
        Title.setFont(new Font("VEDANA", Font.BOLD, 25));
        add(Title);
        JLabel LeftLabel = new JLabel("DANH SÁCH PHÒNG TRỐNG");
        LeftLabel.setBounds(110,110,300,30);
        LeftLabel.setFont(new Font("VEDANA", Font.BOLD, 16));
        add(LeftLabel);
        LeftPanel=new JScrollPane();
        LeftPanel.setBounds(10,160,460,500);
        add(LeftPanel);
        tb=new JTable(cl.RoomList(true,true,true,true,true,true,"",student));
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
                tb=new JTable(cl.RoomList(cb[0].isSelected(),cb[1].isSelected(),cb[2].isSelected()
                        ,type[0].isSelected(),type[1].isSelected(),cb[3].isSelected(),SearchField.getText(),student));
                add(LeftPanel);
                LeftPanel.setViewportView(tb);
            }
        });
        Filter.add(SubmitFilter);
        setLayout(null);
        setVisible(false);
    }
}
