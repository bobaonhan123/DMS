package DAOs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import Models.Student;
import Models.StudentIn;
import Models.Room;
import Views.Alert;

import static java.lang.System.exit;

public class ClientDAO {
    Connection con;
    public ClientDAO() {
        con = new DBConn().getCon();
    }
    public Student StudentInfo(String email){
        Student res=new Student();
        try {

            String sql = "SELECT Name,Gender,SchoolName,IsIn FROM StudentsIsIn WHERE StudentEmail='"+email+"';";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            res=new Student(email,rs.getString(1),rs.getBoolean(2),rs.getString(3),rs.getBoolean(4));
            //System.out.println(sql);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
    public StudentIn StudentInInfo(String email){
        StudentIn res=new StudentIn();
        try {

            String sql = "SELECT * FROM StudentsIn WHERE StudentEmail='"+email+"';";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            res=new StudentIn(email,rs.getString(2),rs.getBoolean(7),rs.getString(4),rs.getInt(5),rs.getString(6));
            //System.out.println(sql);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
    public boolean isReg(String email) {
        boolean res=false;
        try {

            String sql = "SELECT COUNT(StudentEmail) FROM Waiting WHERE StudentEmail='"+email+"';";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            res=rs.getBoolean(1);
            //System.out.println(sql);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<StudentIn> RoommateList(int roomNumber,String BuildingName){
        ArrayList<StudentIn> res=new ArrayList<StudentIn>();
        try {

            String sql = "SELECT * FROM StudentsIn WHERE RoomNumber="+roomNumber+" AND BuildingName='"+BuildingName+"';";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next())
            res.add(new StudentIn(rs.getString(1),rs.getString(2),rs.getBoolean(7),rs.getString(4),rs.getInt(5),rs.getString(6)));
            //System.out.println(sql);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void del(String email){
        try {
            String Update ="DELETE FROM Registrations WHERE StudentEmail='"+email+"' AND " +
                    " End>CURRENT_DATE();";
            PreparedStatement preparedStatement3 = con.prepareStatement(Update);
            preparedStatement3.executeUpdate();
            //System.out.println(sql);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Room> RoomList(String Condition){
        ArrayList<Room> res=new ArrayList<Room>();
        try {

            String sql = "SELECT * FROM RoomList WHERE EmptySlot > 0 AND (0 "+Condition+" ORDER BY EmptySlot;";

            //System.out.println(sql);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next())
                res.add(new Room(rs.getString(4), rs.getInt(1), rs.getBoolean(3), rs.getInt(2), rs.getInt(5)));


            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void Register(Student st,String BuildingID,int RoomNumber, String dateBegin,String dateEnd) {
        try {
            int gender;
            if (st.getGender()) gender = 1;
            else {
                gender = 0;
            }
            String sql = "SELECT * FROM RoomList WHERE EmptySlot > 0 AND BuildingID='"+BuildingID+
                    "' AND RoomNumber="+RoomNumber+" AND Gender="+gender+";";
            //System.out.println(sql);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if(!rs.next()) {
                new Alert("Lỗi","Phòng đã đầy hoặc không tồn tại");
            }
            else {
                String Select="SELECT RoomID FROM Rooms WHERE BuildingID='"+BuildingID+"' AND RoomNumber="+RoomNumber+";";
                PreparedStatement p2 = con.prepareStatement(Select);
                ResultSet rs2 = p2.executeQuery();
                rs2.next();
                long roomID=rs2.getLong(1);
                String Insert="INSERT INTO Registrations(StudentEmail,RoomID,Begin,End) " +
                        "VALUES('"+st.getEmail()+"',"+roomID+",'"+dateBegin+"','"+dateEnd+"');";
                PreparedStatement p3 = con.prepareStatement(Insert);
                int res=p3.executeUpdate();
                if(res==1)
                {
                    Alert al=new Alert("Thành công","Đăng ký thành công");
                    al.button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            exit(0);
                        }
                    });
                }
            }
            con.close();
        } catch (Exception e) {
            new Alert("Lỗi","Có lỗi xảy ra, vui lòng  tra kỹ (Số phòng,...)");
            e.printStackTrace();
        }
    }

}
