package Controllers;
import DAOs.AdminDAO;
import Models.Room;
import Models.StudentIn;
import Models.WaitingStudent;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import HandlingMethods.DateHandling;
public class Admin {
    AdminDAO ad;
    public Admin() {

    }

    public int StudentsCnt(String School){
        ad=new AdminDAO();
        return ad.StudentsNum(School);
    }

    public DefaultTableModel RoomList(boolean B1, boolean B2, boolean B3, boolean N4, boolean N6, boolean dv, String Number) {
        ad=new AdminDAO();
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

        AdminDAO ad=new AdminDAO();
        ArrayList<Room> RList=ad.RoomList(condition);
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

    public DefaultTableModel RoomateTable(String BuildingName,String RoomNumber) {
        ad=new AdminDAO();
        ArrayList<StudentIn> StudentsList=ad.RoommateList(RoomNumber,BuildingName);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Email");
        model.addColumn("Tên");
        model.addColumn("Giới tính");
        model.addColumn("Trường");
        for(int i=0;i<StudentsList.size();i++) {
            model.addRow(StudentsList.get(i).toObject());
        }
        return model;
    }

    public void del(String email){
        AdminDAO cl= new AdminDAO();
        cl.del("StudentEmail='"+email+"'");
    }

    public void del() {
        ad=new AdminDAO();
        ad.del("1");
    }

    public DefaultTableModel WaitingStudentsTable() {
        ad=new AdminDAO();
        ArrayList<WaitingStudent> StudentsList=ad.WaitingStudentsList();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Email");
        model.addColumn("Tên");
        model.addColumn("Giới tính");
        model.addColumn("Trường");
        model.addColumn("Số phòng");
        model.addColumn("Dãy phòng");
        for(int i=0;i<StudentsList.size();i++) {
            model.addRow(StudentsList.get(i).toObject());
        }
        return model;
    }

    public void RegConfirm(String email) {
        ad=new AdminDAO();
        ad.Comfirm("StudentEmail='"+email+"'");
    }
    public void RegConfirm() {
        ad=new AdminDAO();
        ad.Comfirm("1");
    }

    public void WaitingStudentsCSV() {
        ad=new AdminDAO();
        try {
            String path="DanhSachCho"+DateHandling.dateToString(DateHandling.DateNow())+".csv";
            File myObj = new File(path);
            int num=1;
            while (!myObj.createNewFile()) {
                path="DanhSachCho_"+(num)+"_"+DateHandling.dateToString(DateHandling.DateNow())+".csv";
                myObj=new File(path);
                num++;
            }

                FileWriter writer = new FileWriter(path, true);
                ArrayList<WaitingStudent> StudentsList = ad.WaitingStudentsList();
                writer.write("Email,Họ và tên,Giới tính,Trường,Số phòng,Dãy");
                writer.write("\r\n");
                for (int i = 0; i < StudentsList.size(); i++) {
                    writer.write(StudentsList.get(i).toCSVLine());
                    writer.write("\r\n");

                }
                writer.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
