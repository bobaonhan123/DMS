package Controllers;
import DAOs.ClientLoginDao;
import Views.Use.ClientGUI;
import Views.Alert;
import DAOs.DBConn;
public class ClientLogin {
    ClientLoginDao l;
    public ClientLogin(){
        l = new ClientLoginDao();

    }
    public boolean checkLogin(String user, String passWord) {

        return l.checkLogin(user, passWord);
    }

}
