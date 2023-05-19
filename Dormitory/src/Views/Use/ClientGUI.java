package Views.Use;

import Controllers.Client;
import Models.Student;
import Models.StudentIn;
import HandlingMethods.ImageHandling;
import Views.Use.ClientCom.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private Client cl;
    public ClientGUI(String Email){
        this.setSize(1200,700);
        JPanel navleft=new JPanel();
        add(navleft);
        navleft.setLayout(null);
        navleft.setBounds(0,0,300,700);
        navleft.setBackground(Color.GRAY);JPanel Content=new JPanel();
        JLabel Name=new JLabel();
        Name.setBounds(75,100,200,50);
        navleft.add(Name);
        add(Content);
        Content.setBounds(300,0,getWidth()-300,getHeight());
        Content.setBackground(Color.WHITE);
        Content.setLayout(null);
        cl=new Client();
        Student SInfo=cl.StudentInfo(Email);

        JLabel avt=new JLabel();
        StudentIn Si;
        In in;
        ImageIcon avtIcon=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Views/Icons/DefaultAvt.png")));
        Waiting waiting;
        //cl=new Client();
        JButton Change=new JButton();
        Change.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Change.setBackground(new Color(50,55,59,255));
        Change.setForeground(Color.WHITE);
        Change.setBounds(20,500,260,50);
        if(SInfo.isIn()){
            Si=cl.StudentInInfo(SInfo.getEmail());
            in=new In(Si);
            in.setVisible(true);
            Content.add(in);


        }
        else {
            if(cl.isReg(Email)) {
                waiting=new Waiting();
                waiting.setVisible(true);
                Content.add(waiting);
                Change.setText("Hủy đăng ký");
                navleft.add(Change);
                Change.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        waiting.setVisible(false);
                        SearchGUI re=new SearchGUI(SInfo);
                        re.setVisible(true);
                        Content.add(re);
                        cl=new Client();
                        cl.del(Email);
                        Change.setVisible(false);
                    }
                });
            }
            else {
                SearchGUI re=new SearchGUI(SInfo);
                re.setVisible(true);
                Content.add(re);
                JButton register=new JButton("Đăng ký phòng");
                register.setBounds(10,500,280,100);
                navleft.add(register);
                register.setBackground(Color.DARK_GRAY);
                register.setForeground(Color.WHITE);
                register.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Register RegFrame=new Register(SInfo);
                    }
                });
            }
        }

        avt.setIcon(ImageHandling.imgIconAuto(avtIcon,100,125));
        avt.setBounds(100,50,100,125);
        navleft.add(avt);
        JLabel StName=new JLabel(SInfo.getName().toUpperCase());
        StName.setBounds(50,190,200,30);
        StName.setFont(new Font("VEDANA",Font.BOLD , 20));
        StName.setForeground(Color.WHITE);
        navleft.add(StName);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2-25);
        setLayout(null);
        setVisible(true);
    }
}
