package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionAlert extends Alert{
    boolean submit=false;
    public JButton Submit;
    public ActionAlert(String title,String content){
        super(title,content);
        Submit=new JButton("Xác nhận");
        Submit.setBounds(430,130,100,30);
        add(Submit);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit=true;
                setVisible(false);
            }
        });
    }

    public boolean isSubmit() {
        return submit;
    }
}
