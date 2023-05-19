package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Alert extends JFrame {
    public JButton button;
    public Alert(String title,String content){
        setTitle(title);
        setSize(700,200);
        JLabel label=new JLabel(content);
        label.setBounds(50,30,600,100);
        add(label);
        button = new JButton("Thoát");
        button.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                setVisible(false);
            }
        });
        button.setBounds(550,130,100,30);
        add(button);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        setLayout(null);
        setVisible(true);
    }
}
