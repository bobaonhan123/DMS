package DAOs;

import java.sql.*;
public class DBConn {
    private String status;
    private String url="jdbc:mysql://localhost:3306/Dormitory";
    private String user="root";
    private String pwd="";
    Connection con;
    public DBConn(){
        try {
            con=DriverManager.getConnection(url,user,pwd);
            status="Kết nối thành công";

        }
        catch (Exception e){
            status="Lỗi kết nối";
            e.printStackTrace();
        }
    }
    public Connection getCon() {
        return con;
    }
    public String getStatus() {
        return status;
    }
    /*
    public int updateDB(String query) {
        try{
            Statement stmt=con.createStatement();
            return stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    //public
    public void Disconnect() {
        try{
        con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
     */
}
