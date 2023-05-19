package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientLoginDao {
    Connection con;
    public ClientLoginDao() {
        con = new DBConn().getCon();
    }

    public boolean checkLogin(String user, String pass) {
        boolean check = false;
        try {
            String sql = "SELECT * FROM Students WHERE StudentEmail='"+user+"'";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            //System.out.println(sql);
            if (resultSet.next()) {

                if(resultSet.getString(2).equals(pass))
                    check = true;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
//    public void Close(){
//        try {
//            con.close();
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//    }
}
