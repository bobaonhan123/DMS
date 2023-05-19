package Controllers;
import DAOs.AdminLoginDao;
import Views.Use.AdminGUI;
import DAOs.DBConn;
import Views.Alert;

public class AdminLogin {
    AdminLoginDao l;
    public AdminLogin(){
        l = new AdminLoginDao();

    }
    public boolean checkLogin(String user, String passWord) {

        return l.checkLogin(user, passWord);
    }

}
