package Models;

public class StudentIn extends Student{
    private int RoomNumber;
    private String BuildingName;
    public StudentIn(){

    }

    public StudentIn(int roomNumber, String buildingName) {
        RoomNumber = roomNumber;
        BuildingName = buildingName;
    }

    public StudentIn(String email, String name, boolean gender, String schoolName, int roomNumber, String buildingName) {
        super(email, name, gender, schoolName,true);
        RoomNumber = roomNumber;
        BuildingName = buildingName;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getBuildingName() {
        return BuildingName;
    }

    public void setBuildingName(String buildingName) {
        BuildingName = buildingName;
    }
    public Object[] toObject(){
        return new Object[]{getEmail(),getName(),getGender()?"Nữ":"Nam",getSchoolName()};
    }
}
