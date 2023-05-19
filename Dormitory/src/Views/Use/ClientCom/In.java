package Views.Use.ClientCom;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Models.StudentIn;
import Controllers.Client;
import java.awt.*;
import java.util.ArrayList;

public class In extends JPanel{
    public In(StudentIn student){
        Client cl;
        setSize(900,700);
        setLayout(null);
        String YouAreIn="Bạn đang ở phòng "+student.getRoomNumber()+" "+student.getBuildingName().toLowerCase();
        JLabel youAreIn=new JLabel(YouAreIn);
        youAreIn.setBounds(100,20,700,70);
        youAreIn.setFont(new Font("VEDANA", Font.BOLD, 30));
        add(youAreIn);
        JLabel li=new JLabel("Danh sách bạn cùng phòng");
        li.setBounds(250,100,700,70);
        li.setFont(new Font("Arial", Font.BOLD, 25));

        add(li);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Email");
        model.addColumn("Tên");
        model.addColumn("Giới tính");
        model.addColumn("Trường");
        model.addRow(new Object[]{"Email","Tên","Giới tính","Trường"});
        JTable jt = new JTable(model);
        cl=new Client();
        ArrayList<StudentIn> roommates=cl.RoommateList(student.getRoomNumber(),student.getBuildingName());
        for(int i=0;i<roommates.size();i++){
            model.addRow(roommates.get(i).toObject());
        }
        JPanel sp=new JPanel();
        sp.setBounds(100,170,700,400);
        jt.setBounds(0,0,700,400);
        sp.setLayout(null);
        sp.add(jt);

        add(sp);
        setVisible(false);
    }
}
