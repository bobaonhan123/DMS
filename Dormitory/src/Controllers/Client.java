package Controllers;
import Models.Student;
import DAOs.ClientDAO;
import Models.StudentIn;
import Models.Room;
import Views.Alert;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import HandlingMethods.DateHandling;

public class Client {
    public Client() {
    }
    public Student StudentInfo(String email){
        ClientDAO cl=new ClientDAO();
        return cl.StudentInfo(email);
    }
    public StudentIn StudentInInfo(String email){
        ClientDAO cl=new ClientDAO();
        return cl.StudentInInfo(email);
    }
    public boolean isReg(String email) {
        ClientDAO cl=new ClientDAO();
        return cl.isReg(email);
    }
    public ArrayList<StudentIn> RoommateList(int roomNumber, String BuildingName){
        ClientDAO cl=new ClientDAO();
        return cl.RoommateList(roomNumber,BuildingName);
    }

    public void del(String email){
        ClientDAO cl=new ClientDAO();
        cl.del(email);
    }

    public DefaultTableModel RoomList(boolean B1, boolean B2, boolean B3, boolean N4, boolean N6, boolean dv, String Number,Student student) {
        ArrayList<Boolean> BArr=new ArrayList<Boolean>();
        BArr.add(B1);
        BArr.add(B2);
        BArr.add(B3);
        BArr.add(N4);
        BArr.add(N6);
        BArr.add(dv);
        ArrayList<Room> res=new ArrayList<Room>();
        String condition="";
        String[] st={"OR Name='Dãy 1' ","OR Name='Dãy 2' ","OR(Name='Dãy 3' AND("," Type=4 "," Type=6 ",
                " OR Name='Dãy dịch vụ'"};
        for(int i=0;i<6;i++) {
            if(i==4) {
                if(N4 && N6) {
                    condition=condition+" OR ";
                }
            }
            if(i==5)
                if(B3) {
                    condition = condition + ")";
                }
            if(BArr.get(i)){
                    condition+=st[i];
                }
            if(i==4 && B3) {
                if(N4 || N6)
                    condition=condition+")";
                else
                    condition=condition+"0 )";
            }
        }

        condition=condition+")";


        if(!Number.equals("")) {
            condition= condition+" AND RoomNumber="+Number+"";
        }
        int gender=student.getGender() ? 1 : 0;
        condition= condition+" AND Gender="+gender+"";
        ClientDAO cl=new ClientDAO();
        ArrayList<Room> RList=cl.RoomList(condition);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Dãy");
        model.addColumn("Số phòng");
        model.addColumn("Giới tính");
        model.addColumn("Số người");
        model.addColumn("Số chỗ trống");
        for(int i=0;i<RList.size();i++) {
            model.addRow(RList.get(i).toObject());
        }
        return model;
    }

    public void register(Student student, String BuildingID, int RoomNumber, Date DateBegin, Date DateEnd) {

        try {
            if(DateBegin.compareTo(DateEnd)>-1 || DateEnd.compareTo(DateHandling.DateNow())<1) {
                new Alert("Lỗi","Ngày không hợp lệ");
            }
            else {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String dateBegin=formatter.format(DateBegin);
                String dateEnd=formatter.format(DateEnd);
                ClientDAO cl= new ClientDAO();
                cl.Register(student,BuildingID,RoomNumber,dateBegin,dateEnd);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
