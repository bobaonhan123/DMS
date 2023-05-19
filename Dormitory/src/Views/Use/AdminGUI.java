package Views.Use;
import Controllers.Admin;
import HandlingMethods.ImageHandling;
import Views.Use.AdminCom.ConfirmReg;
import Views.Use.AdminCom.RoomManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {
    private Admin admin;
    private int PanelNow;
    public AdminGUI(String Username){
        admin=new Admin();
        this.setSize(1200,700);
        JPanel Content=new JPanel();
        add(Content);
        Content.setBounds(300,0,getWidth()-300,getHeight());
        JPanel navleft=new JPanel();
        add(navleft);
        navleft.setLayout(null);
        JPanel SchoolPanel=new JPanel();
        SchoolPanel.setBounds(0,0,300,400);
        SchoolPanel.setBackground(new Color(238,238,228));
        SchoolPanel.setLayout(null);
        JLabel vku=new JLabel();
        JLabel StudentNum=new JLabel("SỐ LƯỢNG SINH VIÊN");
        StudentNum.setBounds(75,30,200,50);
        
        SchoolPanel.add(StudentNum);
        SchoolPanel.setBackground(new Color(192,192,192));
        ImageIcon vkuIcon=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Views/Icons/VKU.png")));

        vku.setIcon(ImageHandling.imgIconAuto(vkuIcon,100,50));
        vku.setBounds(100,100,100,50);
        SchoolPanel.add(vku);

        JLabel vkuCnt=new JLabel(admin.StudentsCnt("VKU")+" Sinh viên");
        vkuCnt.setBounds(110,160,100,30);
        SchoolPanel.add(vkuCnt);
        //admin=new Admin();
        JLabel smp=new JLabel();
        ImageIcon smpIcon=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Views/Icons/SMP.png")));

        smp.setIcon(ImageHandling.imgIconAuto(smpIcon,100,100));
        smp.setBounds(100,200,100,100);
        SchoolPanel.add(smp);
        JLabel smpCnt=new JLabel(admin.StudentsCnt("SMP")+" Sinh viên");
        smpCnt.setBounds(110,310,100,30);
        SchoolPanel.add(smpCnt);
        navleft.add(SchoolPanel);
        JPanel OptionPanel=new JPanel();
        OptionPanel.setBounds(0,400,300,260);
        GridLayout Glayout=new GridLayout(2,1);
        Glayout.setHgap(10);
        Glayout.setVgap(5);
        OptionPanel.setLayout(Glayout);
        JButton []Options=new JButton[2];
        for(int i=0;i<2;i++){
            Options[i]=new JButton();
            Options[i].setBackground(new Color(50,55,59,255));
            Options[i].setForeground(Color.WHITE);
            OptionPanel.add(Options[i]);
            Options[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
        }
        Options[0].setText("Đơn đăng ký");
        Options[1].setText("Danh sách phòng");

        JPanel ContentArr[]=new JPanel[3];
        ContentArr[0]=new ConfirmReg();
        ContentArr[1]=new RoomManager();
        PanelNow=0;
        for(int i=0;i<2;i++) {
            ContentArr[i].setVisible(false);
            Content.add(ContentArr[i]);
        }
        for(int i=0;i<2;i++) {
            int finalI = i;
            Options[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ContentArr[PanelNow].setVisible(false);
                    PanelNow= finalI;
                    ContentArr[PanelNow].setVisible(true);
                }
            });
        }
        ContentArr[0].setVisible(true);
        OptionPanel.setVisible(true);
        navleft.add(OptionPanel);
        navleft.setBounds(0,0,300,700);
        navleft.setBackground(Color.GRAY);
        Content.setBackground(Color.WHITE);
        Content.setLayout(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2-25);
        setLayout(null);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        new AdminGUI("bit0_programmer");
//    }
}
