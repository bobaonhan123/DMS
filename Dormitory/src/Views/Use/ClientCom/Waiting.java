package Views.Use.ClientCom;

import javax.swing.*;
import java.awt.*;

public class Waiting extends JPanel {
    public Waiting() {
        setSize(900,700);
        setLayout(null);
        String YouAreIn="Đăng ký thành công, mời sinh viên";
        String Y2="đến KTX làm thủ tục trực tiếp";
        JLabel youAreIn=new JLabel(YouAreIn);
        youAreIn.setBounds(100,20,700,70);
        JLabel youAreIn2=new JLabel(Y2);
        youAreIn2.setBounds(100,55,700,70);

        youAreIn.setFont(new Font("VEDANA", Font.BOLD, 30));
        youAreIn2.setFont(new Font("VEDANA", Font.BOLD, 30));
        add(youAreIn);
        add(youAreIn2);
        setVisible(false);
    }
}
