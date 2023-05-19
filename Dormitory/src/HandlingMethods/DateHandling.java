package HandlingMethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandling {
    public static Date DateNow() {
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return new Date();

        } catch(Exception e){
            e.printStackTrace();
        }
        return new Date();
    }
    public static String dateToString(Date date) {
        String res="";
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            res = dateFormat.format(date); ;

        } catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
