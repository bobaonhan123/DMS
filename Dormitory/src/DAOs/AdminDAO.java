package DAOs;

import Models.Room;
import Models.StudentIn;
import Models.WaitingStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDAO {
    Connection con;
    public AdminDAO() {
        con = new DBConn().getCon();
    }
    public int StudentsNum(String School){
        int res=0;
        try {
            String sql = "SELECT COUNT(Registrations.StudentEmail) FROM Registrations INNER JOIN Students ON Registrations.StudentEmail=Students.StudentEmail WHERE SchoolID='"+School+"' AND AdConfirm=1;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            res=resultSet.getInt(1);
            //System.out.println(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<Room> RoomList(String Condition){
        ArrayList<Room> res=new ArrayList<Room>();
        try {

            String sql = "SELECT * FROM RoomList WHERE 1 AND (0 "+Condition+" ORDER BY EmptySlot;";

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
    public ArrayList<StudentIn> RoommateList(String roomNumber, String BuildingID){
        ArrayList<StudentIn> res=new ArrayList<StudentIn>();
        try {

            String sql = "SELECT * FROM StudentsIn WHERE RoomNumber="+roomNumber+" AND BuildingID='"+BuildingID+"';";
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
    public void del(String condition){
        try {
            String Update ="DELETE FROM Registrations WHERE "+condition+" AND " +
                    " End>CURRENT_DATE() AND NOT AdConfirm;";
            PreparedStatement preparedStatement3 = con.prepareStatement(Update);
            preparedStatement3.executeUpdate();
            //System.out.println(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<WaitingStudent> WaitingStudentsList(){
        ArrayList<WaitingStudent> res=new ArrayList<WaitingStudent>();
        try {

            String sql = "SELECT * FROM Waiting;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next())
                res.add(new WaitingStudent(rs.getString(1),rs.getString(2),rs.getBoolean(7),rs.getString(4),rs.getString(5),rs.getString(8)));
            //System.out.println(sql);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void Comfirm(String condition) {
        try {

            String sql = "UPDATE Registrations SET AdConfirm=1 WHERE End>CURRENT_DATE() AND "+condition+";";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeUpdate();


            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
