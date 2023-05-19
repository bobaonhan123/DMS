package Models;

import java.util.HashMap;
import java.util.Map;

public class WaitingStudent extends Student{
    private String RoomNumber;
    private String BuildingID;

    public WaitingStudent() {

    }

    public WaitingStudent(String roomNumber, String buildingID) {
        RoomNumber = roomNumber;
        BuildingID = buildingID;
    }

    public WaitingStudent(String email, String name, boolean gender, String schoolName, String roomNumber, String buildingID) {
        super(email, name, gender, schoolName, false);
        RoomNumber = roomNumber;
        BuildingID = buildingID;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getBuildingID() {
        return BuildingID;
    }

    public void setBuildingID(String buildingID) {
        BuildingID = buildingID;
    }

    public Object[] toObject() {
        HashMap<String,String> BName=new HashMap<String,String>();
        BName.put("1","Dãy 1");
        BName.put("2","Dãy 2");
        BName.put("3","Dãy 3");
        BName.put("dv","Dãy dịch vụ");
        return new Object[]{getEmail(),getName(),getGender()?"Nữ":"Nam",getSchoolName(),
        getRoomNumber(),BName.get(getBuildingID())};
    }

    public String toCSVLine() {
        HashMap<String,String> BName=new HashMap<String,String>();
        BName.put("1","Dãy 1");
        BName.put("2","Dãy 2");
        BName.put("3","Dãy 3");
        BName.put("dv","Dãy dịch vụ");
        String Gender;
        if (getGender()) Gender = "Nữ";
        else Gender = "Nam";
        String s = getEmail() + "," + getName() + "," + Gender + "," + getSchoolName() + "," +
                getRoomNumber() + "," + BName.get(getBuildingID());
        return s;
    }

}
