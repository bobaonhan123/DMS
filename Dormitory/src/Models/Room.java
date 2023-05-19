package Models;

public class Room {
    private String building;
    private int RoomNumber;
    private boolean gender;
    private int type;
    private int EmptySlot;

    public Room(String building, int roomNumber, boolean gender, int type, int emptySlot) {
        this.building = building;
        RoomNumber = roomNumber;
        this.gender = gender;
        this.type = type;
        EmptySlot = emptySlot;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getEmptySlot() {
        return EmptySlot;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setEmptySlot(int emptySlot) {
        EmptySlot = emptySlot;
    }
    public Object[] toObject(){
        return new Object[]{getBuilding(),getRoomNumber(),getGender()?"Nữ":"Nam",getType(),getEmptySlot()};
    }
}
